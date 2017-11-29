/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

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
    
    public void adicionaAtividadeLista (String nome, String data, String descricao) {
        AtividadeModel atividade = new AtividadeModel();
        atividade.setNome(nome);
        atividade.setData(data);
        atividade.setDescricao(descricao);
        
        model.atividades.add(atividade);
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
        
        // Or like this...
//        System.out.println(model.atividades.get(0).getNome());
        for(int i = 0; i < model.atividades.size(); i++) {
            view.atualizaTela(model.atividades.get(i).getNome(), model.atividades.get(i).getData(), model.atividades.get(i).getDescricao());
        }
    }
    
    
}
