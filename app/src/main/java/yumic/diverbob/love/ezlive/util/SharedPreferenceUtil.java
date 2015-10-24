package yumic.diverbob.love.ezlive.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtil {
    //定义的文件名
	public static String CONFIG = "config";
	private static SharedPreferences sharedPreferences;

	public static void saveStringDate(Context context , String key , String value){
		
		if(sharedPreferences == null){
			//第一个参数用于指定SharedPreference文件的名称，第二个参数用于指定操作模式
			sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
		}
		//获取一个SharedPreferences.Editor对象.用put方法添加数据.调用commit()方法提交数据，完成存储操作
		sharedPreferences.edit().putString(key, value).commit();
	}
	
	public static String getStringDate(Context context , String key , String defaultValue){
		
		if(sharedPreferences == null){
			sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
		}
		
		return sharedPreferences.getString(key, defaultValue);
		
	}
	
	public static void saveBooleanDate(Context context , String key , boolean value){
		
		if(sharedPreferences == null){
			sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
		}
		
		sharedPreferences.edit().putBoolean(key, value).commit();
		
	}
	
	public static boolean getBooleanDate(Context context , String key , boolean defaultValue){
		
		if(sharedPreferences == null){
			sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
		}
		
		return sharedPreferences.getBoolean(key, defaultValue);
		
	}
	
	public static void saveIntDate(Context context , String key , int value){
		
		if(sharedPreferences == null){
			sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
		}
		
		sharedPreferences.edit().putInt(key, value).commit();
		
	}
	
	public static int getIntDate(Context context ,String key , int defaultValue){
		
		if(sharedPreferences == null){
			sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
		}
		
		return sharedPreferences.getInt(key, defaultValue);
		
	}
	
	public static void saveLongDate(Context context , String key , long value){
		
		if(sharedPreferences == null){
			sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
		}
		
		sharedPreferences.edit().putLong(key, value).commit();
		
	}
	
	public static long getLongDate(Context context , String key , long defaultValue){
		
		if(sharedPreferences == null){
			sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
		}
		
		return sharedPreferences.getLong(CONFIG, defaultValue);
		
	}
	
	public static void saveFloatDate(Context context , String key , float value){
		
		if(sharedPreferences == null){
			sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
		}
		
		sharedPreferences.edit().putFloat(key, value).commit();
		
	}
	
	public static float getFloatDate(Context context , String key , float defaultValue){
		if(sharedPreferences == null){
			sharedPreferences = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
		}
		return sharedPreferences.getFloat(key, defaultValue);
	}
	
}
