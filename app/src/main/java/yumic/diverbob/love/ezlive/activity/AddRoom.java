package yumic.diverbob.love.ezlive.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import yumic.diverbob.love.ezlive.R;
import yumic.diverbob.love.ezlive.bean.Roommate;
import yumic.diverbob.love.ezlive.net.NetUrl;

/**
 * Created by apple on 15/10/25.
 */
public class AddRoom extends Activity {
    private EditText city,area,address,money,type,describe;
    private Button up;
    private String cityS,areaS,addressS,moneyS,typeS,describeS;
    private RequestQueue mQueue;
    private StringRequest addRoomStringRequest;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
        init();
        //网络处理初始化
        netinit();
    }

    private void init() {
        city= (EditText) findViewById(R.id.city);
        area= (EditText) findViewById(R.id.area);
        address= (EditText) findViewById(R.id.address);
        money= (EditText) findViewById(R.id.money);
        type= (EditText) findViewById(R.id.type);
        describe= (EditText) findViewById(R.id.describe);
        up= (Button) findViewById(R.id.up);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityS = city.getText().toString();
                areaS = area.getText().toString();
                addressS = address.getText().toString();
                moneyS = money.getText().toString();
                typeS = type.getText().toString();
                describeS = describe.getText().toString();

                mQueue.add(addRoomStringRequest);
            }
        });
    }

    private void netinit() {

        //获取信息
         addRoomStringRequest = new StringRequest(Request.Method.POST, NetUrl.My_Info,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);

                        if (response.equals("1")){

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);


            }
        }) {

             protected Map<String, String> getParams() {
                 Map<String, String> params = new HashMap<String, String>();
                 params.put("position", areaS);
                 params.put("position_more", addressS);
                 params.put("price", moneyS);
                 params.put("type",typeS);
                 params.put("describe",describeS);
                 return params;
             }
        };

    }
}
