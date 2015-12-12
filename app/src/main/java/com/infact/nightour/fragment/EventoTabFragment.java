package com.infact.nightour.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.neto.nightour.R;
import com.infact.nightour.adapter.EventoTabsAdapter;
import com.infact.nightour.adapter.PerfilTabsAdapter;


public class EventoTabFragment extends BaseFragment implements TabLayout.OnTabSelectedListener{

    private ViewPager vpEvento;
    private TabLayout tlEvento;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_evento_tab, container, false);

        // ViewPager
        vpEvento = (ViewPager) view.findViewById(R.id.vpEvento);
        vpEvento.setOffscreenPageLimit(2);
        vpEvento.setAdapter(new EventoTabsAdapter(getContext(), getChildFragmentManager()));

        // Tabs
        tlEvento = (TabLayout) view.findViewById(R.id.tlEvento);

        // Cor Branca no texto
        int corNormal = getContext().getResources().getColor(R.color.textColorPrimary);
        int corSelecionado = getContext().getResources().getColor(R.color.goldColor);
        tlEvento.setTabTextColors(corNormal, corSelecionado);
        // Adiciona Tabs
        tlEvento.addTab(tlEvento.newTab().setText(R.string.programação));
        tlEvento.addTab(tlEvento.newTab().setText(R.string.seguindo));
        tlEvento.addTab(tlEvento.newTab().setText(R.string.seguidores));

        // Listener tratar eventos de clique na tab
        tlEvento.setOnTabSelectedListener(this);
        // Se mudar o ViewPager atualiza a tab selecionada
        vpEvento.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlEvento));


        return view;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        // Se alterar a tab, atualiza o viewpager
        vpEvento.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


}
