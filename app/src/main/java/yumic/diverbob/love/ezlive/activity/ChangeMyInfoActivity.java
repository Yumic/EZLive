package yumic.diverbob.love.ezlive.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.net.NetUrl;

/**
 * Created by apple on 15/10/25.
 */
public class ChangeMyInfoActivity extends Activity {
    private Button changeButton;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,text1,text2,text3,text4,text5,text6;
    private RequestQueue mQueue;
    private StringRequest getMyInfoStringRequest;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_my_info);

        init();
        //网络处理初始化
        netinit();


    }

    private void netinit() {

        //获取信息

        getMyInfoStringRequest = new StringRequest(Request.Method.POST, NetUrl.MY_ROOM,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        }) {

        };
    }

    private void init() {
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        tv3= (TextView) findViewById(R.id.tv3);
        tv4= (TextView) findViewById(R.id.tv4);
        tv5= (TextView) findViewById(R.id.tv5);
        text1= (TextView) findViewById(R.id.text1);
        text2= (TextView) findViewById(R.id.text2);
        text3= (TextView) findViewById(R.id.text3);
        text4= (TextView) findViewById(R.id.text4);
        text5= (TextView) findViewById(R.id.text5);
        changeButton= (Button) findViewById(R.id.btn_finish);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
