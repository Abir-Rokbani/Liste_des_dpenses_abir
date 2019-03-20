package com.example.liste_des_dpenses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.liste_des_dpenses.DBAdapter.*;
import static com.example.liste_des_dpenses.MainActivity.db;
//import static com.example.liste_des_dpenses.MainActivity.db;

public class Ajouter extends AppCompatActivity {

    Button btn;
    TextView achat;
    TextView prix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

        btn=findViewById(R.id.btnadd);
        achat=findViewById(R.id.editachat);
        prix=findViewById(R.id.editprix);




        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                String achats = achat.getText().toString();
                Float soum =Float.valueOf(prix.getText().toString());
                depense depenses = new depense(achats, soum);
                db.ajoutdepense(depenses);
              //  Toast.makeText(Ajouter.this, MainActivity.myaraylist.get(0).getAchat(), Toast.LENGTH_SHORT).show();
               // Intent intent = new Intent(Ajouter.this,MainActivity.class);
                //startActivity(intent);

            }

        });
    }

}

