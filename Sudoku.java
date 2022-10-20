import java.util.HashSet;

public class Sudoku {

    public int maxArea(int[] height) {

        int max=0;



                int left=0,right=height.length-1;
                while(left<right)
                {
                    int min=Math.min(height[left],height[right]);
                    max=Math.max(min*min,max);

                    if(height[left]<height[right])
                    {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
        return max;
    }

    HashSet<HashSet<Integer>> boardhs=new HashSet<>();
    HashSet<Integer> temp=new HashSet<>();

//    public boolean isValidSudoku(char[][] board) {
//
//
//
//
//                if(isvalidVertical(board) && isvalidHorizontal(board) && isvalidBox(board))
//        {
//            return true;
//        }
//                else
//                {
//                    return false;
//                }
//
//    }
//
//    private boolean isvalidBox(char[][] board) {
//
//    }
//
//    private boolean isvalidHorizontal(char[][] board) {
//        for(int i=0;i<9;i++)
//        {
//            for(int j=0;j<9;j++)
//            {
//                if(board[i][j]!='.')
//                {
//                   // temp.add(board[])
//                }
//            }
//        }
//    }
//
//    private boolean isvalidVertical(char[][] board) {
//
//    }
}


