/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author michaelsampietro
 */
public class AtividadeModel {
    private String nome;
    private String data;
    private String descricao;
    private int id = 0;
    
    List<AtividadeModel> atividades = new ArrayList<AtividadeModel>();

        
//    public AtividadeModel (String nome, String data, String descricao) {
//        // adiciona quem entrou na lista de atividades
//        this.nome = nome;
//        this.data = data;
//        this.descricao = descricao;
//        this.id += 1;   
//    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome () {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
     
    
    
    
}
