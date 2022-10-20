import java.util.*;

public class LinkedList<E> {
    static LinkedListNode head;

    public static void main(String[] args) {


        LinkedListNode head=AddtoList(1);

        Map<Integer,String> hm=new HashMap<>();
        Iterator it=hm.entrySet().iterator();


        //hm.getkey();

        AddtoList(3);
        AddtoList(5);
        AddtoList(7);

        LinkedListNode temphead=reverseList(head);




//        while(temphead!=null)
//        {
//            System.out.println("Current element is "+temphead.getData());
//            temphead=temphead.next;
//        }

        //printPattern(5,"",1);
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        int arr[]={1,2,3,4};
        //productExceptSelf(arr);

    }


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result=new ArrayList<List<Integer>>();




        return result;
    }

/*    public static int[] nextGreaterElements(int[] nums) {

        int result[]=new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            int gbn=getNextBiggestNumber(nums,i);
           if(gbn!=Integer.MIN_VALUE)
           {
               result[i]=gbn;
           }
           else {
               result[i]=-1;
           }
        }

        return result;
    }

    private static int getNextBiggestNumber(int[] nums, int currentpos) {
        int nextbignum=Integer.MIN_VALUE;
        for(int i=currentpos+1;i<nums.length;i++)
        {
            if(nums[currentpos]<nums[i])
            {
                nextbignum=nums[i];
                break;
            }
        }

        if(nextbignum==Integer.MIN_VALUE)
        {
            for(int i=0;i<currentpos-1;i++)
            {
                if(nums[currentpos]<nums[i])
                {
                    nextbignum=nums[i];
                    break;
                }
            }
        }

        return nextbignum;
    }*/


    public static int[] productExceptSelf(int[] nums) {


        int []arr=new int[nums.length];
        int total=1;
        for(int i=0;i<nums.length;i++)
        {
            total=total*nums[i];
        }

        for(int i=0;i<nums.length;i++)
        {
            arr[i]=total/nums[i];
        }


        return arr;
    }

    private static void printPattern(int i, String s,int current) {
        if(i+1==current)
        {
            return;
        }
        String str=s+" "+Integer.toString(current);
        System.out.println(str);

        printPattern(i,str,current+1);



    }


    public static LinkedListNode AddtoList() {
        return AddtoList();
    }

    public static LinkedListNode AddtoList(int data)
    {
        LinkedListNode newNode=new LinkedListNode(data);
        if(head==null)
        {
            head=newNode;
        }
        else
        {
            while(head.next!=null)
            {
                head=head.next;
            }
            head.next=newNode;
            head=head.next;
        }

        return head;
    }


    static public LinkedListNode reverseList(LinkedListNode head) {

        if(head==null || head.next==null)
        {
            return  head;
        }
        else
        {
            LinkedListNode Currenthead=reverseList(head.next);
            LinkedListNode NextNode=head.next;
            NextNode.next=head;
            head.next=null;
            return Currenthead;
        }


    }

    }








