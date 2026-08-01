package model;

public class Tablero {

    private static final  int TAMANIO = 8;
    private  final Ficha[][] casillas;
    private Color colorArriba; 

    public Tablero(Color colorJugador1){

        casillas = new Ficha[TAMANIO][TAMANIO];
        this.colorArriba = colorJugador1;
        initializarTablero(colorJugador1);

    }

    public Ficha getFicha(int fila, int columna){
        return casillas[fila][columna];
    }

    public Color getColorArriba(){
        return colorArriba;
    }

    public void initializarTablero(Color colorJugador1){

        Color colorJugador2;

        if(colorJugador1 == Color.NEGRO){
            colorJugador2 = Color.BLANCO;
        }
        else{
           colorJugador2 = Color.NEGRO;
        }

        for(int fila = 0; fila <= 2; fila++){
            for(int columna = 0; columna <= 7; columna++){
                if((fila + columna) % 2 != 0){
                    casillas[fila][columna] = new Ficha(colorJugador1, fila, columna);
                }
            }
        }

        for(int fila = 5; fila <= 7; fila ++ ){
            for(int columna = 0; columna <= 7; columna++){

                if((fila + columna) % 2 != 0){
                    casillas[fila][columna] = new Ficha(colorJugador2, fila, columna);
                }
            }
        }

    }
    
}
