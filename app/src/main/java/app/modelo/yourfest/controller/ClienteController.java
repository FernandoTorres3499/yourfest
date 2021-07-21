package app.modelo.yourfest.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.modelo.yourfest.api.AppUtil;
import app.modelo.yourfest.datamodel.ClienteDataModel;
import app.modelo.yourfest.datasource.AppDataBase;
import app.modelo.yourfest.model.Cliente;


public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    //String versaoApp;


    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        //dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.CEP, obj.getCep());
        dadoDoObjeto.put(ClienteDataModel.LOGRADOURO, obj.getLograudoro());
        dadoDoObjeto.put(ClienteDataModel.NUMERO, obj.getNumero());
        dadoDoObjeto.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadoDoObjeto.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadoDoObjeto.put(ClienteDataModel.ESTADO, obj.getEstado());
        dadoDoObjeto.put(ClienteDataModel.TERMOS_DE_USO, obj.isTermosDeUso());

        // Enviar os dados (dadoDoObj) para a classe AppDataBase
        // Utilizando o metodo capaz de adicionar o Obj no banco de dados
        // Tabela qualquer uma  (Cliente)
        return insert(ClienteDataModel.TABELA, dadoDoObjeto);
    }


    @Override
    public boolean deletar(int id) {


        return deleteById(ClienteDataModel.TABELA, id);
    }


    @Override
    public boolean alterar(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());

        // Enviar os dados (dadoDoObj) para a classe AppDataBase
        // Utilizando o metodo capaz de Alterar o Obj no banco de dados
        // Tabela qualquer uma  (Cliente), respeitando o ID (Chave primaria)

        return update(ClienteDataModel.TABELA, dadoDoObjeto);

    }


    @Override
    public List<Cliente> listar() {


        return getAllClientes(ClienteDataModel.TABELA);
    }


    public List<String> gerarListaDeClientesListView(){

        List<String> clientes = new ArrayList<>();

        for (Cliente obj : listar()) {

            clientes.add(obj.getId() + ", " + obj.getNome() + ", "+ obj.getTelefone());

        }

        return clientes;
    }





    /*
    public ClienteController(){



        this.versaoApp = AppUtil.versaoDoAplicativo();

        Log.i(AppUtil.TAG, "ClienteController: "+ this.versaoApp);


    }*/


}
