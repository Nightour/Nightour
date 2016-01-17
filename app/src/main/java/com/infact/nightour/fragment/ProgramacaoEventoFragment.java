package com.infact.nightour.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.neto.nightour.R;


public class ProgramacaoEventoFragment extends BaseFragment {

    public ProgramacaoEventoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_programacao_evento, container, false);
        return rootView;
    }
}
