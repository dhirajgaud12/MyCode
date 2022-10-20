public class Node {


    private int data;
    public Node(int data)
    {
        this.data=data;
        lchild=null;
        rchild=null;
    }
    Node lchild;

    public int getData() {
        return data;
    }



    public Node getLchild() {
        return lchild;
    }

    public void setLchild(Node lchild) {
        this.lchild = lchild;
    }

    public Node getRchild() {
        return rchild;
    }

    public void setRchild(Node rchild) {
        this.rchild = rchild;
    }

    Node rchild;


}







