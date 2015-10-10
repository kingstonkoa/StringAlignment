package controller;

import java.util.ArrayList;
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
    private ArrayList<Integer> backTrackPath = new ArrayList<>();
    
	
	public BacktrackController(StringAlignerView stringAlignerView) {
		this.stringAlignerView = stringAlignerView;
		alignedFirstWord = "";
		alignedSecondWord = "";
	}

	public void storeInputs(String firstWord, String secondWord, Object[][] grid) {
		this.firstWord = firstWord;
		this.secondWord = secondWord;
		this.grid = grid;
        this.rowLength = firstWord.length()+2;
        this.colLength = secondWord.length()+2;
        
        currentRow = 0;
        currentCol = colLength-1;
	}
	
	public void backtrackAndSaveValues() {
		
		while(currentRow!=rowLength-2 && currentCol!=1) {
			updateAlignedString(getLeastValue());
		}
		
		alignedFirstWord = new StringBuffer(alignedFirstWord).reverse().toString();
		alignedSecondWord = new StringBuffer(alignedSecondWord).reverse().toString();
		
		System.out.println("FIRST: " + alignedFirstWord);	
		System.out.println("SECND: " + alignedSecondWord);
		
	}
	
	private void updateAlignedString(int leastValue) {
        String reversedFirstWord = new StringBuffer(firstWord).reverse().toString();
        
		/** Check down value */
		if(leastValue == (int)grid[currentRow+1][currentCol]) {
			alignedFirstWord = alignedFirstWord.concat(String.valueOf(reversedFirstWord.charAt(currentRow)));
			alignedSecondWord = alignedSecondWord.concat("_");
                        backTrackPath.add(currentRow+1);
                        backTrackPath.add(currentCol);
			
			currentRow++;
			return;
		}
		/** Check diagonal value */
		else if(leastValue == (int)grid[currentRow+1][currentCol-1]) {
			alignedFirstWord = alignedFirstWord.concat(String.valueOf(reversedFirstWord.charAt(currentRow)));
			alignedSecondWord = alignedSecondWord.concat(String.valueOf(secondWord.charAt(currentCol-2)));
                        backTrackPath.add(currentRow+1);
                        backTrackPath.add(currentCol-1);
                        
			currentRow++;
			currentCol--;
			return;
		}
		/** Check left value */
		else if(leastValue == (int)grid[currentRow][currentCol-1]) {
			alignedFirstWord = alignedFirstWord.concat("_");
			alignedSecondWord = alignedSecondWord.concat(String.valueOf(reversedFirstWord.charAt(currentCol-2)));
                        backTrackPath.add(currentRow);
                        backTrackPath.add(currentCol-1);
                        
			currentCol--;
			return;
		}
		
	}

	private int getLeastValue() {
		
		int leastValue;
		
		/** Get down value */
		leastValue = (int) grid[currentRow+1][currentCol];
		
		/** Get diagonal value */
		if((int)grid[currentRow+1][currentCol-1] < leastValue)
			leastValue = (int)grid[currentRow+1][currentCol-1];
		
		/** Get left value */
		if((int)grid[currentRow][currentCol-1] < leastValue)
			leastValue = (int)grid[currentRow][currentCol-1];
		
		return leastValue;
	}

        public ArrayList<Integer> getBacktrackPath()
        {
            return backTrackPath;
        }

}
