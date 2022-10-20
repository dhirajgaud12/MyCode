

import java.util.Arrays;

public class ArrayStack {


    public static void main(String[] args) {

        int newArray[]=createStack(5);
        Arrays.fill(newArray,Integer.MIN_VALUE);

        pusht(1,newArray);
        pusht(3,newArray);
        pusht(5,newArray);
        pusht(7,newArray);
        pusht(11,newArray);
        int newArrayt[]=pusht(9,newArray);


        popt(newArrayt);

    }

    private static void popt(int[] newArrayt) {
        int count=0;
        while (newArrayt[count]!=Integer.MIN_VALUE)
        {
            count++;
        }

        System.out.println("Value popped from stak is "+newArrayt[count-1]);
        newArrayt[newArrayt.length-1]=Integer.MIN_VALUE;
    }

    private static int[] pusht(int num,int []newArray) {
        if(newArray[newArray.length-1]!=Integer.MIN_VALUE)
        {

            return copyToNewArray(num,newArray);
        }

        int count=0;
        while(newArray[count]!=Integer.MIN_VALUE )
        {
            if(newArray[newArray.length-1]!=Integer.MIN_VALUE)
            {
                break;
            }
            count++;
        }
            newArray[count] = num;

        return newArray;
    }

    private static int[] copyToNewArray(int num, int[] newArray) {
        int newlen= (int) (newArray.length*1.5);
        int []latestarr=new int[newlen];

        Arrays.fill(latestarr,Integer.MIN_VALUE);
        int count=0;
        while(count<newArray.length )
        {
            latestarr[count]=newArray[count];
            System.out.println("Added number "+latestarr[count]);
            count++;
        }
        latestarr[count]=num;
        System.out.println("Added number "+latestarr[count]);
        return latestarr;
    }

    private static int[] createStack(int i) {
        int newArray[]=new int[i];
        return newArray;
    }
}
