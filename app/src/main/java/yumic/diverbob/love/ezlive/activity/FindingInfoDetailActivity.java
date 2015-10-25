package yumic.diverbob.love.ezlive.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import yumic.diverbob.love.ezlive.MyApplication;
import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.bean.Roommate;


/**
 * Created by apple on 15/10/24.
 */
public class FindingInfoDetailActivity extends Activity implements View.OnClickListener {

    private TextView tvMoney,tvName,tv1,tv2,tv3,tv4;
    private Button collectButton,callButton;
    private ImageView headImage;

    private Roommate roommate;

    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finding_detail_activity);
        myApplication= (MyApplication) getApplication();
        roommate=myApplication.getCurrentRoommate();
        init();
        fill_in();

    }

    private void fill_in() {
        int money=1000;
        try{
            money=(Integer.parseInt(roommate.getPrice_min())+Integer.parseInt(roommate.getPrice_max()))/2;
        }catch (Exception e){

        }
        tvMoney.setText("期望房租："+money+"/月");
        String sex;
        Log.d("testWISHSEX",roommate.getWish_sex());
        if (roommate.getWish_sex().equals("0")){
            sex="不限";
        }
        else if (roommate.getWish_sex().equals("1")){
            sex="男";
        }else{
            sex="女";
        }
        tvName.setText(roommate.getName()+"\n"+sex+"  "+roommate.getAge()+"岁");
        tv1.setText(" 个人介绍：：\n    "+roommate.getOwn_describe()+"\n");
        tv2.setText(" 舍友期望：\n    "+roommate.getWish_content()+"\n");
        tv3.setText(" 期望居住区域：\n    " + roommate.getPosition() + roommate.getPosition_more() + "\n");
        tv4.setText(" 个人标签：\n    " + roommate.getTags() + "\n");
        callButton.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_call:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + roommate.getUsername()));
                startActivity(intent);
                break;
        }
    }
}
