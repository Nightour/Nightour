package com.infact.nightour.model;

import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringsCampo;

import java.util.Date;

/**
 * Created by Timóteo on 17/01/2016.
 */
public class Timestamp {
    public static long makeUnixTime(Date date) {
        long unixTime = date.getTime();
        return unixTime;
    }

    public static Date dateFromUnixTime(int unixTime) {
        Date date = new Date();
        date.setTime(unixTime);

        return date;
    }

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

    private int id;
    private int createTime;
    private int updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }
}
