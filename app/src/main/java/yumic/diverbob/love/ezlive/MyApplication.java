package yumic.diverbob.love.ezlive;

import android.app.Application;
import android.util.Log;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

import yumic.diverbob.love.ezlive.bean.RoomOption;
import yumic.diverbob.love.ezlive.bean.Roommate;
import yumic.diverbob.love.ezlive.bean.RoommateOption;
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

    private RoommateOption currentRoommateOption ;
    private RoomOption currentRoomOption ;

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
        currentRoommateOption=new RoommateOption();
        currentRoomOption=new RoomOption();
        setCurrentRoommateOption(currentRoommateOption);
        setCurrentRoomOption(currentRoomOption);

        File cacheDir = StorageUtils.getCacheDirectory(this);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
                .diskCacheExtraOptions(480, 800, null)
                .threadPoolSize(3) // default
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCache(new UnlimitedDiskCache(cacheDir)) // default
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(this)) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs()
                .build();

    }

    public RoommateOption getCurrentRoommateOption() {
        return currentRoommateOption;
    }

    public void setCurrentRoommateOption(RoommateOption currentRoommateOption) {
        this.currentRoommateOption = currentRoommateOption;
    }

    public RoomOption getCurrentRoomOption() {
        return currentRoomOption;
    }

    public void setCurrentRoomOption(RoomOption currentRoomOption) {
        this.currentRoomOption = currentRoomOption;
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
