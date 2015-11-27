package com.infact.nightour.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.neto.nightour.R;
import com.infact.nightour.model.Evento;

import java.util.List;

/**
 * Created by Timóteo on 27/11/2015.
 */
public class HomeEventoAdapter extends RecyclerView.Adapter<HomeEventoAdapter.MyViewHolder> {
    private List<Evento> eventos;
    private LayoutInflater inflater;
    private Context context;

    public HomeEventoAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Evento evento = eventos.get(position);

        holder.ibItemDescubra.setImageBitmap(evento.getImagem());
        holder.tvItemDescubra.setText(evento.getNome());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageButton ibItemDescubra;
        TextView tvItemDescubra;

        public MyViewHolder(View view) {
            super(view);
            this.ibItemDescubra = (ImageButton) view.findViewById(R.id.ibIconeEvento_Home);
            this.tvItemDescubra = (TextView) view.findViewById(R.id.tvNomeEvento_Home);
        }
    }
}
