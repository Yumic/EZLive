package yumic.diverbob.love.ezlive.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import yumic.diverbob.love.ezlive.MyApplication;
import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.activity.FindingInfoDetailActivity;
import yumic.diverbob.love.ezlive.bean.Roommate;
import yumic.diverbob.love.ezlive.net.NetUrl;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class MyFindingInfoFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button detailButton,changeButton;
    private ImageView myPicture;
    private TextView tv1,tv2,tv3;
    // 存储上下文对象
    private Context context;
    private Activity activity;
    private MyApplication myApplication;
    private RequestQueue mQueue;
    private View view;
    private StringRequest getMyRoomStringRequest;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MyFindingInfoFragment.
     */
    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        activity = getActivity();
        //通过MyApplication获取当前用户
        myApplication = MyApplication.getInstance();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_my_finding_info, container, false);
        // Inflate the layout for this fragment
        final RequestQueue mQueue = Volley.newRequestQueue(activity);
        init();
        //网络处理初始化
        netinit();
        mQueue.add(getMyRoomStringRequest);
        return view;

    }

    private void netinit() {

        //获取信息

        getMyRoomStringRequest = new StringRequest(Request.Method.POST, NetUrl.My_Info,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                        JSONArray arr = null;

                        try {
                            arr = new JSONArray(response);
                            JSONObject temp = (JSONObject)arr.getJSONObject(0);
                            Log.e("TAG", "7");
                            Log.e("TAG", "6");
                            Roommate roommate=new Roommate();
                            Log.e("TAG", "5");
                            //得到数据
                            roommate.setWish_sex(temp.getString("wish_sex"));
                            roommate.setWish_content(temp.getString("wish_content"));
                            roommate.setOwn_describe(temp.getString("own_describe"));
                            Log.e("TAG", "4");
                            roommate.setPosition(temp.getString("position"));
                            roommate.setPosition_more(temp.getString("position_more"));
                            roommate.setAge_min(temp.getString("age_min"));
                            Log.e("TAG", "3");
                            roommate.setAge_max(temp.getString("age_max"));
                            roommate.setPrice_max(temp.getString("price_max"));
                            Log.e("TAG", "2");
                            roommate.setPrice_min(temp.getString("price_min"));
                            Log.e("TAG", "1");
                            String sex = null;
                            if (temp.getString("wish_sex").equals("0")){
                                sex="不限";
                            }else if (temp.getString("wish_sex").equals("1")){
                                sex="男";
                            }else if (temp.getString("wish_sex").equals("2")){
                                sex="女";
                            }
                            myApplication.setCurrentRoommate(roommate);
                            //设置数据
                            tv1.setText("");
                            tv2.setText("期望舍友的性别："+sex);
                            tv3.setText("对舍友期望："+temp.getString("wish_content"));
                        } catch (Exception e) {

                        }



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
        tv1= (TextView) view.findViewById(R.id.tv1);
        tv2= (TextView) view.findViewById(R.id.tv2);
        tv3= (TextView) view.findViewById(R.id.tv3);
        myPicture= (ImageView) view.findViewById(R.id.my_picture);
        detailButton= (Button) view.findViewById(R.id.detail_message);
        detailButton.setOnClickListener(this);
        changeButton= (Button) view.findViewById(R.id.change_message);
        changeButton.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_message:

                break;
            case R.id.detail_message:
                Intent intent=new Intent(context, FindingInfoDetailActivity.class);
                startActivity(intent);
                break;
        }
    }



}
