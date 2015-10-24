package yumic.diverbob.love.ezlive.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import yumic.diverbob.love.ezlive.MyApplication;
import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.adapter.RoommateAdapter;
import yumic.diverbob.love.ezlive.bean.Roommate;
import yumic.diverbob.love.ezlive.net.NetUrl;
import yumic.diverbob.love.ezlive.util.CommonUtil;
import yumic.diverbob.love.ezlive.view.RoommatePopup;


/**
 * Created by Oathkeeper on 2015/9/9.
 */

public class FindRoommateFragment extends Fragment {
    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.imageView_down_arrow)
    ImageView imageViewDownArrow;
    // 存储上下文对象
    private Context context;
    private Activity activity;
    private MyApplication myApplication;
    private RequestQueue mQueue;

    private RoommateAdapter roommateAdapter;
    private RoommatePopup roommatePopup;

    private ArrayList<Roommate> dataList;

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.swipe)
    SwipeRefreshLayout swipe;

    private final String TAG = "FindRoommateFragment";


    /**
     * 初始化操作
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        activity = getActivity();
        //通过MyApplication获取当前用户
        myApplication = MyApplication.getInstance();
        roommateAdapter = new RoommateAdapter(context);
        roommatePopup = new RoommatePopup(activity);
        Log.d(TAG, "onCreate");
        dataList = new ArrayList<Roommate>();

        fetchInfo();
    }


    //界面初始化
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_find_roommate, container, false);
        ButterKnife.bind(this, view);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流

        swipe.setColorSchemeResources(R.color.colorPrimary);
        swipe
                .setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        swipe.setRefreshing(true);
                        Log.d("Swipe", "Refreshing Number");

                    }
                });
        recyclerView.setAdapter(roommateAdapter);

        //取消焦点
        // editText.clearFocus();

        imageViewDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roommatePopup.showPopupWindow(view);
            }
        });
                //初始化ListView
                //mListView=(ListView) view.findViewById(R.id.listview);
                // mListView.setAdapter(adapter);
        return view;
    }

    private void fetchInfo() {

        //获取Volley的Queue
        mQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, NetUrl.FIND_ROOMMATE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d(TAG, s);
                        JSONArray array;
                        JSONObject object;
                        //对获得json array进行解析
                        try {
                            array = new JSONArray(s);
                            int length = array.length();
                            for (int i = 0; i < length; i++) {
                                Roommate temp = new Roommate();
                                object = array.getJSONObject(i);
                                temp.setUsername(object.getString("username"));
                                temp.setWish_sex(object.getString("wish_sex"));
                                temp.setWish_content(object.getString("wish_content"));
                                temp.setOwn_describe(object.getString("own_describe"));
                                temp.setPosition(object.getString("position"));
                                temp.setPosition_more(object.getString("position_more"));
                                temp.setTags(object.getString("tags"));
                                temp.setAge_min(object.getString("age_min"));
                                temp.setAge_max(object.getString("age_max"));
                                temp.setPrice_max(object.getString("price_max"));
                                temp.setPrice_max(object.getString("price_min"));
                                temp.setSex(object.getString("sex"));
                                temp.setQq(object.getString("qq"));
                                temp.setWeixin(object.getString("weixin"));
                                temp.setAge(object.getString("age"));
                                temp.setId(object.getString("id"));
                                roommateAdapter.setData(temp);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                CommonUtil.toast(context, "无法获取数据，请检查网络连接");
            }
        }) {
            //添加Post参数
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("all", "1");
                map.put("sex", "0");
                map.put("wish_sex", "0");
                map.put("price_min", "0");
                map.put("price_max", "10000");
                map.put("age_min", "15");
                map.put("age_max", "40");
                map.put("tag", "");
                return map;
            }
        };
        //将请求加入请求队列
        mQueue.add(stringRequest);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
