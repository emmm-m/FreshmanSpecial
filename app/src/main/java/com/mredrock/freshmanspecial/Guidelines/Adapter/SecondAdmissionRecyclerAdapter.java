package com.mredrock.freshmanspecial.Guidelines.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.Beans.GuidelinesAdmissionFirBean;
import com.mredrock.freshmanspecial.Guidelines.Guidelines;
import com.mredrock.freshmanspecial.R;

import java.util.List;

/**
 * Created by glossimar on 2017/8/10.
 */

public class SecondAdmissionRecyclerAdapter extends RecyclerView.Adapter<SecondAdmissionRecyclerAdapter.ViewHolder>{

    private List<GuidelinesAdmissionFirBean.GuidelinesAdmissionSecBean> secBeanList;
    private Context context;

    public SecondAdmissionRecyclerAdapter(List<GuidelinesAdmissionFirBean.GuidelinesAdmissionSecBean>
                                          secBeenList, Context context) {
        this.secBeanList = secBeenList;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView secondTitle;
        TextView seconText;

        public ViewHolder(View itemView) {
            super(itemView);
            secondTitle = (TextView) itemView.findViewById(R.id.admission_recycleview_second_title);
            seconText = (TextView) itemView.findViewById(R.id.admission_recycleview_second_text);
        }
    }

    @Override
    public SecondAdmissionRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.special_2017_admission_recycleview_second, parent, false);
        SecondAdmissionRecyclerAdapter.ViewHolder holder = new SecondAdmissionRecyclerAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GuidelinesAdmissionFirBean.GuidelinesAdmissionSecBean secBean = secBeanList.get(position);
        holder.secondTitle.setText(secBean.getSecondTitle());
        holder.seconText.setText(secBean.getSecondText());
    }

    @Override
    public int getItemCount() {
        return secBeanList.size();
    }
}
