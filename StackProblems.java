import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackProblems {

    public static void main(String[] args) {

/*
        String expr = "([{}}])";

        // Function call
        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");

*/


        System.out.println(strResult("10 / 2 * 6 + 12 / 2"));
//        System.out.println(strResult("100 * 2 + 12"));
//        System.out.println(strResult("100 * ( 2 + 12 ))"));
//        System.out.println(strResult("100 * ( 2 + 12 ) / 14"));

        String str="";




        generate(5);


    }




    public static List<ArrayList<Integer>> generate(int numRows) {



        List<ArrayList<Integer>> ListofList=new ArrayList<>();

        Stack<Integer> stack=new Stack<>();


        ArrayList<Integer> list=new ArrayList<>();

        list.add(1);
        stack.push(1);
        stack.push(1);

        if(numRows<0)
        {
            return ListofList;
        }

        else if(numRows==1)
        {
            ListofList.add(list);

            return ListofList;
        }

        else
        {
            while(!stack.isEmpty()){
                
            }
        }

        return ListofList;
    }



    private static int strResult(String str){
int result=0;
        str=str.trim();
        char[] array=str.toCharArray();

        Stack<Integer> intStack=new Stack<>();
        Stack<Character> charStack=new Stack<>();


        for(int i=0;i<str.length();i++)
        {
            if(array[i]==' ')
            {
                continue;
            }

            if(array[i]=='1' || array[i]=='2' || array[i]=='3' || array[i]=='4' || array[i]=='5' ||
                    array[i]=='6' || array[i]=='7' || array[i]=='8' || array[i]=='9' || array[i]=='0')
            {
                int temp=Character.getNumericValue(array[i]);

                int j=i+1;
                while(j<str.length() &&(   array[j]=='1' || array[j]=='2' || array[j]=='3' || array[j]=='4' || array[j]=='5' ||
                        array[j]=='6' || array[j]=='7' || array[j]=='8' || array[j]=='9' || array[j]=='0'))
                {

                    temp=(temp*10)+Character.getNumericValue(array[j]);
                    j++;
                }
                intStack.push(temp);
                i=j;
            }


            if(i<str.length() && (array[i]=='(' || array[i]==')' || array[i]=='/' || array[i]=='*' || array[i]=='+' || array[i]=='-') )
            {
                charStack.push(array[i]);
            }
        }

        result=evaluateStacks(intStack,charStack);

        return result;
    }

    private static int evaluateStacks(Stack<Integer> intStack, Stack<Character> charStack) {

        char ch;
        while(!charStack.isEmpty())
        {
            int leftOperad=0,rightOperand=0;
            int max=getMaxPriorityElement(charStack);

            if(max==0)
            {
                leftOperad=0;
                rightOperand=1;
            }
            else if(max==charStack.size()-1)
            {
                leftOperad=max;
                rightOperand=max+1;
            }
            else{
                leftOperad=max-1;
                rightOperand=max;
            }

            if(!charStack.contains('('))
            {
                ch=charStack.remove(max);
                int tempres=getresult(intStack.get(leftOperad),intStack.remove(rightOperand),ch);
                intStack.set(leftOperad,tempres);
            }
            else
            {


                if(!charStack.isEmpty())
                {
                    ch=charStack.remove(max);
                    int tempres=getresult(intStack.get(leftOperad),intStack.remove(rightOperand),ch);
                    intStack.set(leftOperad,tempres);
                }
            }

        }

        return intStack.get(0);
    }

    private static int getresult(int leftOperad, int rightOperand, char ch) {

        if(ch=='/')
        {
            return leftOperad/rightOperand;
        }
        if(ch=='*')
        {
            return leftOperad*rightOperand;
        }
        if(ch=='+')
        {
            return leftOperad+rightOperand;
        }
        else
        {
            return leftOperad-rightOperand;
        }
    }

    private static int getMaxPriorityElement(Stack<Character> charStack) {
        int result=0,temp=-1;

        for (int i=0;i<charStack.size();i++)
        {
            if(getPriority(charStack.get(i))>=temp)
            {
                temp=getPriority(charStack.get(i));
                result=i;
            }

        }

        return result;
    }

    private static int getPriority(char a) {

        if(a==')')
        {
            return 5;
        }

        else if(a=='/')
        {
            return 4;
        }
        else if(a=='*')
        {
            return 3;
        }
        else if(a=='+')
        {
            return 2;
        }
        else
        {
            return 1;
        }
    }
}



