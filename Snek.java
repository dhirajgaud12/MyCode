import java.util.Random;
import java.util.Stack;

public class Snek {
    static int XCoordinate,YCoordinate,head,temphead;
    static Stack<Integer> snake=new Stack<>();
    //static Stack<Integer> snakecopy=new Stack<>();

    static String laststep="";
    static String grid[][]={
            {"","","","",""},
            {"","","","",""},
            {"","","","",""},
            {"","","","",""},
            {"","","","",""}
    };


    public static void main(String[] args) {

        snake.push(1);
        head=snake.get(0);

        snake.push(2);
        snake.push(3);
        snake.push(4);
        printgrid();


        populateprey();
    isPreyEaten();

    //makeduplicate();
    moveDown();



    moveDown();
    moveDown();
    moveRight();
    moveUp();
    moveUp();
        moveRight();


        //destroyoldsnake();


        printgrid();
        isSnakeDead();

//        while(true)
//        {
//            if(isSnakeDead())
//            {
//                break;
//            }
//        }

    }

    private static boolean isSnakeDead() {

        for(int i=1;i<snake.size();i++)
        {
            if(head==snake.get(i))
            {
                System.out.println("Your snake is dead");
               return true;
            }
        }
        System.out.println("Your snake is not dead");

        return false;
    }


//    private static void destroyoldsnake() {
//        for(int i=0;i<snakecopy.size();i++)
//        {
//            if(!(snake.contains(snakecopy.get(i))))
//            {
//                int elementnum=snakecopy.get(i);
//                XCoordinate=elementnum/5;
//                YCoordinate=elementnum%5;
//
//                grid[XCoordinate][YCoordinate]="";
//            }
//        }
//    }

    private static void printgrid() {
//Check this method
        System.out.println("Snake size is"+snake.size());
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j]="";
            }
        }

        for(int i=0;i<snake.size();i++)
        {
            temphead=snake.get(i);
            temphead=temphead-1;
            XCoordinate=temphead/5;
            YCoordinate=temphead%5;


            grid[XCoordinate][YCoordinate]="O";
        }


        for(int i=0;i<5;i++)
        {
            for (int j=0;j<5;j++)
            {
                if(grid[i][j]=="O" )
                {
                    System.out.print(grid[i][j]);
                }
                else
                {
                    //System.out.println(" ");
                }
            }
            System.out.println();
        }

    }



    private static void eatPrey(int head) {
        int snakesize=snake.peek();
        snake.push(1+snakesize);
    }

    private static void moveUp() {
        head=snake.get(0);
        temphead=head;

        if(head>=5)
        {
            head=head-5;

            int snakesize=snake.size()-1;

            for(int i=snakesize;i>=1;i--)
            {
                snake.set(i,snake.get(i-1));
            }
            snake.set(0,head);

            laststep="Up";
        }

    }

    private static void moveDown() {
        head=snake.get(0);
        temphead=head;
        if(head<=20)
        {
            head=head+5;

            int snakesize=snake.size();

            snake.set(0,head);
            for(int i=snakesize;i>=1;i--)
            {
                if(i==1)
                {
                    snake.set(1,temphead);
                }
                else
                {
                    snake.set(i-1,snake.get(i-2));
                }
            }
            laststep="Down";

        }
    }

    private static void moveLeft() {
        head=snake.get(0);
        temphead=head;


        if(temphead%5!=0)
        {
            head=head-1;

            int snakesize=snake.size();

            snake.set(0,head);
            for(int i=snakesize;i>=1;i--)
            {
                if(i==1)
                {
                    snake.set(1,temphead);
                }
                else
                {
                    snake.set(i-1,snake.get(i-2));
                }
            }
            laststep="Left";

        }
    }

    private static void moveRight() {
        head=snake.get(0);
        temphead=head;

        if(temphead%10!=0)
        {
            head=head+1;

            int snakesize=snake.size();

            snake.set(0,head);
            for(int i=snakesize;i>=1;i--)
            {
                if(i==1)
                {
                    snake.set(1,temphead);
                }
                else
                {
                    snake.set(i-1,snake.get(i-2));
                }
            }
            laststep="Right";

        }
    }

    private static boolean isPreyEaten() {
        int PreyCoordinate=XCoordinate*5+YCoordinate;

        if(head==PreyCoordinate)
        {
            eatPrey(PreyCoordinate);
            return true;
        }
        else {
            return false;
        }
    }



    private static void populateprey() {
        Random random=new Random();

        XCoordinate=random.nextInt(5);
        YCoordinate=random.nextInt(5);

        grid[XCoordinate][YCoordinate]="P";

    }


}



