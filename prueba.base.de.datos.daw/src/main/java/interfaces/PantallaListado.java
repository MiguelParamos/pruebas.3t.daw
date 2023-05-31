package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import auxiliares.interfaz.BotonAzul;
import auxiliares.interfaz.BotonRojo;
import clases.Cliente;

import javax.swing.BoxLayout;

public class PantallaListado extends PanelMadre{
	private Ventana ventana;
	
	public PantallaListado(Ventana v) {
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel labelBienvenido = new JLabel("Bienvenid@, "+
		ventana.clienteLogado.getNombre());
		add(labelBienvenido, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		BotonAzul btnNewButton = new BotonAzul("New button");
		panel.add(btnNewButton);
		
		BotonAzul btnNewButton_1 = new BotonAzul("New button");
		panel.add(btnNewButton_1);
		
		BotonRojo btnNewButton_2 = new BotonRojo("New button");
		panel.add(btnNewButton_2);
		
		BotonAzul btnNewButton_3 = new BotonAzul("New button");
		panel.add(btnNewButton_3);
		
		JScrollPane lista = new JScrollPane();
		add(lista, BorderLayout.CENTER);
		
		JPanel contenedorElementos = new JPanel();
		lista.setViewportView(contenedorElementos);
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));
		
		try {
			ArrayList<Cliente> clientes=Cliente.getTodos();
			for(short i=0;i<clientes.size();i++) {
				contenedorElementos.add(
				new ElementoListaUsuario(ventana,clientes.get(i)));
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	

}
