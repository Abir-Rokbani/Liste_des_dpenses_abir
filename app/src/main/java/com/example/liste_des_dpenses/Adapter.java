package com.example.liste_des_dpenses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
    public class Adapter extends ArrayAdapter<depense> {
        private ArrayList<depense> arrayList;
        private Context ctx;
        private int item;


        public Adapter(@NonNull Context context, int resource , ArrayList<depense> myarray) {
            super(context, resource,myarray);
            this.arrayList=myarray;
            this.ctx=context;
            this.item=resource; }

        @NonNull
        @Override
        public boolean isEnabled(int position)
        {
            return true;
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            convertView= LayoutInflater.from(ctx).inflate(item,parent,false);

            TextView prix=convertView.findViewById(R.id.prix);

            TextView  achat=convertView.findViewById(R.id.achat);

           // TextView date=convertView.findViewById(R.id.date);

            prix.setText(Float.toString(arrayList.get(position).getPrix()));
            achat.setText(arrayList.get(position).getAchat());
           // date.setText(arrayList.get(position).getDate());

            return convertView; }
    }
