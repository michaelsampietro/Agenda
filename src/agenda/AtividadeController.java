/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author michaelsampietro
 */
public class AtividadeController {
    
    AtividadeModel model;
    AtividadeView view;
    AtividadeService service;
    
    public AtividadeController (AtividadeModel model, AtividadeView view, AtividadeService service) { 
        this.model = model;
        this.view = view;
        this.service = service;
    }
    
    public void adicionaAtividadeLista (List<String> informacoesAtividade) throws ParseException {   
        // Verifica se já existe uma atividade com mesmo nome e data
        if (service.verificaAtividade (informacoesAtividade.get(0), informacoesAtividade.get(1))) {
            AtividadeModel atividade = new AtividadeModel();
            atividade.setNome(informacoesAtividade.get(0));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataFormatada = formato.parse(informacoesAtividade.get(1));
            atividade.setData(dataFormatada);
            atividade.setDescricao(informacoesAtividade.get(2));

            model.atividades.add(atividade);
        } else {
            System.out.println("A atividade já existe!");
        }
    }
        
    public void editarAtividadeLista (List<String> informacoesAtividade) throws ParseException {
        AtividadeModel atividade = service.getAtividade(informacoesAtividade.get(0), informacoesAtividade.get(1));
        if (atividade != null) {
            List<String> aux = new ArrayList<String>();
            aux = view.recebeDados();

            atividade.setNome(aux.get(0));

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataFormatada = formato.parse(aux.get(1));
            atividade.setData(dataFormatada);

            atividade.setDescricao(aux.get(2));

            System.out.println("Atividade atualizada!");
            view.imprimeAtividade(atividade.getNome(), atividade.getData(), atividade.getDescricao());
        } else {
            System.out.println ("Atividade não existente, tente novamente.");
        }
    } 
    
    public void deletarAtividadeLista (List<String> informacoesAtividade) throws ParseException {
        AtividadeModel atividade = service.getAtividade(informacoesAtividade.get(0), informacoesAtividade.get(1));

        if (atividade != null) {
            model.atividades.remove(model.atividades.indexOf(atividade));
                
            System.out.println("Atividade removida!\nLista de atividades: ");
            this.atualizaTela();
        } else {
            System.out.println("Não existe nenhuma atividade com este nome e data. Tente novamente.");
        }
    }
        
    public void setNomeAtividade(String nome) {
        model.setNome(nome);
    }
    
    public void setDataAtividade (Date data) {
        model.setData(data);
    }
    
    public void setDescricaoAtividade (String descricao) {
        model.setDescricao(descricao);
    }
    
    public String getNomeAtividade () {
        return model.getNome();
    }
    
    public Date getDataAtividade () {
        return model.getData();
    }
    
    public String getDescricaoAtividade () {
        return model.getDescricao();
    }
    
    public void atualizaTela () {
        // Verifica se existem atividades a serem listadas
        if(service.verificaListaVazia()) {
            System.out.println("Não há atividades a serem listadas!");
        } else {
            view.atualizaTela(model.atividades);
        }
        
    }
}
