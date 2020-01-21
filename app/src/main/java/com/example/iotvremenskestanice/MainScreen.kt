package com.example.iotvremenskestanice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.AdapterView
import android.view.View


class MainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen_activity)

        val al = ArrayList<PodatciStanica>()

        //String name,String temp,String opis,String dateTime,int icon,String padaline,String vlaga,String vjetar
        val stanica_bjelovar = PodatciStanica("Bjelovar","12°C","Sunčano","12.3.2020","Ponedeljak",2,"45%","25%","13 km/h")
        val stanica_borik = PodatciStanica("Borik","14°C","Sunčano","12.3.2020","Utorak",1,"10%","13%","25 km/h")
        val stanica_zdralovi = PodatciStanica("Zdralovi","14°C","Oblačno","30.1.2020","Srijeda",1,"10%","13%","25 km/h")
        val stanica_veleuciliste = PodatciStanica("Centar","14°C","Oblačno","30.1.2020","Četvrtak",1,"10%","13%","25 km/h")
        val stanica_mcdonalds = PodatciStanica("McDonalds/Zaobilaznica","14°C","Oblačno","30.1.2020","Petak",1,"10%","13%","25 km/h")
        val stanica_hotel = PodatciStanica("Hotel Adriatic","14°C","Oblačno","30.1.2020","Subota",1,"10%","13%","25 km/h")
        val stanica_srednjoskolski_centar = PodatciStanica("Srednjoškolski Centar","14°C","Kišovito","30.1.2020","Nedelja",1,"10%","13%","25 km/h")

        al.add(stanica_bjelovar)
        al.add(stanica_borik)
        al.add(stanica_zdralovi)
        al.add(stanica_veleuciliste)
        al.add(stanica_mcdonalds)
        al.add(stanica_hotel)
        al.add(stanica_srednjoskolski_centar)


        val gridView = findViewById(R.id.gridView) as GridView
        val booksAdapter = PodatciAdapter(this, al)
        gridView.adapter = booksAdapter

        gridView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                val intent = Intent(this@MainScreen, StanicaScreen::class.java)
                    // start your next activity
                    startActivity(intent)

                // This tells the GridView to redraw itself
                // in turn calling your PodatciAdapter's getView method again for each cell
                booksAdapter.notifyDataSetChanged()
            }

            fun OnLongClickListener(parent: AdapterView<*>, view: View, position: Int, id: Long){

            }

        }


    }

}
