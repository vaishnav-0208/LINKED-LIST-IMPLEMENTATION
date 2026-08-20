
public class LinkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

                        public void addfirst(int data){
                            Node newNode=new Node(data);
                            size++;
                            if(head==null){
                                head=tail=newNode;
                                return;
                            }
                            newNode.next=head;
                            head=newNode;
                        }
                        public void addlast(int data){
                            Node newNode=new Node(data);
                            size++;
                            if(head==null){
                                head=tail=newNode;
                                return;
                            }
                            tail.next=newNode;
                            tail=newNode;
                        }
                                    
    
    
    
    
                    public void display(){
                    if(head==null){
                        System.out.print("LL si empty");
                    }
                    Node temp=head;
                    while(temp!=null){
                        System.out.print(temp.data +"--->");
                        temp=temp.next;
                    }
                    System.out.println("null");
                }
                   
    
    
    
    
                        public void addmid(int idx,int data){
                        if(idx==0){
                            addfirst(data);
                            return;
                        }
                        Node newNode=new Node(data);
                        size++;
                        Node temp=head;
                        int i=0;
                        while(i<idx-1){
                            temp=temp.next;
                            i++;
                        }
                        newNode.next=temp.next;
                        temp.next=newNode;
                    }
                    
    
    
                    public int removeFirst(){
                    if(size == 0){
                        System.out.println("Linked list is empty");
                        return Integer.MAX_VALUE;
                    }
                    int val = head.data;
                    if(size == 1){
                        head = tail = null;
                    } else {
                        head = head.next;
                    }
                    size--;
                    return val;
                }

               
               
               
                public int removeLast(){
                if(size == 0){
                    System.out.println("empty ll");
                    return Integer.MAX_VALUE;
                }

                if(size == 1){
                    int val = head.data;
                    head = tail = null;
                    size--;
                    return val;
                }

                Node prev = head;
                for(int i = 0; i <=size - 2; i++){
                    prev = prev.next;
                }

                int val = tail.data;
                prev.next = null;
                tail = prev;
                size--;
                return val;
            }


            public int searchingLL(int key){
                Node temp=head;
                int i=0;
                while(temp!=null){
                    if(temp.data==key){         //Searching linearly through a linked list.
                        return i;               //easy method.
                    }
                    temp=temp.next;
                    i++;
                }
                return -1;
            }


            public int RecHelper(Node head,int key){
                if(head == null){
                    return -1;
                }
                if(head.data==key){
                    return 0;                                   //searching recursively htrough a linked list.
                }
                int index=RecHelper(head.next,key);
                if(index==-1){
                    return -1;
                }
                return index=1;
            }
            public int RecSearchLL(int key){
                return RecHelper(head, key);

            }

            
// GFG problem

// Given the head of a Singly Linked List and a value x.
// The task is to insert the key in the middle of the linked list.
// Examples :
// Input: LinkedList = 1->2->4 , x = 3
// Output: 1->2->3->4
// Explanation: 
// The new element is inserted after the current middle element in the linked list.
// Input: LinkedList = 10->20->40->50 , x = 30
// Output: 10->20->30->40->50
// Explanation: 
// The new element is inserted after the current middle
// element in the linked list and Hence, the output is 10->20->30->40->50.java
        


public Node insertInMiddle(Node head, int x) {
        // Code here
         Node newNode = new Node(x);
        
        // If list is empty
        if (head == null) {
            return newNode;
        }

        Node slow = head;
        Node fast = head;

        // Find middle using slow & fast pointers
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Insert after middle
        newNode.next = slow.next;
        slow.next = newNode;

        return head;
    }


    //reversing a linked list
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;

    }



    //removing  nth node from the end 
    public void DeleteNthNode(int n){
        int sz=0;
        Node Temp=head;
        while (Temp!=null) {
            Temp=Temp.next;
            sz++;         
        }

        if(n==sz){
            head=head.next;     //delets if i=1 that is first deleting
            return;
        }


        int i=1;
        int iToFind=sz-n;
        Node prev=head;
        while(i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }


    //slow pointer technique to find the mid node
    public Node Findmid(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast==fast.next.next;
        }
        return fast;
    }


    //main code for palindrome linked list
    public boolean palindrome(){
        if(head!=null  || head.next==null){
            return true;
        }
        Node midNode=Findmid(head);

        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node right=prev;
        Node left=head;


        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }






    public static void main(String args[]){
        LinkedList ll=new LinkedList();
        //   ll.display();
        // ll.head=new Node(10);
        //   ll.display();
        // ll.head.next=new Node(20);
        //   ll.display();
        // ll.head.next.next=new Node(30);
        //   ll.display();
        // ll.tail=ll.head.next.next;
        // ll.addfirst(1);
        // ll.addfirst(2);
        //   ll.display();
        // ll.addlast(1000);
        // ll.addlast(200);
        // ll.display();
        // // System.out.println(size);
        // // ll.removeFirst();
        // // ll.display();                        ****  these lines are also usefull  but due to more clumsiness i deleted
        // // ll.removeLast();                     commented out them.....
        // // System.out.println(size);
        // // ll.display();
        // // ll.serchingLL(20);
        // System.out.println("The index of the 30 is :"+ll.searchingLL(30));
        // System.out.println("The index of 1000 is :"+ll.searchingLL(1000));
        // System.out.println("the index of 10 using Recursice is :"+ll.RecSearchLL(10));
        // ll.reverse();
        // ll.display();
        // ll.DeleteNthNode(3);
        // ll.display();
    
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(2);
        ll.addlast(1);
        ll.display();
        System.out.println(ll.palindrome());

    }
}