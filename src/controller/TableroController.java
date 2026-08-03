package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class TableroController {

    @FXML
    private GridPane tablero;
    
    @FXML
    private Label colorJugadorArriba;

    @FXML
    private Label contadorJugadorArriba;

    @FXML
    private Label colorJugadorAbajo;

    @FXML
    private Label contadorJugadorAbajo;

    @FXML
    private MenuButton menuOpciones;
    
    @FXML
    private MenuItem itemNuevaPartida;

    @FXML
    private MenuItem itemSalir;

    @FXML
    public void Initialize(){
        
    }
}
