package controller;

import view.IStringAlignerView;
import view.StringAlignerView;

public class StringAlignerController {
	
	/** Panel */
	private IStringAlignerView stringAlignerView;
	
	private String firstWord;
	private String secondWord;
	private int grid[][];
	
	public StringAlignerController(StringAlignerView stringAlignerView) {
		this.stringAlignerView = stringAlignerView;
	}

	public void storeUserInputs(String firstWord, String secondWord) {
		this.firstWord = firstWord;
		this.secondWord = secondWord;
	}
	
	public void formGrid() {
		
	}

}
