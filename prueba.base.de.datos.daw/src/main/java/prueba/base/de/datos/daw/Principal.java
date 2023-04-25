package prueba.base.de.datos.daw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dime tu email");
		String email=sc.nextLine();
		System.out.println("Dime tu nombre");
		String nombre=sc.nextLine();
		System.out.println("Dime tu contraseña");
		String contraseña=sc.nextLine();
		System.out.println("Dime tu telefono");
		int telefono=Integer.parseInt(sc.nextLine());
		try {
			
			
			Connection conexion=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/bicicletasdaw","root","admin"
					);
			Statement smt=conexion.createStatement();
			String consulta="insert into cliente values('"+email+"','"+contraseña+"',"+telefono+",'"+nombre+"')";
			System.out.println(consulta);
			smt.executeUpdate(consulta);
			
			smt.close();
			conexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
