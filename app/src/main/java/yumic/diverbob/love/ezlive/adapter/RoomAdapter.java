package yumic.diverbob.love.ezlive.adapter;

import android.content.Context;
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
import yumic.diverbob.love.ezlive.bean.Room;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private final ImageLoader imageLoader;



    private List<Room> data = new ArrayList<Room>();

    public MyApplication myApplication;

    public RoomAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        myApplication = MyApplication.getInstance();
        imageLoader = ImageLoader.getInstance(); // Get singleton instance
        //currentUser=myApplication.getCurrentUser();
        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext)
                .build();
        ImageLoader.getInstance().init(config);
    }


    public void setData(List<Room> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_room, parent, false), mContext);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (position >= 0) {

            //holder.textViewEventName.setText(data.get(position).getEventName());

            holder.textViewPosition.setText(data.get(position).getPosition());
            holder.textViewPosition.setText(data.get(position).getPosition_more());

            String wishSex = "性别不限";

            if (data.get(position).getSex()!=null&&data.get(position).getSex().equals("1")) {
                wishSex = "仅限男性";
            } else if (data.get(position).getSex()!=null&&data.get(position).getSex().equals("2")) {
                wishSex = "仅限女性";
            }else{
                wishSex = "性别不限";
            }

            imageLoader.displayImage("http://112.74.203.123/xiaobaijuyi/public/picture/get/room/" + data.get(position).getId(), holder.imageViewPhoto);

            holder.linearLayoutAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(mContext, RoommateDetailActivity.class);
//                    myApplication.setCurrentRoommate(data.get(position));
//                    mContext.startActivity(intent);
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
        @Bind(R.id.imageView_photo)
        ImageView imageViewPhoto;
        @Bind(R.id.textView_position)
        TextView textViewPosition;
        @Bind(R.id.textView_position_more)
        TextView textViewPositionMore;
        @Bind(R.id.textView_sex)
        TextView textViewSex;
        @Bind(R.id.linearLayout_all)
        LinearLayout linearLayoutAll;


        ViewHolder(final View view, final Context mContext) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getLayoutPosition());
//                    Intent intent=new Intent(mContext, RoommateDetailActivity.class);
//                    mContext.startActivity(intent);
                }
            });
        }
    }

    public void setData(Room room) {
        data.add(room);
        notifyDataSetChanged();
    }

    public void clearAll() {
        data.clear();
    }
}