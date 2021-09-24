package com.example.cooky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);

        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getGroupId();
        switch (id){
            case R.id.mnu_shoppingcart:
                //codde here
                Toast.makeText(MainActivity.this,"ShoppingCard",Toast.LENGTH_LONG).show();
                break;
            case R.id.mnu_addnew:
                Toast.makeText(MainActivity.this,"Add new ",Toast.LENGTH_LONG).show();
                break;
            case R.id.app_bar_search:
                Toast.makeText(MainActivity.this,"search",Toast.LENGTH_LONG).show();
                break;
        }
        return  super.onOptionsItemSelected(item);
    }
}
