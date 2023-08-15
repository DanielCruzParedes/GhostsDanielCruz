package ghosts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class GhostGame extends JPanel implements ActionListener, GameLogic {

    public String usuarioLogeado;
    public String segundoPlayer;
    private JButton[][] botones;
    private int vecesClickeadas = 0;
    private JButton botonClickeado;
    private int posicionInicialx;
    private int posicionInicialy;
    private int posicionFinalx;
    private int posicionFinaly;
    private String textoPrimeraFichaSeleccionada;
    private String textoSegundaFichaSeleccionada;
    public int turno = 1;
    private String textoGanador = "";
    ArrayList<Usuarios>listaUsuarios;

    URL urlImagen1 = getClass().getResource("/Fantasmitas/fantasmabueno.png");
    URL urlImagen2 = getClass().getResource("/Fantasmitas/fantasmamalo.png");
    URL urlImagenNeutra = getClass().getResource("/Fantasmitas/fantasmaneutro.png");
    URL urlImagenTrampa = getClass().getResource("/Fantasmitas/fantasmatrampa.png");
    ImageIcon imageIcon = new ImageIcon(urlImagen1);
    JButton botonProbando;
    Image image;
    Player player;
    Login login;
    private JLabel lblTurno;
    public JTextArea taPlayer1;
    public JTextArea taPlayer2;
    AlrededorTablero at;
    cambioturno ct;

    public GhostGame(Login login, Player player, JLabel lblTurno, JTextArea taPlayer1, JTextArea taPlayer2, AlrededorTablero at) {
        this.login = login;
        this.player = player;
        this.lblTurno = lblTurno;
        this.taPlayer1 = taPlayer1;
        this.taPlayer2 = taPlayer2;
        this.usuarioLogeado = player.usuarioLogeado;
        this.segundoPlayer = player.segundoPlayer;
        this.at = at;
        this.listaUsuarios=player.listaUsuarios;
        this.ct= new cambioturno(at);

        JPanel tableroPanel = new JPanel();
        tableroPanel.setLayout(new GridLayout(6, 6));
        botones = new JButton[6][6];

        //Poner los botones
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                JButton boton = new JButton();
                boton.setPreferredSize(new Dimension(130, 130));
                boton.putClientProperty("x", fila);
                boton.putClientProperty("y", columna);
                Color colorBotonesNormales = new Color(187, 186, 176);
                boton.setBackground(colorBotonesNormales);
                boton.addActionListener(this); // Agregar el ActionListener al botón
                botones[fila][columna] = boton;
                tableroPanel.add(boton);

            }
        }

        add(tableroPanel);

        setVisible(true);

        //Poner metodos
        switch (player.modo) {
            case "AZAR":
                ponerFantasmasAlAzar();
                break;

            case "MANUAL":
                ponerFantasmasManual();

        }
        colorearSalidas();
        ponerImagenes();
        actualizarTurno(lblTurno);
        actualizarTextAreas(taPlayer1, taPlayer2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonClickeado = (JButton) e.getSource();
        int fila = (int) botonClickeado.getClientProperty("x");
        int columna = (int) botonClickeado.getClientProperty("y");

        int x = (int) botonClickeado.getClientProperty("x");
        int y = (int) botonClickeado.getClientProperty("y");
        vecesClickeadas++;
        if (vecesClickeadas == 1) {
            textoPrimeraFichaSeleccionada = botones[x][y].getText();
        } else {
            textoSegundaFichaSeleccionada = botones[x][y].getText();
        }
        hacerMovimientosYTurnos(botonClickeado);
        ponerImagenes();
        accionesAlGanar(fila, columna);
        actualizarTurno(lblTurno);
        actualizarTextAreas(taPlayer1, taPlayer2);

    }
    
    

    @Override
    public void ponerFantasmasManual() {

        //Cuando el modo es normal se ingresan 4 buenos y 4 malos
        if (player.dificultad.equals("NORMAL")) {

            //Poner fantasmas buenos de jugador 1
            for (int fantasmasBuenosPuestos1 = 0; fantasmasBuenosPuestos1 < 4; fantasmasBuenosPuestos1++) {
                String input = JOptionPane.showInputDialog("JUGADOR 1: Ingrese la posición en la que desea poner el fantasma bueno número " + fantasmasBuenosPuestos1 + 1 + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 4 && fila != 5) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");
                                fantasmasBuenosPuestos1--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("GoodGhost1");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasBuenosPuestos1--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasBuenosPuestos1--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasBuenosPuestos1--;
                    }
                }

            }//cierre del for de poner los fantasmas buenos 1

            //Poner fantasmas malos de jugador 1
            for (int fantasmasMalosPuestos1 = 0; fantasmasMalosPuestos1 < 4; fantasmasMalosPuestos1++) {
                String input = JOptionPane.showInputDialog("JUGADOR 1: Ingrese la posición en la que desea poner el fantasma malo número " + fantasmasMalosPuestos1 + 1 + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 4 && fila != 5) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");
                                fantasmasMalosPuestos1--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("BadGhost1");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasMalosPuestos1--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasMalosPuestos1--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasMalosPuestos1--;
                    }
                }

            }//cierre del for de poner los fantasmas malos 1

            //TURNO DE PONER FANTASMAS MALOS DEL JUGADOR 2=====================================================
            //Poner fantasmas buenos de jugador 2
            for (int fantasmasBuenosPuestos2 = 0; fantasmasBuenosPuestos2 < 4; fantasmasBuenosPuestos2++) {
                String input = JOptionPane.showInputDialog("JUGADOR 2: Ingrese la posición en la que desea poner el fantasma bueno número " + fantasmasBuenosPuestos2 + 1 + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 1 && fila != 0) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");
                                fantasmasBuenosPuestos2--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("GoodGhost2");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasBuenosPuestos2--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasBuenosPuestos2--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasBuenosPuestos2--;
                    }
                }

            }//cierre del for de poner los fantasmas buenos 2

            //Poner fantasmas malos de jugador 2
            for (int fantasmasMalosPuestos2 = 0; fantasmasMalosPuestos2 < 4; fantasmasMalosPuestos2++) {
                String input = JOptionPane.showInputDialog("JUGADOR 2: Ingrese la posición en la que desea poner el fantasma malo número " + fantasmasMalosPuestos2 + 1 + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 1 && fila != 0) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");
                                fantasmasMalosPuestos2--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("BadGhost2");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasMalosPuestos2--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasMalosPuestos2--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasMalosPuestos2--;
                    }
                }

            }//cierre del for de poner los fantasmas malos 2

        }//CIERRE DE CUANDO EL MODO ES NORMAL
        
        
        // Si es modo experto se ingresan 2 buenos y dos malos
        if(player.dificultad.equals("EXPERTO")){
            
               //Poner fantasmas buenos de jugador 1
            for (int fantasmasBuenosPuestos1 = 0; fantasmasBuenosPuestos1 < 2; fantasmasBuenosPuestos1++) {
                String input = JOptionPane.showInputDialog("JUGADOR 1: Ingrese la posición en la que desea poner el fantasma bueno número " + (fantasmasBuenosPuestos1+1) + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 4 && fila != 5) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");
                                fantasmasBuenosPuestos1--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("GoodGhost1");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasBuenosPuestos1--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasBuenosPuestos1--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasBuenosPuestos1--;
                    }
                }

            }//cierre del for de poner los fantasmas buenos 1

            //Poner fantasmas malos de jugador 1
            for (int fantasmasMalosPuestos1 = 0; fantasmasMalosPuestos1 < 2; fantasmasMalosPuestos1++) {
                String input = JOptionPane.showInputDialog("JUGADOR 1: Ingrese la posición en la que desea poner el fantasma malo número " + (fantasmasMalosPuestos1+1) + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 4 && fila != 5) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");
                                fantasmasMalosPuestos1--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("BadGhost1");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasMalosPuestos1--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasMalosPuestos1--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasMalosPuestos1--;
                    }
                }

            }//cierre del for de poner los fantasmas malos 1

            //TURNO DE PONER FANTASMAS MALOS DEL JUGADOR 2=====================================================
            //Poner fantasmas buenos de jugador 2
            for (int fantasmasBuenosPuestos2 = 0; fantasmasBuenosPuestos2 < 2; fantasmasBuenosPuestos2++) {
                String input = JOptionPane.showInputDialog("JUGADOR 2: Ingrese la posición en la que desea poner el fantasma bueno número " + (fantasmasBuenosPuestos2+1) + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 1 && fila != 0) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");
                                fantasmasBuenosPuestos2--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("GoodGhost2");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasBuenosPuestos2--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasBuenosPuestos2--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasBuenosPuestos2--;
                    }
                }

            }//cierre del for de poner los fantasmas buenos 2

            //Poner fantasmas malos de jugador 2
            for (int fantasmasMalosPuestos2 = 0; fantasmasMalosPuestos2 < 2; fantasmasMalosPuestos2++) {
                String input = JOptionPane.showInputDialog("JUGADOR 2: Ingrese la posición en la que desea poner el fantasma malo número " + (fantasmasMalosPuestos2+1) + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 1 && fila != 0) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");
                                fantasmasMalosPuestos2--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("BadGhost2");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasMalosPuestos2--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasMalosPuestos2--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasMalosPuestos2--;
                    }
                }

            }//cierre del for de poner los fantasmas malos 2
        }//CIERRE DE CUANDO LA DIFICULTAD ES EXPERTO
        
        
        //CUANDO LA DIFICULTAD ES EXPERTO SE INGRESA 1 BUENO Y 1 MALO Y 4 TRAMPAS
        if(player.dificultad.equals("GENIO")){
            
               //Poner fantasmas buenos de jugador 1
            for (int fantasmasBuenosPuestos1 = 0; fantasmasBuenosPuestos1 < 1; fantasmasBuenosPuestos1++) {
                String input = JOptionPane.showInputDialog("JUGADOR 1: Ingrese la posición en la que desea poner el fantasma bueno número " + (fantasmasBuenosPuestos1+1) + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 4 && fila != 5) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");
                                fantasmasBuenosPuestos1--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("GoodGhost1");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasBuenosPuestos1--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasBuenosPuestos1--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasBuenosPuestos1--;
                    }
                }

            }//cierre del for de poner los fantasmas buenos 1

            //Poner fantasmas malos de jugador 1
            for (int fantasmasMalosPuestos1 = 0; fantasmasMalosPuestos1 < 1; fantasmasMalosPuestos1++) {
                String input = JOptionPane.showInputDialog("JUGADOR 1: Ingrese la posición en la que desea poner el fantasma malo número " + (fantasmasMalosPuestos1+1) + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 4 && fila != 5) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");
                                fantasmasMalosPuestos1--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("BadGhost1");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasMalosPuestos1--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasMalosPuestos1--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasMalosPuestos1--;
                    }
                }

            }//cierre del for de poner los fantasmas malos 1
            
            //Poner fantasmas trampas de jugador 1
            for (int fantasmasTrampasPuestos1 = 0; fantasmasTrampasPuestos1 < 4; fantasmasTrampasPuestos1++) {
                String input = JOptionPane.showInputDialog("JUGADOR 1: Ingrese la posición en la que desea poner el fantasma trampa número " + (fantasmasTrampasPuestos1+1) + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 4 && fila != 5) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 4, 5 y columnas 1, 2, 3, 4.");
                                fantasmasTrampasPuestos1--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("fantasmaTrampa1");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasTrampasPuestos1--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasTrampasPuestos1--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasTrampasPuestos1--;
                    }
                }

            }//cierre del for de poner los fantasmas trampas 1

            //TURNO DE PONER FANTASMAS MALOS DEL JUGADOR 2=====================================================
            //Poner fantasmas buenos de jugador 2
            for (int fantasmasBuenosPuestos2 = 0; fantasmasBuenosPuestos2 < 1; fantasmasBuenosPuestos2++) {
                String input = JOptionPane.showInputDialog("JUGADOR 2: Ingrese la posición en la que desea poner el fantasma bueno número " +(fantasmasBuenosPuestos2+1) + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 1 && fila != 0) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");
                                fantasmasBuenosPuestos2--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("GoodGhost2");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasBuenosPuestos2--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasBuenosPuestos2--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasBuenosPuestos2--;
                    }
                }

            }//cierre del for de poner los fantasmas buenos 2

            //Poner fantasmas malos de jugador 2
            for (int fantasmasMalosPuestos2 = 0; fantasmasMalosPuestos2 < 1; fantasmasMalosPuestos2++) {
                String input = JOptionPane.showInputDialog("JUGADOR 2: Ingrese la posición en la que desea poner el fantasma malo número " + fantasmasMalosPuestos2 + 1 + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 1 && fila != 0) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");
                                fantasmasMalosPuestos2--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("BadGhost2");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasMalosPuestos2--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasMalosPuestos2--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasMalosPuestos2--;
                    }
                }

            }//cierre del for de poner los fantasmas malos 2
            
            //Poner fantasmas trampas de jugador 2
            for (int fantasmasTrampasPuestos2 = 0; fantasmasTrampasPuestos2 < 4; fantasmasTrampasPuestos2++) {
                String input = JOptionPane.showInputDialog("JUGADOR 2: Ingrese la posición en la que desea poner el fantasma trampa número " + (fantasmasTrampasPuestos2+1) + "\nLa posición debe de ser escrita en la forma de FILA COLUMNA, por ejemplo = 1 1.\nSolo puedes poner fantasmas en las filas 0, 1 y columnas 1, 2, 3, 4.");

                if (input != null) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        try {
                            int fila = Integer.parseInt(parts[0]);
                            int columna = Integer.parseInt(parts[1]);

                            if ((fila != 1 && fila != 0) || (columna != 1 && columna != 2 && columna != 3 && columna != 4)) {
                                JOptionPane.showMessageDialog(null, "Solo puedes poner fantasmas en las filas 1, 0 y columnas 1, 2, 3, 4.");
                                fantasmasTrampasPuestos2--;
                            } else {
                                if (botones[fila][columna].getText().equals("")) {
                                    botones[fila][columna].setText("fantasmaTrampa2");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ya has puesto un fantasma en esa posicion.");
                                    fantasmasTrampasPuestos2--;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numericos validos para fila y columna.");
                            fantasmasTrampasPuestos2--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ingrese la posicion en el formato correcto.");
                        fantasmasTrampasPuestos2--;
                    }
                }

            }//cierre del for de poner los fantasmas trampas 1

        }//CIERRE DE CUANDO LA DIFICULTAD ES GENIO
        
        
    }

    public void actualizarTurno(JLabel lblTurno) {

        switch (player.turno) {
            case 1:
                lblTurno.setText(player.usuarioLogeado);
                break;
            case 2:
                lblTurno.setText(player.segundoPlayer);
                break;
        }

    }

    public void actualizarTextAreas(JTextArea taPlayer1, JTextArea taPlayer2) {
        taPlayer1.setText("Fantasmas buenos: " + player.contadorFantasmasBuenos1 + "\nFantasmas malos: " + player.contadorFantasmasMalos1);
        taPlayer2.setText("Fantasmas buenos: " + player.contadorFantasmasBuenos2 + "\nFantasmas malos: " + player.contadorFantasmasMalos2);

    }

    public void accionesAlGanar(int fila, int columna) {
        boolean ganaJugador1 = revisarGane1(fila, columna);
        boolean ganaJugador2 = revisarGane2(fila, columna);
        if (ganaJugador1 == true) {
            if (player.contadorFantasmasBuenos2 == 0) {
                JOptionPane.showMessageDialog(null, usuarioLogeado + " triunfo sobre " + segundoPlayer + " porque capturo todos sus fantasmas buenos!");
                MenuPrincipal mp = new MenuPrincipal(login, player);
                player.buscarUsuario(player.usuarioLogeado, 0).setPuntos(3);
                player.buscarUsuario(player.usuarioLogeado, 0).setLogs(usuarioLogeado + " triunfo sobre " + segundoPlayer + " porque capturo todos sus fantasmas buenos!");
                mp.setVisible(true);
                ct.dispose();
                at.dispose();
                

            } else if (player.contadorFantasmasMalos2 == 0) {
                JOptionPane.showMessageDialog(null, usuarioLogeado + " triunfo sobre " + segundoPlayer + " porque capturo todos sus fantasmas malos!");
                MenuPrincipal mp = new MenuPrincipal(login, player);
                player.buscarUsuario(player.usuarioLogeado, 0).setPuntos(3);
                player.buscarUsuario(player.usuarioLogeado, 0).setLogs(usuarioLogeado + " triunfo sobre " + segundoPlayer + " porque capturo todos sus fantasmas malos!");
                mp.setVisible(true);ct.dispose();
                at.dispose();
            } else {
                JOptionPane.showMessageDialog(null, usuarioLogeado + " triunfo al sacar del castillo un fantasma bueno!");
                MenuPrincipal mp = new MenuPrincipal(login, player);
                player.buscarUsuario(player.usuarioLogeado, 0).setPuntos(3);
                player.buscarUsuario(player.usuarioLogeado, 0).setLogs(usuarioLogeado + " triunfo al sacar del castillo un fantasma bueno!");
                mp.setVisible(true);
                ct.dispose();
                at.dispose();
            }

        } else if (ganaJugador2 == true) {
            if (player.contadorFantasmasBuenos1 == 0) {
                JOptionPane.showMessageDialog(null, segundoPlayer + " triunfo sobre " + usuarioLogeado + " porque capturo todos sus fantasmas buenos!");
                MenuPrincipal mp = new MenuPrincipal(login, player);
                player.buscarUsuario(player.segundoPlayer, 0).setPuntos(3);
                player.buscarUsuario(player.segundoPlayer, 0).setLogs(segundoPlayer + " triunfo sobre " + usuarioLogeado + " porque capturo todos sus fantasmas buenos!");
                mp.setVisible(true);
                ct.dispose();
                at.dispose();
            } else if (player.contadorFantasmasMalos1 == 0) {
                JOptionPane.showMessageDialog(null, segundoPlayer + " triunfo sobre " + usuarioLogeado + " porque capturo todos sus fantasmas malos!");
                MenuPrincipal mp = new MenuPrincipal(login, player);
                player.buscarUsuario(player.segundoPlayer, 0).setPuntos(3);
                player.buscarUsuario(player.segundoPlayer, 0).setLogs(segundoPlayer + " triunfo sobre " + usuarioLogeado + " porque capturo todos sus fantasmas malos!");
                mp.setVisible(true);ct.dispose();
                at.dispose();
            } else {
                JOptionPane.showMessageDialog(null, segundoPlayer + " triunfo al sacar del castillo un fantasma bueno!");
                MenuPrincipal mp = new MenuPrincipal(login, player);
                player.buscarUsuario(player.segundoPlayer, 0).setPuntos(3);
                player.buscarUsuario(player.segundoPlayer, 0).setLogs(segundoPlayer + " triunfo al sacar del castillo un fantasma bueno!");
                mp.setVisible(true);
                ct.dispose();
                at.dispose();
            }
        }
    }

    public void ponerFantasmasBuenosAbajo(int fila, int columna) {
        botones[fila][columna].setText("GoodGhost1");
    }

    public void ponerFantasmasBuenosArriba(int fila, int columna) {
        botones[fila][columna].setText("GoodGhost2");
    }

    public void ponerFantasmasMalosArriba(int fila, int columna) {
        botones[fila][columna].setText("BadGhost2");
    }

    public void ponerFantasmasMalosAbajo(int fila, int columna) {
        botones[fila][columna].setText("BadGhost1");
    }

    @Override
    public boolean revisarSiEstaVacio(int posicionX, int posicionY) {
        boolean espaciovacio;

        if (botones[posicionX][posicionY].getText().equals("")) {
            espaciovacio = true;
        } else {
            espaciovacio = false;
        }
        return espaciovacio;
    }

    @Override
    public void colorearSalidas() {
        botones[0][0].setBackground(Color.RED);
        botones[0][5].setBackground(Color.RED);
        botones[5][0].setBackground(Color.GRAY);
        botones[5][5].setBackground(Color.GRAY);

    }

    @Override
    public void hacerMovimientosYTurnos(JButton botonClickeado) {
        //Obtener los datos del primer click
        if (player.turno == 1) {
            if (textoPrimeraFichaSeleccionada.equals("")) {
                vecesClickeadas = 0;
            }

            //obtener datos del primer click turno 1
            if (vecesClickeadas == 1) {
                int x = (int) botonClickeado.getClientProperty("x");
                int y = (int) botonClickeado.getClientProperty("y");
                posicionInicialx = x;
                posicionInicialy = y;
                textoPrimeraFichaSeleccionada = botones[posicionInicialx][posicionInicialy].getText();
                if (!textoPrimeraFichaSeleccionada.equals("GoodGhost1") && !textoPrimeraFichaSeleccionada.equals("BadGhost1") && !textoPrimeraFichaSeleccionada.equals("fantasmaTrampa1")) {
                    JOptionPane.showMessageDialog(null, "No puedes mover fantasmas del oponente.");
                    vecesClickeadas = 0;
                }

            }
            //Obtener los datos del segundo click turno 1
            if (vecesClickeadas == 2) {
                int x = (int) botonClickeado.getClientProperty("x");
                int y = (int) botonClickeado.getClientProperty("y");
                posicionFinalx = x;
                posicionFinaly = y;
                textoSegundaFichaSeleccionada = botones[posicionFinalx][posicionFinaly].getText();
                vecesClickeadas = 0;
                if (!textoSegundaFichaSeleccionada.equals("SALIDA")) {

                }
                //Si le dan click a una ficha vacia (SI hace movimiento)
                if (textoSegundaFichaSeleccionada.equals("")
                        && esMovimientoValido(posicionInicialx, posicionInicialy, posicionFinalx, posicionFinaly, textoPrimeraFichaSeleccionada) == true) {

                    botones[posicionInicialx][posicionInicialy].setText("");
                    botones[posicionFinalx][posicionFinaly].setText(textoPrimeraFichaSeleccionada);
                    vecesClickeadas = 0;
                    player.turno = 2;
                    
                    ct.setVisible(true);
                    at.hide();
                } else if (textoPrimeraFichaSeleccionada.equals(textoSegundaFichaSeleccionada)) {
                    JOptionPane.showMessageDialog(null, "No puedes moverte al mismo lugar.");
                    vecesClickeadas = 0;
                    //si no es movimiento valido
                } else if (esMovimientoValido(posicionInicialx, posicionInicialy, posicionFinalx, posicionFinaly, textoPrimeraFichaSeleccionada) == false) {
                    JOptionPane.showMessageDialog(null, "Movimiento invalido.");
                    vecesClickeadas = 0;

                    //Si no se esta intentando comer sus propios fantasmas
                } else if (!textoSegundaFichaSeleccionada.equals("") && !textoSegundaFichaSeleccionada.equals("BadGhost1")
                        && !textoSegundaFichaSeleccionada.equals("GoodGhost1") && !textoSegundaFichaSeleccionada.equals("fantasmaTrampa1")) {

                    if (textoSegundaFichaSeleccionada.equals("GoodGhost2")) {
                        player.contadorFantasmasBuenos2--;
                        mensajeComida(textoSegundaFichaSeleccionada);
                        player.turno = 2;
                    ct.setVisible(true);
                    at.hide();
                    }
                    if (textoSegundaFichaSeleccionada.equals("BadGhost2")) {

                        player.contadorFantasmasMalos2--;
                        mensajeComida(textoSegundaFichaSeleccionada);
                        player.turno = 2;
                    ct.setVisible(true);
                    at.hide();
                    }
                    //Elimina ambos fantasmas trampas si alguno de ellos se intenta comer
                    if ((textoPrimeraFichaSeleccionada.equals("fantasmaTrampa1") || textoPrimeraFichaSeleccionada.equals("fantasmaTrampa2")) && (textoSegundaFichaSeleccionada.equals("fantasmaTrampa1") || textoSegundaFichaSeleccionada.equals("fantasmaTrampa2"))) {
                        botones[posicionFinalx][posicionFinaly].setText("");
                        botones[posicionInicialx][posicionInicialy].setText("");
                        player.turno = 2;
                    ct.setVisible(true);
                    at.hide();
                    }
                    if (!textoPrimeraFichaSeleccionada.equals("fantasmaTrampa1") && !textoPrimeraFichaSeleccionada.equals("fantasmaTrampa2")) {
                        botones[posicionFinalx][posicionFinaly].setText(textoPrimeraFichaSeleccionada);
                        botones[posicionInicialx][posicionInicialy].setText("");
                        vecesClickeadas = 0;
                        player.turno = 2;
                    ct.setVisible(true);
                    at.hide();

                    } else {
                        botones[posicionInicialx][posicionInicialy].setText("");
                        player.turno = 2;
                    ct.setVisible(true);
                    at.hide();
                    }
                }

                vecesClickeadas = 0;
            }

        }

        //Obtener los datos del primer click
        if (player.turno == 2) {
            if (textoPrimeraFichaSeleccionada.equals("")) {
                vecesClickeadas = 0;
            }

            //obtener datos del primer clic turno 2
            if (vecesClickeadas == 1) {
                int x = (int) botonClickeado.getClientProperty("x");
                int y = (int) botonClickeado.getClientProperty("y");
                posicionInicialx = x;
                posicionInicialy = y;
                textoPrimeraFichaSeleccionada = botones[posicionInicialx][posicionInicialy].getText();
                if (!textoPrimeraFichaSeleccionada.equals("GoodGhost2") && !textoPrimeraFichaSeleccionada.equals("BadGhost2") && !textoPrimeraFichaSeleccionada.equals("fantasmaTrampa2")) {
                    JOptionPane.showMessageDialog(null, "No puedes mover fantasmas del oponente.");
                    vecesClickeadas = 0;
                }

            }
            //Obtener los datos del segundo click turno 2
            if (vecesClickeadas == 2) {
                int x = (int) botonClickeado.getClientProperty("x");
                int y = (int) botonClickeado.getClientProperty("y");
                posicionFinalx = x;
                posicionFinaly = y;
                textoSegundaFichaSeleccionada = botones[posicionFinalx][posicionFinaly].getText();
                vecesClickeadas = 0;
                //Si le dan click a una ficha vacia (SI hace movimiento)
                if (textoSegundaFichaSeleccionada.equals("")
                        && esMovimientoValido(posicionInicialx, posicionInicialy, posicionFinalx, posicionFinaly, textoPrimeraFichaSeleccionada) == true) {
                    botones[posicionInicialx][posicionInicialy].setText("");
                    botones[posicionFinalx][posicionFinaly].setText(textoPrimeraFichaSeleccionada);
                    vecesClickeadas = 0;
                    player.turno = 1;
                    ct.setVisible(true);
                    at.hide();

                    //Cuando se intenta mover al mismo lugar
                } else if (textoPrimeraFichaSeleccionada.equals(textoSegundaFichaSeleccionada)) {
                    JOptionPane.showMessageDialog(null, "No puedes moverte al mismo lugar.");
                    vecesClickeadas = 0;
                } else if (esMovimientoValido(posicionInicialx, posicionInicialy, posicionFinalx, posicionFinaly, textoPrimeraFichaSeleccionada) == false) {
                    JOptionPane.showMessageDialog(null, "Movimiento invalido.");
                    vecesClickeadas = 0;
                    //por si se intenta comer sus propios fantasmas
                } else if (!textoSegundaFichaSeleccionada.equals("") && !textoSegundaFichaSeleccionada.equals("BadGhost2")
                        && !textoSegundaFichaSeleccionada.equals("GoodGhost2") && !textoSegundaFichaSeleccionada.equals("fantasmaTrampa2")) {
                    if (textoSegundaFichaSeleccionada.equals("GoodGhost1")) {

                        //se elimina el fantasma trampa
                        if (!textoPrimeraFichaSeleccionada.equals("fantasmaTrampa2")) {
                            player.contadorFantasmasBuenos1--;
                            mensajeComida(textoSegundaFichaSeleccionada);
                            player.turno = 1;
                    ct.setVisible(true);
                    at.hide();
                        }
                    } else if (textoSegundaFichaSeleccionada.equals("BadGhost1")) {
                        if (!textoPrimeraFichaSeleccionada.equals("fantasmaTrampa2")) {
                            player.contadorFantasmasMalos1--;
                            mensajeComida(textoSegundaFichaSeleccionada);
                            player.turno = 1;
                    ct.setVisible(true);
                    at.hide();
                        }
                    }
                    //si se intentan comer entre los trampas se eliminan ambos
                    if ((textoPrimeraFichaSeleccionada.equals("fantasmaTrampa1") || textoPrimeraFichaSeleccionada.equals("fantasmaTrampa2")) && (textoSegundaFichaSeleccionada.equals("fantasmaTrampa1") || textoSegundaFichaSeleccionada.equals("fantasmaTrampa2"))) {
                        botones[posicionFinalx][posicionFinaly].setText("");
                        botones[posicionInicialx][posicionInicialy].setText("");
                        player.turno = 1;
                    ct.setVisible(true);
                    at.hide();
                    }
                    if (!textoPrimeraFichaSeleccionada.equals("fantasmaTrampa1") && !textoPrimeraFichaSeleccionada.equals("fantasmaTrampa2")) {
                        botones[posicionFinalx][posicionFinaly].setText(textoPrimeraFichaSeleccionada);
                        botones[posicionInicialx][posicionInicialy].setText("");
                        vecesClickeadas = 0;
                        player.turno = 1;
                    ct.setVisible(true);
                    at.hide();

                    } else {
                        botones[posicionInicialx][posicionInicialy].setText("");
                        player.turno = 1;
                    ct.setVisible(true);
                    at.hide();
                    }
                }
                vecesClickeadas = 0;
                ponerImagenes();
            }
        }

        //verificar esquinas de la parte de arriba
        if (!botones[0][0].getText().equals("") || !botones[0][5].getText().equals("")) {
            if (!botones[0][0].getText().equals("GoodGhost1") && !botones[0][0].getText().equals("")) {
                JOptionPane.showMessageDialog(null, "UN FANTASMA HA ESCAPADO! PERO NO ERA BUENO...");
                botones[0][0].setText("");
                if (textoPrimeraFichaSeleccionada.equals("GoodGhost2")) {
                    player.contadorFantasmasBuenos2--;
                }
                if (textoPrimeraFichaSeleccionada.equals("BadGhost2")) {
                    player.contadorFantasmasMalos2--;
                }
                if (textoPrimeraFichaSeleccionada.equals("BadGhost1")) {
                    player.contadorFantasmasMalos1--;
                }
                if (textoPrimeraFichaSeleccionada.equals("GoodGhost1")) {
                    player.contadorFantasmasBuenos1--;
                }
            }
            if (!botones[0][5].getText().equals("GoodGhost1") && !botones[0][5].getText().equals("")) {
                JOptionPane.showMessageDialog(null, "UN FANTASMA HA ESCAPADO! PERO NO ERA BUENO...");
                botones[0][5].setText("");
                if (textoPrimeraFichaSeleccionada.equals("GoodGhost2")) {
                    player.contadorFantasmasBuenos2--;
                }
                if (textoPrimeraFichaSeleccionada.equals("BadGhost2")) {
                    player.contadorFantasmasMalos2--;
                }
                 if (textoPrimeraFichaSeleccionada.equals("BadGhost1")) {
                    player.contadorFantasmasMalos1--;
                }
                if (textoPrimeraFichaSeleccionada.equals("GoodGhost1")) {
                    player.contadorFantasmasBuenos1--;
                }
            }
        }

        //verificar esquinas de la parte de abajo
        if (!botones[5][0].getText().equals("") || !botones[5][5].getText().equals("")) {
            if (!botones[5][0].getText().equals("GoodGhost2") && !botones[5][0].getText().equals("")) {
                JOptionPane.showMessageDialog(null, "UN FANTASMA HA ESCAPADO! PERO NO ERA BUENO...");
                botones[5][0].setText("");
                if (textoPrimeraFichaSeleccionada.equals("GoodGhost1")) {
                    player.contadorFantasmasBuenos1--;
                }
                if (textoPrimeraFichaSeleccionada.equals("BadGhost1")) {
                    player.contadorFantasmasMalos1--;
                }
                 if (textoPrimeraFichaSeleccionada.equals("BadGhost2")) {
                    player.contadorFantasmasMalos2--;
                }
                if (textoPrimeraFichaSeleccionada.equals("GoodGhost2")) {
                    player.contadorFantasmasBuenos2--;
                }

            }
            if (!botones[5][5].getText().equals("GoodGhost2") && !botones[5][5].getText().equals("")) {
                JOptionPane.showMessageDialog(null, "UN FANTASMA HA ESCAPADO! PERO NO ERA BUENO...");
                botones[5][5].setText("");
                if (textoPrimeraFichaSeleccionada.equals("GoodGhost1")) {
                    player.contadorFantasmasBuenos1--;
                }
                if (textoPrimeraFichaSeleccionada.equals("BadGhost1")) {
                    player.contadorFantasmasMalos1--;
                }
                 if (textoPrimeraFichaSeleccionada.equals("BadGhost2")) {
                    player.contadorFantasmasMalos2--;
                }
                if (textoPrimeraFichaSeleccionada.equals("GoodGhost2")) {
                    player.contadorFantasmasBuenos2--;
                }
            }
        }

    }

    @Override
    public void ponerImagenes() {
        
        if(player.modo.equals("MANUAL")){
            ImageIcon imageIcon1 = new ImageIcon(urlImagen1);
        ImageIcon imageIcon2 = new ImageIcon(urlImagen2);
        ImageIcon imageIconNeutra = new ImageIcon(urlImagenNeutra);
        ImageIcon imageIconTrampa = new ImageIcon(urlImagenTrampa);

        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                botonProbando = botones[fila][columna];
                String botonTexto = botonProbando.getText();

                if (player.turno == 1) {
                    if (botonTexto.equals("GoodGhost1")) {
                        aplicarImagen(botonProbando, imageIcon1);
                    } else if (botonTexto.equals("BadGhost1")) {
                        aplicarImagen(botonProbando, imageIcon2);
                    } else if (!botonTexto.equals("GoodGhost1") && !botonTexto.equals("BadGhost1") && !botonTexto.equals("fantasmaTrampa1") && !botonTexto.equals("")) {
                        aplicarImagen(botonProbando, imageIconNeutra);
                    } else if (botonTexto.equals("fantasmaTrampa1") || botonTexto.equals("fantasmaTrampa2")) {
                        aplicarImagen(botonProbando, imageIconTrampa);
                    } else if (botonTexto.equals("")) {
                        botonProbando.setIcon(null);
                    }
                } else if (player.turno == 2) {
                    if (botonTexto.equals("GoodGhost2")) {
                        aplicarImagen(botonProbando, imageIcon1);
                    } else if (botonTexto.equals("BadGhost2")) {
                        aplicarImagen(botonProbando, imageIcon2);
                    } else if (!botonTexto.equals("GoodGhost2") && !botonTexto.equals("BadGhost2") && !botonTexto.equals("fantasmaTrampa2") && !botonTexto.equals("")) {
                        aplicarImagen(botonProbando, imageIconNeutra);
                    } else if (botonTexto.equals("fantasmaTrampa1") || botonTexto.equals("fantasmaTrampa2")) {
                        aplicarImagen(botonProbando, imageIconTrampa);
                    } else if (botonTexto.equals("")) {
                        botonProbando.setIcon(null);
                    }
                }
            }
        }
        }else{
            
            ImageIcon imageIcon1 = new ImageIcon(urlImagen1);
        ImageIcon imageIcon2 = new ImageIcon(urlImagen2);
        ImageIcon imageIconNeutra = new ImageIcon(urlImagenNeutra);
        ImageIcon imageIconTrampa = new ImageIcon(urlImagenTrampa);

        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                botonProbando = botones[fila][columna];
                String botonTexto = botonProbando.getText();

                if (player.turno == 1) {
                    if (botonTexto.equals("GoodGhost1")) {
                        aplicarImagen(botonProbando, imageIconTrampa);
                    } else if (botonTexto.equals("BadGhost1")) {
                        aplicarImagen(botonProbando, imageIconTrampa);
                    } else if (!botonTexto.equals("GoodGhost1") && !botonTexto.equals("BadGhost1") && !botonTexto.equals("fantasmaTrampa1") && !botonTexto.equals("")) {
                        aplicarImagen(botonProbando, imageIconNeutra);
                    } else if (botonTexto.equals("fantasmaTrampa1") || botonTexto.equals("fantasmaTrampa2")) {
                        aplicarImagen(botonProbando, imageIconTrampa);
                    } else if (botonTexto.equals("")) {
                        botonProbando.setIcon(null);
                    }
                } else if (player.turno == 2) {
                    if (botonTexto.equals("GoodGhost2")) {
                        aplicarImagen(botonProbando, imageIconTrampa);
                    } else if (botonTexto.equals("BadGhost2")) {
                        aplicarImagen(botonProbando, imageIconTrampa);
                    } else if (!botonTexto.equals("GoodGhost2") && !botonTexto.equals("BadGhost2") && !botonTexto.equals("fantasmaTrampa2") && !botonTexto.equals("")) {
                        aplicarImagen(botonProbando, imageIconNeutra);
                    } else if (botonTexto.equals("fantasmaTrampa1") || botonTexto.equals("fantasmaTrampa2")) {
                        aplicarImagen(botonProbando, imageIconTrampa);
                    } else if (botonTexto.equals("")) {
                        botonProbando.setIcon(null);
                    }
                }
            }
        }
            
        }
        
    }

    private void aplicarImagen(JButton boton, ImageIcon imageIcon) {
        int width = boton.getWidth();
        int height = boton.getHeight();
        Image image = imageIcon.getImage();
        ImageIcon resizedIcon = new ImageIcon(image);
        boton.setIcon(resizedIcon);
    }

    @Override
    public final boolean revisarGane1(int fila, int columna) {
        if (botones[0][0].getText().equals("GoodGhost1") || botones[0][5].getText().equals("GoodGhost1")) {
            return true;
        } else if (player.contadorFantasmasBuenos2 == 0) {
            return true;
        } else if (player.contadorFantasmasMalos2 == 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public final boolean revisarGane2(int fila, int columna) {
        if (botones[5][0].getText().equals("GoodGhost2") || botones[5][5].getText().equals("GoodGhost2")) {
            return true;
        } else if (player.contadorFantasmasBuenos1 == 0) {
            return true;
        } else if (player.contadorFantasmasMalos1 == 0) {
            return true;
        } else {
            return false;
        }

    }

    public final void mensajeComida(String textoSegundaFicha) {
        if (textoSegundaFicha.equals("BadGhost2")) {
            JOptionPane.showMessageDialog(null, "TE HAS COMIDO UN FANTASMA MALO DE " + segundoPlayer + "!");
        }
        if (textoSegundaFicha.equals("GoodGhost2")) {
            JOptionPane.showMessageDialog(null, "TE HAS COMIDO UN FANTASMA BUENO DE " + segundoPlayer + "!");
        }
        if (textoSegundaFicha.equals("GoodGhost1")) {
            JOptionPane.showMessageDialog(null, "TE HAS COMIDO UN FANTASMA BUENO DE " + usuarioLogeado + "!");
        }
        if (textoSegundaFicha.equals("BadGhost1")) {
            JOptionPane.showMessageDialog(null, "TE HAS COMIDO UN FANTASMA MALO DE " + usuarioLogeado + "!");
        }
        if (textoSegundaFicha.equals("fantasmaTrampa1") || textoSegundaFicha.equals("fantasmaTrampa2")) {
            JOptionPane.showMessageDialog(null, "TE COMISTE UN FANTASMA TRAMPA!");
        }
    }

    @Override
    public void ponerFantasmasAlAzar() {

        Random nAzar = new Random();
        int numeroAlAzarFila = 0;
        int numeroAlAzarColumna = 0;

        if (player.dificultad.equals("NORMAL")) {
            //Poner los fantasmas buenos de abajo
            for (int i = 0; i < 4; i++) {
                numeroAlAzarFila = nAzar.nextInt(4, 6);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasBuenosAbajo(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }

            //Poner los fantasmas buenos de arriba
            for (int i = 0; i < 4; i++) {
                numeroAlAzarFila = nAzar.nextInt(0, 2);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasBuenosArriba(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }

            //Poner los fantasmas malos de abajo
            for (int i = 0; i < 4; i++) {
                numeroAlAzarFila = nAzar.nextInt(4, 6);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasMalosAbajo(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }

            //Poner los fantasmas malos de arriba
            for (int i = 0; i < 4; i++) {
                numeroAlAzarFila = nAzar.nextInt(0, 2);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasMalosArriba(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }
        } else if (player.dificultad.equals("EXPERTO")) {
            //Poner los fantasmas buenos de abajo
            for (int i = 0; i < 2; i++) {
                numeroAlAzarFila = nAzar.nextInt(4, 6);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasBuenosAbajo(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }

            //Poner los fantasmas buenos de arriba
            for (int i = 0; i < 2; i++) {
                numeroAlAzarFila = nAzar.nextInt(0, 2);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasBuenosArriba(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }

            //Poner los fantasmas malos de abajo
            for (int i = 0; i < 2; i++) {
                numeroAlAzarFila = nAzar.nextInt(4, 6);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasMalosAbajo(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }

            //Poner los fantasmas malos de arriba
            for (int i = 0; i < 2; i++) {
                numeroAlAzarFila = nAzar.nextInt(0, 2);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasMalosArriba(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }
        } else if (player.dificultad.equals("GENIO")) {

            //Poner los fantasmas buenos de abajo
            for (int i = 0; i < 1; i++) {
                numeroAlAzarFila = nAzar.nextInt(4, 6);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasBuenosAbajo(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }

            //Poner los fantasmas buenos de arriba
            for (int i = 0; i < 1; i++) {
                numeroAlAzarFila = nAzar.nextInt(0, 2);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasBuenosArriba(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }

            //Poner los fantasmas malos de abajo
            for (int i = 0; i < 1; i++) {
                numeroAlAzarFila = nAzar.nextInt(4, 6);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasMalosAbajo(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }

            //Poner los fantasmas malos de arriba
            for (int i = 0; i < 1; i++) {
                numeroAlAzarFila = nAzar.nextInt(0, 2);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    ponerFantasmasMalosArriba(numeroAlAzarFila, numeroAlAzarColumna);
                } else {
                    i--;
                }
            }

            //Poner los fantasmas trampa de arriba
            for (int i = 0; i < 4; i++) {
                numeroAlAzarFila = nAzar.nextInt(0, 2);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    botones[numeroAlAzarFila][numeroAlAzarColumna].setText("fantasmaTrampa2");
                } else {
                    i--;
                }
            }

            //Poner los fantasmas trampa de abajo
            for (int i = 0; i < 4; i++) {
                numeroAlAzarFila = nAzar.nextInt(4, 6);
                numeroAlAzarColumna = nAzar.nextInt(1, 5);
                boolean estaVacio = revisarSiEstaVacio(numeroAlAzarFila, numeroAlAzarColumna);
                if (estaVacio == true) {
                    botones[numeroAlAzarFila][numeroAlAzarColumna].setText("fantasmaTrampa1");
                } else {
                    i--;
                }
            }
        }
    }

}
