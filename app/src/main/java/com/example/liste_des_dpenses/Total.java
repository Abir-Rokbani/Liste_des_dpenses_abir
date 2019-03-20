package com.example.liste_des_dpenses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//import static com.example.liste_des_dpenses.MainActivity.db;
//import static com.example.liste_des_dpenses.MainActivity.getAppFirstInstallTime;
//import static com.example.liste_des_dpenses.MainActivity.getDate;

public class Total extends AppCompatActivity {
    TextView text,datev;
    Long date;
    DBAdapter db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        new DBAdapter(this);
        text=findViewById(R.id.total);
        text.setText(Float.toString(db.total()));
        //date= getAppFirstInstallTime(this);
        String dtt = getDate(date, "jj/mm/aaaa");
        datev = findViewById(R.id.findate);
        datev.setText(dtt);
    }

    private String getDate(Long date, String s) {
        return s;
    }

    public void onResume(){
        super.onResume();
        text.setText(Float.toString(db.total()));


    }
}
