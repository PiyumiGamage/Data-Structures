
package datastructreTest;

public class qeue {

	   
		public static class queue{
			
			int front;
			int rear;
			int capacity;
			int noltem;
		
		int queueArr[];
		
		queue(int size){
			
			capacity =size;
			front =0;
			rear = -1;
			
			queueArr = new int[size];
			
			
			
		}
		
		
		 boolean isFull() {
			 return rear +1 == capacity;
		 }
		 
		 boolean isEmpty(){
			return front>rear; 
			 
		 }
		 
		 void enQueue(int x){
			 if(isFull()) {
				 System.out.println("The Queue is Full");
			 }
		
		 
			 else {
				 rear++;
				 queueArr[rear]= x;
				 System.out.println("inserting"+x);
				 
			 }
		 
		 }
		 
		 
		 void deQueue() {
			 
			 if(isEmpty()) {
				System.out.println("The Queue is Empty!"); 
				 
			 }
			 else {
				 
				 System.out.println("Removing"+queueArr[front]);
			      
				 front++;
				 
			 }
		 
		 
		 }
		 
		   void printQueue() {
			   for(int i=front;i<=rear;i++) {
				  System.out.println(queueArr[i]+" "); 
			   }
			   
		   }
		  public static void main(String arg[]) {
			  queue myqueue=new queue(5);
		
			  
			  myqueue.enQueue(10);
			  myqueue.enQueue(20);
			  myqueue.enQueue(30);
			  myqueue.enQueue(40);
			  myqueue.enQueue(50);
			  myqueue.deQueue();
			  myqueue.deQueue();
			  
			  myqueue.printQueue();
			  
			  
			 
			  
		  }
		
		}
		

}


