package com.example.iotvremenskestanice;

public class Book{
    public String name = "Bjelovar";
    public String temp = "12 °C";
    public String tempString = "Sunčano";
    public String dateTime = "Subota" + " 16.11.2019";
    public String icon = "12 °C X";

    public int getImageResource(){
        int x = R.drawable.placeholder_1;
        return x;
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return icon;
    }

}
