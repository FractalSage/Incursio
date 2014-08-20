/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incursiofx;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Francisco
 */
public class Obligacion {

    private final Tablero tTablero;
    private final boolean[] aObligadas = new boolean[5];
    private final Ficha[] aFichas = new Ficha[5];
    private Casilla cSuperior;
    private Casilla cInferior;
    private Ficha fSuperior;
    private Ficha fInferior;

    public boolean[] getaObligadas() {
        return aObligadas;
    }

    public Ficha[] getaFichas() {
        return aFichas;
    }

    public void setObligacion(boolean b, int i) {
        aObligadas[i] = b;
    }

    public Obligacion(Jugador j, Tablero t) {
        this.tTablero = t;
        int i = 0;
        int r;
        if (j.isbTurno()) {
            r = 1;
        } else {
            r = -1;
        }
        for (Ficha f : j.getfFichas()) {
            cSuperior = null;
            fSuperior = null;
            cInferior = null;
            fInferior = null;
            this.aFichas[i] = f;
            if (f.geteEstado() != Ficha.Estado.MUERTA) {
                Casilla c = tTablero.getCasilla(f.getiPosicion()[0], f.getiPosicion()[1]);
                if (c.isBotTP() || c.isTopTP()) {
                    CasoTP(c, r);
                } else {
                    CasoComun(c, r);
                }
                boolean b = false;
                if (cSuperior != null && fSuperior != null) {
                    if (!Objects.equals(fSuperior.getjJugador().isbTurno(), f.getjJugador().isbTurno())) {
                        b = true;
                    }
                }
                if (cInferior != null && fInferior != null) {
                    if (!Objects.equals(fInferior.getjJugador().isbTurno(), f.getjJugador().isbTurno())) {
                        b = true;
                    }
                }
                if (b) {
                    if (f.geteEstado() == Ficha.Estado.NORMAL) {
                        f.seteEstado(Ficha.Estado.NORMAL_OBLIGADA);
                    }
                    if (f.geteEstado() == Ficha.Estado.COMIO) {
                        f.seteEstado(Ficha.Estado.COMIO_OBLIGADA);
                    }
                    this.aObligadas[i] =b;
                }
            }
            i++;
        }
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
        return Arrays.toString(aObligadas);
    }
}
