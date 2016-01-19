package com.infact.nightour.dto;

/**
 * Created by Timóteo on 19/01/2016.
 */
public class EventoDTO {
    private int id;
    private String nome;
    private String descricao;
    private String genero;

    private FotoDTO capa;
    private LocalDTO local;
    private UsuarioDTO criador;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public FotoDTO getCapa() {
        return capa;
    }

    public void setCapa(FotoDTO capa) {
        this.capa = capa;
    }

    public LocalDTO getLocal() {
        return local;
    }

    public void setLocal(LocalDTO local) {
        this.local = local;
    }

    public UsuarioDTO getCriador() {
        return criador;
    }

    public void setCriador(UsuarioDTO criador) {
        this.criador = criador;
    }
}
