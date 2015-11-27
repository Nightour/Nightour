package com.infact.nightour.helper;

/**
 * Created by Timóteo on 22/11/2015.
 */
public class StringChaveEstrangeira {
    private String nomeChave;
    private String tipo;
    private String campoReferenciado;
    private String tabelaReferenciada;

    public StringChaveEstrangeira(String nomeChave, String tipo, String tabelaReferenciada, String campoReferenciado) {
        this.nomeChave = nomeChave;
        this.setCampoReferenciado(campoReferenciado);
        this.setTabelaReferenciada(tabelaReferenciada);
    }

    public String getNomeChave() {
        return nomeChave;
    }

    public void setNomeChave(String nomeChave) {
        this.nomeChave = nomeChave;
    }

    public String getTabelaReferenciada() {
        return tabelaReferenciada;
    }

    public void setTabelaReferenciada(String tabelaReferenciada) {
        this.tabelaReferenciada = tabelaReferenciada;
    }

    @Override
    public String toString() {
        return "FOREIGN KEY(" + getNomeChave() + ") REFERENCES " + getTabelaReferenciada() + "(" + getCampoReferenciado() + ")";
    }

    public String getCampoReferenciado() {
        return campoReferenciado;
    }

    public void setCampoReferenciado(String campoReferenciado) {
        this.campoReferenciado = campoReferenciado;
    }
}
