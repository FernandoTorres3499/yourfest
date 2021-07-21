package app.modelo.yourfest.datamodel;

public class ClienteDataModel {

    // Modelo Objeto Relacional
    // Toda Classe dentro da Data Model tem:
    // 5 - Query para consultas gerais
    // 4 - Metodo para gerar o Script para criar a tabela

    // 1 - Atributo nome da tabela
    public static final String TABELA = "cliente";

    // 2 - Atributos um para um com os nomes dos campos
    public static final String ID = "id"; //integer
    public static final String NOME = "nome"; //text
    public static final String TELEFONE = "telefone"; //text
    public static final String EMAIL = "email"; //text
    public static final String CEP = "cep"; //text
    public static final String LOGRADOURO = "logradouro"; //text
    public static final String NUMERO = "numero"; //text
    public static final String BAIRRO = "bairro"; //text
    public static final String CIDADE = "cidade"; //text
    public static final String ESTADO = "estado"; //text
    public static final String TERMOS_DE_USO = "termos_de_uso"; //integer

    // 3 - Query para criar a tabela no banco de dados
    public static String querryCriarTabela = " ";


    // 4 - Metodo para gerar o Script para criar a tabela

    public static String criarTabela(){

        // Concatenação de String

        querryCriarTabela += "CREATE TABLE " + TABELA + " (";
        querryCriarTabela += ID + " integer primary key autoincrement, ";
        querryCriarTabela += NOME + " text, ";
        querryCriarTabela += TELEFONE + " text, ";
        querryCriarTabela += EMAIL + " text,";
        querryCriarTabela += CEP  + " integer,";
        querryCriarTabela += LOGRADOURO  + " text,";
        querryCriarTabela += NUMERO  + " text,";
        querryCriarTabela += BAIRRO  + " text,";
        querryCriarTabela += CIDADE  + " text,";
        querryCriarTabela += ESTADO  + " text,";
        querryCriarTabela += TERMOS_DE_USO + " integer";
        querryCriarTabela += ")";

        return querryCriarTabela;
    }
}
