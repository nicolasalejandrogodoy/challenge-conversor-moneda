package com.conversor.api.divisas;

import org.json.JSONObject;
	import java.net.URL;
	import java.util.Scanner;

	import javax.net.ssl.HttpsURLConnection;

public class ApiDivisas {
	

	public static JSONObject arsObject;


public static void iniciarApi() {
    StringBuilder cadenaDeInformacion = new StringBuilder();
	try {
		// Solicitar una petición https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/ars.json
		URL url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/ars.json"); //creamos url
			HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection(); //abrimos conexion con la url
			conexion.setRequestMethod("GET"); //establecemos nombre para el metodo de peticion
			conexion.connect(); // conectamos
			
			//comprobamos si la conexion fue exitosa
			int CodigoDeRespuesta = conexion.getResponseCode();
			if(CodigoDeRespuesta != 200) {
				throw new RuntimeException("Ha ocurrido un error: " +CodigoDeRespuesta );
			}else {
				//abrir un escaner que lea el flujo de datos

				Scanner scanner = new Scanner(url.openStream());
				//abrimos el flujo de datos
				//mientras el scanner tenga una siguiente linea
				while(scanner.hasNext()) {
					
					//vamos a estar añadiendo de scanner su siguiente linea
					
					  cadenaDeInformacion.append(scanner.nextLine());
				
					
				}
				//una vez termina de leer el flujo de datos cerramos el scanner
				scanner.close();
				//leemos los datos por consola
				//System.out.println(cadenaDeInformacion);
}
				
	JSONObject jsonarray = new JSONObject(cadenaDeInformacion.toString()); 							 
	 arsObject = jsonarray.getJSONObject("ars");

}catch(Exception e) {
e.printStackTrace();
}
	



}


	
	


	
			

			
		

}


