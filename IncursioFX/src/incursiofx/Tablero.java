/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incursiofx;

import fxml.BoardController;

/**
 *
 * @author Francisco
 */
public class Tablero {

    private final Casilla[][] aCasillas = new Casilla[9][5];
    private final Jugador[] jJugadores = new Jugador[2];
    private Boolean bTurno;
    private Movimiento mMovimiento;
    private final BoardController bcBoard;

    public Casilla[][] getaCasillas() {
        return aCasillas;
    }

    public Jugador[] getjJugadores() {
        return jJugadores;
    }

    public Boolean isbTurno() {
        return bTurno;
    }

    public Movimiento getmMovimiento() {
        return mMovimiento;
    }

    public void setmMovimiento(Movimiento mMovimiento) {
        this.mMovimiento = mMovimiento;
    }

    public BoardController getBC() {
        return bcBoard;
    }

    public Tablero(BoardController bc) {
        bcBoard = bc;
        this.bTurno = true;
        Casilla c;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 5; y++) {
                c = new Casilla(x, y, this);
                aCasillas[x][y] = c;
            }
        }
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 5; y++) {
                if (aCasillas[x][y].isBotTP() || aCasillas[x][y].isTopTP()) {
                    int a, b;
                    if (y == 0) {
                        b = 4;
                    } else {
                        b = 0;
                    }
                    if (x == 2) {
                        a = 6;
                    } else {
                        if (x == 6) {
                            a = 2;
                        } else {
                            a = x;
                        }
                    }
                    aCasillas[x][y].setcDestino(getCasilla(a, b));
                }
            }
        }

        Jugador j;
        j = new Jugador(true, this);
        this.jJugadores[0] = j;
        j = new Jugador(false, this);
        this.jJugadores[1] = j;
        mMovimiento = new Movimiento(this);
    }

    public final Casilla getCasilla(int x, int y) {
        return aCasillas[x][y];
    }

    public void FinalizarPartida() {
        int iPuntosP1 = 0, iPuntosP2 = 0;
        boolean bMuertasP1 = true, bMuertasP2 = true;
        for (Ficha f : jJugadores[0].getfFichas()) {
            if (f.enMeta()) {
                iPuntosP1++;
            }
            if (f.geteEstado() != Ficha.Estado.MUERTA) {
                bMuertasP1 = false;
            }
        }
        if (bMuertasP1) {
            iPuntosP1 += 5;
        }
        for (Ficha f : jJugadores[1].getfFichas()) {
            if (f.enMeta()) {
                iPuntosP2++;
            }
            if (f.geteEstado() != Ficha.Estado.MUERTA) {
                bMuertasP2 = false;
            }
        }
        if (bMuertasP2) {
            iPuntosP2 += 5;
        }
        jJugadores[0].setiPuntos(iPuntosP1);
        jJugadores[1].setiPuntos(iPuntosP2);
        if (iPuntosP1 > iPuntosP2) {
            bTurno = jJugadores[0].isbTurno();
        } else {
            if (iPuntosP1 < iPuntosP2) {
                bTurno = jJugadores[1].isbTurno();
            } else {
                bTurno = !bTurno;
            }
        }
        for(Jugador j: jJugadores){
            j.CargarFichas(bTurno, this);            
        }
        bcBoard.ReLoadBoard();
        mMovimiento = new Movimiento(this);
    }

    public void CambiarTurno() {
        this.bTurno = !bTurno;
        mMovimiento = new Movimiento(this);
    }

}
