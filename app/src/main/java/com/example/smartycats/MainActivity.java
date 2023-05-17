package com.example.smartycats;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button openButton;

    ViewPager2 viewPager;
    ArrayList<ViewPagerItem> viewPagerItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        openButton = findViewById(R.id.open_menu_button);
        viewPager = findViewById(R.id.view_pager);


        // Sidebar Menu
        navigationView.setNavigationItemSelectedListener(this);
        openButton.setOnClickListener(view -> {
            if(drawerLayout.isDrawerOpen(GravityCompat.END)) {
                drawerLayout.closeDrawer(GravityCompat.END);
            }
            drawerLayout.openDrawer(GravityCompat.END);
        });


        // ViewPager
        int[] images = {R.drawable.viewpager_image_1, R.drawable.viewpager_image_2, R.drawable.viewpager_image_3};
        String[] headings = {getString(R.string.viewpager_title_1), getString(R.string.viewpager_title_2), getString(R.string.viewpager_title_3)};
        String[] descs = {getString(R.string.viewpager_desc_1), getString(R.string.viewpager_desc_2), getString(R.string.viewpager_desc_3)};

        viewPagerItemArrayList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ViewPagerItem viewPagerItem = new ViewPagerItem(images[i], headings[i], descs[i]);
            viewPagerItemArrayList.add(viewPagerItem);
        }

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(viewPagerItemArrayList);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(2);
        viewPager.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_assignments:
                Toast.makeText(MainActivity.this, "Assignments", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(MainActivity.this, "Nothing.", Toast.LENGTH_SHORT).show();

        }
        return false;
    }
}