package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	
	public PantallaRegistro(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setBounds(181, 54, 46, 14);
		add(lblNewLabel);
	}
	
}
