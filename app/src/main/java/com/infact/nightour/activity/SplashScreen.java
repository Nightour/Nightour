package com.infact.nightour.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.neto.nightour.R;
import com.infact.nightour.dto.EventoDTO;
import com.infact.nightour.dto.UsuarioDTO;
import com.infact.nightour.parsing.GsonParsing;
import com.infact.nightour.task.WebTask;

public class SplashScreen extends BaseActivity {

    EditText editText;
    Button btGetUser, btPostUser, btGetEvent, btPostEvent;
    WebTask webTask;
    String IP = "172.25.3.147";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final String baseURL = "http://" + IP + ":8080/night-tour-server/ws/";
        editText = (EditText) findViewById(R.id.editText);
        btGetUser = (Button) findViewById(R.id.btGetUser);
        btPostUser = (Button) findViewById(R.id.btPostUser);
        btGetEvent = (Button) findViewById(R.id.btGetEvent);
        btPostEvent = (Button) findViewById(R.id.btPostEvent);



        btGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webTask = new WebTask(SplashScreen.this);
                webTask.execute(baseURL + "users");
            }
        });

        btPostUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webTask = new WebTask(SplashScreen.this);
                String jsonUser = getJsonUserDTOTest();
                webTask.execute(baseURL + "users", jsonUser);
            }
        });

        btGetEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webTask = new WebTask(SplashScreen.this);
                webTask.execute(baseURL + "events");
            }
        });

        btPostEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webTask = new WebTask(SplashScreen.this);
                String jsonEvent = getJsonEventDTOTest();
                webTask.execute(baseURL + "events", jsonEvent);
            }
        });
    }

    private String getJsonUserDTOTest(){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setFacebookId("9100");
        usuarioDTO.setNome("Klinsman Maia");
        usuarioDTO.setInteresse("HUehueheue");
        usuarioDTO.setStatus("Status");
        return GsonParsing.getJsonFromUserDTO(usuarioDTO);
    }

    private String getJsonEventDTOTest(){
        EventoDTO eventoDTO = new EventoDTO();
        eventoDTO.setDescricao("Json huehuee");
        eventoDTO.setNome("Do json heueuheue");
        return GsonParsing.getJsonFromEventDTO(eventoDTO);
    }
}
