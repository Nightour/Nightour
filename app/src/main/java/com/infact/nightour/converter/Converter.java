package com.infact.nightour.converter;

import com.infact.nightour.dto.FotoDTO;
import com.infact.nightour.dto.LocalDTO;
import com.infact.nightour.dto.UsuarioDTO;
import com.infact.nightour.model.Foto;
import com.infact.nightour.model.Local;
import com.infact.nightour.model.Usuario;

/**
 * Created by Timóteo on 28/02/2016.
 */
public class Converter {
    public static Foto DTOtoFoto(FotoDTO dto) {
        Foto foto = new Foto();

        foto.setId(dto.getId());
        foto.setImagem(Foto.bitmapFromBlob(dto.getImagem()));
        foto.setDescricao(dto.getDescricao());

        return foto;
    }

    public static Local DTOtoLocal(LocalDTO dto) {
        Local local = new Local();

        local.setId(dto.getId());
        local.setZoom((float)dto.getZoom());
        local.setLatitude(dto.getLatitude());
        local.setLongitude(dto.getLongitude());

        return local;
    }

    public static Usuario DTOtoUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();

        usuario.setId(dto.getId());
        usuario.setStatus(dto.getStatus());
        usuario.setInteresse(dto.getInteresse());
        usuario.setAniversario(Long.parseLong(dto.getAniversario(), 10));
        usuario.setImagemPerfil(DTOtoFoto(dto.getImagemPerfil()));

        return usuario;
    }
}
