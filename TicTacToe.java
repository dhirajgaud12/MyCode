import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    static int x=-1,y=-1;


    public static void main(String[] args) {
        String board[][]={
                {"","",""},
                {"","",""},
                {"","",""}
        };

        Scanner sc=new Scanner(System.in);


        List<Integer> list=new ArrayList<>();

        int num=-1111111;
        int count =1;
        while(count<10)
        {



            if(count %2==0)
            {
                System.out.println("O's turn, Please enter position");
                num= sc.nextInt();
                num=num-1;
                convertTo2d(num);

                if(!list.contains(num))
                {
                    board[x][y]="O";
                    list.add(num);
                }

                if(isWinning(board))
                {
                    break;
                }
            }
            else
            {
                System.out.println("X's turn, Please enter position");

                num= sc.nextInt();
                num=num-1;
                convertTo2d(num);

                if(!list.contains(num))
                {
                    board[x][y]="X";
                    list.add(num);
                }

                if(isWinning(board))
                {
                    break;
                }
            }




                count++;
        }

    }

    private static void convertTo2d(int num) {
        x=num/3;
        y=num%3;

    }

    private static boolean isWinning(String[][] board) {

        if(isVerticalWin(board) || isHorizontalWin(board) || isDiagonalWin(board))
        {
            return true;
        }
        return false;
    }

    private static boolean isDiagonalWin(String[][] board) {
        if(board[0][0]=="X" && board[1][1]=="X" && board[2][2]=="X")
        {
            System.out.println("X wins");
            return true;
        }

        if(board[0][2]=="X" && board[1][1]=="X" && board[2][0]=="X")
        {
            System.out.println("X wins");
            return true;
        }

        if(board[0][0]=="O" && board[1][1]=="O" && board[2][2]=="O")
        {
            System.out.println("O wins");
            return true;
        }

        if(board[0][2]=="O" && board[1][1]=="O" && board[2][0]=="O")
        {
            System.out.println("O wins");
            return true;
        }

        return false;
    }

    private static boolean isVerticalWin(String[][] board) {

        if(board[0][0]=="X" && board[1][0]=="X" && board[2][0]=="X")
        {
            System.out.println("X wins");
            return true;
        }

        if(board[0][1]=="X" && board[1][1]=="X" && board[2][1]=="X")
        {
            System.out.println("X wins");
            return true;
        }

        if(board[0][2]=="X" && board[1][2]=="X" && board[2][2]=="X")
        {
            System.out.println("X wins");
            return true;
        }

        if(board[0][0]=="O" && board[1][0]=="O" && board[2][0]=="O")
        {
            System.out.println("O wins");
            return true;
        }

        if(board[0][1]=="O" && board[1][1]=="O" && board[2][1]=="O")
        {
            System.out.println("O wins");
            return true;
        }

        if(board[0][2]=="O" && board[1][2]=="O" && board[2][2]=="O")
        {
            System.out.println("O wins");
            return true;
        }

        return false;
    }

    private static boolean isHorizontalWin(String[][] board) {
        if(board[0][0]=="X" && board[0][1]=="X" && board[0][2]=="X")
        {
            System.out.println("X wins");
            return true;
        }

        if(board[1][0]=="X" && board[1][1]=="X" && board[1][2]=="X")
        {
            System.out.println("X wins");
            return true;
        }

        if(board[2][0]=="X" && board[2][1]=="X" && board[2][2]=="X")
        {
            System.out.println("X wins");
            return true;
        }

        if(board[0][0]=="O" && board[0][1]=="O" && board[0][2]=="O")
        {
            System.out.println("O wins");
            return true;
        }

        if(board[1][0]=="O" && board[1][1]=="O" && board[1][2]=="O")
        {
            System.out.println("O wins");
            return true;
        }

        if(board[2][0]=="O" && board[2][1]=="O" && board[2][2]=="O")
        {
            System.out.println("O wins");
            return true;
        }

        return false;
    }
}


