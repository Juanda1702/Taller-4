package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.http.WebSocket.Listener;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class PantallaPrincipal extends JFrame implements Listener {

	PanelTamañoDificultad panelTamañoDificultad;
	
	PanelTablero panelTablero;
	
	PanelMenu panelMenu;
	
	PanelJugador panelJugador;
	
	Top10 top10;
	
	RegistroTop10 registroTop10;

	
	public PantallaPrincipal() {
		
		setSize(800, 765);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
		panelTamañoDificultad = new PanelTamañoDificultad(this);
		add(panelTamañoDificultad, BorderLayout.NORTH);
		
		panelMenu = new PanelMenu(this);
		add(panelMenu,BorderLayout.EAST);

		panelJugador = new PanelJugador(this);
		add(panelJugador,BorderLayout.SOUTH);
		
		panelTablero = new PanelTablero(5,this);
		add(panelTablero, BorderLayout.CENTER);
	
		top10 = new Top10();
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try {
					top10.salvarRecords(new File("./data/top10.csv"));
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	public void setTamañoTablero(int i) {
		panelTablero.setTamaño(i);
	}
	
	public void reiniciar() {
		panelTablero.reiniciar();
	}
	
	public int getDificultad() {
		return panelTamañoDificultad.getDificultad();
	}

	public void nuevo() {
		panelTablero.nuevo();
	}

	public void top10() {
		Top10Jugadores top10 = new Top10Jugadores(this);
		top10.setVisible(true);
	}
	
	public void cambiarNombre() {
		panelJugador.cambiarNombre();
	}
	
	public void cargarTop10() {
		top10.cargarRecords(new File("./data/top10.csv"));
	}
	
	public Collection<RegistroTop10> getTop() {
		return top10.darRegistros();
	}
	
	public void revisarGanador() {
		boolean ganador = panelTablero.darTablero().tableroIluminado();
		if (ganador) {
			int puntaje = darPuntaje();
			JOptionPane.showMessageDialog(null, "¡Ganaste!\n" + "Tu puntaje fue: " + puntaje, "¡Eres el mejor!", JOptionPane.INFORMATION_MESSAGE);
			top10.agregarRegistro(panelJugador.darJugador(), puntaje);
		}
	}
	
	public int darPuntaje() {
		return panelTablero.darPuntaje();
	}
	
	public boolean checkJugador() {
		boolean nombre = panelJugador.hayJugador();
		if (nombre) {
			return false;
		}
		else {
			return true;
		}
	}
}
