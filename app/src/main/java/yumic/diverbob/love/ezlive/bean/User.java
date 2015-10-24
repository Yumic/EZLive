package yumic.diverbob.love.ezlive.bean;

import android.graphics.Bitmap;

/**
 * Created by Oathkeeper on 2015/10/24.
 */
public class User {
    private String managerId;
    private String managerPhone;
    private String imagePath;
//    保留必要账户的唯一性凭证，就是注册用的手机号
    private  String name;
    private String nickName;
    private  String sex;
    private  String age;
    private Bitmap currentBitmap;

    public Bitmap getCurrentBitmap() {
        return currentBitmap;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCurrentBitmap(Bitmap currentBitmap) {
        this.currentBitmap = currentBitmap;
    }

    public User() {
        setManagerId("未能获取");
        setManagerPhone("未能获取");
        setImagePath("未能获取");
        setNickName("未能获取");

    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
