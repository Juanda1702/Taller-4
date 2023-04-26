package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelJugador extends JPanel implements ActionListener {
	
	private JTextField jugadas;
	private JTextField nombreJugador;

	public PanelJugador(PantallaPrincipal principal) {
		int alto = 50;
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(Box.createRigidArea(new Dimension(10,alto)));

		add(new JLabel("Jugadas:"));
		add(Box.createRigidArea(new Dimension(50,alto)));
		
		jugadas = new JTextField("0");
		add(jugadas);
		jugadas.setEditable(false);
		jugadas.setDisabledTextColor(Color.black);
		
		add(Box.createRigidArea(new Dimension(20,alto)));
		
		JLabel jugador = new JLabel("Jugador:");
		add(jugador);
		add(Box.createRigidArea(new Dimension(50,alto)));

		nombreJugador = new JTextField();
		
		add(nombreJugador);
		add(Box.createRigidArea(new Dimension(10,alto)));

	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void setJugadas(int cantidadJugadas) {
		cantidadJugadas++;
		String valor = Integer.toString(cantidadJugadas);
		jugadas.setText(valor);
	}
	
	public boolean hayJugador() {
		return nombreJugador.getText().isEmpty();
	}
	
	public String darJugador() {
		return nombreJugador.getText();
	}
	
	public int darJugadas() {
		return Integer.parseUnsignedInt(this.jugadas.getText());
	}
	
	public void cambiarNombre() {
		//nombreJugador;
	}
}
