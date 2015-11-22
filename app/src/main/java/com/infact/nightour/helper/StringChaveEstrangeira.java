package com.infact.nightour.helper;

/**
 * Created by Timóteo on 22/11/2015.
 */
public class StringChaveEstrangeira {
    private String nomeChave;
    private String tabelaReferenciada;

    public StringChaveEstrangeira(String nomeChave, String tabelaReferenciada) {
        this.nomeChave = nomeChave;
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
}
