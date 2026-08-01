package model;

public class Movimiento {
    
    private int filaOrigen;
    private int colOrigen;
    private int filaDestino;
    private int colDestino;
    private boolean esCaptura;
    private int filaCaptura;
    private int colCaptura;

    public Movimiento(int filaOr, int colOg, int filaDest, int colDest){

        setFilaOrigen(filaOr);
        setColOrigen(colOg);
        setFilaDestino(filaDest);
        setColDestino(colDest);
        
    }

     public Movimiento(int filaOr, int colOg, int filaDest, int colDest, boolean esCapt, int filaCapt, int colCapt){

        setFilaOrigen(filaOr);
        setColOrigen(colOg);
        setFilaDestino(filaDest);
        setColDestino(colDest);
        setEsCaptura(esCapt);
        setFilaCaptura(filaCapt);
        setColCaptura(colCapt);
        
    }

    public int getFilaOrigen(){
        return filaOrigen;
    }

    public int getColOrigen(){
        return colOrigen;
    }

    public int getFilaDestino(){
        return filaDestino;
    }

    public int getColDestino(){
        return colDestino;
    }

    public boolean getEsCaptura(){
        return esCaptura;
    }

    public int getFilaCapt(){
        return filaCaptura;
    }

    public int getColCapt(){
        return colCaptura;
    }

    public void setFilaOrigen(int filaOrig){
        this.filaOrigen = filaOrig;
    }

    public void setColOrigen(int colOrig){
        this.colOrigen = colOrig;
    }

    public void setFilaDestino(int filaDest){
        this.filaDestino = filaDest;
    }

    public void setColDestino(int colDest){
        this.colDestino = colDest;
    }

    public void setEsCaptura(boolean esCapt){
        this.esCaptura = esCapt; 
    }

    public void setFilaCaptura(int filaCapt){
        this.filaCaptura = filaCapt;
    }

    public void setColCaptura(int colCapt){
        this.colCaptura = colCapt;
    }
    
}
