package com.infact.nightour.model;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringChaveEstrangeira;
import com.infact.nightour.helper.StringsCampo;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timóteo on 08/11/2015.
 */
public class Evento {
    public static String NOME_TABELA = "eventos";

    public static String BD_ID = "_id";
    public static String BD_ID_TIPO = "integer primary key autoincrement";

    public static String BD_NOME = "evento_nome";
    public static String BD_NOME_TIPO = "text";

    public static String BD_DESCRICAO = "evento_descricao";
    public static String BD_DESCRICAO_TIPO = "text";

    public static String BD_GENERO = "genero";
    public static String BD_GENERO_TIPO = "text";

    public static String BD_IMAGEM_CHAVE = "imagem_chave"; // Chave estrangeira
    public static String BD_IMAGEM_CHAVE_TIPO = "INT";
    public static String BD_IMAGEM_REFERENCIA = Foto.NOME_TABELA;
    public static String BD_IMAGEM_CAMPO_REFERENCIADO = Foto.BD_ID;

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new Object[] {
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_NOME, BD_NOME_TIPO),
                new StringsCampo(BD_DESCRICAO, BD_DESCRICAO_TIPO),
                new StringsCampo(BD_GENERO, BD_GENERO_TIPO),
                new StringChaveEstrangeira(BD_IMAGEM_CHAVE, BD_IMAGEM_CHAVE_TIPO, BD_IMAGEM_REFERENCIA, BD_IMAGEM_CAMPO_REFERENCIADO)
        });
    }

    // ---

    // Cria um evento a partir dos dados na posição apontada pelo cursor passado.
    public static Evento fromCursor(Cursor cursor) {
        Evento evento = new Evento();

        evento.setId(cursor.getInt(cursor.getColumnIndexOrThrow(BD_ID)));
        evento.setNome(cursor.getString(cursor.getColumnIndexOrThrow(BD_NOME)));
        evento.setDescricao(cursor.getString(cursor.getColumnIndexOrThrow(BD_DESCRICAO)));
        evento.setGenero(cursor.getString(cursor.getColumnIndexOrThrow(BD_GENERO)));
        evento.setImagemBytes(cursor.getBlob(cursor.getColumnIndexOrThrow(BD_IMAGEM)));

        return evento;
    }

    public static List<Evento> getListFromCursor(Cursor cursor) {
        List<Evento> eventos = new ArrayList<Evento>();

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            eventos.add(Evento.fromCursor(cursor));
        }

        return eventos;
    }

    // ---

    private int id;
    private String nome;
    private String descricao;
    private String genero;
    private Bitmap imagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Bitmap getImagem() {
        return imagem;
    }

    public void setImagem(Bitmap imagem) {
        this.imagem = imagem;
    }

    public void setImagemBytes(byte[] bytes) {
        setImagem(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
    }

    public byte[] getImagemBytes() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        getImagem().compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    @Override
    public String toString(){
        return "Evento{" + "nome='" + nome +'\'' + '}';
    }
}
