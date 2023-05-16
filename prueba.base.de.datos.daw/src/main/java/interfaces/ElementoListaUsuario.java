package interfaces;

import javax.swing.JPanel;

import clases.Cliente;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;

public class ElementoListaUsuario extends JPanel{
	Ventana ventana;
	Cliente usuarioActual;
	public ElementoListaUsuario(Ventana v, Cliente c) {
		this.ventana=v;
		this.usuarioActual=c;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 78, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelEmail = new JLabel(usuarioActual.getEmail());
		labelEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.WEST;
		gbc_labelEmail.gridwidth = 4;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 0;
		add(labelEmail, gbc_labelEmail);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridheight = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel labelNombre = new JLabel(usuarioActual.getNombre());
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.gridwidth = 3;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 1;
		add(labelNombre, gbc_labelNombre);
		
		JLabel labelTelefono = new JLabel(""+usuarioActual.getTelefono());
		GridBagConstraints gbc_labelTelefono = new GridBagConstraints();
		gbc_labelTelefono.gridwidth = 3;
		gbc_labelTelefono.insets = new Insets(0, 0, 0, 5);
		gbc_labelTelefono.gridx = 0;
		gbc_labelTelefono.gridy = 2;
		add(labelTelefono, gbc_labelTelefono);
		ventana=v;
		usuarioActual=c;
	}
	

}
