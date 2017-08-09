package com.mredrock.freshmanspecial.Units;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mredrock.freshmanspecial.Beans.MienBeans.BeautyBean;
import com.mredrock.freshmanspecial.Beans.MienBeans.ExcellentBean;
import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zxzhu on 2017/8/7.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    public static final int BEAUTY = 0,STUDENT = 1,TEACHER = 2;
    private List data = new ArrayList<>();
    private Context context;
    private int type;
    private PopupWindow popupWindow;


    public MyRecyclerAdapter(Context context, List data, int viewType){
        this.context = context;
        this.data = data;
        this.type = viewType;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (type == BEAUTY) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_beauty, parent, false);
            return new MyViewHolder(view,BEAUTY);
        }else if (type == STUDENT) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_excellent, parent, false);
            return new MyViewHolder(view,STUDENT);
        }
        else if (type == TEACHER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_excellent, parent, false);
            return new MyViewHolder(view,TEACHER);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        switch (holder.viewType){
            case BEAUTY:
                BeautyBean beautyBean = (BeautyBean) data.get(position);
                holder.img_beauty.setImageDrawable(beautyBean.getImg());
                holder.content_beauty.setText(beautyBean.getContent());
                holder.title_beauty.setText(beautyBean.getTitle());
                break;
            case STUDENT:
                final ExcellentBean excellentBean = (ExcellentBean) data.get(position);
                holder.name_excellent.setText(excellentBean.getName());
                holder.img_excellent.setImageDrawable(excellentBean.getImg());
                holder.content_excellent.setText(excellentBean.getContent());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        initPopupWindow(view, excellentBean);
                    }
                });
                break;
            case TEACHER:
                final ExcellentBean excellentBean_teacher = (ExcellentBean) data.get(position);
                holder.name_excellent.setText(excellentBean_teacher.getName());
                holder.img_excellent.setImageDrawable(excellentBean_teacher.getImg());
                holder.content_excellent.setText(excellentBean_teacher.getContent());
                break;
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    private void initPopupWindow(View view, ExcellentBean bean) {
        View popupView = LayoutInflater.from(context).inflate(R.layout.pop_window_excellent, null);
        // 三部曲第二  构造函数关联
        View parent = LayoutInflater.from(context).inflate(R.layout.special_2017_fragment_student,null);
        TextView name,content;
        CircleImageView img;
        ImageView close;
        close = popupView.findViewById(R.id.close_pop);
        name = popupView.findViewById(R.id.name_pop);
        content = popupView.findViewById(R.id.tx_pop);
        img = popupView.findViewById(R.id.img_pop);
        name.setText(bean.getName());
        content.setText(bean.getContent());
        img.setImageDrawable(bean.getImg());
        int wide = ScreenUnit.bulid(context).getPxWide();
        int height = ScreenUnit.bulid(context).getPxHiget();
        popupWindow = new PopupWindow(popupView
                ,wide*3/4, height*2/3, true);
        // =======  两者结合才能让popup点击外部消失
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        // =======  两者结合才能让popup点击外部消失
        // 让popup占有优先于activity的交互响应能力，不单单是焦点问题。
        popupWindow.setFocusable(true);
        // 设置动画  这里选用系统提供的
        popupWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        // popup和软键盘的关系
        // 三部曲第三   展示popup
        backgroundAlpaha((Activity) context, 0.5f);
        popupWindow.showAtLocation(parent, Gravity.CENTER,0,0);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpaha((Activity) context, 1.0f);
            }
        });
    }
    /**
     * 设置添加屏幕的背景透明度
     * **/
    public void backgroundAlpaha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow()
                .addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }
    
    class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView img_excellent;
        ImageView img_beauty;
        TextView title_beauty,name_excellent,content_beauty,content_excellent;
        int viewType;
        public MyViewHolder(View itemView, int viewType) {
            super(itemView);
            this.viewType = viewType;
            switch (viewType){
                case BEAUTY:
                    img_beauty = (ImageView) itemView.findViewById(R.id.img_item_beauty);
                    title_beauty = (TextView) itemView.findViewById(R.id.title_item_beauty);
                    content_beauty = (TextView) itemView.findViewById(R.id.tx_item_beauty);
                    break;
                case STUDENT:
                    img_excellent = (CircleImageView) itemView.findViewById(R.id.img_item_excellent);
                    name_excellent = (TextView) itemView.findViewById(R.id.name_item_excellent);
                    content_excellent = (TextView) itemView.findViewById(R.id.tx_item_excellent);
                    break;
                case TEACHER:
                    img_excellent = (CircleImageView) itemView.findViewById(R.id.img_item_excellent);
                    name_excellent = (TextView) itemView.findViewById(R.id.name_item_excellent);
                    content_excellent = (TextView) itemView.findViewById(R.id.tx_item_excellent);
                    break;
            }
        }
    }
}
