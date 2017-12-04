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
public class AtividadeService {
    
    AtividadeModel model;
    
    public AtividadeService (AtividadeModel model) {
        this.model = model;
    }
    
    // Verifica se uma atividade com mesmo nome e data já existe.
    boolean verificaAtividade(String nome, String data) throws ParseException {
        Iterator<AtividadeModel> atividadesIterator = model.atividades.iterator();
        
        // transformando a string data no tipo Date
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = formato.parse(data);
        
        while (atividadesIterator.hasNext()) {
            AtividadeModel atividade = atividadesIterator.next();
            if (atividade.getNome().equals(nome) && atividade.getData().equals(dataFormatada)) {
                return false; // Pode inserir
            }
        }
        return true; // Já existe uma atividade com esse nome e data.
    }

    boolean verificaListaVazia() {
        return model.atividades.isEmpty();
    }

    AtividadeModel getAtividade(String nome, String data) throws ParseException {
        Iterator<AtividadeModel> atividadesIterator = model.atividades.iterator();
        AtividadeModel atividade = null;
        
        // transformando a string data no tipo Date
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = formato.parse(data);
        
        while (atividadesIterator.hasNext()) {
            atividade = atividadesIterator.next();
            if (atividade.getNome().equals(nome) && atividade.getData().equals(dataFormatada)) {
                break;
            } else {
                atividade = null;
            }
        }
        return atividade;
    }
    
}
