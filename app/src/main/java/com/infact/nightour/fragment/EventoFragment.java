package com.infact.nightour.fragment;


import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neto.nightour.R;
import com.infact.nightour.model.Evento;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventoFragment extends BaseFragment {

    private Evento evento;
    private TextView tvDescricaoDoEventoNaPagina;
    private ImageView ivFotoDoUsuarioNoEvento;

    public EventoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvDescricaoDoEventoNaPagina = (TextView) getView().findViewById(R.id.tvDescricaoDoEventoNaPagina);
        ivFotoDoUsuarioNoEvento = (ImageView) getView().findViewById(R.id.ivFotoDoUsuarioNoEvento);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_evento, container, false);
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.add(R.id.flTabEvento, new EventoTabFragment());
        ft.commit();

        return rootView;
    }
    public void setEvento(Evento evento){
        if(evento != null){
            this.evento = evento;
            tvDescricaoDoEventoNaPagina.setText(evento.getDescricao());
            Drawable d = new BitmapDrawable(getResources(), evento.getImagem());
            ivFotoDoUsuarioNoEvento.setImageDrawable(d);
        }
    }

}
