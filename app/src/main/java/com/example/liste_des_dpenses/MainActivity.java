package com.example.liste_des_dpenses;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ListView mylist;
    public static DBAdapter db;
    static Adapter messageAdapter ;
    //public static Adapter array ;
    public static ArrayList<depense> myaraylist;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         db = new DBAdapter(this);
        myaraylist = new ArrayList<>();
        myaraylist = db.afficher();
        mylist = findViewById(R.id.list);
        messageAdapter = new Adapter(this, R.layout.depense_item, myaraylist);

        Toast.makeText(this, myaraylist.get(0).getAchat(), Toast.LENGTH_SHORT).show();
       mylist.setAdapter(messageAdapter);



        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Delete entry");
                alert.setMessage("Are you sure you want to delete this entry?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "supprimé", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Okay", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.create().show();


                Calendar c = Calendar.getInstance();
                System.out.println("Current time => "+c.getTime());

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = df.format(c.getTime());
                // formattedDate have current date/time
                Toast.makeText(MainActivity.this, formattedDate, Toast.LENGTH_SHORT).show();

                                /*})
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();

                                db.remove(base.get(position).getId());
                                base=db.afficher();

                                array=new Adapter(MainActivity.this,R.layout.depense_item,base);

                                liste.setAdapter(array);*/


            }

        });


    }

    @Override
    public void onResume(){
        super.onResume();
        myaraylist = db.afficher();
        mylist = findViewById(R.id.list);
        messageAdapter = new Adapter(this, R.layout.depense_item, myaraylist);

        Toast.makeText(this, myaraylist.get(0).getAchat(), Toast.LENGTH_SHORT).show();
        mylist.setAdapter(messageAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.ajouter) {
            Intent intent = new Intent(MainActivity.this, Ajouter.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.total) {
            Intent intent = new Intent(MainActivity.this, Total.class);
            startActivity(intent);
        }
        return true;}
}




    /*public static long getAppFirstInstallTime(Context context) {
        PackageInfo packageInfo;
        try {
            if (Build.VERSION.SDK_INT > 8) {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                return packageInfo.firstInstallTime;
            } else {
                ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
                String sAppFile = appInfo.sourceDir;
                return new File(sAppFile).lastModified();
            }
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }*/





    //public void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);



        // Now we display formattedDate value in TextView
        /*TextView txtView = new TextView(this);
        txtView.setText("Current Date and Time : "+formattedDate);
        txtView.setGravity(Gravity.CENTER);
        txtView.setTextSize(20);
        setContentView(txtView);*/
    //}


    //public String getDate() {
        //Date   now = new Date();
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY HH:mm");
       // String result = formatter.format(now);

        //Calendar rightNow = Calendar.getInstance();
        //System.out.println(rightNow.get(Calendar.DAY_OF_MONTH) + "/" + rightNow.get(Calendar.MONTH) + "/" + rightNow.get(Calendar.YEAR));

    //}

//};