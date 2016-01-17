package com.infact.nightour.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neto.nightour.R;
import com.infact.nightour.model.Evento;

import java.util.List;


public class HomeAoVivoEventoAdapter extends RecyclerView.Adapter<HomeAoVivoEventoAdapter.MyViewHolder> {

    private List<Evento> eventos;
    private LayoutInflater inflater;
    private Context context;
    private AoVivoEventoOnClickListener aoVivoEventoOnClickListener;

    public HomeAoVivoEventoAdapter(Context context, List<Evento> eventos, AoVivoEventoOnClickListener eventoOnClickListener) {
        this.context = context;
        this.eventos = eventos;
        this.aoVivoEventoOnClickListener = eventoOnClickListener;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.aovivo_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Evento evento = eventos.get(position);
        holder.ibAoVivoItemDescubra.setImageBitmap(evento.getImagem());
        holder.tvAoVivoItemDescubra.setText(evento.getNome());
    }

    @Override
    public int getItemCount() {
        return this.eventos != null ? this.eventos.size() : 0;
    }

    public interface AoVivoEventoOnClickListener{
        public void onClickEvento(View view, int idx);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ibAoVivoItemDescubra;
        TextView tvAoVivoItemDescubra;

        public MyViewHolder(View view) {
            super(view);
            this.ibAoVivoItemDescubra = (ImageView) view.findViewById(R.id.ibIconeEventoAoVivo_Home);
            this.tvAoVivoItemDescubra = (TextView) view.findViewById(R.id.tvNomeEventoAoVivo_Home);
        }
    }
}
