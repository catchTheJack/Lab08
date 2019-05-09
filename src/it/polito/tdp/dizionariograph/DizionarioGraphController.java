package it.polito.tdp.dizionariograph;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {
	Model model = new Model();
	
	public void setModel(Model m) {
		this.model = m;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNum;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnGenera;

    @FXML
    private Button btnVicini;

    @FXML
    private Button btnGrado;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnReset;

    @FXML
    void doGenera(ActionEvent event) {
    	int numeroLettere =Integer.parseInt(txtNum.getText());
    	model.createGraph(numeroLettere);
    	txtArea.appendText("Generato grafo con "+model.getVert()+" vertici e "+model.getEdg()+" archi \n");
    }

    @FXML
    void doGradoMax(ActionEvent event) {
    	String cercata = txtParola.getText();
    	int numeroLettere =Integer.parseInt(txtNum.getText());
    	model.createGraph(numeroLettere);
    	model.displayNeighbours(cercata);
    	txtArea.appendText(""+model.findMaxDegree()+"\n");

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtNum.clear();
    	txtParola.clear();
    	txtArea.clear();

    }

    @FXML
    void doVicini(ActionEvent event) {
    	String cercata = txtParola.getText();
    	txtArea.appendText(model.displayNeighbours(cercata).toString()+"\n");

    }

    @FXML
    void initialize() {
        assert txtNum != null : "fx:id=\"txtNum\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnGenera != null : "fx:id=\"btnGenera\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnVicini != null : "fx:id=\"btnVicini\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnGrado != null : "fx:id=\"btnGrado\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

    }
}
