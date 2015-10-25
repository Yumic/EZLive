package yumic.diverbob.love.ezlive.net;

/**
 * Created by apple on 15/10/24.
 */
public class NetUrl {
    private static final String BASE_ADDRESS = "http://112.74.203.123/xiaobaijuyi/public";

    //登录
    public static final String LOGIN = BASE_ADDRESS + "/account/login";

    //找室友
    public static final String FIND_ROOMMATE =BASE_ADDRESS+"/find/friend";

    //找房源
    public static final String FIND_ROOM =BASE_ADDRESS+"/find/room";

    //我的合租信息
    public static final String My_Info=BASE_ADDRESS+"/find/my/roommate";
    //我的房源
    public static final String MY_ROOM=BASE_ADDRESS+"/find/my/room";
    //添加房源
    public static final String ADD_ROOM=BASE_ADDRESS+"/save/room";


}
