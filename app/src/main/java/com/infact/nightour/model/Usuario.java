package com.infact.nightour.model;

import android.content.Context;
import android.database.Cursor;

import com.infact.nightour.controller.FotosController;
import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringChaveEstrangeira;
import com.infact.nightour.helper.StringsCampo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Timóteo on 08/11/2015.
 */
public class Usuario {
    public static String NOME_TABELA = "usuarios";

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

    public static String BD_IMAGEM_PERFIL = "fotoPerfil_chave"; // Chave estrangeira
    public static String BD_IMAGEM_PERFIL_TIPO = "integer";
    public static String BD_IMAGEM_REFERENCIA = Foto.NOME_TABELA;
    public static String BD_IMAGEM_CAMPO_REFERENCIADO = Foto.BD_ID;

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new Object[] {
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_NOME, BD_NOME_TIPO),
                new StringsCampo(BD_STATUS, BD_STATUS_TIPO),
                new StringsCampo(BD_INTERESSE, BD_INTERESSE_TIPO),
                new StringsCampo(BD_ANIVERSARIO, BD_ANIVERSARIO_TIPO),
                new StringsCampo(BD_IMAGEM_PERFIL, BD_IMAGEM_PERFIL_TIPO),
                new StringChaveEstrangeira(BD_IMAGEM_PERFIL, BD_IMAGEM_REFERENCIA, BD_IMAGEM_CAMPO_REFERENCIADO)
            });
    }

    public static Usuario fromCursor(Cursor cursor, Context context) {
        Usuario usuario = new Usuario();

        usuario.setId(cursor.getInt(cursor.getColumnIndexOrThrow(BD_ID)));
        usuario.setNome(cursor.getString(cursor.getColumnIndexOrThrow(BD_NOME)));
        usuario.setStatus(cursor.getString(cursor.getColumnIndexOrThrow(BD_STATUS)));
        usuario.setInteresse(cursor.getString(cursor.getColumnIndexOrThrow(BD_INTERESSE)));
        usuario.setAniversario(cursor.getLong(cursor.getColumnIndexOrThrow(BD_ANIVERSARIO)));

        Long chaveImagem = cursor.getLong(cursor.getColumnIndexOrThrow(BD_IMAGEM_PERFIL));
        usuario.setImagemPerfil(Foto.fromCursor(new FotosController(context).carregaFotoById(chaveImagem)));

        return usuario;
    }

    public static List<Usuario> getListFromCursor(Cursor cursor, Context context) {
        List<Usuario> usuarios = new ArrayList<Usuario>();

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            usuarios.add(Usuario.fromCursor(cursor, context));
        }

        return usuarios;
    }

    private long id;
    private String nome;
    private String status;
    private String interesse;
    private long aniversario;
    private Foto imagemPerfil;

    public Usuario() {}
    public Usuario(String nome){
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    public long getAniversario() {
        return aniversario;
    }

    public void setAniversario(long aniversario) {
        this.aniversario = aniversario;
    }

    public long getChaveImagemPerfil() {
        return getImagemPerfil().getId();
    }

    public Foto getImagemPerfil() {
        return imagemPerfil;
    }

    public void setImagemPerfil(Foto imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }
}
