package com.example.liste_des_dpenses;


public class depense {
    private String achat ;
    private Float prix ;
    private String date ;
    private int id;

    public depense (){

    }

    public depense(String achat, Float prix) {
        this.achat = achat;
        this.prix = prix;
        //String Format = "jj/mm/aaaa hh:mm:ss";

        //DateFormat dateF = new SimpleDateFormat(Format);
        //Date today = Calendar.getInstance().getTime();

        //date = dateF.format(today);

    }

    public String getAchat() {

        return achat;
    }

    public Float getPrix() {

        return prix;
    }

    public String getDate() {

        return date;
    }

    public int getId() {

        return id;
    }

    public void setAchat(String achat) {

        this.achat = achat;
    }

    public void setPrix(Float prix) {

        this.prix = prix;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public void setId(int id) {

        this.id = id;
    }






}

