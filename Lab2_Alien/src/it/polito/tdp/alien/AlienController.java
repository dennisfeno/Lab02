package it.polito.tdp.alien;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    private AlienDictionary dictionary = new AlienDictionary();

    @FXML
    void doReset(ActionEvent event) {

    	txtWord.setText("");
    	txtResult.setText("Welcome to Alien Dictionary v2017\n");
    	
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String s = txtWord.getText();
    	List<String> traduzione= null;
    	//così " dovrebbe " funzionare 
    	
    	//txtResult.appendText(s.matches("[a-zA-Z]*")+": parola\n");    	
    	//txtResult.appendText(s.matches("[a-zA-Z]*[' '][a-zA-Z]*")+": traduzione\n");

    	if(s.matches("[a-zA-Z]*")){ // search word
    		
    		traduzione=dictionary.translateWord(s);
    		
    		if(traduzione!=null){
    			
	    		txtResult.appendText(String.format("La traduzione di %s è ",s));
    			
    	    	for(String p: traduzione)    			
    	    		txtResult.appendText(String.format("%s      ",p));
    	    	
    	    	txtResult.appendText(".\n");
    		}
    		else{
        		txtResult.appendText("Parola non trovata.\n");
    		}
    		
    	}
    	else if(s.matches("[a-zA-Z?]*")){ // wildcard
    		
    		//txtResult.appendText("C'è un punto di domanda.\n");
    		
    		int len = s.length();
    		int count = 0;
    		List<String> stamp = null;
    		
    		for(int i=0; i<len ; i++){
    			if(s.charAt(i)=='?')
    				count++;
    		}
    		
    		if(count==1){
    			//txtResult.appendText("Ok.\n");
    			stamp=dictionary.wildCard(s);
    			
    			if(stamp!=null){
    				for(String vedi: stamp){ // per ogni parola della lista
    		    		traduzione=dictionary.translateWord(vedi);
    		    		    		    			
    			    		txtResult.appendText(String.format("La traduzione di %s è ",vedi));
    		    			
    		    	    	for(String p: traduzione)    			
    		    	    		txtResult.appendText(String.format("%s      ",p));
    		    	    	
    		    	    	txtResult.appendText(".\n");
    		    		}
    			}
    			else{
        			txtResult.appendText("Nessuna corrispondenza trovata.\n");
    			}
    		}
    		else
    			txtResult.appendText("Ricerca assistita non disponibile.\n");

    		
    	}
    	else if(s.matches("[a-zA-Z]*[' '][a-zA-Z]*")){ //add translation
    		
    		String[] divido = s.split(" ");
    		Boolean present=dictionary.addWord(divido[0], divido[1]);
    		
    		if(present)
        		txtResult.appendText("Traduzione aggiunta.\n");
    		else
    			txtResult.appendText("Parola aggiunta.\n");
    	}
    	else {
    		txtResult.appendText("Inserisci un pattern valido.\n");
    	}
    	
    	
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    	txtResult.setText("Welcome to Alien Dictionary v2017\n");
        
    }
}
