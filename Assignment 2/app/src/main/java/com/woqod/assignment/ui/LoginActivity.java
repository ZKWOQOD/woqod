package com.woqod.assignment.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.woqod.assignment.R;
import com.woqod.assignment.common.Util;
import com.woqod.assignment.db.UserLoginLogs;
import com.woqod.assignment.model.LogModel;

import static com.woqod.assignment.common.Util.THE_USERNAME_OR_PASSWORD_IS_INCORRECT;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnLogin, btnLogs;
    String username = "test@123";
    String password = "test@123";
    RelativeLayout customProgress;
    UserLoginLogs logdb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logdb = new UserLoginLogs(LoginActivity.this);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        customProgress = (RelativeLayout) findViewById(R.id.customProgress);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogs = (Button) findViewById(R.id.btnLogs);

        btnLogin.setOnClickListener(this);
        btnLogs.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnLogin:
                if (isLoginFormvalidate()) {
                    login();
                }
                break;

            case R.id.btnLogs:
                Intent logs = new Intent(LoginActivity.this, AllLogsActivity.class);
                startActivity(logs);
                break;

        }
    }

    private boolean isLoginFormvalidate() {

        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (Util.isBlank(username)) {
            Toast.makeText(LoginActivity.this, "Username can't be left blank", Toast.LENGTH_SHORT).show();
            return false;
        } else if (Util.isBlank(password)) {
            Toast.makeText(LoginActivity.this, "Password can't be left blank", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void login() {

        if (etUsername.getText().toString().contentEquals(username) && etPassword.getText().toString().contentEquals(password)) {

            Log.d("login_successful", "User login successfully");

            Intent home = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(home);

        } else {
            Toast.makeText(LoginActivity.this, THE_USERNAME_OR_PASSWORD_IS_INCORRECT, Toast.LENGTH_SHORT).show();
            logdb.insertLogs(new LogModel(Util.THE_USERNAME_OR_PASSWORD_IS_INCORRECT));
        }
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
