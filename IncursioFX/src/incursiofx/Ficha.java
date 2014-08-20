/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incursiofx;

import java.util.Objects;

/**
 *
 * @author Francisco
 */
public class Ficha {

    public enum Estado {

        NORMAL, NORMAL_RESALTADA, NORMAL_OBLIGADA, COMIO, COMIO_RESALTADA, COMIO_OBLIGADA, SALTANDO, MUERTA;

    }
    private final Jugador jJugador;
    private final Tablero tTablero;
    private Estado eEstado;
    private int[] iPosicion = new int[2];
    private final int iNumero;
    private Casilla cSuperior;
    private Casilla cInferior;
    private Ficha fSuperior;
    private Ficha fInferior;

    public Jugador getjJugador() {
        return jJugador;
    }

    public Estado geteEstado() {
        return eEstado;
    }

    public void seteEstado(Estado e) {
        this.eEstado = e;
        String s = null;
        switch (eEstado) {
            case NORMAL: {
                s = "_Normal";
                break;
            }
            case NORMAL_RESALTADA: {
                s = "_Normal_Resaltada";
                break;
            }
            case NORMAL_OBLIGADA: {
                s = "_Normal_Obligada";
                break;
            }
            case COMIO: {
                s = "_Ya_Comio";
                break;
            }
            case COMIO_RESALTADA: {
                s = "_Ya_Comio_Resaltada";
                break;
            }
            case COMIO_OBLIGADA: {
                s = "_Ya_Comio_Obligada";
                break;
            }
            case SALTANDO:
            case MUERTA: {
                s = "";
                break;
            }
        }
        tTablero.getBC().ChangeSprite(iNumero, s);
    }

    public int[] getiPosicion() {
        return iPosicion;
    }

    public void setiPosicion(int[] iPosicion) {
        this.iPosicion = iPosicion;
    }

    public int getiNumero() {
        return iNumero;
    }

    public boolean enMeta() {
        int r = 4;
        if (jJugador.isbTurno()) {
            r += 4;
        } else {
            r -= 4;
        }
        return iPosicion[0] == r;
    }    

    public Ficha(int i, Boolean b, Jugador j, Tablero t) {
        this.tTablero = t;
        int r;
        if (b) {
            r = -1;
        } else {
            r = 1;
        }
        this.jJugador = j;
        this.iPosicion[1] = i;
        if ((i & 1) == 0) {
            this.iPosicion[0] = r * 4 + 4;
        } else {
            this.iPosicion[0] = r * 3 + 4;
        }
        this.eEstado = Estado.NORMAL;
        String s = "_Normal";
        if (!jJugador.isbTurno()) {
            i += 5;
        }
        this.iNumero = i;
        tTablero.getCasilla(iPosicion[0], iPosicion[1]).setfOcupante(this);
        tTablero.getBC().ChangeSprite(i, s);

    }    

    @Override
    public String toString() {
        String s = iNumero + " " + jJugador.isbTurno() + " x = " + iPosicion[0] + " y = " + iPosicion[1] + " " + eEstado.toString();
        return s;
    }
}
