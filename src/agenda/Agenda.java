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
public class Agenda {
    public static void main(String[] args) {
        // Criar uma view
        AtividadeView view = new AtividadeView();

        // Model
        AtividadeModel model = new AtividadeModel();

        // Controller
        AtividadeController controller = new AtividadeController(model, view);
                       
        view.menu(controller, model);
                
        controller.atualizaTela();
    }
    
}
