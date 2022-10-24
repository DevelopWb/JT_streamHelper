package com.juntai.look;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.ArrayMap;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.juntai.wisdom.basecomponent.app.BaseApplication;
import com.juntai.wisdom.basecomponent.utils.CrashHandler;
import com.juntai.wisdom.video.ModuleVideo_Init;
import com.mob.MobSDK;
import com.orhanobut.hawk.Hawk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by whs on 17/5/1.
 */

public class MyApplication extends BaseApplication {
    public Bitmap header;
    List<String> accesstokens;


    public Map<String,String> tokenMap = new ArrayMap<>();//融云测试token


    @Override
    public void appBackground(boolean isBackground, Activity activity) {

    }

    @Override
    public String getTinkerId() {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext(),"crash_tyb");
        Hawk.init(this).build();
        MobSDK.init(this);
//        initWebSocket();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
        accesstokens = new ArrayList<>();
        //Im模块初始化
//        ModuleIm_Init.init(this);
        //Video模块初始化
        ModuleVideo_Init.init();
//        EZOpenSDK.showSDKLog(true);
//        JPushInterface.setDebugMode(false);
//        JPushInterface.init(this);
//        NIMClient.init(this, loginInfo(), options());
//        // ... your codes
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Looper.prepare();
//                    Response rs = Conn.httpget(Conn.REQUEST_ACCESS_TOKEN);
//                    String rsstr = rs.body().string();
//                    PrintLog.printlog(rsstr);
//                    JSONObject atjson = new JSONObject(rsstr);
//                    String status = atjson.optString("status");
//                    if (status.equals("200")) {
//                        JSONArray tokensAr = atjson.optJSONArray("token");
//                        for(int i = 0;i<tokensAr.length();i++){
//                            JSONObject item = tokensAr.getJSONObject(i);
//                            String id = item.optString("maId");
//                            String appKey = item.optString("appKey");
//                            String accessToken = item.optString("accesstoken");
//                            CameraBelongAccount cameraBelongAccount = new CameraBelongAccount(id,appKey,accessToken);
//                            cameraBelongAccounts.add(cameraBelongAccount);
//                        }
//                        PrintLog.printlog("CameraAccessToken was setted");
//                    } else {
//                        Toast.makeText(MyApplication.this, "AccessToken获取失败", Toast.LENGTH_SHORT).show();
//                    }
//                    Looper.loop();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        if (NIMUtil.isMainProcess(this)) {
//            // 注意：以下操作必须在主进程中进行
//            // 1、UI相关初始化操作
//            // 2、相关Service调用
//        }
    }

//    private void initWebSocket() {
//
//        WebSocketSetting setting = new WebSocketSetting();
//        //连接地址，必填，例如 wss://echo.websocket.org
//        setting.setConnectUrl("wss://www.juntaikeji.net:32090/vms/websocket/socketServer.do");
//        //设置连接超时时间
//        setting.setConnectTimeout(15 * 1000);
//
//        //设置心跳间隔时间
//        setting.setConnectionLostTimeout(20);
//
//        //设置断开后的重连次数，可以设置的很大，不会有什么性能上的影响
//        setting.setReconnectFrequency(40);
//
//        //网络状态发生变化后是否重连，
//        //需要调用 WebSocketHandler.registerNetworkChangedReceiver(context) 方法注册网络监听广播
//        setting.setReconnectWithNetworkChanged(true);
//        //通过 init 方法初始化默认的 WebSocketManager 对象
//        WebSocketManager manager = WebSocketHandler.init(setting);
//        //启动连接
//        manager.start();
//    }


    //    /**
//     * 设置萤石key,token
//     * @param appKey
//     * @param accesstoken
//     */
//    public void setYsAccount(String appKey,String accesstoken) {
//        if (appKey == null || accesstoken == null){
//            return;
//        }
//        LogUtil.e("key="+appKey+"  token="+accesstoken);
//        EZOpenSDK.initLib(this, appKey);
//        EZOpenSDK.getInstance().setAccessToken(accesstoken);
//    }
//    public void setYsAccount(String which) {
//        for(int i =0;i<cameraBelongAccounts.size();i++){
//            if(which.equals(cameraBelongAccounts.get(i).getId())){
//                EZOpenSDK.initLib(this, cameraBelongAccounts.get(i).getAppKey());
//                EZOpenSDK.getInstance().setAccessToken(cameraBelongAccounts.get(i).getAccessToken());
//            }
//        }
//    }




}