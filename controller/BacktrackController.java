package controller;

import view.IStringAlignerView;
import view.StringAlignerView;

public class BacktrackController {

    /** Panel */
    private IStringAlignerView stringAlignerView;

    private String firstWord;
    private String secondWord;
    private Object [][] grid;
    private int rowLength;
    private int colLength;
    
    private int currentRow;
    private int currentCol;
    
    private String alignedFirstWord;
    private String alignedSecondWord;
    
	
	public BacktrackController(StringAlignerView stringAlignerView) {
		this.stringAlignerView = stringAlignerView;
	}

	public void storeInputs(String firstWord, String secondWord, Object[][] grid) {
		this.firstWord = firstWord;
		this.secondWord = secondWord;
		this.grid = grid;
        this.rowLength = firstWord.length()+2;
        this.colLength = secondWord.length()+2;

		alignedFirstWord = "";
		alignedSecondWord = "";
        
        currentRow = 0;
        currentCol = colLength-1;
	}
	
	public void backtrackAndSaveValues() {
		
		while(!(currentRow==rowLength-2 && currentCol==1)) {
			updateAlignedString(getLeastValue());
			System.out.println(currentRow + " " + currentCol);
		}
		
		alignedFirstWord = new StringBuffer(alignedFirstWord).reverse().toString();
		alignedSecondWord = new StringBuffer(alignedSecondWord).reverse().toString();
		
		System.out.println("FIRST: " + alignedFirstWord);	
		System.out.println("SECND: " + alignedSecondWord);
		
	}
	
	private void updateAlignedString(int leastValue) {
        String reversedFirstWord = new StringBuffer(firstWord).reverse().toString();
        
		/** If not yet bottom row */
		if(currentRow<rowLength-2) {
			/** Check down value */
			if(leastValue == (int)grid[currentRow+1][currentCol]) {
				alignedFirstWord = alignedFirstWord.concat(String.valueOf(reversedFirstWord.charAt(currentRow)));
				alignedSecondWord = alignedSecondWord.concat("_");
				
				currentRow++;
				return;
			}
		}
		
		/** If not yet extreme left column */
		if( currentCol>1) {
			/** Check left value */
			if(leastValue == (int)grid[currentRow][currentCol-1]) {
				alignedFirstWord = alignedFirstWord.concat("_");
				alignedSecondWord = alignedSecondWord.concat(String.valueOf(secondWord.charAt(currentCol-2)));
				
				currentCol--;
				return;
			}
		}
		
		/** If not yet bottom and extreme left column */
		if(currentRow<rowLength-2 && currentCol>1) {
			/** Check diagonal value */
			if(leastValue == (int)grid[currentRow+1][currentCol-1]) {
				alignedFirstWord = alignedFirstWord.concat(String.valueOf(reversedFirstWord.charAt(currentRow)));
				alignedSecondWord = alignedSecondWord.concat(String.valueOf(secondWord.charAt(currentCol-2)));
				
				currentRow++;
				currentCol--;
				return;
			}
		}
		
	}

	private int getLeastValue() {
		
		int leastValue = (int)grid[currentRow][currentCol];
		
		/** If not yet bottom row */
		if(currentRow<rowLength-2) {
			/** Get down value */
			if((int)grid[currentRow+1][currentCol] < leastValue)
				leastValue = (int) grid[currentRow+1][currentCol];
		}
		
		/** If not yet extreme left column */
		if(currentCol>1) {
			/** Get left value */
			if((int)grid[currentRow][currentCol-1] < leastValue)
				leastValue = (int)grid[currentRow][currentCol-1];
		}
		
		/** If not yet bottom and extreme left column */
		if(currentRow<rowLength-2 && currentCol>1) {
			/** Get diagonal value */
			if((int)grid[currentRow+1][currentCol-1] < leastValue)
				leastValue = (int)grid[currentRow+1][currentCol-1];
		}
		
		return leastValue;
	}

}
