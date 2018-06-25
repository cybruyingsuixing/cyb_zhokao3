package com.bway.chenyibai_zhoukao3.mvp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bway.chenyibai_zhoukao3.R;
import com.bway.chenyibai_zhoukao3.base.BaseActivity;
import com.bway.chenyibai_zhoukao3.base.IView;
import com.bway.chenyibai_zhoukao3.mvp.model.bean.CloseBean;
import com.bway.chenyibai_zhoukao3.mvp.presenter.ClosePresenter;
import com.bway.chenyibai_zhoukao3.mvp.view.adapter.CloseAdapter;
import com.bway.chenyibai_zhoukao3.mvp.view.view.CloseView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ClosePresenter> implements CloseView {

    private static final String TAG = "MainActivity****";
    private RecyclerView recyclerView;

    private List<CloseBean.DataBeanX.DataBean> list= new ArrayList<>();
    private CloseAdapter closeAdapter;

    @Override
    protected void initData() {
        presenter.getClose();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initViews() {
        //获取id
        recyclerView = findViewById(R.id.main_recy);
    }

    @Override
    protected ClosePresenter provide() {
        return new ClosePresenter(this);
    }

    @Override
    protected int priovId() {
        return R.layout.activity_main;
    }

    //成功的方法
    @Override
    public void onSuccess(CloseBean closeBean) {

        List<CloseBean.DataBeanX.DataBean> data = closeBean.getData().getData();
        list.addAll(data);
        //创建适配器
        closeAdapter = new CloseAdapter(list);
      GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
       /* LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);*/
        recyclerView.setAdapter(closeAdapter);

    }

    @Override
    public void onFaild(String error) {

    }
}
