package com.infact.nightour.relation;

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
}
