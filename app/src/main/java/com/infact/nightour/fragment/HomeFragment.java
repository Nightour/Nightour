package com.infact.nightour.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.*;

import com.example.neto.nightour.R;
import com.infact.nightour.activity.EventoActivity;
import com.infact.nightour.adapter.HomeAoVivoEventoAdapter;
import com.infact.nightour.controller.EventosController;
import com.infact.nightour.model.Evento;
import com.infact.nightour.service.EventoService;

import java.util.List;

public class HomeFragment extends BaseFragment {

    private RecyclerView recyclerView;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.add(R.id.flAoVivoFragmentEventos, new AoVivoEventosFragment());
        ft.commit();

        FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
        ft1.add(R.id.flDescubraFragmentEventos, new DescubraEventosFragment());
        ft1.commit();
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach(){
        super.onDetach();
    }
    @Override
    public String toString(){
        return "Home";
    }

    public void toEvento(Evento evento){
        Intent intent = new Intent(getActivity(), EventoActivity.class);
        intent.putExtra("evento", evento.toString());
        startActivity(intent);
    }
}

