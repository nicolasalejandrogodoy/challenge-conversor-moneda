package com.conversor.clases;

import java.util.Arrays;
import com.conversor.api.divisas.ApiDivisas;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ConversorDivisas extends Conversor{

	
private String seleccionDeConversion;
private Double conversion;
private String cantidadAConvertirString;
private Double cantidadAConvertir;
private Integer indice;

double aDolar = ApiDivisas.arsObject.getDouble("aud");
double aEuro = ApiDivisas.arsObject.getDouble("eur");		  
double aLibra = ApiDivisas.arsObject.getDouble("gbp");	;
double aYen = ApiDivisas.arsObject.getDouble("jpy");
double aWon = ApiDivisas.arsObject.getDouble("krw");


String[] monedaString = { "Dolares", "Euros"  ,"Libras" ,"Yenes" ,"Wones","Pesos" ,"Pesos","Pesos","Pesos","Pesos"};






	@Override
	public void setCantidadAConvertir() {
		ImageIcon icono = new ImageIcon("/Users/Nicolas/Desktop/divisa.jpg");
		  do { cantidadAConvertirString =  (String) JOptionPane.showInputDialog(null,"Ingresa el valor que deseas convertir",null,JOptionPane.PLAIN_MESSAGE,icono,null,null);  
		   try {cantidadAConvertir=Double.parseDouble(cantidadAConvertirString);}catch(NumberFormatException e) {e.printStackTrace();
		   cantidadAConvertir=(double) -1;}
		
		  }while(cantidadAConvertir<0);
	}
	
	public void setMoneda() {
		seleccionDeConversion = (String)(JOptionPane.showInputDialog(null, "Elige la moneda a la que quieras convertir tu dinero","input",JOptionPane.PLAIN_MESSAGE,null,opcionesDeConversion,"Selecione")).toString();
	}
	public Double getCantidadAConvertir() {
		return this.cantidadAConvertir;}
	
	String[] opcionesDeConversion= {"De Pesos a Dollar","De Pesos a Euros","De Pesos a Libras","De Pesos a Yen","De Pesos a Won Coreano","De Dollar a Pesos","De Euro a Pesos ","De Libras a Pesos ","De Yen a Pesos","De Won Coreano a Pesos"};

	public void getConversion() {
		switch(seleccionDeConversion) {
		case "De Pesos a Dollar":
			conversion= cantidadAConvertir * aDolar;
			break;
		case "De Pesos a Euro":
			conversion= cantidadAConvertir * aEuro;
			break;
		case"De Pesos a Libras" :
			conversion= cantidadAConvertir *aLibra ;
			break;
		case"De Pesos a Yen" :
			conversion= cantidadAConvertir*aYen ;
			break;
		case "De Pesos a Won Coreano":
			conversion= cantidadAConvertir *aWon;
			break;
		case"De Dollar a Pesos" :
			conversion= cantidadAConvertir/aDolar ;
			break;
		case "De Euro a Pesos ":
			conversion=  cantidadAConvertir/aEuro;
			break;
		case "De Libras a Pesos ":
			conversion=  cantidadAConvertir/aLibra;
			break;
		case"De Yen a Pesos" :
			conversion= cantidadAConvertir/aYen ;
			break;
		case"De Won Coreano a Pesos" :
			conversion= cantidadAConvertir/aWon ;
			break;
			default:
				break;
		}}
	public void mostrarConversion() {
		indice=Arrays.asList(opcionesDeConversion).indexOf(seleccionDeConversion);
		JOptionPane.showMessageDialog(null,"Tienes "+String.format("%.2f",conversion)+" " +monedaString[indice]);;}
	
//	public void getConversion() {
//		// TODO Auto-generated method stub
//		indice=Arrays.asList(opcionesDeConversion).indexOf(seleccionDeConversion);
//		Double moneda;
//		moneda=(Double) referenciasDeConversion[indice];
//		if(indice<=4){
//	  		
//	  		conversion = getCantidadAConvertir() * moneda;
//	  		JOptionPane.showMessageDialog(null,"Tienes "+String.format("%.2f",conversion)+" " +monedaString[indice]);
//	  			}else {
//	  		conversion = getCantidadAConvertir() / moneda;
//	  		JOptionPane.showMessageDialog(null,"Tienes "+String.format("%.2f",conversion)+" " +monedaString[indice]);;}
//		}

	public static void iniciarConversorMonedas() {
//		ApiDivisas.iniciarApi();
		ConversorDivisas cd =new ConversorDivisas();
	
			cd.setCantidadAConvertir();
			cd.setMoneda();
			cd.getConversion();
	cd.mostrarConversion();


}}
