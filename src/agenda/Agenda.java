/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.text.ParseException;

/**
 *
 * @author michaelsampietro
 */
public class Agenda {
    public static void main(String[] args) throws ParseException {
        // Criar uma view
        AtividadeView view = new AtividadeView();

        // Model
        AtividadeModel model = new AtividadeModel();
        
        // Service
        AtividadeService service = new AtividadeService(model);

        // Controller
        AtividadeController controller = new AtividadeController(model, view, service);
                       
        view.menu(controller, model);
                
        controller.atualizaTela();
    }
}
