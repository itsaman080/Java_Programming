import java.util.*;
public class Stack{  
    int max,top;
    int[] a;
    Stack(){ 
        max=5;
        top=-1;
        a= new int[max];
    }
    public void push(){
        if(top==max-1){
            System.out.println("Stack Overflow");
        }
        else{
            Scanner src = new Scanner(System.in);
            System.out.println("Enter the Element");
            int ele = src.nextInt();
            top++;
            a[top]=ele;
        }
    }


    public void pop(){
        if(top==-1){
            System.out.println("Stack Underflow");
        }
        else{
            System.out.println("Deleting = "+a[top]);
            top--;
        }
    }


    public void display(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("The Stack element are ");
            for(int i=top;i>=0;i--)
                System.out.println(a[i]);
        }
    }
    
    public static void main(String[] args) {
        Stack st = new Stack();
        while (true) {
            System.out.println("1 PUSH 2 POP 3 DISPLAY 4 EXIT");
            System.out.println("Enter Choice ");
            Scanner ob=new Scanner(System.in);
            int ch = ob.nextInt();
            if(ch == 4){
                break;
            }
            switch (ch) {
                case 1:st.push(); break;
                case 2:st.pop();break;
                case 3:st.display();break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
