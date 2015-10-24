package yumic.diverbob.love.ezlive.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import yumic.diverbob.love.ezlive.MyApplication;
import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.bean.User;
import yumic.diverbob.love.ezlive.net.NetUrl;
import yumic.diverbob.love.ezlive.util.DoubleClickJuage;


/**
 * Created by draft on 2015/7/12.
 */
public class LoginActivity extends Activity {
    private Button buttonLogin;
//    注册按钮
    private  Button btn_regiser;
    private ImageView imageViewId;
    private ImageView imageViewHead;
    private EditText editId,editPassword;
    private String id,password;
    private MyApplication myApplication;
    private StringRequest loginStringRequest,getPersonMessageStringRequest;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //通过MyApplication获取当前用户
        myApplication = MyApplication.getInstance();
        final RequestQueue mQueue = Volley.newRequestQueue(LoginActivity.this);
        //初始化
        init();
        //网络处理初始化
        netinit();

        //给按钮设置监听
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                if (DoubleClickJuage.isFastDoubleClick()) {
                    return;
                }

                //获取两个所填Id和Password
                id=editId.getText().toString();
                password=editPassword.getText().toString();
                if(id.equals("")){
                    Toast.makeText(LoginActivity.this, "请输入你的用户名", Toast.LENGTH_SHORT).show();
                }else if(password.equals("")){
                    Toast.makeText(LoginActivity.this, "请输入你的密码", Toast.LENGTH_SHORT).show();
                }else{


                    mQueue.add(loginStringRequest);



                }


            }

        });

//        给注册按钮添加监听事件
        btn_regiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void netinit() {
        //登录
        loginStringRequest = new StringRequest(Request.Method.POST, NetUrl.LOGIN,
                new Response.Listener<String>() {

                    //                                @Override
//                                public Map<String, String> getHeaders() throws AuthFailureError {
//                                    HashMap<String, String> headers = new HashMap<String, String>();
//                                    headers.put("cookie", );
//                                    return headers;
//                                }
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                        if (response.equals("1")){
                            User user=new User();
                            user.setNickName(id);
                            myApplication.setCurrentUser(user);
                            Intent loginIntent=new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(loginIntent);
                            finish();
                        }else if (response.equals("-1")){
                            Toast.makeText(LoginActivity.this, "无此用户", Toast.LENGTH_SHORT).show();
                        }else if (response.equals("-2")){
                            Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG1", error.getMessage(), error);
            }
        }) {


            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", id);
                params.put("password",password);
                return params;
            }
        };



    }

    private void init() {
        imageViewHead=(ImageView)findViewById(R.id.image_head);
        imageViewId=(ImageView)findViewById(R.id.image_id);
        imageViewId.setAlpha(210);
        buttonLogin=(Button)findViewById(R.id.button_login);
        editId=(EditText)findViewById(R.id.edit_id);
        editPassword=(EditText)findViewById(R.id.edit_password);
        btn_regiser= (Button) findViewById(R.id.button_register);

    }


}
