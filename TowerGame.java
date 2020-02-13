package towerOfHanoi;

import java.util.Scanner;

public class TowerGame {
	static int currentScore = 0;

	public static void main(String[] args) {
		Tower t1 = new Tower(1, true);
		Tower t2 = new Tower(2, false);
		Tower t3 = new Tower(3, false);
		
		Scanner scan = new Scanner(System.in);
		
		boolean isFinished = false;
		
		while(true) {
			// print current state
			for (int level = 0; level < 5; level++) {
				String outputLevel = t1.getStringAtLevel(level) + t2.getStringAtLevel(level) + t3.getStringAtLevel(level);
				System.out.println(outputLevel);
			}
			System.out.println(" ===1===  ===2===  ===3===");
			
			System.out.println("# of moves: " + currentScore);
			//get user input for which towers to change
			System.out.print("Enter FROM tower: ");
			int fromPegNum = scan.nextInt();
			System.out.print("Enter TO tower: ");
			int toPegNum = scan.nextInt();
			
			for (int i = 0; i < 15; i++) {
				System.out.println("");
			}
			
			Tower fromTower = t1, toTower = t1;
			//use if statements to assign fromTower and toTower t1, t2, t3 (as appropriate) using fromPeg and toPeg
			if (fromPegNum == 1)
				fromTower = t1;
			if (fromPegNum == 2)
				fromTower = t2;
			if (fromPegNum == 3)
				fromTower = t3;
			
			if (toPegNum == 1)
				toTower = t1;
			if (toPegNum == 2)
				toTower = t2;
			if (toPegNum == 3)
				toTower = t3;
			
			if (fromPegNum == 0 && toPegNum == 0) {
				t1.pieces = "12345";
				t2.pieces = "00000";
				t3.pieces = "00000";
				currentScore = -1;
			}else {
		
			//use getTopPieces(), removeTopPiece, and addTopPiece (as appropriate) to move pieces
				int fromTop = fromTower.getTopPiece();
				int toTop = toTower.getTopPiece();
				
				if (fromTop < toTop || toTop == 0) {
					int top = fromTower.removeTopPiece();
					toTower.addTopPiece(top);
				}else {
					System.out.println("Not a valid move. Try again!");
				}
			}
			
			currentScore++;
			
			//check for win condition
			if (t3.isFull()) {
				isFinished = true;
			}
			
			if (isFinished) {
				// print current state one last time
				for (int level = 0; level < 5; level++) {
					String outputLevel = t1.getStringAtLevel(level) + t2.getStringAtLevel(level) + t3.getStringAtLevel(level);
					System.out.println(outputLevel);
				}
				System.out.println(" ===1===  ===2===  ===3===");
				
				System.out.println("Congradulations! That took you " + currentScore + " moves!");	
				break;
			}
		}
	}
}
