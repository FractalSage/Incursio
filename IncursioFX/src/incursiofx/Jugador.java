/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incursiofx;

/**
 *
 * @author Francisco
 */
public class Jugador {

    private final Tablero tTablero;
    private int iPuntos;
    private final Ficha[] fFichas = new Ficha[5];
    private final Boolean bTurno;

    public int getiPuntos() {
        return iPuntos;
    }

    public void setiPuntos(int iPuntos) {
        this.iPuntos = iPuntos;
    }

    public Ficha[] getfFichas() {
        return fFichas;
    }    

    public Boolean isbTurno() {
        return bTurno;
    }  
    
    public final void CargarFichas(Boolean b, Tablero t){
        Ficha f;
        for (int i = 0; i < 5; i++) {
            f = new Ficha(i, b, this, t);
            this.fFichas[i] = f;
        }
    }

    public Jugador(Boolean b, Tablero t) {
        this.bTurno = b;
        this.tTablero = t;        
        CargarFichas(b, t);
        this.iPuntos = 0;
    }
}
