package com.infact.nightour.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.neto.nightour.R;
import com.infact.nightour.adapter.SeguidoresAdapter;
import com.infact.nightour.interfaces.RecyclerViewOnClickListenerHack;
import com.infact.nightour.model.Usuario;
import android.support.v7.widget.GridLayoutManager;
import com.infact.nightour.VarColumnGridLayoutManager;

import java.util.ArrayList;
import java.util.List;


public class SeguidoresFragment extends BaseFragment implements RecyclerViewOnClickListenerHack {

    private RecyclerView rvSeguidores;
    private List<Usuario> list;

    public SeguidoresFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seguidores, container, false);

        rvSeguidores = (RecyclerView) view.findViewById(R.id.rvSeguidores);
        rvSeguidores.setHasFixedSize(true);
        rvSeguidores.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) rvSeguidores.getLayoutManager();
                SeguidoresAdapter adapter = (SeguidoresAdapter) rvSeguidores.getAdapter();

                if (list.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {
                    List<Usuario> listAux = getSetUsuarioList(12);

                    for (int i = 0; i < listAux.size(); i++) {
                        adapter.addListItem(listAux.get(i), list.size());
                    }
                }
            }
        });


        VarColumnGridLayoutManager llm = new VarColumnGridLayoutManager(getActivity(), 140);
        rvSeguidores.setLayoutManager(llm);


        list = getSetUsuarioList(12);
        SeguidoresAdapter adapter = new SeguidoresAdapter(getActivity(), list);
        //adapter.setRecyclerViewOnClickListenerHack(this);
        rvSeguidores.setAdapter(adapter);


        return view;
    }

    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getActivity(), "Position: " + position, Toast.LENGTH_SHORT).show();

        SeguidoresAdapter adapter = (SeguidoresAdapter) rvSeguidores.getAdapter();
        adapter.removeListItem(position);
    }
    public List<Usuario> getSetUsuarioList(int qtd){
        String[] nomes = new String[]{"Eduardo Lajos", "Caio Souza", "Elliana Falcão", "Andre Rebello", "Lucas Andrade", "Sandro Rosanin", "Samir Abidala", "Javier Santiago", "Iker Xavier", "Amir Latón"};
        List<Usuario> listAux = new ArrayList<>();

        for(int i = 0; i < qtd; i++){
            Usuario usuario = new Usuario( nomes[i % nomes.length]);
            listAux.add(usuario);
        }
        return(listAux);
    }
}
