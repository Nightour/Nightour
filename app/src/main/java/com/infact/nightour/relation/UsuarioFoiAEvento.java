package com.infact.nightour.relation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    // ---

    public long insereFoiAEvento(Usuario usuario, Evento evento) {
        ContentValues valores = new ContentValues();
        valores.put(BD_CHAVE_USUARIO, usuario.getId());
        valores.put(BD_CHAVE_EVENTO, evento.getId());

        db = banco.getWritableDatabase();
        long resultado = db.insert(NOME_TABELA, null, valores);
        db.close();

        return resultado;
    }

    public void deletaFoiAEvento(Usuario usuario, Evento evento) {
        String where = BD_CHAVE_USUARIO + " = " + usuario.getId() + " AND " + BD_CHAVE_EVENTO + " = " + evento.getId();

        db = banco.getWritableDatabase();
        db.delete(NOME_TABELA, where, null);
        db.close();
    }

    public Cursor carregaEventosIdosPor(Usuario usuario) {
        String query = "SELECT * FROM " + Evento.NOME_TABELA + " evento WHERE evento." + Evento.BD_ID + " IN " +
                "(SELECT evento." + BD_CHAVE_EVENTO + " FROM " + NOME_TABELA + " relacao WHERE relacao." + BD_CHAVE_USUARIO + " = " + usuario.getId() + ")";

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        db.close();

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public Cursor carregaUsuariosQueForamA(Evento evento) {
        String query = "SELECT * FROM " + Usuario.NOME_TABELA + " usuario WHERE usuario." + Usuario.BD_ID + " IN " +
                "(SELECT relacao." + BD_CHAVE_USUARIO + " FROM " + NOME_TABELA + " relacao WHERE relacao." + BD_CHAVE_EVENTO + " = " + evento.getId() + ")";

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        db.close();

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }
}
