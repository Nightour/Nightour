package com.infact.nightour.activity;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.neto.nightour.R;
import com.infact.nightour.controller.EventosController;
import com.infact.nightour.controller.UsuariosController;
import com.infact.nightour.converter.Converter;
import com.infact.nightour.dto.EventoDTO;
import com.infact.nightour.dto.FotoDTO;
import com.infact.nightour.dto.LocalDTO;
import com.infact.nightour.dto.UsuarioDTO;
import com.infact.nightour.listener.ResultadoListener;
import com.infact.nightour.model.Evento;
import com.infact.nightour.model.Foto;
import com.infact.nightour.model.Usuario;
import com.infact.nightour.parsing.GsonParsing;
import com.infact.nightour.task.WebTask;

import java.util.List;

public class SplashScreen extends BaseActivity implements ResultadoListener {

    EditText editText;
    Button btGetUser, btPostUser, btGetEvent, btPostEvent;
    WebTask webTask;
    String IP = "179.191.235.42";

    void mostrarUsuarios(UsuariosController controller) {
        Cursor cursor = controller.carregaUsuarios();
        List<Usuario> usuarios = Usuario.getListFromCursor(cursor, controller.getContext());

        for (Usuario usuario: usuarios) {
            Log.d("Usuario", usuario.getId() + "; " + usuario.getNome() + "; " + usuario.getStatus());
        }
    }

    void mostrarEventos(EventosController controller) {
        Cursor cursor = controller.carregaEventos();
        List<Evento> eventos = Evento.getListFromCursor(cursor, controller.getContext());

        for (Evento evento: eventos) {
            Log.d("Evento", evento.getId() + "; " + evento.getNome() + "; " + evento.getDescricao());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final String baseURL = "http://" + IP + ":8080/night-tour-server/rest/";
        editText = (EditText) findViewById(R.id.editText);
        btGetUser = (Button) findViewById(R.id.btGetUser);
        btPostUser = (Button) findViewById(R.id.btPostUser);
        btGetEvent = (Button) findViewById(R.id.btGetEvent);
        btPostEvent = (Button) findViewById(R.id.btPostEvent);



        btGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webTask = new WebTask(SplashScreen.this, new ResultadoListener() {
                    @Override
                    public void getResult(String string) {
                        UsuariosController controller = new UsuariosController(SplashScreen.this.getApplicationContext());

                        mostrarUsuarios(controller);

                        for (UsuarioDTO dto: GsonParsing.getUsuarioDTOListFromJson(string)) {
                            Usuario usuario = Converter.DTOtoUsuario(dto);
                            controller.insereUsuario(usuario);
                            Log.d("NomeUsuario", (usuario.getNome() == null) ? "nullllllllll" : usuario.getNome());
                            Log.d("NomeUsuarioDTO", (dto.getNome() == null)? "NULLOW" : dto.getNome());
                        }

                        /*Foto foto = new Foto();
                        foto.setImagem(BitmapFactory.decodeResource(getResources(), R.drawable.cara_do_perfil_03));
                        foto.setDescricao("abubu");
                        foto.setTimestamp(1000L);

                        Usuario usuario = new Usuario();
                        usuario.setNome("Adabo");
                        usuario.setAniversario(1000L);
                        usuario.setInteresse("comida");
                        usuario.setStatus("com fome");
                        usuario.setImagemPerfil(foto);

                        controller.insereUsuario(usuario);*/

                        mostrarUsuarios(controller);
                    }
                });
                webTask.execute(baseURL + "users");
            }
        });

        btPostUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webTask = new WebTask(SplashScreen.this, new ResultadoListener() {
                    @Override
                    public void getResult(String string) {

                    }
                });
                String jsonUser = getJsonUserDTOTest();
                webTask.execute(baseURL + "users", jsonUser);
            }
        });

        btGetEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webTask = new WebTask(SplashScreen.this, new ResultadoListener() {
                    @Override
                    public void getResult(String string) {
                        EventosController controller = new EventosController(SplashScreen.this.getApplicationContext());

                        //mostrarEventos(controller);

                        for (EventoDTO dto: GsonParsing.getEventoDTOListFromJson(string)) {
                            Evento evento = Converter.DTOtoEvento(dto);
                            controller.insereEvento(evento);
                            Log.d("NomeEvento", evento.getNome());
                            Log.d("NomeEventoDTO", dto.getNome());
                        }

                        mostrarEventos(controller);
                    }
                });
                webTask.execute(baseURL + "events");
            }
        });

        btPostEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webTask = new WebTask(SplashScreen.this, new ResultadoListener() {
                    @Override
                    public void getResult(String string) {
                        Log.d("Recebido algo", string);
                    }
                });
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
        FotoDTO fotoDTO = new FotoDTO();
        fotoDTO.setTimestamp(100L);
        fotoDTO.setDescricao("foto teste");
        fotoDTO.setImagem(Foto.blobFromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.cara_do_perfil_03)));

        LocalDTO localDTO = new LocalDTO();
        localDTO.setLatitude(10);
        localDTO.setLongitude(10);
        localDTO.setZoom(10);

        EventoDTO eventoDTO = new EventoDTO();
        eventoDTO.setDescricao("Json huehuee");
        eventoDTO.setNome("Do json heueuheue");
        //eventoDTO.setCapa(fotoDTO);
        return GsonParsing.getJsonFromEventDTO(eventoDTO);
    }

    @Override
    public void getResult(String string) {
        Log.d("GetResult!!", string == null ? "NULO??" : string);
    }
}
