package com.infact.nightour.model;

import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringsCampo;

/**
 * Created by Timóteo on 26/11/2015.
 */
public class Local {
    public static String NOME_TABELA = "fotos";

    public static String BD_ID = "_id";
    public static String BD_ID_TIPO = "integer primary key autoincrement";

    public static final String BD_LATITUDE = "latitude";
    public static final String BD_LATITUDE_TIPO = "double";

    public static final String BD_LONGITUDE = "longitude";
    public static final String BD_LONGITUDE_TIPO = "double";

    public static final String BD_ZOOM = "zoom";
    public static final String BD_ZOOM_TIPO = "text";

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new Object[]{
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_LATITUDE, BD_LATITUDE_TIPO),
                new StringsCampo(BD_LONGITUDE, BD_LONGITUDE_TIPO),
                new StringsCampo(BD_ZOOM, BD_ZOOM_TIPO)
        });
    }
}