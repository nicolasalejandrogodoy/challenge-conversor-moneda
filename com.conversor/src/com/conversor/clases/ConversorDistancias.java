package com.conversor.clases;
import javax.swing.ImageIcon;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class ConversorDistancias extends Conversor{

	private String cantidadDAConvertirString;
	private String[] opcionesConversion= {"Centimetros a milimetros","Centimetros a decimetros","Centimetros a metros","Cenimetros a kilometros"};
	private String[] unidadesConversion= {"milimetros","decimetros","metros","kilometros"};
private String seleccionDeConversion;
	private Double cantidadAConvertir;
	private Double conversion;
	private int indice;
	
	

	
	@Override
	public void getConversion() {
		seleccionDeConversion = (String)(JOptionPane.showInputDialog(null, "Elige la unidad de medida a la que quieres convertir",null,JOptionPane.PLAIN_MESSAGE,null,opcionesConversion,"Selecione")).toString();
switch(seleccionDeConversion) {
case"Centimetros a milimetros" : 
	conversion=cantidadAConvertir*10;
	break;
case"Centimetros a decimetros" : 
	conversion=cantidadAConvertir/10;
	break;
case"Centimetros a metros" : 
	conversion=cantidadAConvertir/100;
	break;
case "Cenimetros a kilometros": 
	conversion=cantidadAConvertir/1000;
	break;
	default:
		break;
}
	}

	

	@Override
	public void setCantidadAConvertir() {
		// TODO Auto-generated method stub
	
ImageIcon icono = new ImageIcon("/Users/Nicolas/Desktop/rule.jpg");
	 do { cantidadDAConvertirString =  (String) JOptionPane.showInputDialog(null,"Ingresa el valor que deseas convertir",null,JOptionPane.PLAIN_MESSAGE,icono,null,null); 
	   try {cantidadAConvertir= Double.parseDouble(cantidadDAConvertirString);}catch(NumberFormatException e) {e.printStackTrace();
	   cantidadAConvertir=Double.NaN;}
	
	  }while(Double.isNaN(cantidadAConvertir));
	

}
	public void mostrarConversion() {
		indice=Arrays.asList(opcionesConversion).indexOf(seleccionDeConversion);
		JOptionPane.showMessageDialog(null,"Tienes "+String.format("%.3f",conversion)+" " +unidadesConversion[indice]);;}
	public static void iniciarConversorDistancias() {
		ConversorDistancias ct = new ConversorDistancias();
		ct.setCantidadAConvertir();;
		ct.getConversion();
		ct.mostrarConversion();
	}}
