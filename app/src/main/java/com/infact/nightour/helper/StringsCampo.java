package com.infact.nightour.helper;

/**
 * Created by Timóteo on 21/11/2015.
 */
public class StringsCampo {
    private String nomeCampo;
    private String tipoCampo;

    public StringsCampo(String nomeCampo, String tipoCampo) {
        this.nomeCampo = nomeCampo;
        this.tipoCampo = tipoCampo;
    }

    public String getNomeCampo() {
        return nomeCampo;
    }

    public void setNomeCampo(String nomeCampo) {
        this.nomeCampo = nomeCampo;
    }

    public String getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(String tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    @Override
    public String toString() {
        return getNomeCampo() + " " + getTipoCampo();
    }
}
