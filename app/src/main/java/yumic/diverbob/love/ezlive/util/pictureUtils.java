package yumic.diverbob.love.ezlive.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.*;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;


/**
 * Created by Qingwen_li on 2015/9/29.
 * 工具类
 */
public class pictureUtils {
    /*
    * 将drawable里面的图片转换为bitmap，可以实现默认的图片
    * */
    public static Bitmap drawableToBitmap(Drawable drawable){
//        创建一个bitmap对象
        Bitmap bitmap=Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                drawable.getOpacity()!= PixelFormat.OPAQUE  ? Bitmap.Config.ARGB_8888:Bitmap.Config.RGB_565);
        return bitmap;
    }

    public static Bitmap zoomBitmap(Bitmap bitmap){

//        获得图片的真实的宽度和高度
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        float scaleRate=0.01f;



//      想实现的照片的大小（还是没有真正的搞清楚，应该是目标的宽度和高度）
        int aimWidth=150;
        int aimHeight=150;


//      创建一个矩形对象来实现照片的缩放
        Matrix matrix=new Matrix();

       /* float scaleWidth =  width*scaleRate;
        float  scaleHeight =  height*scaleRate;*/


        float scaleWidth = ((float)aimWidth / width);
        float scaleHeight=scaleWidth*height/width;
//        float  scaleHeight = ((float)aimHeight/ height);

        System.out.println("scaleWidth"+scaleWidth);

        matrix.setScale(scaleWidth, scaleHeight);
        Bitmap newbmp=Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
        return newbmp;
    }



    /**
     * 转换图片成圆形
     *
     * @param bitmap
     *            传入Bitmap对象
     * @return
     */
    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float roundPx;
        float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
        if (width <= height) {
            roundPx = width / 2;
            left = 0;
            top = 0;
            right = width;
            bottom = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        } else {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            bottom = height;
            width = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }

        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect src = new Rect((int) left, (int) top, (int) right, (int) bottom);
        final Rect dst = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
        final RectF rectF = new RectF(dst);

        paint.setAntiAlias(true);// 设置画笔无锯齿

        canvas.drawARGB(0, 0, 0, 0); // 填充整个Canvas
        paint.setColor(color);

        // 以下有两种方法画圆,drawRounRect和drawCircle
        // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);// 画圆角矩形，第一个参数为图形显示区域，第二个参数和第三个参数分别是水平圆角半径和垂直圆角半径。
        canvas.drawCircle(roundPx, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));// 设置两张图片相交时的模式,参考http://trylovecatch.iteye.com/blog/1189452
        canvas.drawBitmap(bitmap, src, dst, paint); //以Mode.SRC_IN模式合并bitmap和已经draw了的Circle

        return output;
    }
}
