package logic;

import java.util.ArrayList;
import java.util.Random;

import model.Color;
import model.Ficha;
import model.Movimiento;
import model.Tablero;

public class ReglasDamas {

    private Tablero tablero;
    private Color turnoActual;

    public ReglasDamas(Tablero tablero){

        this.tablero = tablero;
        this.turnoActual = sortTurnoInicial();

    }

    public Color sortTurnoInicial(){

        Random random = new Random();
        int num = random.nextInt(2);

        if(num == 0){
            return Color.NEGRO;
        }else
            return Color.BLANCO;
    }

    public ArrayList<Movimiento> movimientosValidos(Ficha ficha){
        
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        int filaAdelante;
        int columnaIzquierda;
        int columnaDerecha;
        int filaAtras;
        
        if(!ficha.getEsDama()){

            if(ficha.getColor() == tablero.getColorArriba()){
                
                filaAdelante = ficha.getFila() + 1;
            }else{

                filaAdelante = ficha.getFila() - 1;
            }

            columnaIzquierda = ficha.getColumna() -1;
            columnaDerecha = ficha.getColumna() + 1;

            if(filaAdelante >= 0 && filaAdelante <= 7 && columnaIzquierda >= 0 && columnaIzquierda <= 7){
                if(tablero.getFicha(filaAdelante, columnaIzquierda) == null){
                    
                    Movimiento movimientoIzquierdaFicha = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAdelante, columnaIzquierda);
                    movimientos.add(movimientoIzquierdaFicha);
                }
            }

            if(filaAdelante >= 0 && filaAdelante <= 7 && columnaDerecha >=0 && columnaDerecha <= 7){
                if(tablero.getFicha(filaAdelante, columnaDerecha) == null){

                    Movimiento movimientoDerechaFicha = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAdelante, columnaDerecha);
                    movimientos.add(movimientoDerechaFicha);
                }
            }

        }else{
            
            if(ficha.getColor() == tablero.getColorArriba()){

                filaAdelante = ficha.getFila() + 1;
                filaAtras = ficha.getFila() - 1;
            }else{

                filaAdelante = ficha.getFila() -1;
                filaAtras = ficha.getFila() + 1;
            }

            columnaDerecha = ficha.getColumna() + 1;
            columnaIzquierda = ficha.getColumna() - 1;

            if(filaAdelante >= 0 && filaAdelante <= 7 && columnaIzquierda >= 0 && columnaIzquierda <= 7){
                if(tablero.getFicha(filaAdelante, columnaIzquierda) == null){

                    Movimiento movimientoDamaAdelanteIzquierdo = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAdelante, columnaIzquierda);
                    movimientos.add(movimientoDamaAdelanteIzquierdo);
                }
            }   
            if(filaAtras >= 0 && filaAtras <= 7 && columnaIzquierda >= 0 &&  columnaIzquierda <= 7 ){
                if(tablero.getFicha(filaAtras, columnaIzquierda) == null){

                    Movimiento movimientoDamaAtrasIzquierdo = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAtras, columnaIzquierda);
                    movimientos.add(movimientoDamaAtrasIzquierdo);
                }
            }
            if(filaAdelante >= 0 && filaAdelante <= 7 && columnaDerecha >=0 && columnaDerecha <= 7){
                if(tablero.getFicha(filaAdelante, columnaDerecha) == null){

                    Movimiento movimientoDamaAdelanteDerecho = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAdelante, columnaDerecha);
                    movimientos.add(movimientoDamaAdelanteDerecho);
                }
            }

            if(filaAtras >= 0 && filaAtras <= 7 && columnaDerecha >=0 && columnaDerecha <= 7){
                if(tablero.getFicha(filaAtras, columnaDerecha) == null){

                    Movimiento movimientoDamaAtrasDerecho = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAtras, columnaDerecha);
                    movimientos.add(movimientoDamaAtrasDerecho);
                }

            }
        }

        return movimientos;
    } 
}
