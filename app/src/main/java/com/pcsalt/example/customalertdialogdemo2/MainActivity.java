package com.pcsalt.example.customalertdialogdemo2;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_show_dialog).setOnClickListener(view -> showCustomDialog());
    }

    private void showCustomDialog() {
        LinearLayout ll_Main = new LinearLayout(this);
        LinearLayout ll_Row1 = new LinearLayout(this);
        LinearLayout ll_Row2 = new LinearLayout(this);

        ll_Main.setOrientation(LinearLayout.VERTICAL);
        ll_Main.setPadding(10, 10, 10, 10);
        ll_Row1.setOrientation(LinearLayout.HORIZONTAL);
        ll_Row1.setPadding(10, 10, 10, 10);
        ll_Row2.setOrientation(LinearLayout.HORIZONTAL);
        ll_Row2.setPadding(10, 10, 10, 10);

        final EditText et_User = new MyEditText(this);
        final EditText et_Pass = new MyEditText(this);

        TextView tv_User = new TextView(this);
        TextView tv_Pass = new TextView(this);

        tv_User.setText("Username: ");
        tv_Pass.setText("Password: ");

        ll_Row1.addView(tv_User);
        ll_Row1.addView(et_User);
        ll_Row2.addView(tv_Pass);
        ll_Row2.addView(et_Pass);
        ll_Main.addView(ll_Row1);
        ll_Main.addView(ll_Row2);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Custom Login");
        alert.setView(ll_Main);
        alert.setCancelable(false);
        alert.setPositiveButton("Login", (dialog, which) -> {
            String user = et_User.getText().toString();
            String pass = et_Pass.getText().toString();
            Toast.makeText(getBaseContext(), "User: " + user + " Password: " + pass, Toast.LENGTH_SHORT).show();
        });
        alert.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
