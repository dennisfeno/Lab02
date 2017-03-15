package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	private List<WordEnhanced> dictionary;

	public AlienDictionary() {
		dictionary = new ArrayList<WordEnhanced>(); 
	}
	
	public Boolean addWord(String alienWord, String translation){
				
		Boolean presente=false; // controllo se questa parola c'è o meno
				 
		int ln = this.dictionary.size();
		
		for (int i = 0 ; i < ln ; i++) {
			//System.out.println(this.dictionary.get(i).getAlienWord()+" - ");
			//System.out.println(this.dictionary.get(i).getTranslation()+ "\n");
			
			if (this.dictionary.get(i).compare(alienWord)!=null){ // se trovo una corrispondenza
				
				presente=true;
				this.dictionary.get(i).addTranslation(translation);
				
			}
			
		}
		
		
		if(!presente)
			this.dictionary.add(new WordEnhanced(alienWord,translation));

		return presente;
		
	}
	
	
	public List<String> translateWord(String alienWord){
		
		int ln = this.dictionary.size();
		
		List<String> s1 = null;
		
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

	public List<String> wildCard(String alienWord){
		
		int ln = this.dictionary.size();
		Boolean ok=false;
		
		List<String> wild = new ArrayList<String>();
		String s1;
		
		for (int i = 0 ; i < ln ; i++) {
			
			ok = true;
			s1 = this.dictionary.get(i).getAlienWord();
			
		    if(s1.length() != alienWord.length()) ok=false;

		    if (ok){
			    for(int j=0; j<s1.length(); j++){
			        char c1 = s1.charAt(i), c2 = alienWord.charAt(i);
			        if(c1!='?' && c2!='?' && c1!=c2)
			            ok=false;
			    }
			}
		    
		    if (ok)
		    	wild.add(s1);
		}
		
		if(wild!=null) return wild;
		
		else
			return null; 
	}
	
}
