package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel implements ActionListener {
	private final Color colorFondo = Color.decode("#69a8f5");
	private PantallaPrincipal principal;
	
	public PanelMenu(PantallaPrincipal principal) {		
		this.principal = principal;
		
		setPreferredSize(new Dimension(150, 630));
		setLayout(new GridLayout(20, 3));
		
		
		JButton nuevo = new JButton("Nuevo");
		JButton reiniciar = new JButton("Reiniciar");
		JButton top = new JButton("Top-10");
		JButton CambiarJugador = new JButton("Cambiar jugador");
		
		JButton [] botones = {nuevo, reiniciar, top, CambiarJugador};
		
		for (JButton boton : botones) {
			boton.setBackground(colorFondo);
			boton.addActionListener( this );
		}
		
		add(new JLabel( ));
		add(new JLabel( ));
		add(new JLabel( ));
		add(new JLabel( ));
		add(nuevo);
		add(new JLabel( ));
		add(reiniciar);
		add(new JLabel( ));
		add(top);
		add(new JLabel( ));
		add(CambiarJugador);
		add(new JLabel( ));
	}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		switch (action) {
		case "Nuevo":
			principal.nuevo();
			break;
			
		case "Reiniciar":
			principal.reiniciar();
			break;
			
		case "Top-10":
			principal.top10();
			break;
			
		case "Cambiar jugador":
			principal.cambiarNombre();
			break;

		default:
			break;
		}
	}
}
