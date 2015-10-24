package yumic.diverbob.love.ezlive;

import android.app.Application;
import android.util.Log;

import yumic.diverbob.love.ezlive.bean.Roommate;
import yumic.diverbob.love.ezlive.bean.User;

/**
 * Created by Oathkeeper on 2015/10/24.
 */
public class MyApplication extends Application {

    public static String TAG;

    private static MyApplication myApplication = null;

    //用于保存当前用户
    private User currentUser;

    private Roommate currentRoommate;

    //需要调用时请用 myApplication = MyApplication.getInstance();
    public static MyApplication getInstance(){
        return myApplication;
    }




    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        TAG = this.getClass().getSimpleName();
        //由于Application类本身已经单例，所以直接按以下处理即可。
        myApplication = this;
        //设置
        setCurrentUser(currentUser);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


    public Roommate getCurrentRoommate() {
        return currentRoommate;
    }

    public void setCurrentRoommate(Roommate currentRoommate) {
        this.currentRoommate = currentRoommate;
    }
}
