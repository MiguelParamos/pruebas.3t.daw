package prueba.base.de.datos.daw;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

import javax.imageio.ImageIO;

import Utils.DAO;
import clases.Cliente;
import interfaces.Ventana;

public class Principal {

	public static void main(String[] args) {
		//Ventana v=new Ventana();
		
		
		/*File archivo=new File("./noExisto.txt");
		System.out.println("Existe el archivo: "+archivo.exists());
		try {
			System.out.println("Pude crear el archivo: "+archivo.createNewFile());
			System.out.println("Ruta absoluta: "+archivo.getAbsolutePath());
			System.out.println("Nombre: "+archivo.getName());
			System.out.println("carpeta madre: "+archivo.getParent());
			System.out.println("¿Es un directorio? "+archivo.isDirectory());
			System.out.println("tamaño total del disco duro: "+archivo.getTotalSpace()/1024f/1024f/1024f+" GB");
			System.out.println("tamaño libre del disco duro: "+archivo.getFreeSpace()/1024f/1024f/1024f+" GB");
			System.out.println("tamaño del archivo (bytes): "+archivo.length());
			System.out.println("fecha de modificación: "+archivo.lastModified());
			LocalDateTime ultimaMod=LocalDateTime.ofEpochSecond(archivo.lastModified()/1000, 0, 
					ZoneOffset.systemDefault().getRules().getOffset(Instant.now()));
			System.out.println("Fecha de modificación bien escrita: "+ultimaMod);
		
		
			//System.out.println("¿Pude borrarlo? "+archivo.delete());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		recorridoRecursivo(new File("./"));
	}
	
	public static void recorridoRecursivo(File carpeta) {
		if(carpeta.isDirectory()) {
			File[] hijos= carpeta.listFiles();
			for(short i=0;i<hijos.length;i++) {
				File hijoActual=hijos[i];
				if(hijoActual.isDirectory()) {
					recorridoRecursivo(hijoActual);
				}else {
					System.out.println(hijoActual.getAbsolutePath()+
						" : "+hijoActual.length()+" : "+
						LocalDateTime.ofEpochSecond(hijoActual.lastModified()/1000, 0, 
						ZoneOffset.systemDefault().getRules().getOffset(Instant.now())));
				}
			}
		}
	}

}
