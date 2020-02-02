package com.example.iotvremenskestanice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PodatciAdapter extends BaseAdapter {

    private final Context mContext;
    public final ArrayList<PodatciStanica> stanice;

    // 1
    public PodatciAdapter(Context context, ArrayList<PodatciStanica> stanice) {
        this.mContext = context;
        this.stanice = stanice;
    }

    // 2
    @Override
    public int getCount() {
        return stanice.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1
        final PodatciStanica data = stanice.get(position);

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.kartica_stranice, null);
        }

        // 3
        final TextView lokacijaStanice = convertView.findViewById(R.id.lokacija);
        final TextView temperatura = convertView.findViewById(R.id.temp);
        final TextView opisVremena = convertView.findViewById(R.id.opis);
        final TextView datum = convertView.findViewById(R.id.datum);
        final TextView dan = convertView.findViewById(R.id.dan);
        final TextView padaline = convertView.findViewById(R.id.padaline);
        final TextView vlaga = convertView.findViewById(R.id.vlaga);
        //final TextView vjetar = convertView.findViewById(R.id.vjetar);
        //
        final ImageView ikona = convertView.findViewById(R.id.img_icon);

        // 4
        //imageView.setImageResource(book.getImageResource());
        lokacijaStanice.setText(data.getName());
        //potrebno za Marquee scrollanje
        lokacijaStanice.setSelected(true);
        temperatura.setText(data.getTemp());
        opisVremena.setText(data.getOpis());
        datum.setText(data.getDateTime());
        dan.setText(data.getDan());
        padaline.setText(data.getPadaline());
        vlaga.setText(data.getVlaga());
        //vjetar.setText(data.getVjetar());

        ikona.setImageResource(data.getIcon());

        return convertView;
    }

}

