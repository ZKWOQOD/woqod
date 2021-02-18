package com.woqod.assignment.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.woqod.assignment.R;
import com.woqod.assignment.adapter.DashboardAdapter;
import com.woqod.assignment.model.DashboardModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    RecyclerView rvAllLogs;
    DashboardAdapter dashboardAdapter;
    List<DashboardModel> dashboardList;
    AppCompatButton btnSave;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        dashboardList = new ArrayList<>();

        rvAllLogs = (RecyclerView) findViewById(R.id.rvAllLogs);
        btnSave = (AppCompatButton) findViewById(R.id.btnSave);

        dashboardAdapter = new DashboardAdapter(dashboardList, this);
        layoutManager = new LinearLayoutManager(this);
        rvAllLogs.setLayoutManager(layoutManager);
        rvAllLogs.setAdapter(dashboardAdapter);
        dashboardAdapter.notifyDataSetChanged();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("dashboard_data", "" + dashboardList.toString());
            }
        });
        dashboarddatalist();


    }

    private void dashboarddatalist() {
        dashboardList.clear();
        dashboardList.add(new DashboardModel("1", "One", ""));
        dashboardList.add(new DashboardModel("2", "Two", ""));
        dashboardList.add(new DashboardModel("3", "Three", ""));
        dashboardList.add(new DashboardModel("4", "Four", ""));
        dashboardList.add(new DashboardModel("5", "Five", ""));
        dashboardList.add(new DashboardModel("6", "Six", ""));
        dashboardList.add(new DashboardModel("7", "Seven", ""));
        dashboardList.add(new DashboardModel("8", "Eight", ""));
        dashboardList.add(new DashboardModel("9", "Nine", ""));
        dashboardList.add(new DashboardModel("10", "Ten", ""));
    }

    @Override
    public void onBackPressed() {
        exitappdialog();
    }

    private void exitappdialog() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(R.string.app_name);
        alertDialogBuilder.setMessage("Are you sure want to exit...? ");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        finishAffinity();
                        System.exit(0);
                    }
                });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
