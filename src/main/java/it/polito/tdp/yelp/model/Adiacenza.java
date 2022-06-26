package it.polito.tdp.yelp.model;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

public class Adiacenza {
	
	String b1;
	LatLng cordB1;
	
	String b2;
	LatLng cordB2;
	
	double peso;

	public Adiacenza(String b1, LatLng cordB1, String b2, LatLng cordb2) {
		this.b1 = b1;
		this.cordB1 = cordB1;
		this.b2 = b2;
		this.cordB2 = cordb2;
		this.peso = LatLngTool.distance(cordB1,cordB2, LengthUnit.KILOMETER);
	}

	public String getB1() {
		return b1;
	}

	public LatLng getCordB1() {
		return cordB1;
	}

	public String getB2() {
		return b2;
	}

	public LatLng getCordB2() {
		return cordB2;
	}

	public double getPeso() {
		return peso;
	}
	
	

}
