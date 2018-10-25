package com.example.professor.fragmentsdinamicos;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (item.getItemId() == R.id.add_frag1){
            LeftFragment leftFragment = new LeftFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment1, leftFragment,"Left");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            return true;
        }
        else if (item.getItemId() == R.id.add_frag2){
            RightFragment rightFragment = new RightFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment2, rightFragment, "Right");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            return true;
        }
        else if(item.getItemId() == R.id.del_frag1){
            LeftFragment leftFragment = (LeftFragment)fragmentManager.findFragmentById(R.id.fragment1);
            if (leftFragment != null){
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(leftFragment);
                fragmentTransaction.commit();
            }
            return true;
        }
        else if(item.getItemId() == R.id.del_frag2){
            RightFragment rightFragment = (RightFragment)fragmentManager.findFragmentById(R.id.fragment2);
            if (rightFragment != null){
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(rightFragment);
                fragmentTransaction.commit();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}