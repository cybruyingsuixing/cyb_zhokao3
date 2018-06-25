package com.bway.chenyibai_zhoukao3.mvp.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bway.chenyibai_zhoukao3.R;
import com.bway.chenyibai_zhoukao3.app.MyApp;
import com.bway.chenyibai_zhoukao3.mvp.model.bean.CloseBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class CloseAdapter extends RecyclerView.Adapter{

    private static final String TAG = "CloseAdapter*****";
    private List<CloseBean.DataBeanX.DataBean> list;

    public CloseAdapter(List<CloseBean.DataBeanX.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        String p1 = "http://365jia.cn/uploads/"+list.get(position).getPics().get(0);
        String p2 = "http://365jia.cn/uploads/"+list.get(position).getPics().get(0);
       // String p3= "http://365jia.cn/uploads/"+list.get(position).getPics().get(0);
        ImageLoader.getInstance().displayImage(p1,((MyViewHolder)holder).img, MyApp.getOptions());
        ImageLoader.getInstance().displayImage(p2,((MyViewHolder)holder).img1, MyApp.getOptions());
        ((MyViewHolder)holder).tv1.setText(list.get(position).getTitle());
        ((MyViewHolder)holder).tv2.setText(list.get(position).getAlias());
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    //获取控件id
   public class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final TextView tv1;
        private final TextView tv2;
        private final ImageView img1;

        public MyViewHolder(View itemView) {
           super(itemView);
            img = itemView.findViewById(R.id.base_img);
            img1 = itemView.findViewById(R.id.base_img1);
            tv1 = itemView.findViewById(R.id.base_tv1);
            tv2 = itemView.findViewById(R.id.base_tv2);
       }
   }

}
