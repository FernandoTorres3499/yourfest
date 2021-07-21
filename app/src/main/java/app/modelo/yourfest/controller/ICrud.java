package app.modelo.yourfest.controller;

import java.util.List;

public interface ICrud<T> {

    // Metodos: Incluir, Alterar, deletar e listar (para se ter persistencia de dados no BD)


     // incluir
    public boolean incluir(T obj);

    // alterar
    public boolean alterar(T obj);

    //deletar
    public boolean deletar(int id);

    //listar
    public List<T> listar();



}
