package com.infact.nightour.model;

import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringsCampo;

/**
 * Created by Timóteo on 17/01/2016.
 */
public class Timestamp {
    public static String NOME_TABELA = "timestamps";

    public static String BD_ID = "_id";
    public static String BD_ID_TIPO = "integer primary key autoincrement";

    public static String BD_CREATE_TIME = "create_time";
    public static String BD_CREATE_TIME_TIPO = "INT"; // Armazenado em Unix time

    public static String BD_UPDATE_TIME = "update_time";
    public static String BD_UPDATE_TIME_TIPO = "INT"; // Armazenado em Unix time

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new StringsCampo[]{
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_CREATE_TIME, BD_CREATE_TIME_TIPO),
                new StringsCampo(BD_UPDATE_TIME, BD_UPDATE_TIME_TIPO)
        });
    }
}
