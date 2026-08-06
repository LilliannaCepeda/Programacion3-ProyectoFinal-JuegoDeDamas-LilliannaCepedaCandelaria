package controller;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.Navegacion;


public class InicioController {

     @FXML
    private Label titulo;
    
    public void initialize() {
        
        FadeTransition ft = new FadeTransition(Duration.millis(2000), titulo);
        ft.setFromValue(1.0);   // opacidad máxima
        ft.setToValue(0.7);     // opacidad mínima
        ft.setCycleCount(FadeTransition.INDEFINITE); // se repite infinito
        ft.setAutoReverse(true); // va y vuelve
        ft.play();
    }

    @FXML
    private void empezarPartida(ActionEvent event){

        try{
          Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
          Navegacion.cambiarScene(stageActual, "/view/seleccionColor.fxml");  
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void salir(ActionEvent event){
        Platform.exit();
    }
    
}
