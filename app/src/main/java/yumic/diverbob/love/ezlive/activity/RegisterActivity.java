package yumic.diverbob.love.ezlive.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
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

/**
 * Created by Qingwen_li on 2015/10/24.
 */
public class RegisterActivity  extends Activity {
//   用户名
    private EditText et_userName;
//   密码
    private  EditText et_password;
//   注册按钮
    private Button btn_register;
//   保存用户名
    String name;
//    保存密码
    String password;
//    得到一个对象
    MyApplication mapplication = MyApplication.getInstance();


protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    initView();
}

    private void initView() {
        et_userName= (EditText) findViewById(R.id.et_inputName_register);
        et_password= (EditText) findViewById(R.id.et_inputPassword_register);
        btn_register= (Button) findViewById(R.id.btn_register_register);



        /*
        * 注册按钮 添加监听事件
        * */
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                判断两个用户名和密码是否为空
                if (!isNull()) {
//                    Toast.makeText(RegisterActivity.this,"不为空",Toast.LENGTH_LONG).show();
                    Log.e("feikong","判断注册是否成功");
//                    判断是否注册成功
                    isRegisterSuccess();
            }}
        });

    }


    protected void isRegisterSuccess() {

//        建立一个RequestQueue对象
        RequestQueue mQueue = Volley.newRequestQueue(RegisterActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "http://112.74.203.123/xiaobaijuyi/public/account/android/register",
               /*
               * 成功的响应
               * */
                new Response.Listener<String>()
                {

                   public void onResponse(String s)
                   {

                       Log.e("返回值是什么呢",s);
                       if(s.equals("1"))
                       {
                           User us=new User();
                           mapplication.setCurrentUser(us);
                           mapplication.getCurrentUser().setName(et_userName.getText().toString());
//       、                 注册成功之后直接进入主界面
                           Intent intent = new Intent();
                           intent.setClass(RegisterActivity.this, MainActivity.class);
                           startActivity(intent);
                       }


                   }
               },
///           错误的监听
                new Response.ErrorListener()
                   {
                       public void onErrorResponse(VolleyError volleyError)
                       {
                           Log.e("fail to  register","sdfsjdf sdfsfd");
                          Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_LONG).show();
                       }
                    }) {


            protected Map<String, String> getParams() throws AuthFailureError {

              /*
              *传参数
              * */
                Map<String, String> map = new HashMap<String, String>();
                map.put("name","hello");
                map.put("username",name);
                map.put("password", password);
                return map;
            }
        };

        mQueue.add(stringRequest);
    }


    /*
    * 判断用户名，密码，手机号是否为空
    * */
      protected  boolean isNull() {
          name=et_userName.getText().toString();
          password=et_password.getText().toString();

          if(!(name.equals("")||password.equals("")))
          {
              return false;
          }
          else
          {
              Toast.makeText(RegisterActivity.this,"用户名和密码都不能为空",Toast.LENGTH_LONG).show();
              Log.e("isnull"," password is null");
              return true;
          }
    }
}





