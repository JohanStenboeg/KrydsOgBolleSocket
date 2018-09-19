package TicTacToeBackend;

public class TicPrint {




    public void printboard(char board[]){
        System.out.println("ⓣⓘⓒ  ⓣⓐⓒ  ⓣⓞⓔ");
        String newboard = "      |"+board[0]+"|"+board[1]+"|"+board[2]+"|\n"+"      |"+board[3]+"|"+board[4]+"|"+board[5]+"|\n"+"      |"+board[6]+"|"+board[7]+"|"+board[8]+"|\n" ;

        System.out.println(newboard);



    }

    public static void main(String[] args) {
        char board[] = new char[9];
        board[0] = 'x';
        board[1] = 'o';
        board[2] = ' ';
        board[3]= ' ';
        board[4] = ' ';
        board[5] = ' ';
        board[6] = ' ';
        board[7] = ' ';
        board[8] = ' ';

        TicPrint ticPrint = new TicPrint();
        ticPrint.printboard(board);
    }
}
