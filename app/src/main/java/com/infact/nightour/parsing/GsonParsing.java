package com.infact.nightour.parsing;

import com.infact.nightour.dto.EventoDTO;
import com.infact.nightour.dto.UsuarioDTO;
import com.google.gson.Gson;

/**
 * Created by Klinsman
 */
public class GsonParsing {

    public static String getJsonFromEventDTO(EventoDTO eventoDTO){
        String json;
        Gson gson = new Gson();
        json = gson.toJson(eventoDTO);
        return json;
    }

    public static String getJsonFromUserDTO(UsuarioDTO usuarioDTO){
        String json;
        Gson gson = new Gson();
        json = gson.toJson(usuarioDTO);
        return json;
    }
}
