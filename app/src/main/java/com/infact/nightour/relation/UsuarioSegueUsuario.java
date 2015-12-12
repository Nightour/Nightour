package com.infact.nightour.relation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;
import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringChaveEstrangeira;
import com.infact.nightour.model.Usuario;

/**
 * Created by Timóteo on 12/12/2015.
 */
public class UsuarioSegueUsuario {
    public static String NOME_TABELA = "usuario_segue_usuario";

    public static String BD_CHAVE_SEGUIDOR = "chaveUsuarioSeguidor"; // Chave estrangeira
    public static String BD_CHAVE_SEGUIDOR_TIPO = "integer";
    public static String BD_SEGUIDOR_REFERENCIA = Usuario.NOME_TABELA;
    public static String BD_SEGUIDOR_CAMPO_REFERENCIADO = Usuario.BD_ID;

    public static String BD_CHAVE_SEGUIDO = "chaveUsuarioSeguido"; // Chave estrangeira
    public static String BD_CHAVE_SEGUIDO_TIPO = "integer";
    public static String BD_SEGUIDO_REFERENCIA = Usuario.NOME_TABELA;
    public static String BD_SEGUIDO_CAMPO_REFERENCIADO = Usuario.BD_ID;

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new Object[]{
                new StringChaveEstrangeira(BD_CHAVE_SEGUIDOR, BD_CHAVE_SEGUIDOR_TIPO, BD_SEGUIDOR_REFERENCIA, BD_SEGUIDOR_CAMPO_REFERENCIADO),
                new StringChaveEstrangeira(BD_CHAVE_SEGUIDO, BD_CHAVE_SEGUIDO_TIPO, BD_SEGUIDO_REFERENCIA, BD_SEGUIDO_CAMPO_REFERENCIADO),
                "PRIMARY KEY(" + BD_CHAVE_SEGUIDOR + ", " + BD_CHAVE_SEGUIDO + ")"
        });
    }

    // ---

    private SQLiteDatabase db;
    private BancoDeDados banco;

    UsuarioSegueUsuario(Context context) {
        banco = new BancoDeDados(context);
    }

    // ---

    public long insereSeguidor(Usuario seguidor, Usuario seguido) {
        ContentValues valores = new ContentValues();
        valores.put(BD_CHAVE_SEGUIDOR, seguidor.getId());
        valores.put(BD_CHAVE_SEGUIDO, seguido.getId());

        db = banco.getWritableDatabase();
        long resultado = db.insert(NOME_TABELA, null, valores);
        db.close();

        return resultado;
    }

    public void deletaSeguidor(Usuario seguidor, Usuario seguido) {
        String where = BD_CHAVE_SEGUIDOR + " = " + seguidor.getId() + " AND " + BD_CHAVE_SEGUIDO + " = " + seguido.getId();

        db = banco.getWritableDatabase();
        db.delete(NOME_TABELA, where, null);
        db.close();
    }

    public Cursor carregaSeguidores(Usuario seguido) {
        String query = "SELECT * FROM " + Usuario.NOME_TABELA + " usuario WHERE usuario." + Usuario.BD_ID + " IN " +
                "(SELECT segue." + BD_CHAVE_SEGUIDOR + " FROM " + NOME_TABELA + " segue WHERE segue." + BD_CHAVE_SEGUIDO + " = " + seguido.getId() + ")";

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        db.close();

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public Cursor carregaSeguindo(Usuario seguidor) {
        String query = "SELECT * FROM " + Usuario.NOME_TABELA + " usuario WHERE usuario." + Usuario.BD_ID + " IN " +
                "(SELECT relacao." + BD_CHAVE_SEGUIDO + " FROM " + NOME_TABELA + " relacao WHERE relacao." + BD_CHAVE_SEGUIDOR + " = " + seguidor.getId() + ")";

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        db.close();

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }
}
