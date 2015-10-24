package yumic.diverbob.love.ezlive.util;

import android.content.Context;

import yumic.diverbob.love.ezlive.Constants;

/**
 * Created by Oathkeeper on 2015/10/25.
 */
public class DefaultSettingUtil {

    public static void setDefaultRoommate(Context context){
        //默认查询全部信息
        SharedPreferenceUtil.saveStringDate(context, Constants.ROOMATE_SCOPE, "1");
        //默认为任意性别
        SharedPreferenceUtil.saveStringDate(context, Constants.ROOMATE_SEX, "0");
        //默认为期望任意性别
        SharedPreferenceUtil.saveStringDate(context, Constants.ROOMATE_WISH_SEX, "0");


        //设置默认区间（全区间）
        SharedPreferenceUtil.saveStringDate(context,Constants.ROOMATE_PRICE_MIN,Constants.DEFAULT_PRICE_MIN);
        SharedPreferenceUtil.saveStringDate(context,Constants.ROOMATE_PRICE_MAX,""+Constants.DEFAULT_PRICE_MAX);
        SharedPreferenceUtil.saveStringDate(context,Constants.ROOMATE_AGE_MIN,""+Constants.DEFAULT_AGE_MIN);
        SharedPreferenceUtil.saveStringDate(context,Constants.ROOMATE_AGE_MIN,""+Constants.DEFAULT_AGE_MAX);

    }
}
