package yumic.diverbob.love.ezlive.bean;

/**
 *
 * 找室友界面显示的室友要求实体类
 * Created by Oathkeeper on 2015/10/24.
 */
public class Roommate {

    /**
     * 账号
     */
    private String username;

    /**
     * 想和……性别的人合租
     */
    private String wish_sex;

    /**
     * 对室友的期望
     */
    private String wish_content;


    /**
     *个人介绍
     */
    private String own_describe;

    /**
     * 期望居住的区域
     */
    private String position;

    /**
     * 更详细的地址
     */
    private String position_more;

    /**
     * 将tag用空格做间隔拼接
     */
    private String tags;

    /**
     * 期望室友的年龄区间
     */
    private String age_min;
    private String age_max;


    /**
     * 期望的价格区间
     */
    private String price_min;
    private String price_max;




    /**
     * 昵称（姓名）并不是用户名
     */
    private String name;

    //private String password;


    /**
     * 性别
     */
    private String sex;

    /**
     * qq号
     */
    private String qq;

    /**
     * 微信
     */
    private String weixin;

    /**
     * 年龄
     */
    private String age;

    /**
     * 表示ID
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwn_describe() {
        return own_describe;
    }

    public void setOwn_describe(String own_describe) {
        this.own_describe = own_describe;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition_more() {
        return position_more;
    }

    public void setPosition_more(String position_more) {
        this.position_more = position_more;
    }

    public String getPrice_max() {
        return price_max;
    }

    public void setPrice_max(String price_max) {
        this.price_max = price_max;
    }

    public String getPrice_min() {
        return price_min;
    }

    public void setPrice_min(String price_min) {
        this.price_min = price_min;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getWish_content() {
        return wish_content;
    }

    public void setWish_content(String wish_content) {
        this.wish_content = wish_content;
    }

    public String getWish_sex() {
        return wish_sex;
    }

    public void setWish_sex(String wish_sex) {
        this.wish_sex = wish_sex;
    }
}
