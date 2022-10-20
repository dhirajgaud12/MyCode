import java.util.Stack;

public class DFSTraversal {


    static Stack<Integer> stack=new Stack<>();
    static int current=0;

    public static void main(String[] args) {

        boolean adjmatr[][]={
                {false,true,false,true,false},
                {true,false,true,true,false},
                {false,true,false,true,false},
                {true,false,false,false,true},
                {false,false,false,true,false}
        };

        boolean visited[]={false,false,false,false,false};

        int node=0;

        stack.push(0);
        System.out.println("Adding 0");
        visited[0]=true;
        getDFSTraversal(node,adjmatr,visited);


    }

    private static void getDFSTraversal(int node, boolean[][] adjmatr, boolean[] visited)  {
        if(stack.isEmpty())
        {
            return;
        }
        else
        {
            if(!stack.isEmpty())
            {
                current=stack.pop();

            }

            for(int i=0;i<=4;i++)
            {
                if(adjmatr[current][i]==true && visited[i]==false)
                {
                    System.out.println("Adding "+i);

                    visited[i]=true;

                    stack.push(i);

                        getDFSTraversal(stack.peek(),adjmatr,visited);


                }
            }


        }

    }
}









