package yumic.diverbob.love.ezlive.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.fragment.FindingRoommate.FindingRoommateFragment1;
import yumic.diverbob.love.ezlive.fragment.FindingRoommate.FindingRoommateFragment2;
import yumic.diverbob.love.ezlive.fragment.FindingRoommate.FindingRoommateFragment3;
import yumic.diverbob.love.ezlive.fragment.FindingRoommate.FindingRoommateFragment4;


public class AddFindingRoommateActivity extends AppCompatActivity {


    private final String TAG = "AddFindingActivity";
    @Bind(R.id.container)
    FrameLayout container;
    @Bind(R.id.textView_next)
    TextView textViewNext;
    @Bind(R.id.textView_back)
    TextView textViewBack;
    private FragmentManager fragmentManager;
    private Fragment fragment;
    private int fragmentTag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_finding_roommate);
        ButterKnife.bind(this);

        textViewBack.setTextColor(Color.parseColor("#909090"));

        textViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(fragmentTag){
                    case 1:
                        break;
                    case 2:

                        fragment =new FindingRoommateFragment1();
                        textViewBack.setTextColor(Color.parseColor("#909090"));
                        textViewNext.setTextColor(Color.parseColor("#FF9800"));
                        fragmentTag =1;
                        fragmentManager.beginTransaction()
                                .replace(R.id.container,fragment)
                                .commit();
                        break;

                    case 3:
                        textViewBack.setTextColor(Color.parseColor("#FF9800"));
                        textViewNext.setTextColor(Color.parseColor("#FF9800"));
                        fragment =new FindingRoommateFragment2();
                        fragmentTag=2;
                        fragmentManager.beginTransaction()
                                .replace(R.id.container,fragment)
                                .commit();
                        break;

                    case 4:

                        fragment =new FindingRoommateFragment3();
                        textViewNext.setTextColor(Color.parseColor("#FF9800"));
                        textViewNext.setTextColor(Color.parseColor("#FF9800"));
                        fragmentTag=3;
                        fragmentManager.beginTransaction()
                                .replace(R.id.container,fragment)
                                .commit();
                        break;
                }


            }
        });
        textViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(fragmentTag){
                    case 1:
                        fragment =new FindingRoommateFragment1();
                        textViewBack.setTextColor(Color.parseColor("#FF9800"));
                        textViewNext.setTextColor(Color.parseColor("#FF9800"));
                        fragmentTag=2;
                        fragment =new FindingRoommateFragment2();

                        fragmentManager.beginTransaction()
                                .replace(R.id.container,fragment)
                                .commit();
                        break;
                    case 2:
                        fragment =new FindingRoommateFragment3();
                        textViewBack.setTextColor(Color.parseColor("#FF9800"));
                        textViewNext.setTextColor(Color.parseColor("#FF9800"));
                        fragmentTag =3;
                        fragmentManager.beginTransaction()
                                .replace(R.id.container,fragment)
                                .commit();
                        break;

                    case 3:
                        textViewBack.setTextColor(Color.parseColor("#FF9800"));
                        textViewNext.setTextColor(Color.parseColor("#909090"));
                        fragment =new FindingRoommateFragment4();
                        fragmentTag=4;
                        fragmentManager.beginTransaction()
                                .replace(R.id.container,fragment)
                                .commit();
                        break;

                    case 4:
                        break;
                }
            }
        });


        fragmentManager = getSupportFragmentManager();
        fragment = new FindingRoommateFragment1();
        fragmentManager.beginTransaction()
                .replace(R.id.container,fragment)
                .commit();


    }
}

