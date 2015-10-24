package yumic.diverbob.love.ezlive.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Oathkeeper on 2015/10/24.
 */
public class CommonUtil {

    public static void toast(Context context,String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
