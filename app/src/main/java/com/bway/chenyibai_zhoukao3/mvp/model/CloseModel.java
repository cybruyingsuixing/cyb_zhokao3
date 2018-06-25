package com.bway.chenyibai_zhoukao3.mvp.model;

import android.util.Log;

import com.bway.chenyibai_zhoukao3.mvp.model.bean.CloseBean;
import com.bway.chenyibai_zhoukao3.utils.HttpConfig;
import com.bway.chenyibai_zhoukao3.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.List;

public class CloseModel {

    private static final String TAG = "CloseModel///";
    //网络请求
    public void doCLose(final onCallBack onCallBack){
        String url= HttpConfig.URL_TWO;
        OkHttpUtils.getInstance().doGet(url, new OkHttpUtils.onCallBack() {
            @Override
            public void onFaild(Exception e) {
                if(onCallBack!=null){
                    onCallBack.onFaild("有错误");
                }
            }
            @Override
            public void onResponse(String json) {
                //Log.d(TAG, "onResponse: "+json);
                Gson gson = new Gson();
                CloseBean closeBean = gson.fromJson(json, CloseBean.class);
                Log.d(TAG, "onResponse: "+closeBean);
                int code = closeBean.getCode();
                if(code==0){
                    if(onCallBack!=null){
                        onCallBack.onSuccess(closeBean);
                    }
                }else{
                    if(onCallBack!=null){
                        onCallBack.onFaild("有异常");
                    }
                }
            }
        });

    }


    //设置接口
    public interface onCallBack{
        void onSuccess(CloseBean closeBean);
        void onFaild(String error);
    }
}
