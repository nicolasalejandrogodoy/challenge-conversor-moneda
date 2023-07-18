package com.conversor.ventanas;
import com.conversor.clases.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



import com.conversor.api.divisas.*;
import java.awt.Font;
import java.awt.Cursor;


public class PruebaVentana extends JFrame{

	private JMenuBar menuBar;
	private JMenu menu;	
	private JMenuItem opcion1;
	private JMenuItem opcion2;
	private JMenuItem opcion3;
	private JMenuItem opcion4;
	
	public PruebaVentana () {
		setSize(400,300);
		setTitle("Conversor ONE");
		
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
	
	
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setFont(new Font("Roboto", Font.PLAIN, 10));
		panel.setBounds(10, 80, 376, 32);
		mostrarMenu();
		getContentPane().setLayout(null);
		panel.add(menuBar);
		getContentPane().add(panel);
		
		}
	public void mostrarMenu(){
		//inicializacin de los atributos
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Roboto", Font.PLAIN, 12));
	
		menu = new JMenu("Elija una opción");
		menu.setVisible(true);
		opcion1 = new JMenuItem("Conversor de monedas");
		opcion2 = new JMenuItem("Conversor de temperaturas");
		opcion3=new JMenuItem("Conversor de distancias");
		opcion4= new JMenuItem("Salir");
		
		opcion1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConversorDivisas.iniciarConversorMonedas();

			}
		});
		opcion2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConversorTemperaturas.iniciarConversionT();
			}
		});
		opcion3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConversorDistancias.iniciarConversorDistancias();
			}
		});
		opcion4.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
JOptionPane.showMessageDialog(null, "Saliendo");
System.exit(0);
			}
		});
		menu.add(opcion1);
		menu.add(opcion2);
		menu.add(opcion3);
		menu.add(opcion4);
		menuBar.add(menu);
		menu.setBounds(50, 20, 60,30);

	}
	
	
	public static void main(String[] args) {
		PruebaVentana GUI = new PruebaVentana();
		GUI.setVisible(true);
		GUI.setLocationRelativeTo(null);
		ApiDivisas.iniciarApi();
	}
}
