package com.example.consultants.week2_weekend;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_tag";
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets the tool bar, used to apply the menu icon
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Gets the Drawer layout
        mDrawerLayout = findViewById(R.id.drawer_layout);

        //Allow to use the menu icon
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(getListener());
    }

    @NonNull
    private NavigationView.OnNavigationItemSelectedListener getListener() {
        return new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();
                Log.d(TAG, "onNavigationItemSelected: " + menuItem);

                switch (menuItem.getItemId()){
                    case R.id.nav_camera:
                        Log.d(TAG, "onNavigationItemSelected: Camera: " + menuItem);
                        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_gallery:
                        Log.d(TAG, "onNavigationItemSelected: gallery" + menuItem);
                        break;
                    case R.id.new_game:
                        Log.d(TAG, "onNavigationItemSelected: NewGame" + menuItem);
                        break;
                    case R.id.help:
                        Log.d(TAG, "onNavigationItemSelected: Help" + menuItem);
                        break;


                }


                return true;
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.over_flow_menu, menu);
        return true;
    }
}
