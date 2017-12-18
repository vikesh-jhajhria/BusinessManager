package com.businessmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.businessmanager.R;
import com.businessmanager.model.ServiceModel;

import java.util.ArrayList;

/**
 * Created by vikesh.kumar on 16-Dec-17.
 */

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<ServiceModel> mList;

    public ServiceAdapter(Context context, ArrayList list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_service, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ServiceModel model = mList.get(position);
        holder.name.setText(model.getName());
        holder.unit.setText(model.getUnit());
        holder.rate.setText(model.getRate());
        holder.from.setText(model.getValidityFrom());
        if(model.isActive()) {
            holder.ll_to.setVisibility(View.GONE);
            holder.discontinue.setVisibility(View.VISIBLE);
            holder.discontinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        } else {
            holder.ll_to.setVisibility(View.VISIBLE);
            holder.discontinue.setVisibility(View.GONE);
            holder.to.setText(model.getValidityTo());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //View holder class
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, unit, rate, from, to, discontinue;
        LinearLayout ll_to;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            unit = itemView.findViewById(R.id.txt_unit);
            rate = itemView.findViewById(R.id.txt_rate);
            from = itemView.findViewById(R.id.txt_applied_from);
            to = itemView.findViewById(R.id.txt_applied_to);
            discontinue = itemView.findViewById(R.id.btn_discontinue);
            ll_to = itemView.findViewById(R.id.ll_rate_to);
        }
    }
}
