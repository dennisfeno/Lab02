package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {

	private String alienWord;
	private List<String> translation;
	
	
	public WordEnhanced(String alienWord,String translation) {
		this.alienWord=alienWord;
		this.translation=new ArrayList<String>();
		this.translation.add(translation);
		}
	
	public List<String> getTranslation() {
		return translation;
	}

	public void setTranslation(List<String> translation) {
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	
	
	public List<String> compare(String alienWord){
		
		alienWord.toLowerCase();
		String s1=this.alienWord.toLowerCase();
		
		if(s1.compareTo(alienWord)==0)
			return this.translation;
		
		else return null;
		
	}

	public void addTranslation(String translation) {
		this.translation.add(translation);
	}
	
	
}
