package com.infact.nightour.model;

import android.database.Cursor;

import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringsCampo;

/**
 * Created by Timóteo on 26/11/2015.
 */
public class Local {
    public static String NOME_TABELA = "locais";

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

    public static Local fromCursor(Cursor cursor) {
        Local local = new Local();

        local.setId(cursor.getLong(cursor.getColumnIndexOrThrow(BD_ID)));
        local.setLatitude(cursor.getDouble(cursor.getColumnIndexOrThrow(BD_LATITUDE)));
        local.setLongitude(cursor.getDouble(cursor.getColumnIndexOrThrow(BD_LONGITUDE)));
        local.setZoom(cursor.getFloat(cursor.getColumnIndexOrThrow(BD_ZOOM)));

        return local;
    }

    private long id;
    private double longitude;
    private double latitude;
    private float zoom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }
}