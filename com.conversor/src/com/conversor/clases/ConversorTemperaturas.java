package com.conversor.clases;

import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ConversorTemperaturas {
	
	String[] opcionesDeConversionT = {"De Celcius a Kelvin","De Celcius a Fahrenheit","De Kelvin a Celcius","De Fahrenheit a Celcius"};
	String[] escalasTemperatura= {"Kelvin","Fahrenheit","Celcius","Celcius"};
	 private String cantidadTAConvertir;
	  private double valor;
	private double celciusAKelvin=0.0;
	    private double celciusAFarethei=0.0;
	   private double kelvinACelcius=0.0;
	    private double fahrenheitACelcius=0.0;
	  
	  
public void setCantidadAConverit() {
	 //cuanto
	ImageIcon icono = new ImageIcon("/Users/Nicolas/Desktop/termometro.jpg");
	 
	  do { cantidadTAConvertir =  (String) JOptionPane.showInputDialog(null,"Ingresa el valor que deseas convertir",null,JOptionPane.PLAIN_MESSAGE,icono,null,null); 
	   try {valor= Double.parseDouble(cantidadTAConvertir);}catch(NumberFormatException e) {e.printStackTrace();
	   valor=Double.NaN;}
	
	  }while(Double.isNaN(valor));
}
public void setygetConversion() {
	  //Que conversion T
	  String tipoDeConversionT = (String)(JOptionPane.showInputDialog(null, "Elige qué conversión quieres realizar",null,JOptionPane.PLAIN_MESSAGE,null,opcionesDeConversionT,"Selecione")).toString();	  
switch (tipoDeConversionT) {
case "De Celcius a Kelvin":
	 celciusAKelvin=valor+273.15;	
	break;
case "De Celcius a Fahrenheit":
	celciusAFarethei= (valor * 9/5) + 32;
	
	break;
	case "De Kelvin a Celcius" :
		kelvinACelcius= valor-273.15;
		
		break; 
		case "De Fahrenheit a Celcius":
			fahrenheitACelcius=(valor - 32) * 5/9;
			break;
default:
	break;
}
Object[] VariablesTemperatura = {     celciusAKelvin,  celciusAFarethei, kelvinACelcius, fahrenheitACelcius};
int indiceT=Arrays.asList(opcionesDeConversionT).indexOf(tipoDeConversionT) ;
double variableAretornar=(double) VariablesTemperatura[indiceT];
	//resultado de conversion con su determinada escala de temperatura
	JOptionPane.showMessageDialog(null,"Tienes "+String.format("%.2f",variableAretornar)+"° " +escalasTemperatura[indiceT]);

}
public static void iniciarConversionT() {
	ConversorTemperaturas ct= new ConversorTemperaturas();
	ct.setCantidadAConverit();
	ct.setygetConversion();
}

}

