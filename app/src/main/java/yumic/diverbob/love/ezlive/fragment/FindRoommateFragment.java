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
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import yumic.diverbob.love.ezlive.MyApplication;
import yumic.diverbob.love.ezlive.R;


/**
 * Created by Oathkeeper on 2015/9/9.
 */

public class FindRoommateFragment extends Fragment {
    // 存储上下文对象
    public Context context;
    public Activity activity;
    public MyApplication myApplication;
    public ListView mListView = null;
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
        Log.d(TAG,"onCreate");
    }

    //界面初始化
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_find_roommate, container, false);
        ButterKnife.bind(this, view);
        //  recyclerView.setLayoutManager(new LinearLayoutManager(context));//这里用线性显示 类似于listview
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));//这里用线性宫格显示 类似于grid view
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
        //recyclerView.setAdapter(browseAdapter);
        //初始化ListView
        //mListView=(ListView) view.findViewById(R.id.listview);
        // mListView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
