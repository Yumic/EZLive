package yumic.diverbob.love.ezlive.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.Bind;
import yumic.diverbob.love.ezlive.R;

/**
 * Created by Oathkeeper on 2015/10/24.
 */
public class RoommatePopup extends PopupWindow {

    @Bind(R.id.textView_show)
    TextView textViewShow;
    @Bind(R.id.radioButton_show_all)
    RadioButton radioButtonShowAll;
    @Bind(R.id.radioButton_show_my)
    RadioButton radioButtonShowMy;
    @Bind(R.id.radioGroup_show)
    RadioGroup radioGroupShow;
    @Bind(R.id.textView_sex)
    TextView textViewSex;
    @Bind(R.id.radioButton_sex_male)
    RadioButton radioButtonSexMale;
    @Bind(R.id.radioGroup_sex)
    RadioGroup radioGroupSex;
    @Bind(R.id.radioButton_sex_female)
    RadioButton radioButtonSexFemale;
    @Bind(R.id.textView_price_min)
    TextView textViewPriceMin;
    @Bind(R.id.seekBar_price_min)
    SeekBar seekBarPriceMin;
    @Bind(R.id.textView_price_max)
    TextView textViewPriceMax;
    @Bind(R.id.seekBar_price_max)
    SeekBar seekBarPriceMax;
    @Bind(R.id.textView_price)
    TextView textViewPrice;
    @Bind(R.id.textView_price_show)
    TextView textViewPriceShow;
    @Bind(R.id.textView_roommatesex)
    TextView textViewRoommatesex;
    @Bind(R.id.radioButton_roommatesex_male)
    RadioButton radioButtonRoommatesexMale;
    @Bind(R.id.radioGroup_roommatesex)
    RadioGroup radioGroupRoommatesex;
    @Bind(R.id.radioButton_roommatesex_female)
    RadioButton radioButtonRoommatesexFemale;
    @Bind(R.id.radioButton_roommatesex_all)
    RadioButton radioButtonRoommatesexAll;
    @Bind(R.id.textView_roommateage)
    TextView textViewRoommateage;
    @Bind(R.id.editText_roomateage_min)
    EditText editTextRoomateageMin;
    @Bind(R.id.textView_roommateage_divider1)
    TextView textViewRoommateageDivider1;
    @Bind(R.id.editText_roomateage_max)
    EditText editTextRoomateageMax;
    private View contentView;

    public RoommatePopup(Activity activity) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(R.layout.popupwindow_findroommate, null);
        int h = activity.getWindowManager().getDefaultDisplay().getHeight();

        int w = activity.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        this.setContentView(contentView);
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

        iniListner();

    }

    private void iniListner() {

        //




    }

    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent, 0, 0);
        } else {
            this.dismiss();
        }
    }


}
