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
public class Casilla {

    protected final Tablero tTablero;
    protected final int[] iPosicion = new int[2];
    protected final Boolean bPisable;
    protected Boolean bResaltada;
    protected Ficha fOcupante;
    private Casilla cDestino;

    public Casilla getcDestino() {
        return cDestino;
    }    

    public void setcDestino(Casilla cDestino) {
        this.cDestino = cDestino;
    }

    public int[] getiPosicion() {
        return iPosicion;
    }

    public Boolean isbPisable() {
        return bPisable;
    }

    public Ficha getfOcupante() {
        return fOcupante;
    }

    public void setfOcupante(Ficha fOcupante) {
        this.fOcupante = fOcupante;
    }

    public Boolean isbResaltada() {
        return bResaltada;
    }

    public void setbResaltada(Boolean b) {
        this.bResaltada = b;
        Integer i = iPosicion[0] * 10 + iPosicion[1];
        tTablero.getBC().ChangeSprite(i, bResaltada, bPisable);
    }

    public final boolean isTopTP() {
        return ((iPosicion[0] == 2 || iPosicion[0] == 4 || iPosicion[0] == 6) && iPosicion[1] == 0);
    }

    public final boolean isBotTP() {
        return ((iPosicion[0] == 2 || iPosicion[0] == 4 || iPosicion[0] == 6) && iPosicion[1] == 4);
    }

    public Casilla(int x, int y, Tablero t) {
        this.tTablero = t;
        if (x == 4 && y == 2) {
            this.bPisable = false;
        } else {
            if ((x & 1) == 0) {
                this.bPisable = ((y & 1) == 0);
            } else {
                this.bPisable = ((y & 1) != 0);
            }
        }
        this.bResaltada = false;
        this.fOcupante = null;
        this.iPosicion[0] = x;
        this.iPosicion[1] = y;
        Integer i = iPosicion[0] * 10 + iPosicion[1];
        tTablero.getBC().ChangeSprite(i, bResaltada, bPisable);
        cDestino=null;
    }

    @Override
    public String toString() {
        String s = "x = " + iPosicion[0] + " y = " + iPosicion[1];
        if (bPisable) {
            s += " Pisable";
        } else {
            s += " No Pisable";
        }
        if (isTopTP() || isBotTP()) {
            s += " Es Casilla TP";
        }
        return s;
    }
}
