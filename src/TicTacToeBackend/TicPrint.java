package TicTacToeBackend;

public class TicPrint {




    public String printboard(char board[]){

        String newboard = "ⓣⓘⓒ  ⓣⓐⓒ  ⓣⓞⓔ\n      |"+board[0]+"|"+board[1]+"|"+board[2]+"|\n"+"      |"+board[3]+"|"+board[4]+"|"+board[5]+"|\n"+"      |"+board[6]+"|"+board[7]+"|"+board[8]+"|\n" ;
        //System.out.println("ⓣⓘⓒ  ⓣⓐⓒ  ⓣⓞⓔ");
        //System.out.println(newboard);


        return newboard;
    }


    public String printBoardStart(){
        int board[] = new int[9];
        board[0] = 0;
        board[1] = 1;
        board[2] = 2;
        board[3] = 3;
        board[4] = 4;
        board[5] = 5;
        board[6] = 6;
        board[7] = 7;
        board[8] = 8;

        String newboard = "ⓣⓘⓒ  ⓣⓐⓒ  ⓣⓞⓔ\n"+"Her er pladserner og tallene du skal bruge\n      "+"|"+board[0]+"|"+board[1]+"|"+board[2]+"|\n"+"      |"+board[3]+"|"+board[4]+"|"+board[5]+"|\n"+"      |"+board[6]+"|"+board[7]+"|"+board[8]+"|\n" ;
        //System.out.println("ⓣⓘⓒ  ⓣⓐⓒ  ⓣⓞⓔ");
        //System.out.println(newboard);


        return newboard;
    }

    public static void main(String[] args) {
        TicPrint ticPrint = new TicPrint();
        System.out.println(ticPrint.printBoardStart());
    }

}