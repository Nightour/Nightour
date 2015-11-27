package com.infact.nightour.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.neto.nightour.R;
import com.infact.nightour.model.Evento;

/**
 * Created by Timóteo on 27/11/2015.
 */
public class HomeEventoAdapter extends CursorAdapter {
    public HomeEventoAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.descubra_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageButton ibItemDescubra = (ImageButton) view.findViewById(R.id.ibIconeEvento_Home);
        TextView tvItemDescubra = (TextView) view.findViewById(R.id.tvNomeEvento_Home);

        Evento evento = Evento.fromCursor(cursor);

        ibItemDescubra.setImageBitmap(evento.getImagem());
        tvItemDescubra.setText(evento.getNome());
    }
}
