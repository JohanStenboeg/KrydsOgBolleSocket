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

    // Denne tjekker 1 2 3. Er lavet.
        for(int x = 0; x < 2; x++){
        if(bræt[x]== checkX) {
            sum++;
        }
    }

        if (sum == 3){
            winner = true;
        }

    // Denne skal tjekke 4 5 6
        sum = 0;
    for(int x = 0; x < 2; x++){
        if(bræt[x]== checkX) {
            sum++;
        }
    }
        if (sum == 3){
            winner = true;
        }

        // Denne skal tjekke 7 8 9
        sum = 0;
        for(int x = 0; x < 2; x++){
            if(bræt[x]== checkX) {
                sum++;
            }
        }
        if (sum == 3){
            winner = true;
        }

        // Denne skal tjekke 1 4 7
        sum = 0;
        for(int x = 0; x < 2; x++){
            if(bræt[x]== checkX) {
                sum++;
            }
        }
        if (sum == 3){
            winner = true;
        }
        // Denne skal tjekke 2 5 8
        sum = 0;
        for(int x = 0; x < 2; x++){
            if(bræt[x]== checkX) {
                sum++;
            }
        }
        if (sum == 3){
            winner = true;
        }
        // Denne skal tjekke 3 6 9
        sum = 0;
        for(int x = 0; x < 2; x++){
            if(bræt[x]== checkX) {
                sum++;
            }
        }
        if (sum == 3){
            winner = true;
        }
        // Denne skal tjekke 1 5 9
        sum = 0;
        for(int x = 0; x < 2; x++){
            if(bræt[x]== checkX) {
                sum++;
            }
        }
        if (sum == 3){
            winner = true;
        }
        // Denne skal tjekke 3 5 8
        sum = 0;
        for(int x = 0; x < 2; x++){
            if(bræt[x]== checkX) {
                sum++;
            }
        }
        if (sum == 3){
            winner = true;
        }






    else if(){

    }

    else if(){

    }

    else{
        return "nej";
    }


    }


}



