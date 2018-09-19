package TicTacToeBackend;

public class TicPrint {




    public String printboard(char board[]){

        String newboard = "ⓣⓘⓒ  ⓣⓐⓒ  ⓣⓞⓔ\n      |"+board[0]+"|"+board[1]+"|"+board[2]+"|\n"+"      |"+board[3]+"|"+board[4]+"|"+board[5]+"|\n"+"      |"+board[6]+"|"+board[7]+"|"+board[8]+"|\n" ;
        //System.out.println("ⓣⓘⓒ  ⓣⓐⓒ  ⓣⓞⓔ");
        //System.out.println(newboard);


        return newboard;
    }

    public static void main(String[] args) {
        TicPrint ticPrint = new TicPrint();
        System.out.println(ticPrint.printboard(new char[9]));
    }

}