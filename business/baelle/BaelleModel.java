package business.baelle;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

import business.Sportartikel;
import business.SportartikelListe;
import ownUtil.*;

 public class BaelleModel 
// 	extends Observable {
    implements Observable{
	 
	private Vector<Observer> observers = new Vector<Observer>();
 
 	
	private SportartikelListe<Ball> baelle = new SportartikelListe<>();
	//private Ball[] baelle = new Ball[100];
	
	//private int anzahlBaelle;
	
	private static BaelleModel baelleModel;
	
	private BaelleModel() {		
	}
	
	public static BaelleModel getInstance() {
		if(baelleModel == null) {
			baelleModel = new BaelleModel();
		}
		return baelleModel;
	}
	
	//public int getAnzahlBaelle() {
	//	return anzahlBaelle;
	//}

	//public void setAnzahlBaelle(int anzahlBaelle) {
	//	this.anzahlBaelle = anzahlBaelle;
	//}
	
	//public Ball[] holeBaelle() {
	//	//Ball[] result = new Ball[this.getAnzahlBaelle()];
	//	Ball[] result = new Ball[baelle.length()]
	//	for(int i = 0; i < result.length; i++) {
	//		result[i] = this.baelle[i];
	//	}
	//	return result;
	//}
	public SportartikelListe<Ball> getBaelle(){
		return this.baelle;
	}
	
	public Ball gibBall(String einkaufsdatum) {
		Ball ball = null;
		int i = 0;
		//while (ball == null && i < this.getAnzahlBaelle()) {
		//	if(Integer.parseInt(einkaufsdatum) == this.holeBaelle()[i].getEinkaufsdatum()){
		//		ball = this.holeBaelle()[i];
		//	}
		//	i++;
		//}
		while(ball == null && i < this.baelle.getAnzahlSportartikel()) {
			if(Integer.parseInt(einkaufsdatum) == this.baelle.getAnzahlSportartikel()) {
				ball = this.baelle.getSportartikel(i);
			}
		}
		return ball;
	}
	
	public void addObserver(Observer obs){
		this.observers.addElement(obs);
	}
	
	public void removeObserver(Observer obs){
		this.observers.removeElement(obs);
	}
	
	public void notifyObservers(){
		for(int i = 0; i < this.observers.size(); i++){
			this.observers.elementAt(i).update();
		}
	}

	// Die Fabrik-Methode wurde zum Lesen aus der CsvDatei nicht angewendet
	public void leseBaelleAusDatei()
	    throws Exception{
	    BufferedReader ein = new BufferedReader(new FileReader("Baelle.csv"));
	   	//for(int i = 0; i < this.anzahlBaelle; i++) {
	   	// 	this.baelle[i] = null;
	   	//}
	    this.baelle.removeAllSportartikel();
	    
	   	//this.anzahlBaelle = Integer.parseInt(ein.readLine());
	    int anzahlBaelle = Integer.parseInt(ein.readLine());
	   	String[] zeile;
	   	for(int i = 0; i < anzahlBaelle; i++) {
	   		zeile = ein.readLine().split(";");
	   		this.baelle.addSportartikel(new Ball(
	   			Integer.parseInt(zeile[0]), 
	   			zeile[1], zeile[2], zeile[3], zeile[4], 
	   			Double.parseDouble(zeile[5])));
	   	}
	    ein.close();
//		setChanged();
    	notifyObservers();
 	}
}