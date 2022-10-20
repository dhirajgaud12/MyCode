import java.util.Arrays;

public class UnionFind {
    static int arr[]=new int[10];

    public static void main(String[] args) {



        for(int i=0;i<10;i++)
        {
           arr[i]=i;
        }


        Union(4,3);
        Union(3,8);
        Union(6,5);
        Union(9,4);
        Union(2,1);

        if(isConnected(8,9))
        {
            System.out.println("Is connected");
        }
        else
        {
            System.out.println("not connected");
        }

        Union(5,0);
        Union(7,2);
        Union(6,1);

        if(isConnected(3,4))
        {
            System.out.println("Is connected");
        }

    }

    private static Boolean isConnected(int a, int b) {
        int tempa=arr[a];
        int tempb=arr[b];
        for(int i=0;i<10;i++)
        {
            tempa=arr[tempa];
            if(tempa==arr[tempa])
            {
                break;
            }
        }

        for(int i=0;i<10;i++)
        {
            tempb=arr[tempb];
            if(tempb==arr[tempb])
            {
                break;
            }
        }

        return tempa==tempb;
    }

    private static void Union(int a, int b) {
        int tempb=arr[b];

        while(arr[tempb]!=tempb)
        {
            tempb=arr[tempb];
        }
        arr[a]=tempb;
    }



}