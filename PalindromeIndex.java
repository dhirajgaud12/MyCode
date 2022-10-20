import java.util.HashSet;

public class PalindromeIndex {

    public static void main(String[] args) {

        HashSet<Integer> set=new HashSet<>();
      
        String str = "raceca1r";
       //returnPalindromeIndex(str);
        //System.out.println(str.replaceFirst("a",""));

        calcsum(3,19,0);

        int count=countAllPalindrome("abbaeae");
        System.out.println("Count of all palindrome strings is"+count);


        isPalindrome(121);
    }

    private static int countAllPalindrome(String str) {
        int totalcount=0;
        for(int i=0;i<str.length();i++)
        {
            for(int j=i+1;j<str.length();j++)
            {
                if(j-i>1)
                {
                    if(isPalindrome(str.substring(i,j)))
                    {
                        System.out.println(str.substring(i,j));
                        totalcount++;
                    }
                }
            }
        }
        return totalcount;
    }


    private static void calcsum(int innum, int totalnum, int countofoperands) {

        if(totalnum>0)
        {
            while((innum*countofoperands) <totalnum)
            {
                countofoperands++;


            }
            countofoperands--;
            int diff=totalnum-(innum*countofoperands);
            System.out.println("Obtained "+totalnum+" by adding "+countofoperands+"*"+innum+" and"+diff);
            System.out.println("Total Number of operands is "+countofoperands);
        }

        else
        {

        }


    }

    public static boolean isPalindrome(int x) {
        if(x<0)
        {
            x=x*-1;
        }

        String str=Integer.toString(x);

        int slen=str.length();

        for(int i=0;i<slen/2;i++)
        {
            int temp=slen-i;
            if(str.substring(i,i+1) == (str.substring(temp-2,temp-1)))
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    private static int returnPalindromeIndex(String str) {
String temp="";
        for (int i = 0; i < str.length(); i++) {
            String iter=str.substring(i,i+1);
            temp=replaceCharWithBlank(i,str);
            if (isPalindrome(temp)) {
                System.out.println("Palindrome is "+temp+" Index is "+i);
            }
        }

        return 0;
    }

    private static String replaceCharWithBlank(int index, String str) {
        if (index==0)
        {
            return str.substring(1,str.length()-1);
        }
        if (index==1)
        {
            return str.substring(0,1) + str.substring(2,str.length()-1);
        }

        return str.substring(0,index) + str.substring(index+1,str.length());
    }

    private static boolean isPalindrome(String str) {
        int mid=str.length()/2;
        char carr[]=str.toCharArray();

        for(int i=0,j=str.length()-1;i<mid;i++,j--)
        {
            if(carr[i]==carr[j])
            {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}



