
import java.util.*;
import java.util.LinkedList;

public class LilasString {


    public static void main(String[] args) {


        //getcountofLilasString("abba",11);
        int arr[]={-1,0,1,2,-1,-4};

        threeSum(arr);

        int array[]={4,0,1,2,3,5,7,9,11,13,15};

        Arrays.sort(array);
        int num=lengthOfLongestSubstring(array,0,array.length,13);

        System.out.println("number foudn at "+num);

        LinkedListNode list1=new LinkedListNode(2);
        list1.next=new LinkedListNode(4);
        list1.next.next=new LinkedListNode(3);

        LinkedListNode list2=new LinkedListNode(5);
        list2.next=new LinkedListNode(6);
        list2.next.next=new LinkedListNode(4);


        mergeTwoLists(list1,list2,null);
        }

    public static LinkedListNode mergeTwoLists(LinkedListNode list1, LinkedListNode list2,LinkedListNode list) {

        if(list1==null)
        {
            return list2;
        }
        if(list2==null)
        {
            return list1;
        }
        LinkedListNode newNode= new LinkedListNode(list1.getData()+list2.getData());

        if(list==null)
        {
            list=newNode;

        }
        else
        {

            list.next=newNode;

        }
        mergeTwoLists(list1.next,list2.next,list);


        return list;
    }

    public static int maxProfit(int[] prices) {

        int left=0,res=0;
        int right=left+1;

        while(right<prices.length)
        {
            if (prices[right]-prices[left]<0){
                left++;
                right++;
            }
            else {
                res=prices[right]-prices[left];
                    right++;
            }
        }


        return res;
    }



    public static int  lengthOfLongestSubstring(int []arr,int left,int right,int num) {
    int mid=((left+right)/2);
        if(arr[mid]==num)
        {
            return mid;
        }
        else
        {
            if(arr[mid]<=num)
            {
               return lengthOfLongestSubstring(arr, mid, right, num);
            }
            else
            {
                return lengthOfLongestSubstring(arr, left, mid, num);
            }
        }
    }

    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listsum=new LinkedList<List<Integer>>();

        int res[]={0,0};

        List<Integer> totzero;

        for(int i=0;i<nums.length;i++)
        {
            totzero=new LinkedList<>();
            if(nums[i]<0)
            {
                int num=nums[i]*-1;
                res=twoSum(nums,num);
                totzero.add(nums[i]);
                totzero.add(res[0]);
                totzero.add(res[1]);

                listsum.add(totzero);
            }
        }
        return listsum;
    }

    static public int[] twoSum(int[] nums, int target) {
        int res[]={0,0};

        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }

        for(int i=0;i<nums.length;i++)
        {
            int diff=target-nums[i];
            if(set.contains(diff))
            {
                res[0]=nums[i];
                res[1]=diff;
            }
        }

        return res;

    }


    private static int getIndexOf(int diff, int[] nums) {

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==diff)
            {
                return i;
            }
        }
        return 0;
    }

    private static void getcountofLilasString(String word, int count) {
        String str="";

        int len=word.length();

        for(int i=0;i<(count/len);i++)
        {
            str=str+word;
        }
        len=count-str.length();

        for(int i=0;i<len;i++)
        {
            str=str+word.substring(i,i+1);
        }

        System.out.println(str);
        len=0;
        for(int i=0;i<count;i++)
        {
            if(str.substring(i,i+1).contains("a"))
            {
                len++;
            }
        }


        System.out.println("length is"+len);
    }

}



