package com.example.iotvremenskestanice;

public class PodatciStanica {
    public String name;
    public String temp;
    public String opis;
    public String dateTime;
    public String dan;
    public int icon;
    public String padaline;
    public String vlaga;
    public String vjetar;

    //Konstruktori
    PodatciStanica(){}
    PodatciStanica(String name,String temp,String opis,String dateTime,String dan,int icon,String padaline,String vlaga,String vjetar){
        this.name = name;
        this.temp = temp;
        this.opis = opis;
        this.dateTime = dateTime;
        this.dan = dan;
        this.icon = icon;
        this.padaline = padaline;
        this.vlaga = vlaga;
        this.vjetar = vjetar;
    }

    //Getovi
    public String getName(){
        return name;
    }
    public String getTemp(){
        return temp;
    }
    public String getOpis(){
        return opis;
    }
    public String getDateTime(){
        return dateTime;
    }
    public int getIcon(){
        switch (icon){
            case 1:
                return R.drawable.sun;
            case 2:
                return R.drawable.ic_vjetar;
            case 3:
                return R.drawable.ic_umbrella;
            default:
                return icon;
        }
    }
    public String getDan(){
        return dan;
    }
    public String getPadaline() {
        return padaline;
    }
    public String getVlaga() {
        return vlaga;
    }
    public String getVjetar() {
        return vjetar;
    }
}
