package com.infact.nightour.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringsCampo;

import java.io.ByteArrayOutputStream;

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

    public static String BD_IMAGEM = "imagem";
    public static String BD_IMAGEM_TIPO = "blob";

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new StringsCampo[] {
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_NOME, BD_NOME_TIPO),
                new StringsCampo(BD_DESCRICAO, BD_DESCRICAO_TIPO),
                new StringsCampo(BD_GENERO, BD_GENERO_TIPO),
                new StringsCampo(BD_IMAGEM, BD_IMAGEM_TIPO)
        });
    }

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
}
