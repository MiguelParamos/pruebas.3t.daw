package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class DAO {
	private static Connection conexion;

	private static Statement conectar() {
		 try {
			conexion=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/bicicletasdaw","root","admin"
					);
			return conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private static void desconectar(Statement s) {
		try {
			s.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int insertar(String tabla,HashMap<String,String> columnas) throws SQLException {
		Statement smt=conectar();
		//insert into cliente (email,nombre,contraseña) values ('a@a.a','paco','mer');
		//insert into cliente (email,telefono,contraseña,nombre) values (
		String consulta="insert into "+tabla+" (";
		Iterator it=columnas.keySet().iterator();
		while(it.hasNext()) {
			consulta+=(String)it.next()+",";
		}
		consulta=consulta.substring(0,consulta.length()-1);
		consulta+=") values (";
		it=columnas.values().iterator();
		while(it.hasNext()) {
			consulta+="'"+(String)it.next()+"',";
		}
		consulta=consulta.substring(0,consulta.length()-1);
		consulta+=")";
		System.out.println(consulta);
		int ret=smt.executeUpdate(consulta);
		desconectar(smt);
		return ret;
	}
	
	public static int borrar(String tabla,HashMap<String,String> columnas) throws SQLException {
		Statement smt=conectar();
		String consulta="delete from "+tabla+" where ";
		Iterator it=columnas.entrySet().iterator();
		while(it.hasNext()) {
			Entry actual=(Entry)it.next();
			consulta+=(String)actual.getKey()+"='"+(String)actual.getValue()+"' and ";
		}
		consulta=consulta.substring(0,consulta.length()-5);
		System.out.println(consulta);
		int ret=smt.executeUpdate(consulta);
		desconectar(smt);
		return ret;
	}
	
}
