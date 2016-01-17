package com.infact.nightour.relation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;
import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringChaveEstrangeira;
import com.infact.nightour.model.Evento;
import com.infact.nightour.model.Usuario;

/**
 * Created by Timóteo on 17/01/2016.
 */
public class UsuarioFoiAEvento {
    public static String NOME_TABELA = "usuarios_foram_a_eventos";

    public static String BD_CHAVE_USUARIO = "usuario_chave"; // Chave estrangeira
    public static String BD_CHAVE_USUARIO_TIPO = "INT";
    public static String BD_USUARIO_REFERENCIA = Usuario.NOME_TABELA;
    public static String BD_USUARIO_CAMPO_REFERENCIADO = Usuario.BD_ID;

    public static String BD_CHAVE_EVENTO = "evento_chave"; // Chave estrangeira
    public static String BD_CHAVE_EVENTO_TIPO = "INT";
    public static String BD_EVENTO_REFERENCIA = Evento.NOME_TABELA;
    public static String BD_EVENTO_CAMPO_REFERENCIADO = Evento.BD_ID;

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new Object[]{
                new StringChaveEstrangeira(BD_CHAVE_USUARIO, BD_CHAVE_USUARIO_TIPO, BD_USUARIO_REFERENCIA, BD_USUARIO_CAMPO_REFERENCIADO),
                new StringChaveEstrangeira(BD_CHAVE_EVENTO, BD_CHAVE_EVENTO_TIPO, BD_EVENTO_REFERENCIA, BD_EVENTO_CAMPO_REFERENCIADO),
                "PRIMARY KEY(" + BD_CHAVE_USUARIO + ", " + BD_CHAVE_EVENTO + ")"
        });
    }

    // ---

    private SQLiteDatabase db;
    private BancoDeDados banco;

    UsuarioFoiAEvento(Context context) {
        banco = new BancoDeDados(context);
    }
}
