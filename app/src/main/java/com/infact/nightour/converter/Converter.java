package com.infact.nightour.converter;

import com.infact.nightour.dto.UsuarioDTO;
import com.infact.nightour.model.Usuario;

/**
 * Created by Timóteo on 28/02/2016.
 */
public class Converter {
    public static Usuario DTOtoUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();

        usuario.setId(dto.getId());
        usuario.setStatus(dto.getStatus());
        usuario.setInteresse(dto.getInteresse());
        usuario.setAniversario(Long.parseLong(dto.getAniversario(), 10));

        return usuario;
    }
}
