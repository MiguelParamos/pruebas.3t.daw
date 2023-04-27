package prueba.base.de.datos.daw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

import Utils.DAO;

public class Principal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		Byte opcion;
		do {
			System.out.println("Dime qué quieres hacer:"
					+ "\n\t0 - Salir"
					+ "\n\t1 - Insertar cliente"
					+ "\n\t2 - Borrar cliente"
					+ "\n\t3 - Modificar cliente"
					+ "\n\t4 - Mostrar clientes");
			opcion=Byte.parseByte(sc.nextLine());
			switch(opcion) {
			case 1:
				System.out.println("Dime tu email");
				String email=sc.nextLine();
				System.out.println("Dime tu nombre");
				String nombre=sc.nextLine();
				System.out.println("Dime tu contraseña");
				String contraseña=sc.nextLine();
				System.out.println("Dime tu telefono");
				int telefono=Integer.parseInt(sc.nextLine());
				try {
					HashMap<String,String> cols=new HashMap<String,String>();
					cols.put("email", email);
					cols.put("nombre",nombre);
					cols.put("password", contraseña);
					DAO.insertar("cliente",cols);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Dime el email de la persona a borrar");
				String emailABorrar=sc.nextLine();
				try {
					HashMap<String,String> columnasBorrar=new HashMap<String,String>();
					columnasBorrar.put("email", emailABorrar);
					if(DAO.borrar("cliente",columnasBorrar)==0) {
						System.out.println("No se ha podido borrar: El email no existía");
					}else {
						System.out.println("Borrado con éxito");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				
				break;
			case 4:
				try {
					LinkedHashSet columnasSacar=new LinkedHashSet<String>();
					columnasSacar.add("email");
					columnasSacar.add("password");
					columnasSacar.add("telefono");
					columnasSacar.add("nombre");
					HashMap<String,String> restricciones=new HashMap<String,String>();
					ArrayList<Object> cliente=
					DAO.consultar("cliente",columnasSacar,restricciones);
					for(byte i=0;i<cliente.size();i++) {
						System.out.print(cliente.get(i)+" : ");
					}
					System.out.println();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}while(opcion!=0);
		
		
		
	}

}
