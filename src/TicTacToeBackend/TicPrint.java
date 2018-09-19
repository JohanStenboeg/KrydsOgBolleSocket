package TicTacToeBackend;

public class TicPrint {




    public void printboard(char board[]){
        System.out.println("ⓣⓘⓒ  ⓣⓐⓒ  ⓣⓞⓔ");
        String newboard = "      |"+board[0]+"|"+board[1]+"|"+board[2]+"|\n"+"      |"+board[3]+"|"+board[4]+"|"+board[5]+"|\n"+"      |"+board[6]+"|"+board[7]+"|"+board[8]+"|\n" ;

        System.out.println(newboard);



    }

}