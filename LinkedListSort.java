import java.util.*;

class LinkedListSort{
    class Node{
		 int data;
		 Node next;
    }

    Node head;

    public void insertValuesFunc(int data){
    	Node nodenew = new Node();
    	if(head == null){
    		nodenew.data = data;
    		nodenew.next = null;
    		head = nodenew;
    	}
    	else{

    		Node temp = head;
    		while(temp.next!= null){
    			temp = temp.next;
    		}
    		nodenew.data = data;
    		temp.next = nodenew;
    		nodenew.next = null;
    	}
   }
   public void printValues(){
   	   Node temp = head;
   	   while(temp != null){
   	   	System.out.println("datavalues are " + temp.data);
   	   	temp = temp.next;
   	   }
   }
   public void sort(){
	   	System.out.println("\nInside sort method\n");
	   		Node temp = head;
	   		Node temp1;
	   		Node first = head;

	   		while(temp.next!= null){
	   			Node min = temp;
	   			Node temp2 = temp;
	   			Node last = temp;
	   			while(temp2.next != null){
	   				if(min.data > temp2.next.data){
	   					min = temp2.next;
	   					last = temp2;
	   				}
	   				temp2= temp2.next;
	   			}
	   			if(min != temp){

	   				if(last != temp){

	   					last.next = temp;
	   					temp1 = temp.next;
	   					temp.next = min.next;
	   					min.next = temp1;
	   				}
	   				else{
	   					temp.next = min.next;
	   					min.next = temp;
	   				}

	   			if(first!=temp){
	   				first.next = min;
	   			}
	   			else{
	   				head = min;
	   			}
	   		}

	   		temp = min;
	   		first = temp;
	   		temp= temp.next;
	   	 }
	   	}

   public static void main(String[] args){
   	 LinkedListSort l = new LinkedListSort();

   	 Random randomInteger = new Random();
   	 for(int i = 0;i<15;i++){
   		int  r = randomInteger.nextInt(10);
   	    l.insertValuesFunc(r);
   	 }
   	 l.printValues();
   	 l.sort();
   	 System.out.println("\nafter sorting\n");
   	 l.printValues();
   }
}
