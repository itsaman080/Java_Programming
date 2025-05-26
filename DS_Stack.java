import java.util.*;
class Stack
{
    int max,top1,top2;
    int[] a;
    Stack()
    {
        max=5;
        a = new int[max];
        top1=max;
        top2=-1;
    }
    public  void push()
    {
        if(top1-top2==1)
            System.out.println("Stack overflow");
        else
        {
            Scanner ob = new Scanner(System.in);
            System.out.println("Enter the element = ");
            int ele = ob.nextInt();
            System.out.println("Enter 1 insert from top 2 insert from bottom ");
            int chInsert = ob.nextInt();
            if(chInsert == 1)
            {
                top1--;
                a[top1] = ele;
            }
            else if (chInsert == 2)
            {
                top2++;
                a[top2] = ele;
            }
            else
                System.out.println("Invalid choice");
        }
    }
    public  void pop()
    {
        System.out.println("POP");
        System.out.println("Enter 1 pop from top 2 pop from bottom ");
        Scanner ob = new Scanner(System.in);
        int chInsert = ob.nextInt();
        if(chInsert == 1)
        {
            if(top1==max)
                System.out.println("overflow from top bottom");
            else
                System.out.println("deleting = "+a[top1++]);
        }
        else if(chInsert == 2)
        {
            if(top2==-1)
                System.out.println("overflow from top bottom");
            else
                System.out.println("deleting = "+a[top2--]);
        }
        else
        {
            System.out.println("Invalid choice");
        }
    }
    public  void display()
    {
        if(top1==max && top2==-1)
            System.out.println("Stack is empty");
        else
        {
            System.out.println("the stack elements(top bottom) are = ");
            for(int i=max-1;i>=top1;i--)
                System.out.println(a[i]);
            System.out.println("the stack elements(bottom top) are = ");
            for(int i=top2;i>=0;i--)
                System.out.println(a[i]);


        }
    }
}

public class DS_Stack {
    public static void main(String[] args) {
        Stack st = new Stack();
        while (true) {
            System.out.println("1 PUSH 2 POP 3 DISPLAY 4 EXIT ");
            System.out.println("Enter choice = ");
            Scanner ob1 = new Scanner(System.in);
            int ch = ob1.nextInt();
            if(ch == 4)
                break;
            switch(ch)
            {
                case 1 :st.push();break;
                case 2: st.pop();break;
                case 3: st.display();break;
                default:  System.out.println("invalid choice");
            }
        }
  }
}
