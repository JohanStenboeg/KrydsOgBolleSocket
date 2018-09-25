package TicTacToeBackend;

public class Logik {

    //Deklarere instance variabler.
    TicPrint ticprint = new TicPrint();
    private char[] bræt = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}; //Spille brættet, lavet af et single array.
    private boolean xTurn; //Sandt hvis det er X's tur, false hvis det er O's tur.
    private boolean winnerX = false; // Antager som udgangspunkt at X ikke har vundet.
    private boolean winnerO = false; // Antager som udgangspunkt at O ikke har vundet.
    private boolean draw = false; // Antager som udgangspunkt det ikke er draw.
    private String result = ""; // Resultat


    private boolean returnIkkeBoards = false;
    private String andenMessage = "Fejl";
    private boolean canWeDoIt = true;

    public String getPrintBræt() {
        return ticprint.printboard(bræt);
    }

    //Metode til at placere et X eller O i brættet.
    public String play(int input, boolean xTurn){
        returnIkkeBoards = false;
        canWeDoIt = true;

        //Tjekker om positionen er uden for brættet.
        if (input >= 0 && input <= 8) {
            System.out.println("Hasagi");
            //Tjekker om positionen allerede er optaget.
            if (bræt[input] != ' '){
                andenMessage= "Denne position er allerede taget.";

                returnIkkeBoards = true;
                canWeDoIt = false;
            }
        } else {
            andenMessage = "Denne position er ikke inden for brættes spille rammer.";
            returnIkkeBoards = true;
            canWeDoIt = false;
        }


        if(canWeDoIt==true) {
            //Udfylder brættet med enten X eller O såfremt det er en valid position.
            if (xTurn)
                bræt[input] = 'X';
            else
                bræt[input] = 'O';
        }
        System.out.println(checkIfOver());

        if(returnIkkeBoards==true){
            return andenMessage;

        }else if(winnerX==true || winnerO == true ||draw==true){
            return checkIfOver();
        }
        else {
            return ticprint.printboard(bræt);
        }
    }


    public String checkIfOver() {
        char checkX = 'X';
        char checkO = 'O';
        int sumX = 0;
        int sumO = 0;
        int sumDraw = 0;

        //Start på tjek af X
        // Denne tjekker 0 1 2. Er Done.
        // checker for x
        for (int x = 0; x < 3; x++) {
            if (bræt[x] == checkX) {
                sumX++;
                System.out.println("1 "+ x);
            }

        }

        if (sumX == 3) {
            winnerX = true;
        }
        // Denne skal tjekke 3 4 5
        // checker for x
        sumX = 0;



        for (int x = 3; x < 6; x++) {
            if (bræt[x] == checkX) {
                System.out.println("2"+sumX);

                sumX++;
            }
        }
        if (sumX == 3) {
            winnerX = true;
        }

        // Denne skal tjekke 6 7 8
        // checker for x
        sumX = 0;



        for (int x = 6; x < 9; x++) {
            if (bræt[x] == checkX) {
                System.out.println("3"+sumX);

                sumX++;
            }
        }
        if (sumX == 3) {
            winnerX = true;
        }

        // Denne skal tjekke 0 3 6
        // checker for x
        sumX = 0;


        for (int x = 0; x < 9; x+=3) {
            if (bræt[x] == checkX) {
                System.out.println("4"+sumX);

                sumX ++;

            }
        }
        if (sumX == 3) {
            winnerX = true;
        }
        // Denne skal tjekke 1 4 7
        // checker for x
        sumX = 0;

        for (int x = 1; x < 9; x+=3) {
            if (bræt[x] == checkX) {
                System.out.println("5"+sumX);

                sumX ++;
            }
        }
        if (sumX == 3) {
            winnerX = true;
        }
        // Denne skal tjekke 2 5 8
        // checker for x
        sumX = 0;
        for (int x = 2; x < 9; x+=3) {
            if (bræt[x] == checkX) {
                System.out.println("6"+sumX);

                sumX ++;
            }
        }
        if (sumX == 3) {
            winnerX = true;
        }
        // Denne skal tjekke 0 4 8
        // checker for x
        sumX = 0;
        for (int x = 0; x < 9; x+=4) {
            if (bræt[x] == checkX) {
                System.out.println("7"+sumX);

                sumX ++;
            }
        }


        if (sumX == 3) {
            winnerX = true;
        }
        // Denne skal tjekke 2 4 6
        // checker for x
        sumX = 0;
        for (int x = 2; x < 9; x+=4) {
            if (bræt[x] == checkX) {
                System.out.println("8"+sumX);

                sumX ++;
            }
        }
        if (sumX == 3) {
            winnerX = true;
        }

        if(winnerX) {
            result = "-----X VANDT-----\n "+ticprint.printboard(bræt)+" ";
        }


        // Start på tjek af O
        // Denne tjekker 0 1 2. Er Done.
        // checker for o
        for (int o = 0; o < 3; o++) {
            if (bræt[o] == checkO) {
                sumO++;
            }

        }

        if (sumO == 3) {
            winnerO = true;
        }

        // Denne skal tjekke 3 4 5
        // checker for o
        sumO = 0;
        for (int o = 3; o < 6; o++) {
            if (bræt[o] == checkO) {
                sumO++;
            }
        }
        if (sumX == 3) {
            winnerO = true;
        }

        // Denne skal tjekke 6 7 8
        // checker for o
        sumO = 0;
        for (int o = 6; o < 9; o++) {
            if (bræt[o] == checkO) {
                sumO++;
            }
        }
        if (sumO == 3) {
            winnerO = true;
        }

        // Denne skal tjekke 0 3 6
        // checker for o
        sumO = 0;
        for (int o = 0; o < 9; o+=3) {
            if (bræt[o] == checkO) {
                sumO++;

            }
        }
        if (sumO == 3) {
            winnerO = true;
        }
        // Denne skal tjekke 1 4 7
        // checker for o
        sumO = 0;
        for (int o = 1; o < 9; o+=3) {
            if (bræt[o] == checkO) {
                sumO++;
            }
        }
        if (sumO == 3) {
            winnerO = true;
        }
        // Denne skal tjekke 2 5 8
        // checker for o
        sumO = 0;
        for (int o = 2; o < 9; o+=3) {
            if (bræt[o] == checkO) {
                sumO++;
            }
        }
        if (sumO == 3) {
            winnerO = true;
        }
        // Denne skal tjekke 0 4 8
        // checker for o
        sumO = 0;
        for (int o = 0; o < 2; o+=4) {
            if (bræt[o] == checkO) {
                sumX++;
            }
        }
        if (sumO == 3) {
            winnerO = true;
        }
        // Denne skal tjekke 2 4 6
        // checker for o
        sumO = 0;
        for (int o = 2; o < 9; o+=4) {
            if (bræt[o] == checkO) {
                sumX++;
            }
        }
        if (sumO == 3) {
            winnerO = true;
        }

        if(winnerO)
            result = "-----O VANDT----- \n"+ticprint.printboard(bræt)+"\n (•_•) ( •_•)>⌐■-■ (⌐■_■) ";


        //Start på tjek af draw.
        //Tjekker for både X og O.
        for (int d = 0; d < 9; d++) {
            if (bræt[d] == checkO || bræt[d] == checkX) {
                sumDraw++;
            }

        }

        if (sumDraw == 9) {
            draw = true;
        }

        if(draw)
            result = "-----DET BLEV UDAFGJORT-----\n"+ticprint.printboard(bræt)+" ";

        return result;
    } //Slut på checkIfOver()

    //return statement




    }



