package com.infact.nightour.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neto.nightour.R;
import com.infact.nightour.model.Evento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timóteo on 27/11/2015.
 */
public class HomeEventoAdapter extends RecyclerView.Adapter<HomeEventoAdapter.MyViewHolder> {

    private List<Evento> eventos;
    private LayoutInflater inflater;
    private Context context;
    private DescubraEventoOnClickListener descubraEventoOnClickListener;

    public HomeEventoAdapter(Context context, List<Evento> eventos, DescubraEventoOnClickListener eventoOnClickListener) {
        this.context = context;
        this.eventos = eventos;
        this.descubraEventoOnClickListener = eventoOnClickListener;
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

        //Utilizar Picasso para WebService
    }

    @Override
    public int getItemCount() {
        return this.eventos != null ? this.eventos.size() : 0;
    }

    public interface DescubraEventoOnClickListener{
        public void onClickEvento(View view, int idx);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ibItemDescubra;
        TextView tvItemDescubra;

        public MyViewHolder(View view) {
            super(view);
            this.ibItemDescubra = (ImageView) view.findViewById(R.id.ibIconeEventoDescubra_Home);
            this.tvItemDescubra = (TextView) view.findViewById(R.id.tvNomeEventoDescubra_Home);
        }
    }
}
