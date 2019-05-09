package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;


import it.polito.tdp.dizionariograph.db.WordDAO;

public class Model {
	WordDAO tdao ;
	Graph<String,DefaultEdge> grafo;
	final int maxLettereDiverse = 1;
	List<String> parole;
	
	
public Model() {	
	this.tdao = new WordDAO();
	this.grafo = new SimpleGraph<>(DefaultEdge.class);
	this.parole = null;
}

	public void createGraph(int numeroLettere) {
		parole = tdao.getAllWordsFixedLength(numeroLettere);
		Graphs.addAllVertices(grafo, parole);
		
		for(String temp:parole) {
			for(String temp2 : parole) {
				if(edgeControl(temp,temp2)==true) {
					grafo.addEdge(temp, temp2);
				}
				
			}
		}
		
		//System.out.println(grafo);
	}

	
	public List<String> displayNeighbours(String parolaInserita) {
		List<String> allEdges = new ArrayList<String>();
		for(String temp: parole) {
			if(grafo.getEdge(parolaInserita, temp) != null) {
				allEdges.add(temp);
			}
			
		}
		
		//System.out.println(allEdges);
		return allEdges;
	}

	
	public int findMaxDegree() {
		int maxDim = 0;
		for(String temp : parole) {
			List<String> temporary = displayNeighbours(temp);
			if(temporary.size()>maxDim)
				maxDim = temporary.size();
		}
		//System.out.println(maxDim);
		return maxDim;
	}
	
	
	private boolean edgeControl(String p1, String p2) {
		boolean control = false;
		int count = 0;
		int lung = p1.length();
		char[] pc1 = p1.toCharArray();
		char[] pc2 = p2.toCharArray();
		if(p1.compareTo(p2)!=0) {
				for(int i=0; i<lung; i++) {
					if(pc1[i]!=pc2[i])
						count++;
				}	
			}
		if(count==maxLettereDiverse) {
			control = true;
		}
		return control;	
		}
	
	
	public int getVert() {
		return parole.size();
	}
	
	public int getEdg() {
		return grafo.edgeSet().size();
	}
	}

