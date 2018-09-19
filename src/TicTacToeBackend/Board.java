package TicTacToeBackend;


import java.util.Scanner;

public class Board {

    //Deklarere instance variabler.
    private char[][] board; //Spillet brættet, lavet af et 2 dimensionelt Array.
    private boolean xTurn; //Sandt hvis det er X's tur, false hvis det er O's tur.
    private Scanner input; //Scanner der taget imod input til vores spil.

    // Constructor der sætter det op så spillet kan køre.

    public Board() {

        //Laver brættet
        board = new char[3][3];

        //Initialisere brættet for alle pladser.
        for (int r = 0; r < 3; r++) {

            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';
        }

        //Sikre det er X's tur når vi starter spillet.
        xTurn = true;

        //create our keyboard object
        input = new Scanner(System.in);
    }

    //Viser en enkelt Row fra spille brættet specificeret af row parameteren.


    private void visRow(int row) {

        System.out.println(" " + board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
    }


    //Viser hele spille brættet.

    private void visBoard() {

        visRow(0);
        System.out.println("-----------");
        visRow(1);
        System.out.println("-----------");
        visRow(2);
    }


    //Viser basis menu tilgængelig for spilleren.

    private void visMenu() {

        //Printer hvis tur det er
        if (xTurn)
            System.out.println("X's Tur!");
        else
            System.out.println("O's Tur!");

        //print the options menu
        System.out.println("Hvad vil du gerne gøre?");
        System.out.println("1: MAKE A MOVE");
        System.out.println("2: Start forfra");
        System.out.println("3: End game.");
        System.out.print("Vælg: ");
    }

    /*
     * Modtaget position fra useren om hvor næste move skal laves.
     *
     * Brættet opdateres når et valid move er lavet.
     *
     * Returnere true hvis der er en vinder, og false hvis der ikke er en vinder.
     *
     */

    private boolean getMove() {

        boolean invalid = true;
        int row = 0, column = 0;

        //While loop der bliver ved med at spørger for en position indtil spiller laver et valid move.
        while (invalid) {

            System.out.println("Hvilken row, column vil du gerne placere din brik på? Indtast 2 tal mellem 0-2, seperarede med et mellemrum for at indikere position");
            row = input.nextInt();
            column = input.nextInt();

            //Tjekker om positionen er uden for brættet.
            if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {

                //Thekker om positionen allerede er optaget.
                if (board[row][column] != ' ')
                    System.out.println("Denne position er allerede taget.");
                else
                    invalid = false;
            } else
                System.out.println("Denne position er ikke inden for brættes spille rammer.");
        }

        //Udfylder brættet med enten X eller O såfremt det er en valid position.
        if (xTurn)
            board[row][column] = 'X';
        else
            board[row][column] = 'O';

        return winner(row, column);
    }

    //Genstarter spillet ved at resette alle variabler.

    private void restart() {

        //Tømmer spille brættet.
        for (int r = 0; r < 3; r++) {

            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';
        }

        //Nulstiller hvis tur det er.
        xTurn = true;
    }


    //Denne metode returnere true hvis det sidste move resulterede i et win.
    //Dette laves ud fra den sidste row og column.

    private boolean winner(int lastR, int lastC) {

        boolean winner = false; //Antget som udgangs punkt der ingen vinder er.
        char symbol = board[lastR][lastC]; //Symbol for sidste move er enten X eller O.

        //Tjekker venstre-højre.
        //Sidste move vi lavede, var i row lastR - tjekker denne row for 3 af samme symbol.
        int numFound = 0;
        for (int c = 0; c < 3; c++) {
            if (board[lastR][c] == symbol)
                numFound++;
        }

        if (numFound == 3)
            winner = true;

        //Tjekker op-ned
        //Sidste move vi lavede, var i row lastR - tjekker denne row for 3 af samme symbol.
        numFound = 0;
        for (int r = 0; r < 3; r++) {
            if (board[r][lastC] == symbol)
                numFound++;
        }

        if (numFound == 3)
            winner = true;

        //Tjekker begge diagonaler.
        numFound = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == symbol)
                numFound++;
        }

        if (numFound == 3)
            winner = true;

        numFound = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][2 - i] == symbol)
                numFound++;
        }

        if (numFound == 3)
            winner = true;

        return winner;
    }

    /*
     * Tjekker om brættet er fuld, og spillet er slit.
     *
     * Returnere true hvis ddet er fuld.
     */

    private boolean boardFull() {

        //Tjekker efter hvor mange spille pladser der er taget af enten X eller O
        int numSpotsFilled = 0;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == 'X' || board[r][c] == 'O')
                    numSpotsFilled++;
            }
        }

        return numSpotsFilled == 9;
    }

    /*
     * Metode til at starte spillet.
     */

    public void play() {

        while (true) {

            visBoard();
            visMenu();

            int choice = input.nextInt();

            if (choice == 1) {

                if (getMove()) {
                    //Vi har en vinder!
                    visBoard();    //Viser brættet en sidste gang.

                    if (xTurn)
                        System.out.println("X vandt!");
                    else
                        System.out.println("O vandt!");

                    System.exit(0);
                } else if (boardFull()) {
                    //Det blev udafgjordt.
                    visBoard(); //Viser brættet en sidste gang.

                    System.out.println("Udafgjordt!");

                    System.exit(0);
                } else {
                    //Ingen vinder endnu.
                    xTurn = !xTurn;  //Skiftet hvis tur det er.
                }
            } else if (choice == 2)
                restart();
            else if (choice == 3)
                System.exit(0);    //quit
            else
                System.out.println("Ugyldig mulighed.");
        }

    }
}
