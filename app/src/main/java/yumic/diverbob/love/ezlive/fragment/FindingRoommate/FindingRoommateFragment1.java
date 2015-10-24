package yumic.diverbob.love.ezlive.fragment.FindingRoommate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import yumic.diverbob.love.ezlive.R;


public class FindingRoommateFragment1 extends Fragment {


    @Bind(R.id.editText_price_min)
    EditText editTextPriceMin;
    @Bind(R.id.editText_price_max)
    EditText editTextPriceMax;
    @Bind(R.id.radioButton_wish_sex_male)
    RadioButton radioButtonWishSexMale;
    @Bind(R.id.radioButton_wish_sex_female)
    RadioButton radioButtonWishSexFemale;
    @Bind(R.id.radioButton_wish_sex_all)
    RadioButton radioButtonWishSexAll;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;
    @Bind(R.id.editText_age_min)
    EditText editTextAgeMin;
    @Bind(R.id.editText_age_max)
    EditText editTextAgeMax;
    @Bind(R.id.editText_position)
    EditText editTextPosition;
    @Bind(R.id.editText_wish_content)
    EditText editTextWishContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_finding_roommate_fragment1, container, false);
        ButterKnife.bind(this, view);

        initListener();
        return view;
    }

    private void initListener() {
        editTextPriceMin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b==false){

                }
            }
        });

        editTextPriceMax.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false) {

                }
            }
        });



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == radioButtonWishSexMale.getId()){

                }else if(i == radioButtonWishSexFemale.getId()){

                }else if(i == radioButtonWishSexAll.getId()){

                }

            }
        });

        editTextAgeMin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b==false){

                }
            }
        });

        editTextAgeMax.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false) {

                }
            }
        });

        editTextPosition.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b==false){

                }
            }
        });

        editTextWishContent.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b==false){

                }
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
