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
public class Movimiento {

    private final Tablero tTablero;
    private boolean bSeleccion;
    private Casilla cSuperior;
    private Casilla cInferior;
    private Ficha fSeleccion;
    private Ficha fSuperior;
    private Ficha fInferior;
    private final Obligacion oObligacion;
    private boolean bObligacion;
    private boolean bFinPartida;

    public void DetectarCaso(Casilla c) {
        if (c.isbResaltada()) {
            if (c == cSuperior) {
                Mover(cSuperior, fSuperior);
            } else {
                Mover(cInferior, fInferior);
            }
            Desresaltar(true);
            if (c.getfOcupante().geteEstado() == Ficha.Estado.SALTANDO) {
                Arrays.fill(oObligacion.getaObligadas(), false);
                for (int i = 0; i < 5; i++) {
                    if (oObligacion.getaFichas()[i] == c.getfOcupante()) {
                        oObligacion.setObligacion(true, i);
                    }
                }
                bObligacion = true;
                fSeleccion = c.getfOcupante();
                fSeleccion.seteEstado(Ficha.Estado.COMIO_OBLIGADA);
                int r;
                if (tTablero.isbTurno()) {
                    r = 1;
                } else {
                    r = -1;
                }
                if (c.isBotTP() || c.isTopTP()) {
                    CasoTP(c, r);
                } else {
                    CasoComun(c, r);
                }
                if (fSuperior == null) {
                    cSuperior = null;
                }
                if (fInferior == null) {
                    cInferior = null;
                }
                bSeleccion = true;
                Resaltar();
            } else {
                tTablero.CambiarTurno();
            }
        } else {
            if (bObligacion) {
                Ficha f = c.getfOcupante();
                if (f != null) {
                    if (f.geteEstado() == Ficha.Estado.COMIO_OBLIGADA || f.geteEstado() == Ficha.Estado.NORMAL_OBLIGADA) {
                        fSeleccion = f;
                        int r;
                        if (tTablero.isbTurno()) {
                            r = 1;
                        } else {
                            r = -1;
                        }
                        if (c.isBotTP() || c.isTopTP()) {
                            CasoTP(c, r);
                        } else {
                            CasoComun(c, r);
                        }
                        boolean b = false;
                        if (fSuperior == null) {
                            cSuperior = null;
                        } else {
                            if (Objects.equals(fSuperior.getjJugador().isbTurno(), fSeleccion.getjJugador().isbTurno())) {
                                fSuperior = null;
                                cSuperior = null;
                            } else {
                                b = true;
                            }
                        }
                        if (fInferior == null) {
                            cInferior = null;
                        } else {
                            if (Objects.equals(fInferior.getjJugador().isbTurno(), fSeleccion.getjJugador().isbTurno())) {
                                fInferior = null;
                                cInferior = null;
                            } else {
                                b = true;
                            }
                        }
                        if (b) {
                            Desresaltar(false);
                            bSeleccion = true;
                            Resaltar();
                        }
                    } else {
                        Desresaltar(false);
                        bSeleccion = false;
                        fSeleccion = null;
                    }
                } else {
                    Desresaltar(false);
                    bSeleccion = false;
                    fSeleccion = null;
                }
            } else {
                Ficha f = c.getfOcupante();
                if (f != null && !f.enMeta() && Objects.equals(f.getjJugador().isbTurno(), tTablero.isbTurno())) {
                    if (!bSeleccion) {
                        fSeleccion = f;
                        int r;
                        if (tTablero.isbTurno()) {
                            r = 1;
                        } else {
                            r = -1;
                        }
                        if (c.isBotTP() || c.isTopTP()) {
                            CasoTP(c, r);
                        } else {
                            CasoComun(c, r);
                        }
                        if (cSuperior != null || cInferior != null) {
                            bSeleccion = true;
                            Resaltar();
                        }
                    } else {
                        Desresaltar(false);
                        bSeleccion = false;
                        fSeleccion = null;
                    }
                }
            }
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

    private void Resaltar() {
        if (cSuperior != null) {
            cSuperior.setbResaltada(Boolean.TRUE);
            if (fSuperior != null) {
                Resaltar(fSuperior, 'c');
            }
        }
        if (cInferior != null) {
            cInferior.setbResaltada(Boolean.TRUE);
            if (fInferior != null) {
                Resaltar(fInferior, 'c');
            }
        }
    }

    private void Resaltar(Ficha f, char c) {
        switch (c) {
            case 'c': {
                if (f.geteEstado() == Ficha.Estado.NORMAL) {
                    f.seteEstado(Ficha.Estado.NORMAL_RESALTADA);
                } else {
                    if (f.geteEstado() == Ficha.Estado.COMIO) {
                        f.seteEstado(Ficha.Estado.COMIO_RESALTADA);
                    }
                }
                break;
            }
        }
    }

    private void Desresaltar(boolean b) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 5; y++) {
                tTablero.getaCasillas()[x][y].setbResaltada(false);
            }
        }
        for (Jugador j : tTablero.getjJugadores()) {
            for (Ficha f : j.getfFichas()) {
                if (f.geteEstado() == Ficha.Estado.NORMAL_RESALTADA) {
                    f.seteEstado(Ficha.Estado.NORMAL);
                } else {
                    if (f.geteEstado() == Ficha.Estado.COMIO_RESALTADA) {
                        f.seteEstado(Ficha.Estado.COMIO);
                    } else {
                        if (b) {
                            if (f.geteEstado() == Ficha.Estado.NORMAL_OBLIGADA) {
                                f.seteEstado(Ficha.Estado.NORMAL);
                            } else {
                                if (f.geteEstado() == Ficha.Estado.COMIO_OBLIGADA) {
                                    f.seteEstado(Ficha.Estado.COMIO);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void Mover(Casilla c, Ficha f) {
        Desresaltar(true);
        tTablero.getCasilla(fSeleccion.getiPosicion()[0], fSeleccion.getiPosicion()[1]).setfOcupante(null);
        int x = c.getiPosicion()[0];
        int y = c.getiPosicion()[1];
        int i = fSeleccion.getiNumero();
        fSeleccion.setiPosicion(c.getiPosicion());
        tTablero.getBC().MovePiece(i, x, y);
        c.setfOcupante(fSeleccion);
        if (f != null) {
            if (fSeleccion.getjJugador() != f.getjJugador()) {
                f.seteEstado(Ficha.Estado.MUERTA);
                i = f.getiNumero();
                tTablero.getBC().MovePiece(i, -1, -1);
                tTablero.getCasilla(f.getiPosicion()[0], f.getiPosicion()[1]).setfOcupante(null);
                int r;
                if (tTablero.isbTurno()) {
                    r = 1;
                } else {
                    r = -1;
                }
                if (fSeleccion.geteEstado() == Ficha.Estado.NORMAL) {
                    fSeleccion.seteEstado(Ficha.Estado.COMIO);
                }
                if (PuedeSaltar(r, c)) {
                    fSeleccion.seteEstado(Ficha.Estado.SALTANDO);
                } else {

                    if (fSeleccion.geteEstado() == Ficha.Estado.COMIO) {
                        fSeleccion.seteEstado(Ficha.Estado.MUERTA);
                        i = f.getiNumero();
                        tTablero.getBC().MovePiece(i, -1, -1);
                    } else {
                        if (fSeleccion.geteEstado() == Ficha.Estado.SALTANDO) {
                            fSeleccion.seteEstado(Ficha.Estado.MUERTA);
                            i = f.getiNumero();
                            tTablero.getBC().MovePiece(i, -1, -1);
                            tTablero.getCasilla(fSeleccion.getiPosicion()[0], fSeleccion.getiPosicion()[1]).setfOcupante(null);
                        }
                    }

                }
            }
        }
    }

    private boolean PuedeSaltar(int r, Casilla c) {
        Ficha f = c.getfOcupante();
        if (!f.enMeta()) {
            System.out.println("entre a");
            if (c.isBotTP() || c.isTopTP()) {
                CasoTP(c, r);
            } else {
                CasoComun(c, r);
            }
            boolean b = false;
            if (fSuperior != null) {
                if (!Objects.equals(fSuperior.getjJugador().isbTurno(), f.getjJugador().isbTurno())) {
                    b = true;
                } else {
                    cSuperior = null;
                    fSuperior = null;
                }
            } else {
                cSuperior = null;
                fSuperior = null;
            }
            if (fInferior != null) {
                if (!Objects.equals(fInferior.getjJugador().isbTurno(), f.getjJugador().isbTurno())) {
                    b = true;
                } else {
                    cInferior = null;
                    fInferior = null;
                }
            } else {
                cSuperior = null;
                fSuperior = null;
            }
            if (b) {
                bSeleccion = true;
                Resaltar();
                return true;
            } else {
                Desresaltar(true);
                return false;
            }
        } else {
            Desresaltar(true);
            return false;
        }
    }

    public Movimiento(Tablero t) {
        cSuperior = null;
        cInferior = null;
        fSuperior = null;
        fInferior = null;
        tTablero = t;
        bSeleccion = false;
        fSeleccion = null;
        Jugador j;
        if (Objects.equals(t.isbTurno(), t.getjJugadores()[0].isbTurno())) {
            oObligacion = new Obligacion(t.getjJugadores()[0], tTablero);
            j = tTablero.getjJugadores()[0];
        } else {
            oObligacion = new Obligacion(t.getjJugadores()[1], tTablero);
            j = tTablero.getjJugadores()[1];
        }
        bObligacion = false;
        for (int i = 0; i < 5; i++) {
            if (oObligacion.getaObligadas()[i]) {
                Ficha f = oObligacion.getaFichas()[i];
                Resaltar(f, 'o');
                bObligacion = true;
            }
        }
        bFinPartida = true;
        for (Ficha f : j.getfFichas()) {
            if (f.geteEstado() != Ficha.Estado.MUERTA) {
                if (!f.enMeta()) {
                    int r;
                    if (j.isbTurno()) {
                        r = 1;
                    } else {
                        r = -1;
                    }
                    Casilla c = tTablero.getCasilla(f.getiPosicion()[0], f.getiPosicion()[1]);
                    if (c.isBotTP() || c.isTopTP()) {
                        CasoTP(c, r);
                    } else {
                        CasoComun(c, r);
                    }
                    boolean b = false;
                    if (cSuperior != null || cInferior != null) {
                        b = true;
                    }
                    if (b) {
                        bFinPartida = false;
                    }
                }
            }
        }
        cSuperior = null;
        cInferior = null;
        fSuperior = null;
        fInferior = null;
    }
}
