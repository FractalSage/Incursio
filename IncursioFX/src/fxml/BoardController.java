/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import incursiofx.Casilla;
import incursiofx.Ficha;
import incursiofx.Tablero;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Francisco
 */
public class BoardController implements Initializable {

    private Tablero tTablero;
    @FXML
    public GridPane Grilla;
    public ImageView c00 = new ImageView(), c01 = new ImageView(), c02 = new ImageView(),
            c03 = new ImageView(), c04 = new ImageView(), c10 = new ImageView(),
            c11 = new ImageView(), c12 = new ImageView(), c13 = new ImageView(),
            c14 = new ImageView(), c20 = new ImageView(), c21 = new ImageView(),
            c22 = new ImageView(), c23 = new ImageView(), c24 = new ImageView(),
            c30 = new ImageView(), c31 = new ImageView(), c32 = new ImageView(),
            c33 = new ImageView(), c34 = new ImageView(), c40 = new ImageView(),
            c41 = new ImageView(), c42 = new ImageView(), c43 = new ImageView(),
            c44 = new ImageView(), c50 = new ImageView(), c51 = new ImageView(),
            c52 = new ImageView(), c53 = new ImageView(), c54 = new ImageView(),
            c60 = new ImageView(), c61 = new ImageView(), c62 = new ImageView(),
            c63 = new ImageView(), c64 = new ImageView(), c70 = new ImageView(),
            c71 = new ImageView(), c72 = new ImageView(), c73 = new ImageView(),
            c74 = new ImageView(), c80 = new ImageView(), c81 = new ImageView(),
            c82 = new ImageView(), c83 = new ImageView(), c84 = new ImageView(),
            f1p1 = new ImageView(), f2p1 = new ImageView(), f3p1 = new ImageView(),
            f4p1 = new ImageView(), f5p1 = new ImageView(), f1p2 = new ImageView(),
            f2p2 = new ImageView(), f3p2 = new ImageView(), f4p2 = new ImageView(),
            f5p2 = new ImageView();

    @SuppressWarnings("Convert2Lambda")
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tTablero = new Tablero(this);

        f1p1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Ficha f = tTablero.getjJugadores()[0].getfFichas()[0];
                int x, y;
                x = f.getiPosicion()[0];
                y = f.getiPosicion()[1];
                tTablero.getmMovimiento().DetectarCaso(tTablero.getCasilla(x, y));
            }
        });
        f2p1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Ficha f = tTablero.getjJugadores()[0].getfFichas()[1];
                int x, y;
                x = f.getiPosicion()[0];
                y = f.getiPosicion()[1];
                tTablero.getmMovimiento().DetectarCaso(tTablero.getCasilla(x, y));
            }
        });
        f3p1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Ficha f = tTablero.getjJugadores()[0].getfFichas()[2];
                int x, y;
                x = f.getiPosicion()[0];
                y = f.getiPosicion()[1];
                tTablero.getmMovimiento().DetectarCaso(tTablero.getCasilla(x, y));
            }
        });
        f4p1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Ficha f = tTablero.getjJugadores()[0].getfFichas()[3];
                int x, y;
                x = f.getiPosicion()[0];
                y = f.getiPosicion()[1];
                tTablero.getmMovimiento().DetectarCaso(tTablero.getCasilla(x, y));
            }
        });
        f5p1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Ficha f = tTablero.getjJugadores()[0].getfFichas()[4];
                int x, y;
                x = f.getiPosicion()[0];
                y = f.getiPosicion()[1];
                tTablero.getmMovimiento().DetectarCaso(tTablero.getCasilla(x, y));
            }
        });
        f1p2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Ficha f = tTablero.getjJugadores()[1].getfFichas()[0];
                int x, y;
                x = f.getiPosicion()[0];
                y = f.getiPosicion()[1];
                tTablero.getmMovimiento().DetectarCaso(tTablero.getCasilla(x, y));
            }
        });
        f2p2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Ficha f = tTablero.getjJugadores()[1].getfFichas()[1];
                int x, y;
                x = f.getiPosicion()[0];
                y = f.getiPosicion()[1];
                tTablero.getmMovimiento().DetectarCaso(tTablero.getCasilla(x, y));
            }
        });
        f3p2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Ficha f = tTablero.getjJugadores()[1].getfFichas()[2];
                int x, y;
                x = f.getiPosicion()[0];
                y = f.getiPosicion()[1];
                tTablero.getmMovimiento().DetectarCaso(tTablero.getCasilla(x, y));
            }
        });
        f4p2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Ficha f = tTablero.getjJugadores()[1].getfFichas()[3];
                int x, y;
                x = f.getiPosicion()[0];
                y = f.getiPosicion()[1];
                tTablero.getmMovimiento().DetectarCaso(tTablero.getCasilla(x, y));
            }
        });
        f5p2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Ficha f = tTablero.getjJugadores()[1].getfFichas()[4];
                int x, y;
                x = f.getiPosicion()[0];
                y = f.getiPosicion()[1];
                tTablero.getmMovimiento().DetectarCaso(tTablero.getCasilla(x, y));
            }
        });

        c00.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(0, 0);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c10.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(1, 0);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c20.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(2, 0);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c30.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(3, 0);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c40.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(4, 0);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c50.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(5, 0);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c60.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(6, 0);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c70.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(7, 0);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c80.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(8, 0);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c01.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(0, 1);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c11.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(1, 1);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c21.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(2, 1);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c31.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(3, 1);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c41.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(4, 1);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c51.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(5, 1);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c61.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(6, 1);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c71.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(7, 1);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c81.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(8, 1);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c02.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(0, 2);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c12.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(1, 2);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c22.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(2, 2);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c32.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(3, 2);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c42.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(4, 2);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c52.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(5, 2);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c62.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(6, 2);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c72.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(7, 2);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c82.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(8, 2);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c03.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(0, 3);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c13.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(1, 3);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c23.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(2, 3);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c33.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(3, 3);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c43.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(4, 3);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c53.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(5, 3);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c63.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(6, 3);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c73.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(7, 3);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c83.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(8, 3);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c04.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(0, 4);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c14.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(1, 4);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c24.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(2, 4);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c34.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(3, 4);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c44.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(4, 4);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c54.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(5, 4);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c64.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(6, 4);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c74.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(7, 4);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
        c84.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Casilla c = tTablero.getCasilla(8, 4);
                tTablero.getmMovimiento().DetectarCaso(c);
            }
        });
    }

    public void ChangeSprite(int i, String estado) {
        if (!"".equals(estado)) {
            switch (i) {
                case 0: {
                    f1p1.setImage(new Image("/img/Ficha_P1" + estado + ".png"));
                    break;
                }
                case 1: {
                    f2p1.setImage(new Image("/img/Ficha_P1" + estado + ".png"));
                    break;
                }
                case 2: {
                    f3p1.setImage(new Image("/img/Ficha_P1" + estado + ".png"));
                    break;
                }
                case 3: {
                    f4p1.setImage(new Image("/img/Ficha_P1" + estado + ".png"));
                    break;
                }
                case 4: {
                    f5p1.setImage(new Image("/img/Ficha_P1" + estado + ".png"));
                    break;
                }
                case 5: {
                    f1p2.setImage(new Image("/img/Ficha_P2" + estado + ".png"));
                    break;
                }
                case 6: {
                    f2p2.setImage(new Image("/img/Ficha_P2" + estado + ".png"));
                    break;
                }
                case 7: {
                    f3p2.setImage(new Image("/img/Ficha_P2" + estado + ".png"));
                    break;
                }
                case 8: {
                    f4p2.setImage(new Image("/img/Ficha_P2" + estado + ".png"));
                    break;
                }
                case 9: {
                    f5p2.setImage(new Image("/img/Ficha_P2" + estado + ".png"));
                    break;
                }
            }
        }
    }

    @SuppressWarnings("null")
    public void ChangeSprite(Integer i, boolean b, boolean p) {
        String s = "/img/";
        switch (i) {
            case 20:
            case 64: {
                s += "Casilla_TP_A";
                break;
            }
            case 40:
            case 44: {
                s += "Casilla_TP_C";
                break;
            }
            case 60:
            case 24: {
                s += "Casilla_TP_B";
                break;
            }
            default: {
                if (p) {
                    s += "Casilla_Pisable";
                } else {
                    s += "Casilla_No_Pisable";
                }
                break;
            }
        }
        if (b) {
            s += "_Resaltada";
        }
        s += ".png";
        ImageView iv = null;
        switch (i) {
            case 0: {
                iv = c00;
                break;
            }
            case 10: {
                iv = c10;
                break;
            }
            case 20: {
                iv = c20;
                break;
            }
            case 30: {
                iv = c30;
                break;
            }
            case 40: {
                iv = c40;
                break;
            }
            case 50: {
                iv = c50;
                break;
            }
            case 60: {
                iv = c60;
                break;
            }
            case 70: {
                iv = c70;
                break;
            }
            case 80: {
                iv = c80;
                break;
            }
            case 1: {
                iv = c01;
                break;
            }
            case 11: {
                iv = c11;
                break;
            }
            case 21: {
                iv = c21;
                break;
            }
            case 31: {
                iv = c31;
                break;
            }
            case 41: {
                iv = c41;
                break;
            }
            case 51: {
                iv = c51;
                break;
            }
            case 61: {
                iv = c61;
                break;
            }
            case 71: {
                iv = c71;
                break;
            }
            case 81: {
                iv = c81;
                break;
            }
            case 2: {
                iv = c02;
                break;
            }
            case 12: {
                iv = c12;
                break;
            }
            case 22: {
                iv = c22;
                break;
            }
            case 32: {
                iv = c32;
                break;
            }
            case 42: {
                iv = c42;
                break;
            }
            case 52: {
                iv = c52;
                break;
            }
            case 62: {
                iv = c62;
                break;
            }
            case 72: {
                iv = c72;
                break;
            }
            case 82: {
                iv = c82;
                break;
            }
            case 3: {
                iv = c03;
                break;
            }
            case 13: {
                iv = c13;
                break;
            }
            case 23: {
                iv = c23;
                break;
            }
            case 33: {
                iv = c33;
                break;
            }
            case 43: {
                iv = c43;
                break;
            }
            case 53: {
                iv = c53;
                break;
            }
            case 63: {
                iv = c63;
                break;
            }
            case 73: {
                iv = c73;
                break;
            }
            case 83: {
                iv = c83;
                break;
            }
            case 4: {
                iv = c04;
                break;
            }
            case 14: {
                iv = c14;
                break;
            }
            case 24: {
                iv = c24;
                break;
            }
            case 34: {
                iv = c34;
                break;
            }
            case 44: {
                iv = c44;
                break;
            }
            case 54: {
                iv = c54;
                break;
            }
            case 64: {
                iv = c64;
                break;
            }
            case 74: {
                iv = c74;
                break;
            }
            case 84: {
                iv = c84;
                break;
            }
        }
        iv.setImage(new Image(s));
    }

    @SuppressWarnings("null")
    public void MovePiece(int i, int x, int y) {
        ImageView iv = null;
        switch (i) {
            case 0: {
                iv = f1p1;
                break;
            }
            case 1: {
                iv = f2p1;
                break;
            }
            case 2: {
                iv = f3p1;
                break;
            }
            case 3: {
                iv = f4p1;
                break;
            }
            case 4: {
                iv = f5p1;
                break;
            }
            case 5: {
                iv = f1p2;
                break;
            }
            case 6: {
                iv = f2p2;
                break;
            }
            case 7: {
                iv = f3p2;
                break;
            }
            case 8: {
                iv = f4p2;
                break;
            }
            case 9: {
                iv = f5p2;
                break;
            }
        }
        Grilla.getChildren().remove(iv);
        if (x > -1 && y > -1) {
            Grilla.add(iv, x, y);
        }
    }

    public void ReLoadBoard() {
        Grilla.getChildren().remove(f1p1);
        Grilla.getChildren().remove(f2p1);
        Grilla.getChildren().remove(f3p1);
        Grilla.getChildren().remove(f4p1);
        Grilla.getChildren().remove(f5p1);
        Grilla.getChildren().remove(f1p2);
        Grilla.getChildren().remove(f2p2);
        Grilla.getChildren().remove(f3p2);
        Grilla.getChildren().remove(f4p2);
        Grilla.getChildren().remove(f5p2);
        Grilla.add(f1p1, 0, 0);
        Grilla.add(f2p1, 1, 1);
        Grilla.add(f3p1, 0, 2);
        Grilla.add(f4p1, 1, 3);
        Grilla.add(f5p1, 0, 4);
        Grilla.add(f1p2, 8, 0);
        Grilla.add(f2p2, 7, 1);
        Grilla.add(f3p2, 8, 2);
        Grilla.add(f4p2, 7, 3);
        Grilla.add(f5p2, 8, 4);
    }

}
