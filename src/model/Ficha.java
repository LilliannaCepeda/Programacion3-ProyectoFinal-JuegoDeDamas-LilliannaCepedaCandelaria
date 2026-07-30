package model;

public class Ficha {

    private Color color;
    private boolean esDama;
    private int fila;
    private int columna;
    
    public Ficha(Color color, int fila, int columna){
        this.color = color;
        this.fila = fila;
        this.columna = columna;

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

    
}
