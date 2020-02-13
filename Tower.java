package towerOfHanoi;

public class Tower {
	/* pieces will contain info on the size of the tower such that 1 = smallest piece, 5 = largest piece
	 * if tower has no pieces the string will be empty (i.e. " ")
	 * string numbers will be in ascending order
	 */
	
	public String pieces;
	private int pegNumber;
	private boolean isStart;
	
	/* based on pegNumber and isStart, constructor should
	 * set values for pieces and pegNumber
	 * if isStart, pieces should be filled with non-zero numbers
	 * if not isStart, String pieces should be all zeros (of size MAX_PIECES)
	 */
	
	public Tower(int pegNumber, boolean isStart) {
		this.pegNumber = pegNumber;
		this.isStart = isStart;
		if (isStart == true) {
			this.pieces = "12345";
		}else {
			this.pieces = "00000";
		}
	}
	
	// getter methods
	public String getPieces() {
		return pieces;
	}
	
	public int getPegNumber() {
		return pegNumber;
	}
	
	/*getStringAtLevel will return the string that shows the piece on that level for this tower
	 * it will show a "  |  " if the spot has no piece, 
	 * or it will show "A", "/A\", "AAA", "/AAA\", "AAAAA", "/AAAAA\" depending on size of piece. 
	*/
	
	public String getStringAtLevel(int level) {
		String temp = this.getPieces();
		char p = temp.charAt(level);
		if (p == '1')
			return "    A    ";
		if (p == '2')
			return "   /A\\   ";
		if (p == '3')
			return "   AAA   ";
		if (p == '4')
			return "  /AAA\\  ";
		if (p == '5')
			return "  AAAAA  ";
			
		
		return "    |    ";
	}
	
	/* getTopPieces() will return the size of the smallest non-zero piece in tower
	 * will return 0 if all pieces are zero
	 */
	
	public int getTopPiece() {
		for (int i = 0; i < 5; i++) {
			char p = this.getPieces().charAt(i);
			int a = Character.getNumericValue(p);
			
			if (a != 0)
				return a;
		}
		return 0;
	}
	
	/* removeTopPiece() will take away the smallest non-zero piece in a tower
	 * String pieces should replace that number with zero in the String
	 * return whatever size that piece is 
	 */
	
	public int removeTopPiece() {
		int p = this.getTopPiece();
		int place = 0;
		for (int i = 0; i < 5; i++) {
			char check = this.getPieces().charAt(i);
			int test = Character.getNumericValue(check);
			if(test == p) {
				place = i;
			}
		}
		this.pieces = this.getPieces().substring(0,place) + "0" + this.getPieces().substring(place+1);
		return p;
	}
	
	/* addTopPiece() will add pieceSize to the appropriate spot in the String pieces
	 * replacing a zero (the last zero) in String
	 */
	
	public void addTopPiece(int pieceSize) {
		int place = 0;
		for (int i = 0; i < 5; i++) {
			char check = this.getPieces().charAt(i);
			int test = Character.getNumericValue(check);
			if(test != 0) {
				place = (i - 1);
				break;
			}else {
				place = 4;
			}
		}
		this.pieces = this.getPieces().substring(0,place) + pieceSize + this.getPieces().substring(place+1);
	}
	
	public boolean isFull() {
		if (pieces.equals("12345")) {
			return true;	
		}
		return false;
	}


}
