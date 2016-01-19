package com.infact.nightour.dto;

/**
 * Created by Timóteo on 19/01/2016.
 */
public class UsuarioDTO {
    private int id;
    private String nome;
    private String status;
    private String interesse;
    private String aniversario;

    private FotoDTO imagemPerfil;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public FotoDTO getImagemPerfil() {
        return imagemPerfil;
    }

    public void setImagemPerfil(FotoDTO imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }
}
