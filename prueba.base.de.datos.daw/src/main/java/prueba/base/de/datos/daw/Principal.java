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
import clases.Cliente;
import interfaces.Ventana;

public class Principal {

	public static void main(String[] args) {
		try {
			ArrayList<Cliente> clientes = Cliente.getTodos();
			for(Cliente c: clientes) {
				System.out.println("Nombre: "+c.getNombre()+", Email: "+c.getEmail()+" ,Telefono: "+c.getTelefono());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
