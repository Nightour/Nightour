package com.infact.nightour.helper;

/**
 * Created by Timóteo on 22/11/2015.
 */
public class StringChaveEstrangeira {
    private String nomeChave;
    private String tipoCampo;
    private String campoReferenciado;
    private String tabelaReferenciada;

    public StringChaveEstrangeira(String nomeChave, String tipo, String tabelaReferenciada, String campoReferenciado) {
        this.setNomeChave(nomeChave);
        this.setTipoCampo(tipo);
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
        String query = getNomeChave() + " " + getTipoCampo() + ",";
        query += "FOREIGN KEY(" + getNomeChave() + ") REFERENCES " + getTabelaReferenciada() + "(" + getCampoReferenciado() + ")";
        return query;
    }

    public String getCampoReferenciado() {
        return campoReferenciado;
    }

    public void setCampoReferenciado(String campoReferenciado) {
        this.campoReferenciado = campoReferenciado;
    }

    public String getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(String tipoCampo) {
        this.tipoCampo = tipoCampo;
    }
}
