package yumic.diverbob.love.ezlive.fragment;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import yumic.diverbob.love.ezlive.MyApplication;
import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.activity.MainActivity;
import yumic.diverbob.love.ezlive.activity.RegisterActivity;
import yumic.diverbob.love.ezlive.util.pictureUtils;


public class SettingProfileFragment extends Fragment {
//   照片
    private ImageView iv_myPhoto;
    //昵称
    private EditText et_nickName;
    //    年龄
    private EditText et_ages;
    //   性别
     private RadioGroup rg_sex;
    //    名字
    private String nickName = "小白";

    //   淇濆瓨鎬у埆
    private String sex = "男";
    //    骞撮緞
    private String age = "20";
    //    保存设置
    private Button btn_saveChanges;

//     判断是否为第一次
    private  boolean isFirst=true;
//    view
    private View view;
    // 存储上下文对象
    private Context context;
    private Activity activity;
    private MyApplication myApplication;


    public SettingProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragement_myinfo, container,false);
        init();
        return view;
    }

    private void init() {
        iv_myPhoto= (ImageView) view.findViewById(R.id.iv_photo);
        et_nickName= (EditText) view.findViewById(R.id.et_myInfo_nick);
        et_ages= (EditText) view.findViewById(R.id.et_myInfo_age);
        rg_sex= (RadioGroup) view.findViewById(R.id.rg_myInfo_sex);
        btn_saveChanges= (Button) view.findViewById(R.id.btn_myInfo_saveChanges);
//      得到当前对象
        myApplication=MyApplication.getInstance();


        /*
        * 给保存按钮添加监听
        * */
            btn_saveChanges.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("change", "onclick");

                    sex = getSex();
                    age =String.valueOf(et_ages.getText());
                    nickName = et_nickName.getText().toString();


                    if (isAgesLegal(age)) {

                        toUpData();
                        myApplication.getCurrentUser().setAge(age);
                        myApplication.getCurrentUser().setNickName(nickName);
                        myApplication.getCurrentUser().setSex(sex);

                    }
                /*
                * 输出一个要保存的数据，然后上传网络，与网络进行交互
                * */
                    Toast.makeText(getActivity(), ""+nickName + age + sex, Toast.LENGTH_LONG).show();


                }
            });




            if(!isFirst){
                iv_myPhoto.setImageBitmap(myApplication.getCurrentUser().getCurrentBitmap());
            }else{
                Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.xiake);
                iv_myPhoto.setImageBitmap(pictureUtils.toRoundBitmap(bitmap));
            }

        /*
       * 选择自己手机里的照片进行选择
       * */
            iv_myPhoto.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
              /*
              * 閫氳繃intent瀹炵幇椤甸潰鐨勮烦杞紝鎵撳紑閫夋嫨鐓х墖鐨勯〉闈?
              * */
                    Intent intent = new Intent();
//
                    intent.setType("image/*");
//
                    intent.setAction(Intent.ACTION_GET_CONTENT);
//
                    startActivityForResult(intent, 1);


                }
            });


        }

    private void toUpData() {
        //        建立一个RequestQueue对象
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "http://112.74.203.123/xiaobaijuyi/public/account/set",
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
                        Toast.makeText(activity,"保存数据成功",Toast.LENGTH_LONG).show();
                        }


                    }
                },
///           错误的监听
                new Response.ErrorListener()
                {
                    public void onErrorResponse(VolleyError volleyError)
                    {
                        Toast.makeText(activity,"保存失败",Toast.LENGTH_LONG).show();
                    }
                }) {


            protected Map<String, String> getParams() throws AuthFailureError {

              /*
              *传参数
              * */
                Map<String, String> map = new HashMap<String, String>();
                map.put("age",age);
                map.put("username",nickName);
                map.put("sex", sex);
                return map;
            }
        };

        mQueue.add(stringRequest);

    }


       public void  onActivityResult(int requestCode,int resultCode,Intent data){
            if(resultCode==activity.RESULT_OK){

                Uri uri=data.getData();

                Log.e("uri", uri.toString());

                ContentResolver cr=activity.getContentResolver();

                try{

                    Bitmap bitMap= null;

                        bitMap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                        Bitmap circleBitmap=pictureUtils.toRoundBitmap(bitMap);


//              灏嗘墜鏈轰腑鐨勫浘鐗囪缃埌鎴戜滑鐨勫ご鍍忎腑
//                iv_myPhoto.setImageBitmap(bitMap);
                    myApplication.getCurrentUser().setCurrentBitmap(circleBitmap);
//                    Myapplication.currentPhoto=circleBitmap;
                    isFirst=false;

                    activity.setContentView(R.layout.fragement_myinfo);
                    init();

                    isFirst=false;


                }catch (FileNotFoundException e) {
                    Log.e("Exception",e.getMessage());
                    e.printStackTrace();
                }
            }
            super.onActivityResult(requestCode, resultCode, data);
        }


      /*
    * 寰楀埌鎬у埆
    * */
        protected String getSex() {

            rg_sex = (RadioGroup) view.findViewById(R.id.rg_myInfo_sex);
            rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                public void onCheckedChanged(RadioGroup group, int checkedId) {
//                寰楀埌id
                    int radioButtonId = group.getCheckedRadioButtonId();

                    RadioButton rb = (RadioButton) activity.findViewById(radioButtonId);
                    sex= rb.getText().toString();

                }
            });
            return sex;
        }


  /*
    * 鍒ゆ柇骞撮緞鏄惁鍚堟硶
    * */
        private boolean isAgesLegal(String age) {
            Log.e("isAgesLegal","isThere");
            int ages = Integer.parseInt(age);
            if (ages < 110 && ages > 0) {
                return true;
            } else {
                Toast.makeText(view.getContext(), "年龄非法", Toast.LENGTH_LONG).show();
                return false;
            }
        }
    }



