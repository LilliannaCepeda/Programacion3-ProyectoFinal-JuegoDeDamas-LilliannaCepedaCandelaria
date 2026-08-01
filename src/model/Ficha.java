package model;

public class Ficha {

    private final Color color;
    private boolean esDama;
    private int fila;
    private int columna;
    
    public Ficha(Color color, int fila, int columna){
        this.color = color;
        this.fila = fila;
        this.columna = columna;
        this.esDama = false;
    }

    public Color getColor(){
        return color;
    }

    public boolean getEsDama(){
        return esDama;
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    public void setEsDama(boolean esDama){
        this.esDama = esDama;
    }

    public void setFila(int fila){
        this.fila = fila;
    }

    public void setColumna(int columna){
        this.columna = columna;
    }

    public void promoverADama() {
    this.esDama = true;
}
    
}
