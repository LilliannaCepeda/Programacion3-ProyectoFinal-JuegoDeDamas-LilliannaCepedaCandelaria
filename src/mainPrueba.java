import model.Tablero;
import model.Color;
import model.Ficha;
import model.Movimiento;

import java.util.ArrayList;
import java.util.List;

import logic.ReglasDamas;

public class mainPrueba {
    public static void main(String[] args) {

        Tablero tablero = new Tablero(Color.NEGRO);

        ReglasDamas reglas = new ReglasDamas(tablero);

        Ficha fichaNegra = new Ficha(Color.NEGRO, 2, 3);
        Ficha fichaBlancaEnemiga = new Ficha(Color.BLANCO, 3, 4);

        tablero.setFicha(2, 3, fichaNegra);
        tablero.setFicha(3, 4, fichaBlancaEnemiga);
        tablero.setFicha(4, 5, null);

        ArrayList<Movimiento> capturas = reglas.movimientoCaptura(fichaNegra);

        System.out.println("Cantidad de capturas encontradas: " + capturas.size());
        for (Movimiento m : capturas) {
        System.out.println("Captura: de (" + m.getFilaOrigen() + "," + m.getColOrigen() + ") " +
            "a (" + m.getFilaDestino() + "," + m.getColDestino() + "), " +
            "comiendo ficha en (" + m.getFilaCapt() + "," + m.getColCapt() + ")");
}

        Ficha fichaDePrueba = tablero.getFicha(2, 3);
        List<Movimiento> movimientos = reglas.movimientosSimple(fichaDePrueba);
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

        System.out.println("\n--- Prueba: capturaOMovimientoSimple CON captura obligatoria ---");

Tablero tableroA = new Tablero(Color.NEGRO);
ReglasDamas reglasA = new ReglasDamas(tableroA);

// Armamos una captura disponible para una ficha negra
Ficha fichaNegraA = new Ficha(Color.NEGRO, 2, 3);
Ficha fichaBlancaEnemigaA = new Ficha(Color.BLANCO, 3, 4);

tableroA.setFicha(2, 3, fichaNegraA);
tableroA.setFicha(3, 4, fichaBlancaEnemigaA);
tableroA.setFicha(4, 5, null);

// Probamos con ESA MISMA ficha, que sí tiene captura
ArrayList<Movimiento> resultadoA1 = reglasA.capturaOMovimientoSimple(fichaNegraA);
System.out.println("Ficha CON captura -> cantidad: " + resultadoA1.size());

// Probamos con OTRA ficha del mismo color, que no tiene captura (debería quedar bloqueada)
Ficha otraFichaNegra = tableroA.getFicha(0, 1);
if (otraFichaNegra != null) {
    ArrayList<Movimiento> resultadoA2 = reglasA.capturaOMovimientoSimple(otraFichaNegra);
    System.out.println("Otra ficha SIN captura propia -> cantidad: " + resultadoA2.size());
}

        
        
    }
}
