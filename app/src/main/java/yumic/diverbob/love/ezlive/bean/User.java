package yumic.diverbob.love.ezlive.bean;

/**
 * Created by Oathkeeper on 2015/10/24.
 */
public class User {
    private String managerId;
    private String managerPhone;
    private String imagePath;
    private String nickName;

    public User() {
        setManagerId("未能获取");
        setManagerPhone("未能获取");
        setImagePath("未能获取");
        setNickName("未能获取");
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
