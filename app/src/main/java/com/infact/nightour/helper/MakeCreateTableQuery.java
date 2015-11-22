package com.infact.nightour.helper;

/**
 * Created by Timóteo on 21/11/2015.
 */
public class MakeCreateTableQuery {
    public static String makeString(String nomeTabela, StringsCampo[] campos) {
        String query = "CREATE TABLE " + nomeTabela + " (";
        boolean primeiroCampo = true;

        for (StringsCampo campo: campos) {
            if (primeiroCampo) {
                primeiroCampo = false;
            }
            else {
                query += ",";
            }

            query += campo.getNomeCampo() + " " + campo.getTipoCampo();
        }

        query += ")";
        return query;
    }
}
