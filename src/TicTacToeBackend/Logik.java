package TicTacToeBackend;

public class Logik {

    //Deklarere instance variabler.
    TicPrint ticprint = new TicPrint();
    private char[] bræt = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}; //Spille brættet, lavet af et single array.
    private boolean xTurn; //Sandt hvis det er X's tur, false hvis det er O's tur.



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
    if(){

    }

    else if(){

    }

    else{
        return "nej";
    }


    }


}
