package controller;

import java.io.IOError;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Color;
import utils.Navegacion;

public class GanadorController {
    
    @FXML
    private Label lblGanador;

    @FXML
    private ImageView imagenGanador;

    public void mostrarGanador(Color colorGanador){
        lblGanador.setText("Ganador: " + colorGanador);

        if(colorGanador == Color.NEGRO){
            imagenGanador.setImage(new Image("/Imagenes/fichas/FichaNegra.png"));
        }else{
            imagenGanador.setImage(new Image("/Imagenes/fichas/FichaBlanca.png"));
        }
    }

    @FXML
    private void nuevaPartida(ActionEvent event){
        try{
             Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
             Navegacion.irANuevaPartida(stageActual);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void regresar(ActionEvent event){

        try{

            Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Navegacion.irAInicio(stageActual);

        }catch (IOException e){
            e.printStackTrace();
        }
         

    }
    
}
