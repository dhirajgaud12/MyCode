
public class Binary {


    public static void main(String[] args) {
        int binary=getfourthbit(23);
        System.out.println();
    }

    private static int getfourthbit(int i) {
        int binary=0;
        String bin="",rev="";
        while(i>0)
        {

            bin=bin+String.valueOf(i%2);
            i=i/2;

        }

        for(int j=bin.length();j>0;j--)
        {
            rev=rev+bin.substring(j,j+1);
        }
        //binary=String.valueOf(rev);
        return binary;
    }
}
