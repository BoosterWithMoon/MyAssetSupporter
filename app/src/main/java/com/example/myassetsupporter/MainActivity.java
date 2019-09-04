package com.example.myassetsupporter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myassetsupporter.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    final public int LOGIN_CODE = 1000;

    //private FragmentLogin fragmentLogin = new FragmentLogin();
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentHome fragmentHome = new FragmentHome();
    private FragmentSettings fragmentSettings = new FragmentSettings();
    private FragmentNotifications fragmentNotifications = new FragmentNotifications();


    private BackPressCloseHandler bpch;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();
                    break;
                case R.id.navigation_settings:
                    transaction.replace(R.id.frameLayout, fragmentSettings).commitAllowingStateLoss();
                    break;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.frameLayout, fragmentNotifications).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Login();
        bpch = new BackPressCloseHandler(this);

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();
        //transaction.replace(R.id.frameLayout, fragmentLogin).commitAllowingStateLoss();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        //navView.setVisibility(View.GONE);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //finish();

        //Intent intent = new Intent(this, LoginActivity.class);
        //startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        bpch.onBackPressed();
    }

    public void onAssetButtonClicked(View view){
        //FragmentTransaction transaction = fragmentManager.beginTransaction();

        Intent intent = new Intent(this, ActivityAssetdetail.class);
        switch(view.getId()){
            case R.id.button_1stAsset:
                //Toast.makeText(getApplicationContext(), "Kakao", Toast.LENGTH_LONG).show();
                intent.putExtra("AssetName", "Kakao");
                startActivity(intent);
                break;
            case R.id.button_2ndAsset:
                intent.putExtra("AssetName", "IBK");
                startActivity(intent);
                break;
        }
    }
}
