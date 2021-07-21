package app.modelo.yourfest.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


import app.modelo.yourfest.api.AppUtil;
import app.modelo.yourfest.datamodel.ClienteDataModel;

import app.modelo.yourfest.model.Cliente;



public class AppDataBase extends SQLiteOpenHelper {


    //definir nome do Banco de dados
    public static final String DB_NAME = "MeusClientes.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;


    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(AppUtil.TAG, "AppDataBase: Criando Banco de Dados ");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //criando tabela cliente

        db.execSQL(ClienteDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate: Tabela Cliente criada:  " + ClienteDataModel.criarTabela());


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Metodo para incluir dados no Banco de Dados
     *
     * @return
     */

    public boolean insert(String tabela, ContentValues dados) {

        //abrir conexao Bd
        db = getWritableDatabase();

        boolean retorno = false;

        // regra de negocio

        try {
            // o que deve ser realizado?
            //Salvar os dados

            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {

            Log.d(AppUtil.TAG, "insert:  " + e.getMessage());

        }


        //inserir no BD


        return retorno;
    }


    /**
     * Metodo para excluir dados no Banco de Dados
     *
     * @return
     */

    public boolean deleteById(String tabela, int id) {

        //abrir conexao Bd
        db = getWritableDatabase();

        boolean retorno = false;

        // regra de negocio

        try {
            // o que deve ser realizado?
            //Salvar os dados

          //  retorno = db.insert(tabela, null, dados) > 0;
            retorno = db.delete(tabela, "id = ?", new String[]{String.valueOf(id)})>0;

        } catch (Exception e) {

            Log.d(AppUtil.TAG, "Delete:  " + e.getMessage());

        }

        //inserir no BD

        return retorno;
    }


    /**
     * Metodo para Alterar dados no Banco de Dados
     *
     * @return
     */

    public boolean update(String tabela, ContentValues dados) {

        //abrir conexao Bd
        db = getWritableDatabase();

        boolean retorno = false;

        // regra de negocio

        try {
            // o que deve ser realizado?
            //Salvar os dados

            retorno = db.update(tabela, dados,"id = ?",
                    new String[] {String.valueOf(dados.get("id"))}) > 0;
        } catch (Exception e) {

            Log.d(AppUtil.TAG, "insert:  " + e.getMessage());

        }


        //inserir no BD


        return retorno;
    }

    public List<Cliente> getAllClientes(String tabela){

        Cliente obj;

        db = getWritableDatabase();

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM "+tabela;

        Cursor cursor;
        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){

            do {
                obj = new Cliente();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                obj.setTelefone(cursor.getString(cursor.getColumnIndex(ClienteDataModel.TELEFONE)));


                clientes.add(obj);

                Log.i("Listar", "getAllClientes: "+obj.getNome());

            }while (cursor.moveToNext());
        }


        return clientes;
    }


}
