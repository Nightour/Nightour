package com.infact.nightour.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.neto.nightour.R;
import com.infact.nightour.fragment.EventoFragment;
import com.infact.nightour.model.Evento;

public class EventoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        setUpToolBar();

        EventoFragment ef = (EventoFragment) getSupportFragmentManager().findFragmentById(R.id.EventoFragment);
        Evento evento = (Evento) getIntent().getSerializableExtra("evento");
        ef.setEvento(evento);
        getSupportActionBar().setTitle(evento.getNome());
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }


}
