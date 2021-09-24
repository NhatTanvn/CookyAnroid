package com.example.cooky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {
    ActionBar actionBar;
    Fragment fragment;
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    OrderFragment orderFragment;
    AccountFragment accouFragment;
    FavoritesFragment favoritesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        actionBar = getSupportActionBar();

        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.mnu_home:
                        showHomePage();
                        break;
                    case R.id.mnu_order:
                        showOrderPage();
                        break;
                    case R.id.mnu_favorites:
                        showFavoritePage();
                        break;
                    case R.id.mnu_usrer:
                        showUserPage();
                        break;
                }
                return false;
            }
        });
        showHomePage();
    }
    private void showHomePage(){
        Toast.makeText(BottomNavigationActivity.this,"Home",Toast.LENGTH_LONG).show();
        loadFragment(0);
        actionBar.setTitle("Home");
        actionBar.setDisplayHomeAsUpEnabled(false);
    }
    private void showOrderPage(){

        Toast.makeText(BottomNavigationActivity.this,"Order",Toast.LENGTH_LONG).show();
        loadFragment(1);
        actionBar.setTitle("Order ");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    private void showFavoritePage(){
        Toast.makeText(BottomNavigationActivity.this,"Favorite",Toast.LENGTH_LONG).show();
        loadFragment(2);
        actionBar.setTitle("Favorite");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    private void showUserPage(){
        Toast.makeText(BottomNavigationActivity.this,"User",Toast.LENGTH_LONG).show();
        loadFragment(3);
        actionBar.setTitle("User");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    private void loadFragment(int flag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Log.d("home",""+homeFragment);
        if(flag==0){
            if (homeFragment==null) {
                homeFragment = new HomeFragment();
            }
                fragment = homeFragment;

        }else if(flag==1){
            fragment = new OrderFragment();
        }else if(flag==2){
            fragment = new FavoritesFragment();
        }else if(flag==3){
        fragment = new AccountFragment();
    }
        fragmentTransaction.replace(R.id.framelayout_container,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
