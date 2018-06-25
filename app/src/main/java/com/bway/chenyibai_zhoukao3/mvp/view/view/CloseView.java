package com.bway.chenyibai_zhoukao3.mvp.view.view;

import com.bway.chenyibai_zhoukao3.base.IView;
import com.bway.chenyibai_zhoukao3.mvp.model.bean.CloseBean;

public interface CloseView extends IView{

    void onSuccess(CloseBean closeBean);
    void onFaild(String error);
}
