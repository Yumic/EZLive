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
import android.widget.ImageButton;
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
import yumic.diverbob.love.ezlive.adapter.RoomAdapter;
import yumic.diverbob.love.ezlive.bean.Room;
import yumic.diverbob.love.ezlive.bean.RoomOption;
import yumic.diverbob.love.ezlive.net.NetUrl;
import yumic.diverbob.love.ezlive.util.CommonUtil;
import yumic.diverbob.love.ezlive.view.RoomPopup;


/**
 * Created by Oathkeeper on 2015/9/9.
 */

public class FindRoomFragment extends Fragment {
    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.imageButton)
    ImageButton imageButton;
    @Bind(R.id.imageView_down_arrow)
    ImageView imageViewDownArrow;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.swipe)
    SwipeRefreshLayout swipe;
    // 存储上下文对象
    private Context context;
    private Activity activity;
    private MyApplication myApplication;
    private RequestQueue mQueue;

    private RoomAdapter roomAdapter;
    private RoomPopup roomPopup;
    private RoomOption currentRoomOption;

    private ArrayList<Room> dataList;
    private final String TAG = "FindRoomFragment";


    /**
     * 初始化操作
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        activity = getActivity();
        //通过MyApplication获取当前用户
        myApplication = MyApplication.getInstance();
        currentRoomOption = myApplication.getCurrentRoomOption();
        roomAdapter = new RoomAdapter(context);

        Log.d(TAG, "onCreate");
        dataList = new ArrayList<Room>();
        // DefaultSettingUtil.setDefaultRoommate(activity);

        roomPopup = new RoomPopup(activity, context);

        // iniDefault();
        fetchInfo();

    }


    //界面初始化
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_find_room, container, false);
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
        recyclerView.setAdapter(roomAdapter);

        //取消焦点
        // editText.clearFocus();

        imageViewDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roomPopup.showPopupWindow(view);
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
        StringRequest stringRequest = new StringRequest(Request.Method.POST, NetUrl.FIND_ROOM,
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
                                Room temp = new Room();
                                object = array.getJSONObject(i);
                                temp.setAge_min(object.getString("age_min"));
                                temp.setAge_max(object.getString("age_max"));
                                temp.setAround(object.getString("around"));
                                temp.setDescribe(object.getString("describe"));
                                temp.setFlag(object.getString("flag"));
                                temp.setFloor(object.getString("floor"));
                                temp.setId(object.getString("id"));
                                temp.setOwner_describe(object.getString("owner_describe"));
                                temp.setOwner_tags(object.getString("owner_tags"));
                                temp.setPosition(object.getString("position"));
                                temp.setPosition_more(object.getString("position_more"));
                                temp.setPrice_min(object.getString("price_min"));
                                temp.setPrice_man(object.getString("price_max"));
                                temp.setRoom_owner(object.getString("room_owner"));
                                //temp.setWeixin(object.getString("weixin"));
                                temp.setSquare(object.getString("square"));
                                temp.setTags(object.getString("tags"));
                                temp.setType(object.getString("type"));
                                temp.setWish_describe(object.getString("wish_describe"));

                                roomAdapter.setData(temp);
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
                String all = currentRoomOption.getAll();
                String sex = currentRoomOption.getSex();
                String price_min = currentRoomOption.getPrice_min();
                String price_max = currentRoomOption.getPrice_max();
                String age_min = currentRoomOption.getAge_min();
                String age_max = currentRoomOption.getAge_max();
//                map.put("all", "1");
//                map.put("sex", "0");
//                map.put("wish_sex", "0");
//                map.put("price_min", "0");
//                map.put("price_max", "10000");
//                map.put("age_min", "15");
//                map.put("age_max", "40");
//                map.put("tag", "");

                map.put("all", all);
                map.put("sex", sex);
                map.put("price_min", price_min);
                map.put("price_max", price_max);
                map.put("age_min", age_min);
                map.put("age_max", age_max);
                map.put("tag", "");

                Log.d("all", all);

                Log.d("sex", sex);
                Log.d("price_min", price_min);
                Log.d("price_max", price_max);
                Log.d("age_min", age_min);
                Log.d("age_max", age_max);
                Log.d("test", "");

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
