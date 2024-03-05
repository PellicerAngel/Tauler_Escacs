//Àngel Pellicer Grau
package escacs;

import Teclat.*;

public class escacsPellicerÀngel {

    static final char MOVIMENT = '*';
    static final char BUIT = '_';

    private static void iniciarTauler(char[][] tauler) {

        // OMPLIR EL TAULER DE BUITS
        for (int fil = 1; fil < tauler.length; fil++) {

            for (int colum = 1; colum < tauler[0].length; colum++) {
                tauler[fil][colum] = BUIT;

            }

        }
    }

    private static void Torre(char[][] tauler, int FILES, int posicio_fitxa_fila, int posicio_fitxa_columna, int COLUMNES) {

        for (int recorre_files = posicio_fitxa_fila + 1; recorre_files <= FILES; recorre_files++) {
            if (tauler[recorre_files][posicio_fitxa_columna] == BUIT || tauler[recorre_files][posicio_fitxa_columna] == MOVIMENT) {

                tauler[recorre_files][posicio_fitxa_columna] = MOVIMENT;

            } else {
                break;
            }

        }

        for (int recorre_columnes = posicio_fitxa_columna + 1; recorre_columnes <= COLUMNES; recorre_columnes++) {
            if (tauler[posicio_fitxa_fila][recorre_columnes] == MOVIMENT || tauler[posicio_fitxa_fila][recorre_columnes] == BUIT) {
                tauler[posicio_fitxa_fila][recorre_columnes] = MOVIMENT;
            } else {
                break;
            }

        }

        for (int recorre_files = posicio_fitxa_fila - 1; recorre_files > 0; recorre_files--) {
            if (tauler[recorre_files][posicio_fitxa_columna] == BUIT || tauler[recorre_files][posicio_fitxa_columna] == MOVIMENT) {

                tauler[recorre_files][posicio_fitxa_columna] = MOVIMENT;

            } else {
                break;
            }

        }

        for (int recorre_columnes = posicio_fitxa_columna - 1; recorre_columnes > 0; recorre_columnes--) {
            if (tauler[posicio_fitxa_fila][recorre_columnes] == MOVIMENT || tauler[posicio_fitxa_fila][recorre_columnes] == BUIT) {
                tauler[posicio_fitxa_fila][recorre_columnes] = MOVIMENT;
            } else {
                break;
            }

        }

    }

    private static void Cavall(char[][] tauler, int FILES, int posicio_fitxa_fila, int posicio_fitxa_columna, int COLUMNES) {
        int[] movimentsFila = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] movimentsColumna = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < 8; i++) {
            int novaFila = posicio_fitxa_fila + movimentsFila[i];
            int novaColumna = posicio_fitxa_columna + movimentsColumna[i];

            if ((tauler[novaFila][novaColumna] == MOVIMENT || tauler[novaFila][novaColumna] == BUIT)) {
                if (novaFila >= 1 && novaFila <= FILES && novaColumna >= 1 && novaColumna <= COLUMNES) {
                    tauler[novaFila][novaColumna] = MOVIMENT;
                }
            }
        }
    }
    
    private static void Alfil(char[][] tauler, int FILES, int posicio_fitxa_fila, int posicio_fitxa_columna, int COLUMNES) {

    for (int i = 1; i <= FILES; i++) {
        int novaFila1 = posicio_fitxa_fila + i;
        int novaFila2 = posicio_fitxa_fila - i;
        int novaColumna1 = posicio_fitxa_columna + i;
        int novaColumna2 = posicio_fitxa_columna - i;

        if (novaFila1 <= FILES && novaColumna1 <= COLUMNES) {
            if (tauler[novaFila1][novaColumna1] == MOVIMENT || tauler[novaFila1][novaColumna1] == BUIT) {
                tauler[novaFila1][novaColumna1] = MOVIMENT;
            } else {
                break;
            }
        }

        if (novaFila2 >= 0 && novaColumna1 <= COLUMNES) {
            if (tauler[novaFila2][novaColumna1] == MOVIMENT || tauler[novaFila2][novaColumna1] == BUIT) {
                tauler[novaFila2][novaColumna1] = MOVIMENT;
            } else {
                break;
            }
        }

        if (novaFila1 <= FILES && novaColumna2 >= 0) {
            if (tauler[novaFila1][novaColumna2] == MOVIMENT || tauler[novaFila1][novaColumna2] == BUIT) {
                tauler[novaFila1][novaColumna2] = MOVIMENT;
            } else {
                break;
            }
        }

        if (novaFila2 >= 0 && novaColumna2 >= 0) {
            if (tauler[novaFila2][novaColumna2] == MOVIMENT || tauler[novaFila2][novaColumna2] == BUIT) {
                tauler[novaFila2][novaColumna2] = MOVIMENT;
            } else {
                break;
            }
        }
    }
}

    
    
    private static void Rei(char[][] tauler, int FILES, int posicio_fitxa_fila, int posicio_fitxa_columna, int COLUMNES) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int novaFila = posicio_fitxa_fila + i;
                int novaColumna = posicio_fitxa_columna + j;

                if ((tauler[novaFila][novaColumna] == MOVIMENT || tauler[novaFila][novaColumna] == BUIT)) {
                    if (novaFila >= 1 && novaFila <= FILES && novaColumna >= 1 && novaColumna <= COLUMNES) {
                        tauler[novaFila][novaColumna] = MOVIMENT;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int posicio_fitxa_fila;
        int posicio_fitxa_columna;
        boolean eixir = false;

        System.out.println("Benvingut a l'aplicacio d'escacs de Àngel Pellicer Grau.");

        System.out.println("    ");

        // CREAR EL TAULER
        final int FILES = Teclat.lligInt("Disme les files del tauler", 5, 9);

        final int COLUMNES = Teclat.lligInt("Disme les columnes del tauler", 5, 9);

        char tauler[][] = new char[FILES + 1][COLUMNES + 1];
        iniciarTauler(tauler);

        while (eixir != true) {

            for (int colum = 1; colum < tauler[0].length; colum++) {

                System.out.print(" " + (colum));

            }

            System.out.println("    ");

            for (int fil = 1; fil < tauler.length; fil++) {

                System.out.print(fil);

                for (int colum = 1; colum < tauler[0].length; colum++) {

                    System.out.print(tauler[fil][colum] + "|");

                }
                System.out.println((fil) + "    ");

            }

            for (int colum = 1; colum < tauler[0].length; colum++) {

                System.out.print(" " + (colum));

            }

            // Mostrar els numerets de baix
            // MOSTRAR MENÚ ------------------------------------------
            System.out.println("    ");
            System.out.println("Opcions dels escacs");
            System.out.println("    ");
            System.out.println("1- Posar una peça");
            System.out.println("2- Mostrar els moviments d'una peça");
            System.out.println("3- Esborrar moviments");
            System.out.println("4- Esborrar tauler");
            System.out.println("5- Eixir");
            System.out.println("    ");

            int opcio = Teclat.lligInt("Tria la opcio que vols ", 1, 5);

            switch (opcio) {
                case 1 -> {
                    //Donem les opcions per a posar les peçes
                    posicio_fitxa_fila = Teclat.lligInt("Disme la fila: ", 1, FILES);
                    System.out.println("    ");
                    posicio_fitxa_columna = Teclat.lligInt("Disme la columna: ", 1, COLUMNES);
                    System.out.println("    ");

                    //Mostrar les Opcions de les peces
                    System.out.println("- Torre = T");
                    System.out.println("- Caball = C");
                    System.out.println("- Alfil = A");
                    System.out.println("- Dama = D");
                    System.out.println("- Rei = R");

                    char peça = Teclat.lligChar("Tria la fitxa ", "TCADR");

                    //Posar la peça en les cordenades anteriors
                    tauler[posicio_fitxa_fila][posicio_fitxa_columna] = peça;
                }

                case 2 -> {
                    //Preguntem les files i les columnes
                    posicio_fitxa_fila = Teclat.lligInt("Disme la fila (1 " + FILES + ")");
                    System.out.println("    ");
                    posicio_fitxa_columna = Teclat.lligInt("Disme la columna (1 " + COLUMNES + ")");
                    System.out.println("    ");

                    if (tauler[posicio_fitxa_fila][posicio_fitxa_columna] != BUIT) {
                        //Cridem els parametres
                        switch (tauler[posicio_fitxa_fila][posicio_fitxa_columna]) {
                            case 'T' -> Torre(tauler, FILES, posicio_fitxa_fila, posicio_fitxa_columna, COLUMNES);

                            case 'C' -> Cavall(tauler, FILES, posicio_fitxa_fila, posicio_fitxa_columna, COLUMNES);
                            case 'A' -> Alfil(tauler, FILES, posicio_fitxa_fila, posicio_fitxa_columna, COLUMNES);
                            case 'D' -> {
                                Torre(tauler, FILES, posicio_fitxa_fila, posicio_fitxa_columna, COLUMNES);
                                Alfil(tauler, FILES, posicio_fitxa_fila, posicio_fitxa_columna, COLUMNES);
                            }
                            case 'R' -> Rei(tauler, FILES, posicio_fitxa_fila, posicio_fitxa_columna, COLUMNES);

                        }
                    } else {
                        System.out.println("Les cordenades que has indicat no tenen ninguna peça");
                    }
                }

                case 3 -> {
                    //Borrem tots els moviments i guardem el numero de borrats
                    int contador_borrats = 0;

                    for (int fil = 1; fil < tauler.length; fil++) {

                        for (int colum = 1; colum < tauler[0].length; colum++) {

                            if (tauler[fil][colum] == MOVIMENT) {
                                tauler[fil][colum] = BUIT;
                                contador_borrats++;
                            }
                        }
                    }

                    System.out.println("Nº moviments esborrats: " + contador_borrats);
                }
                case 4 -> {
                    //Tornem a 0 la maquina
                    for (int fil = 1; fil < tauler.length; fil++) {

                        for (int colum = 1; colum < tauler[0].length; colum++) {
                            tauler[fil][colum] = BUIT;

                        }

                    }

                    System.out.println("El tauler acaba de ser reiniciat ");
                }

                case 5 -> {
                    //Es crea la opcio d'ixir
                    String finalitzar_partida = Teclat.lligString("Vols acabar ja la partida (s/n)? ");

                    if ("s".equals(finalitzar_partida) || "S".equals(finalitzar_partida)) {

                        System.out.println("Adeu, i gracies per jugar.");

                        eixir = true;

                    } else {

                        System.out.println("Seguim en la partida");

                    }
                }
            }

        }

    }

}
