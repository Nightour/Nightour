package com.infact.nightour.relation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.infact.nightour.BancoDeDados;
import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringChaveEstrangeira;
import com.infact.nightour.model.Foto;
import com.infact.nightour.model.Usuario;

/**
 * Created by Timóteo on 17/01/2016.
 */
public class UsuarioTemFotos {
    public static String NOME_TABELA = "usuarios_foram_a_eventos";

    public static String BD_CHAVE_DONO = "dono_chave"; // Chave estrangeira
    public static String BD_CHAVE_DONO_TIPO = "INT";
    public static String BD_DONO_REFERENCIA = Usuario.NOME_TABELA;
    public static String BD_DONO_CAMPO_REFERENCIADO = Usuario.BD_ID;

    public static String BD_CHAVE_FOTO = "foto_chave"; // Chave estrangeira
    public static String BD_CHAVE_FOTO_TIPO = "INT";
    public static String BD_FOTO_REFERENCIA = Foto.NOME_TABELA;
    public static String BD_FOTO_CAMPO_REFERENCIADO = Foto.BD_ID;

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new Object[]{
                new StringChaveEstrangeira(BD_CHAVE_DONO, BD_CHAVE_DONO_TIPO, BD_DONO_REFERENCIA, BD_DONO_CAMPO_REFERENCIADO),
                new StringChaveEstrangeira(BD_CHAVE_FOTO, BD_CHAVE_FOTO_TIPO, BD_FOTO_REFERENCIA, BD_FOTO_CAMPO_REFERENCIADO),
                "PRIMARY KEY(" + BD_CHAVE_DONO + ", " + BD_CHAVE_FOTO + ")"
        });
    }

    // ---

    private SQLiteDatabase db;
    private BancoDeDados banco;

    UsuarioTemFotos(Context context) {
        banco = new BancoDeDados(context);
    }

    // ---

    public long insereTemFoto(Usuario dono, Foto foto) {
        ContentValues valores = new ContentValues();
        valores.put(BD_CHAVE_DONO, dono.getId());
        valores.put(BD_CHAVE_FOTO, foto.getId());

        db = banco.getWritableDatabase();
        long resultado = db.insert(NOME_TABELA, null, valores);
        db.close();

        return resultado;
    }

    public void deletaTemFoto(Usuario exDono, Foto foto) {
        String where = BD_CHAVE_DONO + " = " + exDono.getId() + " AND " + BD_CHAVE_FOTO + " = " + foto.getId();

        db = banco.getWritableDatabase();
        db.delete(NOME_TABELA, where, null);
        db.close();
    }

    public Cursor carregaFotosDo(Usuario usuario) {
        String query = "SELECT * FROM " + Foto.NOME_TABELA + " foto WHERE foto." + Foto.BD_ID + " IN " +
                "(SELECT relacao." + BD_CHAVE_FOTO + " FROM " + NOME_TABELA + " relacao WHERE relacao." + BD_CHAVE_DONO + " = " + usuario.getId() + ")";

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        db.close();

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public Cursor carregaDonosDa(Foto foto) {
        String query = "SELECT * FROM " + Usuario.NOME_TABELA + " usuario WHERE usuario." + Usuario.BD_ID + " IN " +
                "(SELECT relacao." + BD_CHAVE_DONO + " FROM " + NOME_TABELA + " relacao WHERE relacao." + BD_CHAVE_FOTO + " = " + foto.getId() + ")";

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        db.close();

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }
}
