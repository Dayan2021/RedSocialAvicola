package com.redsoc.redsocialavicola.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.redsoc.redsocialavicola.R;
import com.redsoc.redsocialavicola.fragments.ChatsFragment;
import com.redsoc.redsocialavicola.fragments.FiltersFragment;
import com.redsoc.redsocialavicola.fragments.HomeFragment;
import com.redsoc.redsocialavicola.fragments.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(new HomeFragment());
    }
    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if(item.getItemId() == R.id.itemHome){
                        //FRAGMENT HOME
                        openFragment(new HomeFragment());
                    }
                    else if(item.getItemId() == R.id.itemChats){
                        //FRAGMENT CHATS
                        openFragment(new ChatsFragment());
                    }
                    else if(item.getItemId() == R.id.itemFilters){
                        //FRAGMENT FILTERS
                        openFragment(new FiltersFragment());
                    }
                    else if(item.getItemId() == R.id.itemProfile){
                        //FRAGMENT PROFILES
                        openFragment(new ProfileFragment());
                    }
                    return true;
                }
            };
}