package hanoiTest;

public class HanoiPuzzle {
	 
    public static void hanoi(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " -> " + target);
            return;
        }
        hanoi(n - 1, source, target, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " -> " + target);
        hanoi(n - 1, auxiliary, source, target);
    }
	
	public static void main(String[] args) {
		int n = 2; // Number of disks
	     hanoi(n, 'A', 'B', 'C');

	}

}
