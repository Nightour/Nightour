package com.infact.nightour.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.*;
import com.example.neto.nightour.R;
import com.infact.nightour.activity.EventoActivity;
import com.infact.nightour.adapter.HomeAoVivoEventoAdapter;
import com.infact.nightour.adapter.HomeEventoAdapter;
import com.infact.nightour.model.Evento;
import com.infact.nightour.service.EventoService;

import java.util.List;



public class AoVivoEventosFragment extends BaseFragment {

    protected RecyclerView recyclerView;
    private List<Evento> eventos;
    private LinearLayoutManager linearLayoutManager;
    private String tipo;

    public AoVivoEventosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            this.tipo = getArguments().getString("tipo");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ao_vivo_eventos, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rvOQueRolaHoje);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        taskAoVivoEventos();
    }


    private void taskAoVivoEventos(){
        //this.eventos = EventoService.getEventos(getContext(), tipo);
        recyclerView.setAdapter(new HomeAoVivoEventoAdapter(getContext(), eventos, onClickEvento()));
    }

    private HomeAoVivoEventoAdapter.AoVivoEventoOnClickListener onClickEvento(){
        return new HomeAoVivoEventoAdapter.AoVivoEventoOnClickListener(){
            @Override
            public void onClickEvento(View view, int idx){
                Evento evento = eventos.get(idx);
                Intent intent = new Intent( getActivity().getBaseContext(), EventoActivity.class);
                intent.putExtra("evento", evento.toString());
                startActivity(intent);
            }
        };
    }

}
