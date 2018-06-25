package com.bway.chenyibai_zhoukao3.mvp.presenter;

import com.bway.chenyibai_zhoukao3.base.BasePresenter;
import com.bway.chenyibai_zhoukao3.base.IView;
import com.bway.chenyibai_zhoukao3.mvp.model.CloseModel;
import com.bway.chenyibai_zhoukao3.mvp.model.bean.CloseBean;
import com.bway.chenyibai_zhoukao3.mvp.view.view.CloseView;

public class ClosePresenter extends BasePresenter<CloseView> {
    private static final String TAG = "ClosePresenter******";

    private CloseModel closeModel;

    public ClosePresenter(CloseView view) {
        super(view);

    }


    @Override
    protected void initModel() {
        closeModel = new CloseModel();
    }


    public void getClose() {
        closeModel.doCLose(new CloseModel.onCallBack() {
            @Override
            public void onSuccess(CloseBean closeBean) {
                if (view != null) {
                    view.onSuccess(closeBean);
                }
            }

            @Override
            public void onFaild(String error) {

                if (view != null) {
                    view.onFaild(error);
                }
            }
        });
    }


}
