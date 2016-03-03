package com.infact.nightour.parsing;

import com.google.gson.reflect.TypeToken;
import com.infact.nightour.dto.EventoDTO;
import com.infact.nightour.dto.UsuarioDTO;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

    public static List<UsuarioDTO> getUsuarioDTOListFromJson(String json){
        List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();
        try{
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<UsuarioDTO>>() {
            }.getType();
            usuarioDTOs = gson.fromJson(json, listType);

        }catch (Exception exception){
            exception.printStackTrace();
        }
        return usuarioDTOs;
    }
}
