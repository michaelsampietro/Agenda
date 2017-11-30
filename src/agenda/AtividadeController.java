/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author michaelsampietro
 */
public class AtividadeController {
    
    AtividadeModel model;
     AtividadeView view;
    
    public AtividadeController (AtividadeModel model, AtividadeView view) { 
        this.model = model;
        this.view = view;
    }
    
    public void adicionaAtividadeLista (List<String> lista) {        
        AtividadeModel atividade = new AtividadeModel();
        atividade.setNome(lista.get(0));
        atividade.setData(lista.get(1));
        atividade.setDescricao(lista.get(2));
        
        model.atividades.add(atividade);
    }
        
    public void editarAtividadeLista (String nomeAtividade) {
        Iterator<AtividadeModel> atividadesIterator = model.atividades.iterator();
        while (atividadesIterator.hasNext()) {
            AtividadeModel atividade = atividadesIterator.next();
            if (atividade.getNome().equals(nomeAtividade)) {
                List<String> aux = new ArrayList<String>();
                
                aux = view.recebeDados();
                
                atividade.setNome(aux.get(0));
                atividade.setData(aux.get(1));
                atividade.setDescricao(aux.get(2));
                
                System.out.println("Atividade atualizada!");
                view.imprimeAtividade(atividade.getNome(), atividade.getData(), atividade.getDescricao());

                break;
            }
        }
    }
    
    public void deletarAtividadeLista (String nomeAtividade) {
        Iterator<AtividadeModel> atividadesIterator = model.atividades.iterator();
        while (atividadesIterator.hasNext()) {
            AtividadeModel atividade = atividadesIterator.next();
            if (atividade.getNome().equals(nomeAtividade)) {
                atividadesIterator.remove();
                
                System.out.println("Atividade removida!\nLista de atividades: ");
                view.atualizaTela(model.atividades);
                
                break;
            }
        }
    }
        
    public void setNomeAtividade(String nome) {
        model.setNome(nome);
    }
    
    public void setDataAtividade (String data) {
        model.setData(data);
    }
    
    public void setDescricaoAtividade (String descricao) {
        model.setDescricao(descricao);
    }
    
    public String getNomeAtividade () {
        return model.getNome();
    }
    
    public String getDataAtividade () {
        return model.getData();
    }
    
    public String getDescricaoAtividade () {
        return model.getDescricao();
    }
    
    public void atualizaTela () {
        view.atualizaTela(model.atividades);
    }
}
