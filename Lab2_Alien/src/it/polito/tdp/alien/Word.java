package it.polito.tdp.alien;

public class Word {

	private String alienWord;
	private String translation;
	
	
	public Word(String alienWord, String translation) {
		this.alienWord=alienWord;
		this.translation=translation;
		}
	
	

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}



	public String compare(String alienWord){
		
		alienWord.toLowerCase();
		String s1=this.alienWord.toLowerCase();
		
		if(s1.compareTo(alienWord)==0)
			return this.translation;
		
		else return null;
		
	}
		
	
}
