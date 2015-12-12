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
import com.infact.nightour.VarColumnGridLayoutManager;
import com.infact.nightour.adapter.SeguidoresAdapter;
import com.infact.nightour.interfaces.RecyclerViewOnClickListenerHack;
import com.infact.nightour.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeguindoFragment extends BaseFragment implements RecyclerViewOnClickListenerHack {

    private RecyclerView rvSeguindo;
    private List<Usuario> list;

    public SeguindoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seguindo, container, false);

        rvSeguindo = (RecyclerView) view.findViewById(R.id.rvSeguindo);
        rvSeguindo.setHasFixedSize(true);
        rvSeguindo.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) rvSeguindo.getLayoutManager();
                SeguidoresAdapter adapter = (SeguidoresAdapter) rvSeguindo.getAdapter();

                if (list.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {
                    List<Usuario> listAux = getSetUsuarioList(10);

                    for (int i = 0; i < listAux.size(); i++) {
                        adapter.addListItem(listAux.get(i), list.size());
                    }
                }
            }
        });


        VarColumnGridLayoutManager llm = new VarColumnGridLayoutManager(getActivity(), 140);
        rvSeguindo.setLayoutManager(llm);

        list = getSetUsuarioList(12);
        SeguidoresAdapter adapter = new SeguidoresAdapter(getActivity(), list);
        //adapter.setRecyclerViewOnClickListenerHack(this);
        rvSeguindo.setAdapter(adapter);


        return view;
    }

    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getActivity(), "Position: " + position, Toast.LENGTH_SHORT).show();

        SeguidoresAdapter adapter = (SeguidoresAdapter) rvSeguindo.getAdapter();
        adapter.removeListItem(position);
    }
    public List<Usuario> getSetUsuarioList(int qtd){
        String[] nomes = new String[]{"Eduardo Lajos", "Caio Souza Pantaleão", "Elliana Falcão", "Andre Rebello", "Lucas Andrade", "Sandro Rosanin", "Samir Abidala", "Javier Santiago", "Iker Xavier", "Amir Latón"};
        List<Usuario> listAux = new ArrayList<>();

        for(int i = 0; i < qtd; i++){
            Usuario usuario = new Usuario( nomes[i % nomes.length]);
            listAux.add(usuario);
        }
        return(listAux);
    }
}
