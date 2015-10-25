package yumic.diverbob.love.ezlive.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import yumic.diverbob.love.ezlive.Constants;
import yumic.diverbob.love.ezlive.MyApplication;
import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.bean.RoomOption;
import yumic.diverbob.love.ezlive.util.CommonUtil;

/**
 * Created by Oathkeeper on 2015/10/24.
 */
public class RoomPopup extends PopupWindow {
    private final String TAG="RoomPopup";
    Activity activity;
    Context context;
    MyApplication myApplication;
    RoomOption currentRoomOption;


    private View contentView;
    private RadioButton radioButtonShowAll;
    private RadioButton radioButtonShowMy;
    private RadioGroup radioGroupShow;
    private RadioButton radioButtonSexMale;
    private RadioGroup radioGroupSex;
    private RadioButton radioButtonSexFemale;
    private EditText editTextPriceMin;
    private EditText editTextPriceMax;

    public RoomPopup(Activity activity, Context context) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(R.layout.popupwindow_findroom, null);
        this.activity=activity;
        this.context=context;
        myApplication= MyApplication.getInstance();
        currentRoomOption=myApplication.getCurrentRoomOption();

        // 设置SelectPicPopupWindow的View
        this.setContentView(contentView);


        findView();

        int h = activity.getWindowManager().getDefaultDisplay().getHeight();

        int w = activity.getWindowManager().getDefaultDisplay().getWidth();

        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w - 4);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(AbsListView.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        ColorDrawable dw = new ColorDrawable(00000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);
        // mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        // 设置SelectPicPopupWindow弹出窗体动画效果

        this.setAnimationStyle(R.style.AnimationPreview);

        iniListner(activity);
       // iniDefault();

    }

    private void findView() {

        radioButtonShowAll = (RadioButton) contentView.findViewById(R.id.radioButton_show_all);

        radioButtonShowMy = (RadioButton) contentView.findViewById(R.id.radioButton_show_my);

        radioGroupShow = (RadioGroup) contentView.findViewById(R.id.radioGroup_show);

      radioButtonSexMale = (RadioButton) contentView.findViewById(R.id.radioButton_sex_male);

        radioGroupSex = (RadioGroup) contentView.findViewById(R.id.radioGroup_sex);

       radioButtonSexFemale = (RadioButton) contentView.findViewById(R.id.radioButton_sex_female);

       editTextPriceMin = (EditText) contentView.findViewById(R.id.editText_price_min);

       editTextPriceMax = (EditText) contentView.findViewById(R.id.editText_price_max);




    }

    private void iniDefault() {
        radioButtonShowAll.isChecked();
        radioButtonSexMale.isChecked();
        editTextPriceMin.setText(Constants.DEFAULT_PRICE_MIN);
        editTextPriceMax.setText(Constants.DEFAULT_PRICE_MAX);


    }

    private void iniListner(final Context context) {

        radioGroupShow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == radioButtonShowAll.getId()) {
                    currentRoomOption.setAll("1");
                    Log.d(TAG, "ROOM_SCOPE1");

                } else if (i == radioButtonShowMy.getId()) {
                    //0代表查询收藏
                    currentRoomOption.setAll("0");
                    Log.d(TAG, "ROOM_SCOPE0");
                }

            }
        });

        radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == radioButtonSexMale.getId()) {
                    //1代表男
                    currentRoomOption.setSex("1");
                    Log.d(TAG, "ROOM_SEX1");

                } else if (i == radioButtonSexFemale.getId()) {
                    //2代表女
                    currentRoomOption.setSex("2");

                    Log.d(TAG, "ROOM_SEX2");
                }
            }
        });



    }


    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent, 0, 0);
        } else {
            this.dismiss();
        }
    }

    @Override
    public void dismiss() {

        int intPriceMin;
        int intPriceMax;
        try{

            intPriceMin=Integer.parseInt(editTextPriceMin.getText().toString());
            intPriceMax=Integer.parseInt(editTextPriceMax.getText().toString());

            Log.d(TAG,"intPriceMin"+intPriceMin+ "intPriceMax"+intPriceMax
                    );
            if(intPriceMin<Integer.parseInt(Constants.DEFAULT_PRICE_MIN)
                    &&intPriceMax>Integer.parseInt(Constants.DEFAULT_PRICE_MAX)){
                CommonUtil.toast(activity, "价格区间应在" + Constants.ROOMATE_PRICE_MIN + "元/月——"
                        + Constants.DEFAULT_PRICE_MIN + "元/月");
                editTextPriceMin.setText(Constants.DEFAULT_PRICE_MIN);
                editTextPriceMax.setText(Constants.DEFAULT_PRICE_MAX);
            }else{
                currentRoomOption.setPrice_min("" + intPriceMin);
                currentRoomOption.setPrice_max("" + intPriceMax);
                super.dismiss();
            }

        }catch(Exception e){
            CommonUtil.toast(activity, "请输入正确的数字格式");
        }



    }
}
