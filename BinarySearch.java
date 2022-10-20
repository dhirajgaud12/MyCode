
import java.util.*;


public class BinarySearch {
    static int index=0;


    public static int numIslands(char[][] grid) {
        int noisl=0;

        HashSet<Integer> Corners=new HashSet<>();


        for(int i=0;i< grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                int cornernum= (grid.length*i+1)+ j;

                if(grid[i][j]=='1' )
                {
                    traverseIsland(grid,i,j,cornernum);
                    noisl++;
                }
            }
        }
        System.out.println("Count is "+ noisl);
        return noisl;
    }

    private static void traverseIsland(char[][] grid, int i, int j,int num) {

        Queue<Integer> queue=new ArrayDeque<>();

        queue.add(num);

        int dirX[]={-1,0,1,0};
        int dirY[]={0,1,0,-1};

        while (!queue.isEmpty())
        {
            int temp=queue.remove();
            int x=temp/ grid.length;
            int y=temp% grid[0].length;

            for(int k=0;k<4;k++)
            {
                int a=x+dirX[k];
                int b=y+dirY[k];
                if(a<0 || b<0 || a>=grid.length || b>=grid[0].length
                        || grid[a][b]=='0') continue;
                grid[a][b]='0';
                int number=(x* grid.length)+y;

                grid[x][y]='0';
                queue.add(number);

            }

        }

    }

    public static void main(String[] args) {
//        int arr[]={90,80,70,60,50,40,31,21,11,02};
//        Arrays.sort(arr);
//
//
//        getElementIndex(02,0,arr.length,arr);
//
//        System.out.println("Index is "+index);
    char ch[]={'h','e','l','l','o'};
        reverseString(ch);

        for(int i=0;i<ch.length;i++)
        System.out.println(ch[i]);
        char grid[][] = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        numIslands(grid);
    }
    
    

//    private static void getElementIndex(int i, int low, int high,int arr[]) {
//        int mid=(low+high)/2;
//        if(i==arr[mid])
//        {
//            index=mid;
//            return;
//        }
//        else
//        {
//            if(i<=arr[mid])
//            {
//                getElementIndex(i,low,mid,arr);
//            }
//            else
//            {
//                getElementIndex(i,mid,high,arr);
//            }
//        }
//    }


    public static void reverseString(char[] s) {
        int count=0;
        reverseStringNow(s,count,s.length-1);
    }

    public static void reverseStringNow(char[] s, int count, int length) {
        if(count>=length)
        {
            return;
        }
        else
        {
            char temp= s[count];
            s[count]=s[length];
            s[length]=temp;

            reverseStringNow(s,count+1,length-1);
        }
    }
}
