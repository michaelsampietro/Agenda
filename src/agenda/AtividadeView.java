/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import static java.lang.System.exit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author michaelsampietro
 */
public class AtividadeView {
    
    
    
    public void atualizaTela (List<AtividadeModel> atividades) {
        Iterator<AtividadeModel> atividadesIterator = atividades.iterator();
        while (atividadesIterator.hasNext()) {
            AtividadeModel atividade = atividadesIterator.next();
            System.out.println("Nome: " + atividade.getNome());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                
            System.out.println("Data: " + formato.format(atividade.getData()));
            System.out.println("Descrição: " + atividade.getDescricao() + "\n");
        }
        
    }
    
    public void menu (AtividadeController controller, AtividadeModel model) throws ParseException {
        Scanner keyboard = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1 - Criar nova atividade");
            System.out.println("2 - Editar atividade");
            System.out.println("3 - Deletar atividade");
            System.out.println("4 - Listar atividades");
            System.out.println("0 - Encerrar programa");
            opcao = keyboard.nextInt();

            switch(opcao) {
                case 1:
                    controller.adicionaAtividadeLista(criaAtividade());
                    break;
                case 2:
                    controller.editarAtividadeLista(editarAtividade());
                    break;
                case 3:
                    controller.deletarAtividadeLista(deletarAtividade());
                    break;
                case 4:
                    controller.atualizaTela();
                    break;
                case 0:
                    exit(1);
            }
            
        } while (opcao != 0);
    }
    
    public List<String> criaAtividade () {
        Scanner keyboard = new Scanner(System.in); 
        List<String> saida = new ArrayList<String>();
        
        System.out.println("Criar nova atividade");
        System.out.println("Nome da atividade:");
        String nome = keyboard.nextLine();
        saida.add(nome);
        
        System.out.println("Data da atividade:");
        String data = keyboard.nextLine();
        saida.add(data);
        
        System.out.println("Descrição da atividade:");
        String descricao = keyboard.nextLine();
        saida.add(descricao);
        
        return saida;
    }
      
    public String editarAtividade () {
        Scanner keyboard = new Scanner(System.in);        
        
        System.out.println("Qual o nome da atividade que deseja editar?");
        String nome = keyboard.nextLine();
        
        return nome;
    }
    
    public List<String> recebeDados () {
        Scanner keyboard = new Scanner(System.in); 
        List<String> saida = new ArrayList<String>();
        
        System.out.println("Nome: ");
        String nome = keyboard.nextLine();
        saida.add(nome);
        
        System.out.println("Data: ");
        String data = keyboard.nextLine();
        saida.add(data);
        
        System.out.println("Descrição: ");
        String descricao = keyboard.nextLine();
        saida.add(descricao);
        
        return saida;
    }
    
    public String deletarAtividade () {
        Scanner keyboard = new Scanner(System.in);        
        
        System.out.println("Qual o nome da atividade que deseja deletar?");
        String nome = keyboard.nextLine();
        
        return nome;
    }
    
    public void imprimeAtividade (String nome, Date data, String descricao) throws ParseException {
        System.out.println("Nome: " + nome);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                
        System.out.println("Data: " + formato.format(data));
        System.out.println("Descrição: " + descricao + "\n");
    }
}
