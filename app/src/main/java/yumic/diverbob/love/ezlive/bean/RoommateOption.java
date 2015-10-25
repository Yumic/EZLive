package yumic.diverbob.love.ezlive.bean;

import yumic.diverbob.love.ezlive.Constants;
import yumic.diverbob.love.ezlive.util.SharedPreferenceUtil;

/**
 * Created by Oathkeeper on 2015/10/25.
 */
public class RoommateOption {

    private String all= "1";
    private String sex= "0";
    private String wish_sex= "0";
    private  String price_min= "0";
    private String price_max ="10000";
    private String age_min="15";
    private  String age_max="40";

    public String getAge_max() {
        return age_max;
    }

    public void setAge_max(String age_max) {
        this.age_max = age_max;
    }

    public String getAge_min() {
        return age_min;
    }

    public void setAge_min(String age_min) {
        this.age_min = age_min;
    }

    public String getPrice_max() {
        return price_max;
    }

    public void setPrice_max(String price_max) {
        this.price_max = price_max;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPrice_min() {
        return price_min;
    }

    public void setPrice_min(String price_min) {
        this.price_min = price_min;
    }

    public String getWish_sex() {
        return wish_sex;
    }

    public void setWish_sex(String wish_sex) {
        this.wish_sex = wish_sex;
    }
}
