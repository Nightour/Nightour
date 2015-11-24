package com.infact.nightour.model;

import com.infact.nightour.helper.MakeCreateTableQuery;
import com.infact.nightour.helper.StringChaveEstrangeira;
import com.infact.nightour.helper.StringsCampo;

import java.util.Date;

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

    public static String BD_IMAGEM_PERFIL = "imagemPerfil"; // Chave estrangeira
    public static String BD_IMAGEM_REFERENCIA = "PLACEHOLDER"; // Substituir por Foto.NOME_TABELA mais tarde

    public static String getCreateTableQuery() {
        return MakeCreateTableQuery.makeString(NOME_TABELA, new Object[] {
                new StringsCampo(BD_ID, BD_ID_TIPO),
                new StringsCampo(BD_NOME, BD_NOME_TIPO),
                new StringsCampo(BD_STATUS, BD_STATUS_TIPO),
                new StringsCampo(BD_INTERESSE, BD_INTERESSE_TIPO),
                new StringsCampo(BD_ANIVERSARIO, BD_ANIVERSARIO_TIPO),
                new StringChaveEstrangeira(BD_IMAGEM_PERFIL, BD_IMAGEM_REFERENCIA)
            });
    }

    private int id;
    private String nome;
    private String status;
    private String interesse;
    private Date aniversario;
    private int chaveImagemPerfil; // Pegar a imagem de perfil do usuário através de FotosController.carregaImagemPerfilByUsuario!

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

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public long getAniversarioUnixTime() {
        long unixTime = getAniversario().getTime() / 1000L;
        return unixTime;
    }

    public int getChaveImagemPerfil() {
        return chaveImagemPerfil;
    }

    public void setChaveImagemPerfil(int chaveImagemPerfil) {
        this.chaveImagemPerfil = chaveImagemPerfil;
    }
}
