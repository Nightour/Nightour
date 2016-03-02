package com.infact.nightour.converter;

import com.infact.nightour.dto.EventoDTO;
import com.infact.nightour.dto.FotoDTO;
import com.infact.nightour.dto.LocalDTO;
import com.infact.nightour.dto.UsuarioDTO;
import com.infact.nightour.model.Evento;
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
        local.setZoom((float) dto.getZoom());
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

    public static Evento DTOtoEvento(EventoDTO dto) {
        Evento evento = new Evento();

        evento.setId(dto.getId());
        evento.setNome(dto.getNome());
        evento.setDescricao(dto.getDescricao());
        evento.setLocal(DTOtoLocal(dto.getLocal()));
        evento.setImagem(DTOtoFoto(dto.getCapa()));

        return evento;
    }

    public static LocalDTO localToDTO(Local local) {
        LocalDTO dto = new LocalDTO();

        dto.setId(local.getId());
        dto.setZoom(local.getZoom());
        dto.setLatitude(local.getLatitude());
        dto.setLongitude(local.getLongitude());

        return dto;
    }

    public static FotoDTO fotoToDTO(Foto foto) {
        FotoDTO dto = new FotoDTO();

        dto.setId(foto.getId());
        dto.setImagem(foto.getImagemBytes());
        dto.setDescricao(foto.getDescricao());

        return dto;
    }

    public static UsuarioDTO usuarioToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();

        dto.setId(usuario.getId());
        dto.setStatus(usuario.getStatus());
        dto.setInteresse(usuario.getInteresse());
        dto.setAniversario(usuario.getAniversario() + "");
        dto.setImagemPerfil(fotoToDTO(usuario.getImagemPerfil()));

        return dto;
    }

    public EventoDTO eventoToDTO(Evento evento) {
        EventoDTO dto = new EventoDTO();

        dto.setId(evento.getId());
        dto.setNome(evento.getNome());
        dto.setDescricao(evento.getDescricao());
        dto.setLocal(localToDTO(evento.getLocal()));
        dto.setCapa(fotoToDTO(evento.getImagem()));

        return dto;
    }
}
