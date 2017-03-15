package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionaryPunto1 {

	private List<Word> dictionary;

	public AlienDictionaryPunto1() {
		dictionary = new ArrayList<Word>(); 
	}
	
	public Boolean addWord(String alienWord, String translation){
				
		Boolean presente=false; // controllo se questa parola c'è o meno
				 
		int ln = this.dictionary.size();
		
		for (int i = 0 ; i < ln ; i++) {
			//System.out.println(this.dictionary.get(i).getAlienWord()+" - ");
			//System.out.println(this.dictionary.get(i).getTranslation()+ "\n");
			
			if (!this.dictionary.get(i).compare(alienWord).isEmpty()){ // se trovo una corrispondenza
				
				presente=true;
				this.dictionary.get(i).setTranslation(translation);
				
			}
			
		}
		
		
		if(!presente)
			this.dictionary.add(new Word(alienWord,translation));

		return presente;
		
	}
	
	
	public String translateWord(String alienWord){
		
		int ln = this.dictionary.size();
		
		String s1 = null;
		
		for (int i = 0 ; i < ln ; i++) {
			//System.out.println(this.dictionary.get(i).getAlienWord()+" - ");
			//System.out.println(this.dictionary.get(i).getTranslation()+ "\n");
			
			if(this.dictionary.get(i).compare(alienWord)!=null){
				s1=this.dictionary.get(i).compare(alienWord);
			}
			
		}
		
		if(s1!=null) return s1;
		
		else
			return null; 
	}

	
	
}
