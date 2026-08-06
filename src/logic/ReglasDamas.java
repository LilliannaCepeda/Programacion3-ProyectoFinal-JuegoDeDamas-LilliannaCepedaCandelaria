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

    public Color getTurnoActual(){
        return turnoActual;
    }

    public Color sortTurnoInicial(){

        Random random = new Random();
        int num = random.nextInt(2);

        if(num == 0){
            return Color.NEGRO;
        }else
            return Color.BLANCO;
    }

    //REGLA 1: movimientos normales para ficha normal y dama

    public ArrayList<Movimiento> movimientosSimple(Ficha ficha){
        
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

    //REGLA 2: movimeinto de captura para ficha normal y dama

    public ArrayList<Movimiento> movimientoCaptura(Ficha ficha){

        ArrayList<Movimiento> movimientos = new ArrayList<>();

        int filaAdelante;
        int filaAtras;
        int columnaIzquierda;
        int columnaDerecha;
        int filaAterrizaje;
        int filaAterrizajeAdelante;
        int filaAterrizajeAtras;
        int columnaAterrizajeIzq;
        int columnaAterrizajeDer;

        if(!ficha.getEsDama()){
            if(ficha.getColor() == tablero.getColorArriba()){

                filaAdelante = ficha.getFila() + 1;

            }else{

                filaAdelante = ficha.getFila() - 1;
            }

            columnaIzquierda = ficha.getColumna() - 1;
            columnaDerecha = ficha.getColumna() + 1;

            if(ficha.getColor() == tablero.getColorArriba()){
                filaAterrizaje = filaAdelante + 1;

            }else{
                filaAterrizaje = filaAdelante -1;
            }

            columnaAterrizajeIzq = columnaIzquierda - 1;
            columnaAterrizajeDer = columnaDerecha + 1;

            if(filaAdelante >= 0 && filaAdelante <= 7 && columnaIzquierda >=0 && columnaIzquierda <=7){

                Ficha fichaEnemiga = tablero.getFicha(filaAdelante, columnaIzquierda);

                if(fichaEnemiga != null && fichaEnemiga.getColor() != ficha.getColor()){
                    if(filaAterrizaje >= 0 && filaAterrizaje <=7 && columnaAterrizajeIzq >= 0 && columnaAterrizajeIzq <= 7 ){
                        if(tablero.getFicha(filaAterrizaje, columnaAterrizajeIzq) == null){

                            Movimiento capturaIzquierdaFicha = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAterrizaje, columnaAterrizajeIzq, true,  filaAdelante, columnaIzquierda);
                            movimientos.add(capturaIzquierdaFicha);

                        }

                    }
                }
            }

            if(filaAdelante >= 0 && filaAdelante <= 7 && columnaDerecha >=0 && columnaDerecha <=7){

                Ficha fichaEnemiga = tablero.getFicha(filaAdelante, columnaDerecha);

                if(fichaEnemiga != null && fichaEnemiga.getColor() != ficha.getColor()){
                    if(filaAterrizaje >= 0 && filaAterrizaje <=7 && columnaAterrizajeDer >= 0 && columnaAterrizajeDer <= 7 ){
                        if(tablero.getFicha(filaAterrizaje, columnaAterrizajeDer) == null){

                            Movimiento capturaDerechaFicha = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAterrizaje, columnaAterrizajeDer, true,  filaAdelante, columnaDerecha);
                            movimientos.add(capturaDerechaFicha);

                        }

                    }
                }
            }
        }else{
              if(ficha.getColor() == tablero.getColorArriba()){

                filaAdelante = ficha.getFila() + 1;
                filaAtras = ficha.getFila()  - 1;

            }else{

                filaAdelante = ficha.getFila() - 1;
                filaAtras = ficha.getFila() + 1;
            }

            columnaIzquierda = ficha.getColumna() - 1;
            columnaDerecha = ficha.getColumna() + 1;

            if(ficha.getColor() == tablero.getColorArriba()){
                
                filaAterrizajeAdelante = filaAdelante + 1;
                filaAterrizajeAtras = filaAtras - 1;
            }else{
                
                filaAterrizajeAdelante = filaAdelante - 1;
                filaAterrizajeAtras = filaAtras + 1;
            }

            columnaAterrizajeIzq = columnaIzquierda - 1;
            columnaAterrizajeDer = columnaDerecha + 1;

            if(filaAdelante >= 0 && filaAdelante <= 7 && columnaIzquierda >=0 && columnaIzquierda <=7){

                Ficha fichaEnemiga = tablero.getFicha(filaAdelante, columnaIzquierda);

                if(fichaEnemiga != null && fichaEnemiga.getColor() != ficha.getColor()){
                    if(filaAterrizajeAdelante >= 0 && filaAterrizajeAdelante <=7 && columnaAterrizajeIzq >= 0 && columnaAterrizajeIzq <= 7 ){
                        if(tablero.getFicha(filaAterrizajeAdelante, columnaAterrizajeIzq) == null){

                            Movimiento capturaIzqAdelanteFicha = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAterrizajeAdelante, columnaAterrizajeIzq, true,  filaAdelante, columnaIzquierda);
                            movimientos.add(capturaIzqAdelanteFicha);

                        }

                    }
                }
            }

            if(filaAtras >= 0 && filaAtras <= 7 && columnaIzquierda >= 0 && columnaIzquierda <= 7){

                Ficha fichaEnemiga = tablero.getFicha(filaAtras, columnaIzquierda);

                if(fichaEnemiga != null && fichaEnemiga.getColor() != ficha.getColor()){
                    if(filaAterrizajeAtras >= 0 && filaAterrizajeAtras <= 7 && columnaAterrizajeIzq >= 0 && columnaAterrizajeIzq <= 7){
                        if(tablero.getFicha(filaAterrizajeAtras, columnaAterrizajeIzq) == null){

                            Movimiento capturaIzqAtrasFicha = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAterrizajeAtras, columnaAterrizajeIzq, true,  filaAtras, columnaIzquierda);
                            movimientos.add(capturaIzqAtrasFicha);
                        }
                    }

                }
            }

             if(filaAdelante >= 0 && filaAdelante <= 7 && columnaDerecha >=0 && columnaDerecha <=7){

                Ficha fichaEnemiga = tablero.getFicha(filaAdelante, columnaDerecha);

                if(fichaEnemiga != null && fichaEnemiga.getColor() != ficha.getColor()){
                    if(filaAterrizajeAdelante >= 0 && filaAterrizajeAdelante <=7 && columnaAterrizajeDer >= 0 && columnaAterrizajeDer <= 7 ){
                        if(tablero.getFicha(filaAterrizajeAdelante, columnaAterrizajeDer) == null){

                            Movimiento capturaDerAdelanteDama = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAterrizajeAdelante, columnaAterrizajeDer, true,  filaAdelante, columnaDerecha);
                            movimientos.add(capturaDerAdelanteDama);

                        }

                    }
                }
            }

            if(filaAtras >= 0 && filaAtras <= 7 && columnaDerecha >= 0 && columnaDerecha <= 7){

                Ficha fichaEnemiga = tablero.getFicha(filaAtras, columnaDerecha);

                if(fichaEnemiga != null && fichaEnemiga.getColor() != ficha.getColor()){
                    if(filaAterrizajeAtras >= 0 && filaAterrizajeAtras <= 7 && columnaAterrizajeDer >= 0 && columnaAterrizajeDer <= 7){
                        if(tablero.getFicha(filaAterrizajeAtras, columnaAterrizajeDer) == null){

                            Movimiento capturaDerAtrasDama = new Movimiento(ficha.getFila(), ficha.getColumna(), filaAterrizajeAtras, columnaAterrizajeDer, true,  filaAtras, columnaDerecha);
                            movimientos.add(capturaDerAtrasDama);
                        }
                    }

                }
            }

        }

        return movimientos;
    }

    //regla 3: si Captura obligatoria

    public boolean escapturaObligatoria(){

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                
                Ficha fichaEnCasilla = tablero.getFicha(i, j);

                if(fichaEnCasilla != null &&fichaEnCasilla.getColor() == turnoActual){

                    ArrayList<Movimiento> capturaDisp = movimientoCaptura(fichaEnCasilla); 
                    if(capturaDisp.size() > 0){

                        return true;

                    }
                }
            }

        }

        return false;
    }

    //regla 4: movimiento simple o captura obligatoria 

    public ArrayList<Movimiento> capturaOMovimientoSimple(Ficha ficha){

        ArrayList<Movimiento> movimientos = new ArrayList<>();
        
        if(escapturaObligatoria()){
            if(movimientoCaptura(ficha).size() > 0){
                
                movimientos = movimientoCaptura(ficha);
                return movimientos;
            }
            else{
                return movimientos;
            }
        }else{

            movimientos = movimientosSimple(ficha);
            return movimientos;
        }
    }

    //regla 5: Ejectuar Movimiento

    public void ejecutarMovimiento(Ficha ficha, Movimiento movimientoFicha){

        int filaOrigen = movimientoFicha.getFilaOrigen();
        int colOrigen = movimientoFicha.getColOrigen();
        int filaDest = movimientoFicha.getFilaDestino();
        int colDest = movimientoFicha.getColDestino();

        //mover una ficha del tablero a otra posicion
        tablero.setFicha(filaOrigen, colOrigen, null);
        tablero.setFicha(filaDest, colDest, ficha);

        //reasignar valores de coordenadas a la ficha
        ficha.setFila(filaDest);
        ficha.setColumna(colDest);

        if(movimientoFicha.getEsCaptura()){

            int filaCaptura = movimientoFicha.getFilaCapt();
            int colCaptura = movimientoFicha.getColCapt();
            tablero.setFicha(filaCaptura,colCaptura, null);
        }

        //promover a Dama
        if(ficha.getColor() == tablero.getColorArriba()){
            if(filaDest == 7){
                ficha.promoverADama();
            }
        }else{
            if(filaDest == 0){
                ficha.promoverADama();
            }
        }

    }

    //Regla 6: cambio de turno

    public void cambioDeTurno(){

      if(turnoActual == Color.NEGRO){
        turnoActual = Color.BLANCO;
      }else{
        turnoActual = Color.NEGRO;
      }
    }

    //Regla 7: Fin de partida

    public Color finPartida(){

        int cantBlancas = 0;
        int cantNegras = 0;
        boolean blancasConMovimiento = false;
        boolean negrasConMovimeinto = false;
        Color coloGanador;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                
                Ficha ficha = tablero.getFicha(i, j);

                if(ficha != null){
                    if(ficha.getColor() == Color.BLANCO){
                        cantBlancas = cantBlancas + 1;

                        if(movimientosSimple(ficha).size() > 0 || movimientoCaptura(ficha).size() > 0){

                            blancasConMovimiento = true;
                        }

                    }else{
                        cantNegras = cantNegras + 1;

                        if(movimientosSimple(ficha).size() > 0 || movimientoCaptura(ficha).size()> 0){

                            negrasConMovimeinto = true;
                        }
                    }
                }   
            }
        }

        if(cantBlancas == 0 || !blancasConMovimiento){
            coloGanador = Color.NEGRO;
            return coloGanador;
        }

        if(cantNegras == 0 || !negrasConMovimeinto){
            coloGanador = Color.BLANCO;
            return coloGanador;
        }

        return null;
    }   
}
