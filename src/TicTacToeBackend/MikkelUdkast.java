package TicTacToeBackend;

import java.util.Scanner;

public class MikkelUdkast {
    // Navne konstanter, der giver værdier til hvilken spiller der er, og til et tomt bræt.
    private static final int TOMT_BRAET = 0;
    private static final int KRYDS = 1;
    private static final int BOLLE = 2;

    // Navne konstanter, der giver værdier til gamestate, og udfaldet af et spil.
    private static final int SPIL_IGANG = 0;
    private static final int UAFGJORT = 1;
    private static final int KRYDS_VANDT = 2;
    private static final int BOLLE_VANDT = 3;

    // Definerer board
    private static final int RAEKKER = 3;
    private static final int KOLONNER = 3;
    private static int[][] board = new int[RAEKKER][KOLONNER];

    // Deklarerer variabler for, at kunne definerer 'nuværende' værdier.
    private static int nuvStatus, nuvSpiller, nuvRaekke, nuvKolonne;

    // Scanner object.
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        initGame();
        do {
            spillerTraek(nuvSpiller);
            //opdaterSpil(nuvSpiller, nuvRaekke, nuvKolonne);
            // Print en besked hvis der er en der har vundet.
            if (nuvStatus == KRYDS_VANDT) {
                System.out.println("Spiller 'KRYDS' vandt! Tak for spillet!");
            } else if (nuvStatus == BOLLE_VANDT) {
                System.out.println("Spiller 'BOLLE' vandt! Tak for spillet!");
            } else if (nuvStatus == UAFGJORT) {
                System.out.println("Det blev uafgjort! Tak for spillet!");
            }
            // Skifter tur, så længe spillet er i gang.
            nuvSpiller = (nuvSpiller == KRYDS) ? BOLLE : KRYDS;
        }
        while (nuvStatus == SPIL_IGANG);
    }

    // Starter spillet med et tomt bræt (arrayets værdier sættes til 0)
    public static void initGame() {
        for (int raekke = 0; raekke < RAEKKER; raekke++) {
            for (int kolonne = 0; kolonne < KOLONNER; kolonne++) {
                board[raekke][kolonne] = TOMT_BRAET;
            }
        }
        nuvStatus = SPIL_IGANG;
        nuvSpiller = KRYDS;
    }

    public static void spillerTraek(int nuvTur) {
        boolean traek = false;
        do {
            if (nuvTur == KRYDS) {
                System.out.println("Spiller 'KRYDS', lav dit træk. Række: 1-3 Kolonne: 1-3.");
            } else {
                System.out.println("Spiller 'BOLLE', lav dit træk. Række: 1-3 Kolonne: 1-3.");
            }
            int raekke = in.nextInt() - 1;
            int kolonne = in.nextInt() - 1;

            if (raekke >= 0 && raekke < RAEKKER && kolonne >= 0 && kolonne < KOLONNER && board[raekke][kolonne] == TOMT_BRAET) {
                nuvRaekke = raekke;
                nuvKolonne = kolonne;
                board[nuvRaekke][nuvKolonne] = nuvTur;

                // Hvis inputtet er i orden, accepteres det.
                traek = true;
            } else {
                System.out.println("Trækket, der indebærer: (" + (raekke + 1) + "," + (kolonne + 1) + ") kan ikke laves. Prøv et andet træk. ");
            }
        } while (!traek); // Hele dette do loop gentages indtil, det indput man indtaster, kan godtages.

    }

    // Opdatere spillet løbende, når en spiller har lavet et træk.
    public static void opdaterSpil(int traek, int nuvRaekke, int nuvKolonne) {
        if (harVundet(traek, nuvRaekke, nuvKolonne)) {
            nuvStatus = (traek == KRYDS) ? KRYDS_VANDT : BOLLE_VANDT;
        } else if (erUafgjort()) {
            nuvStatus = UAFGJORT;
        }
    }

    public static boolean harVundet(int traek, int nuvRaekke, int nuvKolonne) {
        return (board[nuvRaekke][0] == traek
                    && board[nuvRaekke][1] == traek
                    && board[nuvRaekke][2] == traek
                || board[0][nuvKolonne] == traek
                    && board[1][nuvKolonne] == traek
                    && board[2][nuvKolonne] == traek
                || nuvRaekke == nuvKolonne
                    && board[0][0] == traek
                    && board[1][1] == traek
                    && board[2][2] == traek
                || nuvRaekke + nuvKolonne == 2
                    && board[0][2] == traek
                    && board[1][1] == traek
                    && board[2][0] == traek);
    }
    public static boolean erUafgjort(){
        for (int raekke = 0; raekke < RAEKKER; ++raekke) {
            for (int kolonne = 0; kolonne < KOLONNER; ++kolonne){
                if (board[raekke][kolonne] == TOMT_BRAET){
                    return false;       // Dette skal finde en tom plads på brættet. Hvis der er en tom, skal spillet fortsætte.
                }
            }
        }
        return true;
    }
public static void lavBoard(){
        for (int raekke = 0; raekke < RAEKKER; ++raekke){
            for (int kolonne = 0; kolonne < KOLONNER; ++kolonne){
            printPlads(board[raekke][kolonne]);     // Printer pladserne.
            if (kolonne != KOLONNER - 1) {
                System.out.println("|");        // Printer den lodrette del af brættet.
            }
            }
            System.out.println();
            if (raekke != RAEKKER - 1){
                System.out.println("---------------");  // Printer den vandrette del af brættet
            }
        }
}
public static void printPlads(int brikker){
        switch (brikker){
            case TOMT_BRAET: System.out.println("   ");
            case KRYDS: System.out.println(" X ");
            case BOLLE: System.out.println(" O ");
        }
    }
}

