package com.infact.nightour.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.neto.nightour.R;
import com.infact.nightour.model.Evento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neto on 07/12/2015.
 */
public class EventoService {
    private static Bitmap makeBitmap(Context context, int resource) {
        Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(), resource);
        return largeIcon;}

    public static List<Evento> getEventos(Context context, String tipo) {
        List<Evento> eventos = new ArrayList<Evento>();
        Evento evento = new Evento();
        evento.setNome("Copacabana Chopperia");
        evento.setGenero("Sertanejo");
        evento.setDescricao("Bebida liberada");
        evento.setImagem(makeBitmap(context, R.drawable.eventos___ex_9));
        eventos.add(evento);
        evento = new Evento();
        evento.setNome("Porão do Alemão");
        evento.setGenero("Rock");
        evento.setDescricao("Tributo ao Legião");
        evento.setImagem(makeBitmap(context, R.drawable.eventos___ex_9_2));
        eventos.add(evento);
        evento = new Evento();
        evento.setNome("Rancho Sertanejo");
        evento.setGenero("Sertanejo");
        evento.setDescricao("Mulher não paga");
        evento.setImagem(makeBitmap(context, R.drawable.eventos___ex_9_3));
        eventos.add(evento);
        evento = new Evento();
        evento.setNome("Loucucaracha");
        evento.setGenero("Colegial");
        evento.setDescricao("Loco Loco!");
        evento.setImagem(makeBitmap(context, R.drawable.eventos___ex_9_5));

        eventos.add(evento);
        evento = new Evento();
        evento.setNome("All Night Pup");
        evento.setGenero("Samba");
        evento.setDescricao("Adabo dabo.");
        evento.setImagem(makeBitmap(context, R.drawable.eventos___ex_9_6));

        eventos.add(evento);
        return eventos;
    }
}
