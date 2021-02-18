package com.woqod.assignment.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.woqod.assignment.R;
import com.woqod.assignment.adapter.AllLogsAdapter;
import com.woqod.assignment.db.UserLoginLogs;
import com.woqod.assignment.model.LogModel;

import java.util.ArrayList;

public class AllLogsActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView rvAllLogs;
    ArrayList<LogModel> loglist;
    UserLoginLogs logdb;
    RelativeLayout customProgress;
    AllLogsAdapter logsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_logs);

        loglist = new ArrayList<>();
        logdb = new UserLoginLogs(AllLogsActivity.this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rvAllLogs = (RecyclerView) findViewById(R.id.rvAllLogs);
        customProgress = (RelativeLayout) findViewById(R.id.customProgress);
        loglist = logdb.logList();

        if (loglist.size() > 0) {
            rvAllLogs.setVisibility(View.VISIBLE);
            rvAllLogs.setLayoutManager(new GridLayoutManager(this, 2));
            logsAdapter = new AllLogsAdapter(loglist, this);
            rvAllLogs.setAdapter(logsAdapter);


        } else {
            rvAllLogs.setVisibility(View.GONE);
            Toast.makeText(this, "There is no logs in db", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
