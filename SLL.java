import java.util.Scanner;
class Node
{
    int data;
    Node next;
    Node()
    {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter the data");
        data = ob.nextInt();
        next=null;
    }
}
public class SLL {
    Node head;
    int count;
    SLL()
    {
        head=null;
        count=0;
    }
    void insertBegin()
    {
        Node newnode = new Node();
        if(head==null)
            head = newnode;
        else
        {
            newnode.next = head;
            head = newnode;
        }
        count++;
    }

    void insertEnd()
    {
        Node newnode = new Node();
        if(head==null)
            head = newnode;
        else
        {
            Node ptr=head;
            while (ptr.next!=null) {
                ptr=ptr.next;
            }
            ptr.next = newnode;
        }
        count++;
    }

    void display()
    {
        if(head == null)
            System.out.println("List empty");
        else
        {
            System.out.println("List elements = ");
            Node ptr=head;
            while (ptr!=null) {
                System.out.print(ptr.data+"\t");
                ptr=ptr.next;
            }
            System.out.println("");
        }
    }

    void deleteBegin()
    {
        if(head==null)
            System.out.println("List is empty cannot delete");
        else
        {
            System.out.println("Deleting = "+head.data);
            head=head.next;
            count--;
        }
    }
    void deleteEnd()
    {
        if(head==null)
            System.out.println("List is empty cannot delete");
        else
        {
            Node pp,cp;
            pp = head;
            cp = head;
            while(cp.next!=null)
            {
                pp = cp;
                cp = cp.next;
            }
            System.out.println("Deleting = "+cp.data);
            pp.next=null;
            if(head.next==null)
                head=null;
            count--;
        }
    }

    void insertPos()
    {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter the pos");
        int pos = ob.nextInt();
        if(pos<1 || pos >count+1)
            System.out.println("Invalid pos");
        else if(pos==1)
            insertBegin();
        else if(pos==count+1)
            insertEnd();
        else
        {
            Node newnode = new Node();
            Node pp,cp;
            pp = head;
            cp=head;
            for(int i=1;i<pos;i++)
            {
                pp = cp;
                cp = cp.next;
            }
            pp.next = newnode;
            newnode.next = cp;
            count++;
        }
    }

    void deletePos()
    {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter the pos");
        int pos = ob.nextInt();
        if(pos<1 || pos >count)
            System.out.println("Invalid pos");
        else if(pos==1)
            deleteBegin();
        else if(pos==count)
            deleteEnd();
        else
        {
            Node pp,cp;
            pp = head;
            cp=head;
            for(int i=1;i<pos;i++)
            {
                pp = cp;
                cp = cp.next;
            }
            pp.next = cp.next;
            System.out.println("Deleting = "+cp.data);

            count--;
        }
    }




    public static void message()
    {
        System.out.println("1 Insert in the beginning");
        System.out.println("2 Insert in the end");
        System.out.println("3 Insert at the pos");
        System.out.println("4 Delete in the beginning");
        System.out.println("5 Delete at the end");
        System.out.println("6 Delete at the pos");
        System.out.println("7 Display");        
        System.out.println("8 Exit");
    }

    public static void main(String[] args) {
        SLL s = new SLL();
        int ch;
        Scanner ob = new Scanner(System.in);
        while(true)
        {
            message();
            System.out.println("Enter choice = ");
            ch = ob.nextInt();
            if(ch==8)
                break;
            switch (ch) {
                case 1:s.insertBegin();break;            
                case 2:s.insertEnd();break;           
                case 3:s.insertPos();break;
                case 4:s.deleteBegin();break;
                case 5:s.deleteEnd();break;
                case 6:s.deletePos();break;

                case 7:s.display();break;
                default:
                    break;
            }
        }        
    }
}