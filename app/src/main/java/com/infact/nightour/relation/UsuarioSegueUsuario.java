package com.infact.nightour.relation;

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


}
