/*package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienControllerPunto1 {

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
    	String traduzione= null;
    	//così " dovrebbe " funzionare 
    	
    	//txtResult.appendText(s.matches("[a-zA-Z]*")+": parola\n");    	
    	//txtResult.appendText(s.matches("[a-zA-Z]*[' '][a-zA-Z]*")+": traduzione\n");

    	if(s.matches("[a-zA-Z]*")){ // search word
    		
    		traduzione=dictionary.translateWord(s);
    		
    		if(traduzione!=null){
        		txtResult.appendText(String.format("La traduzione di %s è %s.\n",s,traduzione));
    		}
    		else{
        		txtResult.appendText("Parola non trovata.\n");
    		}
    		
    	}
    	else if(s.matches("[a-zA-Z]*[' '][a-zA-Z]*")){ //add translation
    		
    		String[] divido = s.split(" ");
    		Boolean present=dictionary.addWord(divido[0], divido[1]);
    		
    		if(present)
        		txtResult.appendText("Traduzione aggiornata.\n");
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
*/