package com.infact.nightour.model;

import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringsCampo;

/**
 * Created by Timóteo on 08/11/2015.
 */
public class Usuario {
    public static String BD_TABELA = "usuarios";

    public static String BD_ID = "_id";
    public static String BD_ID_TIPO = "integer primary key autoincrement";

    public static String BD_NOME = "nome";
    public static String BD_NOME_TIPO = "text";

    public static String BD_STATUS = "status";
    public static String BD_STATUS_TIPO = "text";

    public static String BD_INTERESSE = "interesse";
    public static String BD_INTERESSE_TIPO = "text";

    public static String BD_ANIVERSARIO = "aniversario";
    public static String BD_ANIVERSARIO_TIPO = "integer"; // Usar o Unix time

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(BD_TABELA, new StringsCampo[] {
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_NOME, BD_NOME_TIPO),
                new StringsCampo(BD_STATUS, BD_STATUS_TIPO),
                new StringsCampo(BD_INTERESSE, BD_INTERESSE_TIPO),
                new StringsCampo(BD_ANIVERSARIO, BD_ANIVERSARIO_TIPO)
            });
    }

    private int id;
    private String email;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
