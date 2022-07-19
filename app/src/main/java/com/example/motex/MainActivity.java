package com.example.motex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.motex.fragments.AccountFragment;
import com.example.motex.fragments.CartFragment;
import com.example.motex.fragments.HomeFragment;
import com.example.motex.fragments.OffersFragment;
import com.example.motex.fragments.StoresFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()==null){
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


        bottomNavigationView = findViewById(R.id.bottom_nav);


        replaceFragment(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottomHome:
                        replaceFragment(new HomeFragment());
                        return true;
                    case R.id.bottomStores:
                        replaceFragment(new StoresFragment());
                        return true;
                    case R.id.bottomOffers:
                        replaceFragment(new OffersFragment());
                        return true;
                    case R.id.bottomCart:
                        replaceFragment(new CartFragment());
                        return true;
                    case R.id.bottomAccount:
                        replaceFragment(new AccountFragment());
                        return true;

                }
                return false;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,fragment).commit();

    }

    @Override
    public void onBackPressed() {
        if (bottomNavigationView.getSelectedItemId() == R.id.bottomHome){
            super.onBackPressed();
        }else {
            replaceFragment(new HomeFragment());
            bottomNavigationView.setSelectedItemId(R.id.bottomHome);
        }

    }
}
