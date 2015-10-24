package yumic.diverbob.love.ezlive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yumic.diverbob.love.ezlive.MyApplication;
import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.bean.Roommate;

public class RoommateAdapter extends RecyclerView.Adapter<RoommateAdapter.ViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;


    private List<Roommate> data = new ArrayList<Roommate>();

    public MyApplication myApplication;

    public RoommateAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        myApplication = MyApplication.getInstance();
        //currentUser=myApplication.getCurrentUser();
    }


    public void setData(List<Roommate> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_roommate, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (position >= 0) {

            //holder.textViewEventName.setText(data.get(position).getEventName());

            holder.textViewName.setText(data.get(position).getName());
            holder.textViewSex.setText(data.get(position).getSex());
            holder.textViewAge.setText(data.get(position).getAge());
            holder.textViewWishsex.setText(data.get(position).getWish_sex());
            holder.textViewWishcontent.setText(data.get(position).getWish_content());


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


        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //TODO 在这里加监听
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getLayoutPosition());
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