package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Color;
import utils.Navegacion;
import javafx.scene.Node;

public class SeleccionColorController {

    @FXML
    private void seleccionarBlanco(MouseEvent event){
        try{
            Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            TableroController controller = Navegacion.cambiarScene(stageActual, "/view/tablero.fxml");
            controller.inicializarTableroVisual(Color.BLANCO);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void seleccionarNegro(MouseEvent event){
        try{
            Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            TableroController controller = Navegacion.cambiarScene(stageActual, "/view/tablero.fxml");
            controller.inicializarTableroVisual(Color.NEGRO);
        }catch (IOException e){
            e.printStackTrace();
        }
    }  
}
