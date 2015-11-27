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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timóteo on 27/11/2015.
 */
public class HomeEventoAdapter extends RecyclerView.Adapter<HomeEventoAdapter.MyViewHolder> {
    private static List<Evento> getEventosTeste() {
        List<Evento> eventos = new ArrayList<Evento>();

        Evento evento = new Evento();
        evento.setNome("Evento A");
        evento.setGenero("Rock");
        evento.setDescricao("Adabo dabo.");
        evento.setImagem(null);

        eventos.add(evento);

        evento = new Evento();
        evento.setNome("Evento B");
        evento.setGenero("Brega");
        evento.setDescricao("Inakos nakos.");
        evento.setImagem(null);

        eventos.add(evento);

        evento = new Evento();
        evento.setNome("Evento C");
        evento.setGenero("Eletrônica");
        evento.setDescricao("Nimda da.");
        evento.setImagem(null);

        eventos.add(evento);

        evento = new Evento();
        evento.setNome("Evento D");
        evento.setGenero("Sertanejo");
        evento.setDescricao("Oloko loko.");
        evento.setImagem(null);

        eventos.add(evento);

        evento = new Evento();
        evento.setNome("Evento E");
        evento.setGenero("Samba");
        evento.setDescricao("Adabo dabo.");
        evento.setImagem(null);

        eventos.add(evento);

        return eventos;
    }

    private List<Evento> eventos;
    private LayoutInflater inflater;
    private Context context;

    public HomeEventoAdapter(Context context, List<Evento> eventos) {
        this.context = context;
        this.eventos = eventos;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.descubra_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Evento evento = eventos.get(position);

        holder.ibItemDescubra.setImageBitmap(evento.getImagem());
        holder.tvItemDescubra.setText(evento.getNome());
    }

    @Override
    public int getItemCount() {
        return eventos.size();
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
