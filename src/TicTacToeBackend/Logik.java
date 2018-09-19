package TicTacToeBackend;

public class Logik {

    //Deklarere instance variabler.
    TicPrint ticprint = new TicPrint();
    private char[] bræt = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}; //Spille brættet, lavet af et single array.
    private boolean xTurn; //Sandt hvis det er X's tur, false hvis det er O's tur.
    private boolean winner = false; // Antager som udgangspunkt at der ingen vinder er.



    //Metode til at placere et X eller O i brættet.
    public String play(int input, boolean xTurn){

        //Tjekker om positionen er uden for brættet.
        if (input >= 0 && input <= 8) {

            //Tjekker om positionen allerede er optaget.
            if (bræt[input] != ' ')
                System.out.println("Denne position er allerede taget.");
        } else
            System.out.println("Denne position er ikke inden for brættes spille rammer.");

        //Udfylder brættet med enten X eller O såfremt det er en valid position.
        if (xTurn)

            bræt[input] = 'X';
        else
            bræt[input] = 'O';

        return ticprint.printboard(bræt);
    }


    public String checkIfOver(){
        char checkX = 'X';
        char checkO = 'O';
        int sum = 0;

    // Denne tjekker 0 1 2. Er Done.
        // checker for x
        for(int x = 0; x < 3; x++){
        if(bræt[x]== checkX) {
            sum++;
        }

    }

        if (sum == 3){
            winner = true;
        }

    // Denne skal tjekke 3 4 5
        // checker for x
        sum = 0;
    for(int x = 3; x < 6; x++){
        if(bræt[x]== checkX) {
            sum++;
        }
    }
        if (sum == 3){
            winner = true;
        }

        // Denne skal tjekke 6 7 8
        // checker for x
        sum = 0;
        for(int x = 6; x < 9; x++){
            if(bræt[x]== checkX) {
                sum++;
            }
        }
        if (sum == 3){
            winner = true;
        }

        // Denne skal tjekke 0 3 6
        // checker for x
        sum = 0;
        for(int x = 0; x < 9; x++){
            if(bræt[x]== checkX) {
                sum=+3;

            }
        }
        if (sum == 3){
            winner = true;
        }
        // Denne skal tjekke 1 4 7
        // checker for x
        sum = 0;
        for(int x = 1; x < 9; x++){
            if(bræt[x]== checkX) {
                sum=+3;
            }
        }
        if (sum == 3){
            winner = true;
        }
        // Denne skal tjekke 2 5 8
        // checker for x
        sum = 0;
        for(int x = 2; x < 9; x++){
            if(bræt[x]== checkX) {
                sum=+3;
            }
        }
        if (sum == 3){
            winner = true;
        }
        // Denne skal tjekke 0 4 8
        // checker for x
        sum = 0;
        for(int x = 0; x < 2; x++){
            if(bræt[x]== checkX) {
                sum=+4;
            }
        }
        if (sum == 3){
            winner = true;
        }
        // Denne skal tjekke 2 4 6
        // checker for x
        sum = 0;
        for(int x = 2; x < 9; x++){
            if(bræt[x]== checkX) {
                sum=+4;
            }
        }
        if (sum == 3){
            winner = true;
        }






    else if(){
            // Denne tjekker 0 1 2. Er Done.
            // checker for o
            for(int o = 0; o < 3; o++){
                if(bræt[o]== checkO) {
                    sum++;
                }

            }

            if (sum == 3){
                winner = true;
            }

            // Denne skal tjekke 3 4 5
            // checker for o
            sum = 0;
            for(int o = 3; o < 6; o++){
                if(bræt[o]== checkO) {
                    sum++;
                }
            }
            if (sum == 3){
                winner = true;
            }

            // Denne skal tjekke 6 7 8
            // checker for o
            sum = 0;
            for(int o = 6; o < 9; o++){
                if(bræt[o]== checkO) {
                    sum++;
                }
            }
            if (sum == 3){
                winner = true;
            }

            // Denne skal tjekke 0 3 6
            // checker for o
            sum = 0;
            for(int o = 0; o < 9; o++){
                if(bræt[o]== checkO) {
                    sum=+3;

                }
            }
            if (sum == 3){
                winner = true;
            }
            // Denne skal tjekke 1 4 7
            // checker for o
            sum = 0;
            for(int o = 1; o < 9; o++){
                if(bræt[o]== checkO) {
                    sum=+3;
                }
            }
            if (sum == 3){
                winner = true;
            }
            // Denne skal tjekke 2 5 8
            // checker for o
            sum = 0;
            for(int o = 2; o < 9; o++){
                if(bræt[o]== checkO) {
                    sum=+3;
                }
            }
            if (sum == 3){
                winner = true;
            }
            // Denne skal tjekke 0 4 8
            // checker for o
            sum = 0;
            for(int o = 0; o < 2; o++){
                if(bræt[o]== checkO) {
                    sum=+4;
                }
            }
            if (sum == 3){
                winner = true;
            }
            // Denne skal tjekke 2 4 6
            // checker for o
            sum = 0;
            for(int o = 2; o < 9; o++){
                if(bræt[o]== checkO) {
                    sum=+4;
                }
            }
            if (sum == 3){
                winner = true;
            }

        }

    else if(){

    }

    else{
        return "nej";
    }


    }


}



