package com.conversor.test;
import com.conversor.api.divisas.*;
public class testApi {
public static void main(String[] args) {
	ApiDivisas api =new ApiDivisas();
	api.iniciarApi();
System.out.println(	ApiDivisas.arsObject.getDouble("aud")
);}
}
