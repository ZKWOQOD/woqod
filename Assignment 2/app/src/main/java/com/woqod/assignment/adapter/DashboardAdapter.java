package com.woqod.assignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.woqod.assignment.R;
import com.woqod.assignment.model.DashboardModel;

import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.MyViewHolder> {

    Context context;
    List<DashboardModel> dashboarditemList;
    String selectedval;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvItemName;
        AppCompatButton btnYes, btnNo;

        public MyViewHolder(View view) {
            super(view);

            tvItemName = (TextView) view.findViewById(R.id.tvItemName);
            btnYes = (AppCompatButton) view.findViewById(R.id.btnYes);
            btnNo = (AppCompatButton) view.findViewById(R.id.btnNo);
        }
    }

    public DashboardAdapter(List<DashboardModel> dashboarditemList, Context context) {
        this.dashboarditemList = dashboarditemList;
        this.context = context;
    }

    @Override
    public DashboardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_dashboard_list, parent, false);

        return new DashboardAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DashboardAdapter.MyViewHolder holder, final int position) {
        final DashboardModel model = dashboarditemList.get(position);

        holder.tvItemName.setText(model.getItemname());
        holder.btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedval = "Yes";
                model.setSelectedval(selectedval);
                Toast.makeText(context, "Yes", Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedval = "No";
                model.setSelectedval(selectedval);
                Toast.makeText(context, "No", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return dashboarditemList.size();
    }

}