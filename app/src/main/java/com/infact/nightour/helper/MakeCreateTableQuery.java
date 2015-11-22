package com.infact.nightour.helper;

/**
 * Created by Timóteo on 21/11/2015.
 */
public class MakeCreateTableQuery {
    public static String makeString(String nomeTabela, Object[] campos) {
        String query = "CREATE TABLE " + nomeTabela + " (";
        boolean primeiroCampo = true;

        for (Object campo: campos) {
            if (primeiroCampo) {
                primeiroCampo = false;
            }
            else {
                query += ",";
            }

            query += campo.toString();
        }

        query += ")";
        return query;
    }
}
