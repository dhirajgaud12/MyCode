import java.util.LinkedList;
import java.util.Queue;

public class Percolation {
static     Queue <Integer> queue=new LinkedList<>();
static     LinkedList<Integer> path=new LinkedList<Integer>();

    public static void main(String[] args) {

        int adjmtr[][]={
                {0,0,1,0,0},
                {0,1,0,0,0},
                {1,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,0,1}
        };
        if (percolates(adjmtr))
        {
            System.out.println("System Percolates");
        }
        else
        {
            System.out.println("Doesnt percolate");
        }
    }

    private static boolean percolates(int[][] adjmtr) {

        for(int i=0;i<5;i++)
        {

                    if (adjmtr[0][i]==0)
                    {
                        //Getting all top layer free spaces added to queue
                        queue.add(i);
                    }




        }


        while(!queue.isEmpty())
        {

            int current=queue.poll();
            if(path.isEmpty() && current<=19) {
                path.add(current);
            }
            int i=current/5,j=current%5;


            System.out.println("Current element is "+current);

            if(isnextfree(current+5,adjmtr))
            {
                if(!queue.contains(current+5))
                {
                    queue.add(current+5);
                    path.add(current+5);
                }
            }
        }
for(int i=0;i<path.size();i++)
{
    if (path.get(i)<=19)
    {
        return false;
    }



}
        return true;
    }

    private static boolean isnextfree(int position,int adjmatr[][]) {
        int i=position/5,j=position%5;

               if(adjmatr[i][j]==1)
               {
                   return false;
               }
        else
               {
                   return true;
               }

    }


}









