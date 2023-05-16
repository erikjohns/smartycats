package com.example.smartycats;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button openButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        openButton = findViewById(R.id.open_button);

        // Sidebar Menu
        navigationView.setNavigationItemSelectedListener(this);
        openButton.setOnClickListener(view -> {
            if(drawerLayout.isDrawerOpen(GravityCompat.END)) {
                drawerLayout.closeDrawer(GravityCompat.END);
            }
            drawerLayout.openDrawer(GravityCompat.END);
        });

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