package yumic.diverbob.love.ezlive.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yumic.diverbob.love.ezlive.MyApplication;
import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.activity.RoommateDetailActivity;
import yumic.diverbob.love.ezlive.bean.Roommate;

public class RoommateAdapter extends RecyclerView.Adapter<RoommateAdapter.ViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private  final Context mContext;
    private final ImageLoader imageLoader;


    private List<Roommate> data = new ArrayList<Roommate>();

    public MyApplication myApplication;

    public RoommateAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        myApplication = MyApplication.getInstance();
        //currentUser=myApplication.getCurrentUser();
        imageLoader = ImageLoader.getInstance(); // Get singleton instance
        //currentUser=myApplication.getCurrentUser();
        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext)
                .build();
        ImageLoader.getInstance().init(config);
    }


    public void setData(List<Roommate> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_roommate, parent, false),mContext);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (position >= 0) {

            //holder.textViewEventName.setText(data.get(position).getEventName());

            holder.textViewName.setText(data.get(position).getName());
            holder.textViewSex.setText(data.get(position).getSex().equals("1")?"男":"女");
            holder.textViewAge.setText(data.get(position).getAge()+"岁");
            String wishSex="不限";
            if(data.get(position).getWish_sex().equals("1")){
                wishSex="男";
            }else if(data.get(position).getWish_sex().equals("2")){
                wishSex="女";
            }
            holder.textViewWishsex.setText(wishSex);
            holder.textViewWishcontent.setText(data.get(position).getWish_content().substring(0,50)+"...");
            imageLoader.displayImage("http://112.74.203.123/xiaobaijuyi/public/picture/get/roommate/"+data.get(position).getId(), holder.imageViewPhoto);

            holder.linearLayoutAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext,RoommateDetailActivity.class);
                    myApplication.setCurrentRoommate(data.get(position));
                    mContext.startActivity(intent);
                }
            });


        }
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_activities.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder extends RecyclerView.ViewHolder {


        @Bind(R.id.textView_name)
        TextView textViewName;
        @Bind(R.id.textView_sex)
        TextView textViewSex;
        @Bind(R.id.textView_age)
        TextView textViewAge;
        @Bind(R.id.textView_hopesex)
        TextView textViewWishsex;
        @Bind(R.id.textView_wishcontent)
        TextView textViewWishcontent;
        @Bind(R.id.imageView_photo)
        ImageView imageViewPhoto;
        @Bind(R.id.linearLayout_all)
        LinearLayout linearLayoutAll;

        ViewHolder(final View view,final Context mContext) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getLayoutPosition());
                    Intent intent=new Intent(mContext, RoommateDetailActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    public void setData(Roommate roommate) {
        data.add(roommate);
        notifyDataSetChanged();
    }

    public void clearAll() {
        data.clear();
    }
}