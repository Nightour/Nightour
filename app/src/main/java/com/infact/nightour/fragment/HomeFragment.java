package com.infact.nightour.fragment;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.*;

import com.example.neto.nightour.R;
import com.infact.nightour.adapter.HomeEventoAdapter;
import com.infact.nightour.controller.EventosController;
import com.infact.nightour.model.Evento;

import java.util.ArrayList;
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
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rvOQueRolaHoje);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        EventosController crud = new EventosController(getActivity());
        List<Evento> eventos = Evento.getListFromCursor(crud.carregaEventos());

        HomeEventoAdapter adaptador = new HomeEventoAdapter(getActivity(), eventos);
        recyclerView.setAdapter(adaptador);

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
}

