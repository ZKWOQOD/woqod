package com.woqod.assignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.woqod.assignment.R;
import com.woqod.assignment.model.LogModel;

import java.util.List;

public class AllLogsAdapter extends RecyclerView.Adapter<AllLogsAdapter.MyViewHolder> {

    Context context;
    List<LogModel> logsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvLogs;

        public MyViewHolder(View view) {
            super(view);

            tvLogs = (TextView) view.findViewById(R.id.tvLogs);

        }
    }

    public AllLogsAdapter(List<LogModel> logsList, Context context) {
        this.logsList = logsList;
        this.context = context;
    }

    @Override
    public AllLogsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_logs_list, parent, false);

        return new AllLogsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AllLogsAdapter.MyViewHolder holder, final int position) {
        final LogModel model = logsList.get(position);

        holder.tvLogs.setText(model.getLogs());

    }

    @Override
    public int getItemCount() {
        return logsList.size();
    }

}