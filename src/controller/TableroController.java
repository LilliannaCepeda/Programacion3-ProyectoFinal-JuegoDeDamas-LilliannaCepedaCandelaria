package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import logic.ReglasDamas;
import model.Color;
import model.Ficha;
import model.Movimiento;
import model.Tablero;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;

public class TableroController {

    @FXML
    private GridPane tableroGrid;
    
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

    private Tablero tablero;
    private ReglasDamas reglas;
    private Color colorJugador;
    private StackPane[][] casillasVisuales = new StackPane[8][8];
    private Ficha fichaSeleccionada;
    private ArrayList<Movimiento> movimientoDisponible; 

    @FXML
    public void initialize(){

         System.out.println("TableroController cargado");
    }

    public void inicializarTableroVisual(Color colorElegido){

        tablero = new Tablero(colorElegido);
        reglas = new ReglasDamas(tablero);

        dibujarTablero();
        cargarFichas(); 
    }

    private void dibujarTablero(){

        for(int col = 0; col < 8; col++){
            ColumnConstraints columna = new ColumnConstraints(80);
            tableroGrid.getColumnConstraints().add(columna);

            RowConstraints row = new RowConstraints(80);
            tableroGrid.getRowConstraints().add(row);
        }

        for(int i=0; i < 8; i++){
            for (int j = 0; j < 8; j++){

                StackPane casilla = new StackPane();
                casilla.setPrefSize(80, 80);

                int fila = i;
                int columna = j;
                casilla.setOnMouseClicked(event ->{
                    manejarClickCelda(fila, columna);

                });

                if((i + j) % 2 == 0){
                    casilla.setStyle("-fx-background-color: #e5dccc");
                }else{
                    casilla.setStyle("-fx-background-color: #140a07 ");
                }

                tableroGrid.add(casilla, j, i);
                casillasVisuales[i][j] = casilla;
            }
        }
    }

    private void cargarFichas(){

        for(int i =0; i <=7; i++){
            for(int j=0; j<= 7; j++){

                Ficha ficha = tablero.getFicha(i, j);

                if(ficha != null){

                     ImageView imagen;

                    if(ficha.getColor() == Color.NEGRO){

                        imagen = new ImageView(new Image("/Imagenes/fichas/FichaNegra.png"));
                    }else{

                        imagen = new ImageView(new Image("/Imagenes/fichas/FichaBlanca.png"));
                    }

                    imagen.setFitWidth(80);
                    imagen.setFitHeight(80);

                    casillasVisuales[i][j].getChildren().add(imagen);
                }
            }
        }
    }

    private void seleccionarFicha(Ficha ficha){
        fichaSeleccionada = ficha;
        movimientoDisponible = reglas.capturaOMovimientoSimple(ficha);

        System.out.println("Cantidad de movimientos disponibles: " + movimientoDisponible.size());        
 
        for(Movimiento m: movimientoDisponible){
            int filaDestino = m.getFilaDestino();
            int colDestino = m.getColDestino();
            System.out.println("Resaltando: " + filaDestino + ", " + colDestino);
            casillasVisuales[filaDestino][colDestino].setStyle("-fx-background-color: linear-gradient(to bottom right, yellow, orange);");
        }
    }

    private void manejarClickCelda(int fila, int col){
         System.out.println("Click detectado en: " + fila + ", " + col);
       Ficha ficha = tablero.getFicha(fila, col);
       System.out.println("Ficha en esa posición: " + ficha);
       if(ficha != null){
        System.out.println("Color de la ficha: " + ficha.getColor());
        System.out.println("Turno actual: " + reglas.getTurnoActual());
    }

    System.out.println("fichaSeleccionada actual: " + fichaSeleccionada);

       if(ficha != null && ficha.getColor()== reglas.getTurnoActual() && fichaSeleccionada == null){
         System.out.println("Entrando a seleccionarFicha");
        seleccionarFicha(ficha);
       }else if(ficha != null && ficha.getColor() == reglas.getTurnoActual() && fichaSeleccionada != null){
        System.out.println("Entrando a cambiar seleccion");
        limpiarResaltado();
        seleccionarFicha(ficha);

       }else if(fichaSeleccionada != null){
        System.out.println("Entrando a intentoMovimiento");
        intentoMovimiento(fila, col);
       }else {
        System.out.println("No entro a ningun caso");
    }
    }

    
    private void intentoMovimiento(int fila, int col){

        Movimiento movimientoSeleccionado = null;

        for(Movimiento m: movimientoDisponible){
            if(m.getFilaDestino() == fila && m.getColDestino() == col){
                movimientoSeleccionado = m;
            }
        }

        limpiarResaltado();

        if(movimientoSeleccionado != null){
            reglas.ejecutarMovimiento(fichaSeleccionada, movimientoSeleccionado);
            actualizarTablero();

            if(movimientoSeleccionado.getEsCaptura() && reglas.movimientoCaptura(fichaSeleccionada).size() > 0){
                seleccionarFicha(fichaSeleccionada);
            }else{
                reglas.cambioDeTurno();
                fichaSeleccionada = null;
                movimientoDisponible= null;
            }
        }
    }

    private void actualizarTablero(){
            
            for(int i = 0; i < 8; i++){
                for (int j =0; j < 8; j++){
                    casillasVisuales[i][j].getChildren().clear();
                }
            }

            cargarFichas();
        }


    private void limpiarResaltado(){

        for(Movimiento m: movimientoDisponible){
            int fila = m.getFilaDestino();
            int col = m.getColDestino();

            if((fila + col) % 2 == 0){
                casillasVisuales[fila][col].setStyle("-fx-background-color: #e5dccc");
            }else{
                 casillasVisuales[fila][col].setStyle("-fx-background-color: #140a07 ");
            }
        }
    }

    @FXML
    private void nuevaPartida(ActionEvent event){

    } 

}
