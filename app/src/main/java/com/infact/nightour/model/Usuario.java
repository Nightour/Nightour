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

    public static String BD_EMAIL = "email";
    public static String BD_EMAIL_TIPO = "text";

    public static String BD_SENHA = "senha";
    public static String BD_SENHA_TIPO = "text";

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(BD_TABELA, new StringsCampo[] {
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_EMAIL, BD_EMAIL_TIPO),
                new StringsCampo(BD_SENHA, BD_SENHA_TIPO)
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
