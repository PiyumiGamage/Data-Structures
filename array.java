package datastructreTest;

import java.util.Scanner;

public class array {
	
	public static void main(String[] args) {
		 int arr[] = new int[10];
	        int size = 5;

	        Scanner in = new Scanner(System.in);

	        System.out.println("Enter Data:");
	        for (int j = 0; j < size; j++) {
	            arr[j] = in.nextInt();
	        }
	      
	        System.out.println("Output of Array");
	        for (int i = 0; i < size; i++) {
	            System.out.print(arr[i]+", ");
	        }
	        
	        
	        //insert
	        System.out.println("\nEnter the index You need to insert Element:");
	        int ind = in.nextInt();

	        System.out.println("Enter the Element you need to insert:");
	        int ele = in.nextInt();

	        size++;

	        for (int k = size - 1; k > ind; k--) {
	            arr[k] = arr[k - 1];
	        }

	        arr[ind] = ele;

	        System.out.println("Output of array after inserting");
	        for (int i = 0; i < size; i++) {
	        	System.out.print(arr[i]+", ");
	        }

	        
	        
	        
	        //delete
	        System.out.println("\nEnter the index you need to delete:");
	        ind = in.nextInt();

	        for (int j = ind; j < size - 1; j++) {
	            arr[j] = arr[j + 1];
	        }

	        size--;

	        System.out.println("Output of array after deleting");
	        for (int i = 0; i < size; i++) {
	        	System.out.print(arr[i]+", ");
	        }

	        System.out.println("\nEnter the data for search:");
	        int data = in.nextInt();

	        int k;
	        for (k = 0; k < size; k++) {
	            if (arr[k] == data) {
	                break;
	            }
	        }

	        if (k == size) {
	            System.out.println("Element not found");
	        } else {
	            System.out.println("Element found at index: " + k);
	        }

	        
	        in.close();
		
		

	}

}
