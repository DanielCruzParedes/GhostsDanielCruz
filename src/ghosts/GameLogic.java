package ghosts;

import java.util.Random;
import javax.swing.JButton;

public interface GameLogic{
    
    abstract void ponerFantasmasAlAzar();
    abstract void ponerFantasmasBuenosAbajo(int fila, int columna);
    abstract void ponerFantasmasBuenosArriba(int fila, int columna);
    abstract void ponerFantasmasMalosArriba(int fila, int columna);
    abstract void ponerFantasmasMalosAbajo(int fila, int columna);
    boolean revisarSiEstaVacio(int posicionX, int posicionY);
    void colorearSalidas();
    void hacerMovimientosYTurnos(JButton botonClickeado);
    default boolean esMovimientoValido(int posicionInicialx, int posicionInicialy, int posicionFinalx, int posicionFinaly, String fichaSeleccionada) {
    // Movimiento
    int deltaX = Math.abs(posicionFinalx - posicionInicialx);
    int deltaY = Math.abs(posicionFinaly - posicionInicialy);

    //Operador ternario
    return ((deltaX == 1 && deltaY == 0) || (deltaX == 0 && deltaY == 1)) ? true : false;
}

    void ponerImagenes();
    boolean revisarGane1(int fila, int columna);
    boolean revisarGane2(int fila, int columna);
    abstract void ponerFantasmasManual();
      
    
}
