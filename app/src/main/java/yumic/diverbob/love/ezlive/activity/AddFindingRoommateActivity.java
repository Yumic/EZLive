package yumic.diverbob.love.ezlive.activity;


import android.app.Activity;
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
import yumic.diverbob.love.ezlive.fragment.FindingRoommate.FindingRoommateFragment1;
import yumic.diverbob.love.ezlive.fragment.MyFindingInfoFragment;
import yumic.diverbob.love.ezlive.fragment.MyRentingInfoFragment;
import yumic.diverbob.love.ezlive.fragment.SettingAccountFragment;
import yumic.diverbob.love.ezlive.fragment.SettingProfileFragment;


public class AddFindingRoommateActivity extends AppCompatActivity {


    private final String TAG = "AddFindingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //TODO setContentView(R.layout.activity_add_finding_roommate);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = new FindingRoommateFragment1();

    }
}

