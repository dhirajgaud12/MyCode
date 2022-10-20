import java.util.*;
import java.util.LinkedList;

public class HelloWorld {

//    private static int leftupdiag(int queenpos[],int boardsize){
//        int size=0,xpos=queenpos[0],ypos=queenpos[1];
//
//        while(ypos!=4 && xpos!=0)
//        {
//            xpos=xpos-1;
//            ypos=ypos+1;
//            size++;
//        }
//        return size;
//    }
//
//    private static int rightupdiag(int queenpos[],int boardsize){
//        int size=0,xpos=queenpos[0],ypos=queenpos[1];
//
//        while(ypos!=4 && xpos!=4)
//        {
//            xpos=xpos+1;
//            ypos=ypos+1;
//            size++;
//        }
//        return size;
//    }
//
//    private static int leftdowndiag(int queenpos[],int boardsize){
//        int size=0,xpos=queenpos[0],ypos=queenpos[1];
//
//        while(ypos!=0 && xpos!=0)
//        {
//            xpos=xpos-1;
//            ypos=ypos-1;
//            size++;
//        }
//        return size;
//    }
//
//    private static int rightdowndiag(int queenpos[],int boardsize){
//        int size=0,xpos=queenpos[0],ypos=queenpos[1];
//
//        while(ypos!=0 && xpos!=4)
//        {
//            xpos=xpos+1;
//            ypos=ypos-1;
//            size++;
//        }
//        return size;
//    }




    public static void main(String[] args) {
//
//       int arr[]={0,1,2,3,4,5,6,7,8,9};
//
//        int boardsize=5,queenpos[]={0,3},total=0;
//
//        total=leftdowndiag(queenpos,boardsize);
//        total=total+leftupdiag(queenpos,boardsize);
//        total=total+rightdowndiag(queenpos,boardsize);
//        total=total+rightupdiag(queenpos,boardsize)+8;
//
//        System.out.println(total);

//------------------------------------------------------------------------------------
//                       BST - BFS Traversal


        int input[] = {45, 15, 79, 90, 10, 55, 12, 20, 50};

        Node root = new Node(input[0]);
        Node node = root,tree=root;

        for (int i = 1; i < input.length; i++) {
node=root;
            while (node != null) {
                if (input[i] <= node.getData()) {

                    if (node.lchild!=null)
                    {
                        node=node.lchild;
                    }

                    else
                    {
                        node.lchild= new Node(input[i]);
                        System.out.println("inserting "+input[i]+" to left side of "+node.getData());
                        break;
                    }


                }

                if (input[i] > node.getData()) {

                    if (node.rchild!=null)
                    {
                        node=node.rchild;

                    }
                    else
                    {
                        node.rchild = new Node(input[i]);
                        System.out.println("inserting "+input[i]+" to right side of "+node.getData());
                        break;
                    }
                }


            }


        }


        ArrayList<Node> bst = getBSTTraversal(root);
        getdfs(root);


        List<Node> Inorder=new ArrayList<>();
        List<Node> BalancedBST=new ArrayList();

        getInOrderTraversal(root,Inorder);

        System.out.println("Inorder traversal path is"+Inorder);

        int start=0,end=Inorder.size();
        //getBalancedBST(BalancedBST,Inorder,start,end);


        root=invertbst(root);

        ArrayList<Node> invertedbst = getBSTTraversal(root);

        for(Node n:invertedbst)
        {
            System.out.println("Inverted treee is "+n.getData());
        }
        int level=getmaxlevel(root);

        System.out.println("Maximum level is "+level);
        int width=0;
        width=getMaxWidth(root);

        System.out.println("Maximum width is "+width);
    }



    private static void getdfs(Node root) {

        Stack<Node> stack=new Stack<>();

        stack.push(root);
        System.out.println("Pring DFS");
        while(!stack.isEmpty())
        {
            Node current=stack.pop();

                if(current.rchild!=null)
                {
                    stack.push(current.rchild);
                    System.out.println("Entering element"+current.rchild.getData());
                }

            if(current.lchild!=null)
            {
                stack.push(current.lchild);
                System.out.println("Entering element"+current.lchild.getData());
            }
        }
    }

    private static int getmaxlevel(Node node) {

        if(node==null)
        {
            return 0;
        }

        else
        {
            return Math.max(getmaxlevel(node.lchild)+1,getmaxlevel(node.rchild)+1);
        }

    }

    private static int getMaxWidth(Node node) {
    Queue<Node> queue=new LinkedList<>();
    int maxwidth=0;

    queue.add(node);
    while(!queue.isEmpty())
    {
        int len=queue.size();
        maxwidth=Math.max(len,maxwidth);
        for(int i=0;i<len;i++)
        {
            Node temp=queue.poll();
            if(temp.lchild!=null)
            {
                queue.add(temp.lchild);
            }
            if(temp.rchild!=null)
            {
                queue.add(temp.rchild);
            }
        }
    }
      return maxwidth;
    }


    //private static

    private static Node invertbst(Node node) {

        if (node==null)
        {
            return node;
        }

            Node left=invertbst(node.lchild);

            Node right=invertbst(node.rchild);

            node.rchild=left;
            node.lchild=right;



            return node;

    }

private static void getInOrderTraversal(Node root,List<Node> Path)
{
if (root==null)
{
    return ;

}
else
{
    if(root.lchild!=null)
    {
        getInOrderTraversal(root.lchild,Path);
    }
    System.out.println("Inorder travesal"+root.getData());
    Path.add(root);
    if(root.rchild!=null)
    {
        getInOrderTraversal(root.rchild,Path);
    }
}
}

private static void getBalancedBST(List<Node> BalancedBST, List<Node> inorder, int start,int end)
{


}

    private static ArrayList<Node> getBSTTraversal (Node root){
            ArrayList<Node> bsttraversal = new ArrayList<>();
            bsttraversal.add(root);
            Node temp;
           Queue<Node> intermediary = new LinkedList<>();
            intermediary.add(root);

            while (!intermediary.isEmpty()) {

                temp = intermediary.poll();

                if (temp.lchild != null) {
                    intermediary.add(temp.lchild);
                    bsttraversal.add(temp.lchild);
                }
                if (temp.rchild != null) {
                    intermediary.add(temp.rchild);
                    bsttraversal.add(temp.rchild);
                }

            }

            return bsttraversal;
        }


    }