package yumic.diverbob.love.ezlive.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import yumic.diverbob.love.ezlive.R;


/**
 * Created by apple on 15/10/24.
 */
public class RoommateDetailActivity extends Activity {

    private TextView tvMoney,tvName,tv1,tv2,tv3,tv4;
    private Button collectButton,callButton;
    private ImageView headImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roommate_detail_activity);
        init();


    }

    private void init() {
        tvMoney= (TextView) findViewById(R.id.text_money);
        tvName= (TextView) findViewById(R.id.name_sex_age);
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        tv3= (TextView) findViewById(R.id.tv3);
        tv4= (TextView) findViewById(R.id.tv4);
        collectButton= (Button) findViewById(R.id.shoucang);
        callButton= (Button) findViewById(R.id.btn_call);
        headImage= (ImageView) findViewById(R.id.image_head);

    }

}