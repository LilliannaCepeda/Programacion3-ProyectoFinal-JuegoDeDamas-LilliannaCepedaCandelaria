import model.Tablero;
import model.Color;
import model.Ficha;
import model.Movimiento;

import java.util.List;

import logic.ReglasDamas;

public class mainPrueba {
    public static void main(String[] args) {

        Tablero tablero = new Tablero(Color.NEGRO);
        ReglasDamas reglas = new ReglasDamas(tablero);

        Ficha fichaDePrueba = tablero.getFicha(2, 3);
        List<Movimiento> movimientos = reglas.movimientosValidos(fichaDePrueba);
        System.out.println("Cantidad de movimientos: " + movimientos.size());

        for(int fila = 0; fila <= 7; fila++){
            for(int columna = 0; columna <= 7; columna++){
                Ficha ficha = tablero.getFicha(fila, columna);

                if(ficha == null){
                    System.out.print(".");
                }else if(ficha.getColor() == Color.NEGRO){
                    System.out.print("N");
                }else if(ficha.getColor() == Color.BLANCO){
                    System.out.print("B");
                }
            }

            System.out.println();
        }
        
    }
}
