import java.util.*;
class  Queue {
    int[] a;
    int max,front,rear;
    Queue()
    {
        max=5;
        front=0;
        rear=-1;
        a = new int[max];
    }
    void enqueue()
    {
        if(rear-front == max-1)
            System.out.println("Queue overflow");
        else{
            System.out.println("Enter the element = ");
            Scanner ob = new Scanner(System.in);
            int ele = ob.nextInt();
            rear++;
            a[rear%max]=ele;
        }
    }
    void dequeue()
    {
        if(front > rear)
            System.out.println("Queue underflow");
        else{
            System.out.println("Deleted element = "+a[front%max]);
            a[front%max]=0;
            front++;
        }
    }
    void display()
    {
        if(front > rear)
            System.out.println("Queue empty");
        else{
            System.out.println("Elements are  ");
            for(int i=0;i<max;i++)
                System.err.print(a[i]+ "\t");

            System.err.println();
        }
    }
}


public class Circular_Queue {
    public static void main(String[] args) {
    Queue que = new Queue();
    while (true)
    {
        System.out.println("1 ENQUEUE 2 DEQUEUE 3 DISPLAY 4 EXIT ");
        System.out.println("Enter choice = ");
        Scanner ob1 = new Scanner(System.in);
        int ch = ob1.nextInt();
        if(ch == 4)
        break;
        switch(ch)
        {
            case 1 :que.enqueue();break;
            case 2: que.dequeue();break;
            case 3: que.display();break;
            default:  System.out.println("invalid choice");
        }
    }
  }
}
