package datastructreTest;

public class Stack {
	
	int arr[];
    int top;
    int capacity;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    boolean isFull() {
        return top + 1 == capacity;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int x) {
        if (isFull()) {
            System.out.println("Overflow! Cannot push " + x);
        } else {
            top++;
            arr[top] = x;
            System.out.println("Inserting: " + x);
        }
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty: Cannot pop");
        } else {
            System.out.println("Removing: " + arr[top]);
            top--;
        }
    }

    void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Printing stack:");
            for (int i = 0; i <= top; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    int size() {
        return top + 1;
    }
	
	

	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack myStack = new Stack(5);

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.pop();
        myStack.push(50); // Adding another element after popping one
        myStack.push(60); // Adding another element
        myStack.pop();
        
        System.out.println("Current stack: " + myStack.size());
        myStack.printStack(); // Print the stack after operations

	}

}
