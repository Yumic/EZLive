package yumic.diverbob.love.ezlive.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.fragment.FindRoomFragment;
import yumic.diverbob.love.ezlive.fragment.FindRoommateFragment;
import yumic.diverbob.love.ezlive.fragment.MyFindingInfoFragment;
import yumic.diverbob.love.ezlive.fragment.MyRentingInfoFragment;
import yumic.diverbob.love.ezlive.fragment.SettingAccountFragment;
import yumic.diverbob.love.ezlive.fragment.SettingProfileFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private final String TAG="MainActivity";
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        fab = (FloatingActionButton) findViewById(R.id.fab);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_find_room) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   //TODO 设置添加房源
                }
            });
            fragment = new FindRoomFragment();

            Log.d(TAG," fragment = new FindRoomFragment()");
        } else if (id == R.id.nav_find_roommate) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(MainActivity.this,AddFindingRoommateActivity.class);
                    startActivity(intent);
                }
            });
            fragment = new FindRoommateFragment();
            Log.d(TAG,"fragment = new FindRoommateFragment()");


        } else if (id == R.id.nav_my_finding_info) {
            fragment = new MyFindingInfoFragment();
            Log.d(TAG,"fragment = new MyFindingInfoFragment()");

        } else if (id == R.id.nav_my_renting_info) {
            fragment = new MyRentingInfoFragment();

        } else if (id == R.id.nav_setting_profile) {
            fragment = new SettingProfileFragment();
        } else if (id == R.id.nav_setting_account) {
            fragment = new SettingAccountFragment();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        fragmentManager.beginTransaction()
                .replace(R.id.container,fragment)
                .commit();
        return true;
    }
}
