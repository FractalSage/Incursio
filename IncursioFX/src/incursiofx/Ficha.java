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

    public boolean PuedeMoverse() {
        if (this.enMeta()) {
            return false;
        } else {
            int r;
            if (jJugador.isbTurno()) {
                r = 1;
            } else {
                r = -1;
            }
            Casilla c = tTablero.getCasilla(iPosicion[0], iPosicion[1]);
            if (c.isBotTP() || c.isTopTP()) {
                CasoTP(c, r);
            } else {
                CasoComun(c, r);
            }
            boolean b = false;
            if (cSuperior != null || cInferior != null) {
                b = true;
            }
            return b;
        }
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

    private void CasoComun(Casilla c, int r) {
        int x = c.getiPosicion()[0] + r;
        int y = c.getiPosicion()[1] - 1;
        if (x < 9 && x > -1 && y > -1 && y < 5) {
            cSuperior = tTablero.getCasilla(x, y);
            if (cSuperior.isbPisable()) {
                fSuperior = cSuperior.getfOcupante();
                if (fSuperior != null) {
                    if (cSuperior.isTopTP()) {
                        this.cSuperior = cSuperior.getcDestino();
                        if (cSuperior.getfOcupante() != null) {
                            cSuperior = null;
                            fSuperior = null;
                        }
                    } else {
                        x = cSuperior.getiPosicion()[0] + r;
                        y = cSuperior.getiPosicion()[1] - 1;
                        if (x >= 0 && x < 9 && y >= 0 && y < 5) {
                            cSuperior = tTablero.getCasilla(x, y);
                            if (cSuperior.getfOcupante() != null || !cSuperior.isbPisable()) {
                                cSuperior = null;
                                fSuperior = null;
                            }
                        } else {
                            cSuperior = null;
                            fSuperior = null;
                        }
                    }
                }
            } else {
                cSuperior = null;
                fSuperior = null;
            }
        } else {
            cSuperior = null;
            fSuperior = null;
        }
        x = c.getiPosicion()[0] + r;
        y = c.getiPosicion()[1] + 1;
        if (x < 9 && x > -1 && y > -1 && y < 5) {
            cInferior = tTablero.getCasilla(x, y);
            if (cInferior.isbPisable()) {
                this.fInferior = cInferior.getfOcupante();
                if (fInferior != null) {
                    if (cInferior.isBotTP()) {
                        cInferior = cInferior.getcDestino();
                        if (cInferior.getfOcupante() != null) {
                            cInferior = null;
                            fInferior = null;
                        }
                    } else {
                        x = cInferior.getiPosicion()[0] + r;
                        y = cInferior.getiPosicion()[1] + 1;
                        if (x >= 0 && x < 9 && y >= 0 && y < 5) {
                            cInferior = tTablero.getCasilla(x, y);
                            if (cInferior.getfOcupante() != null || !cInferior.isbPisable()) {
                                cInferior = null;
                                fInferior = null;
                            }
                        } else {
                            cInferior = null;
                            fInferior = null;
                        }
                    }
                }
            } else {
                cInferior = null;
                fInferior = null;
            }
        } else {
            cInferior = null;
            fInferior = null;
        }
    }

    private void CasoTP(Casilla d, int r) {
        if (d.isTopTP()) {
            cSuperior = d.getcDestino();
            fSuperior = cSuperior.getfOcupante();
            if (fSuperior != null) {
                int x = cSuperior.getiPosicion()[0] + r;
                int y = cSuperior.getiPosicion()[1] - 1;
                cSuperior = tTablero.getCasilla(x, y);
                if (cSuperior.getfOcupante() != null) {
                    cSuperior = null;
                    fSuperior = null;
                }
            }
            int x = d.getiPosicion()[0] + r;
            int y = d.getiPosicion()[1] + 1;
            cInferior = tTablero.getCasilla(x, y);
            fInferior = cInferior.getfOcupante();
            if (fInferior != null) {
                x = cInferior.getiPosicion()[0] + r;
                y = cInferior.getiPosicion()[1] + 1;
                cInferior = tTablero.getCasilla(x, y);
                if (cInferior.getfOcupante() != null || !cInferior.isbPisable()) {
                    cInferior = null;
                    fInferior = null;
                }
            }
        } else {
            cInferior = d.getcDestino();
            fInferior = cInferior.getfOcupante();
            if (fInferior != null) {
                int x = cInferior.getiPosicion()[0] + r;
                int y = cInferior.getiPosicion()[1] + 1;
                cInferior = tTablero.getCasilla(x, y);
                if (cInferior.getfOcupante() != null) {
                    fInferior = null;
                    fInferior = null;
                }
            }
            int x = d.getiPosicion()[0] + r;
            int y = d.getiPosicion()[1] - 1;
            cSuperior = tTablero.getCasilla(x, y);
            fSuperior = cSuperior.getfOcupante();
            if (fSuperior != null) {
                x = cSuperior.getiPosicion()[0] + r;
                y = cSuperior.getiPosicion()[1] - 1;
                cSuperior = tTablero.getCasilla(x, y);
                if (cSuperior.getfOcupante() != null || !cSuperior.isbPisable()) {
                    cSuperior = null;
                    fSuperior = null;
                }
            }
        }
    }

    @Override
    public String toString() {
        String s = iNumero + " " + jJugador.isbTurno() + " x = " + iPosicion[0] + " y = " + iPosicion[1] + " " + eEstado.toString();
        return s;
    }
}
