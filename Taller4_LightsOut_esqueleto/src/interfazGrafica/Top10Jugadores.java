package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class Top10Jugadores extends JFrame implements MouseMotionListener{
	
	PantallaPrincipal principal;
	JLabel[] listaLabels = new JLabel[10];
	JPanel listaTop ;

	public Top10Jugadores(PantallaPrincipal principal) {
		setLayout(new BorderLayout());
		setSize(200, 500);
		setResizable(false);
		setLocationRelativeTo(null) ;
		addMouseMotionListener(this);
		
		this.principal = principal;
		
		JLabel titulo = new JLabel("# Nombre");
		titulo.setHorizontalAlignment(0);
		titulo.setPreferredSize(new Dimension(WIDTH, 50));
		titulo.setBackground(Color.decode("#69a8f5"));;
		titulo.setOpaque(true);
		add(titulo,BorderLayout.NORTH);
		
		cargarTop();
		llenarLista();
		
	}
	
	public void cargarTop() {
		principal.cargarTop10();
	}
	
	public void llenarLista() {
		
		listaTop =  new JPanel();
		listaTop.setLayout(new GridLayout(10, 1));
		
		Collection<RegistroTop10> listaRegistro = principal.getTop();
		int i = 1;
		for (RegistroTop10 registro: listaRegistro) {
			JLabel datos = new JLabel(i + " " + registro.darNombre() + "..." + registro.darPuntos());
			listaLabels[i-1]=datos;
			datos.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			listaTop.add(datos);
			i ++;
			
		}
		
		add(listaTop);
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		if (e!= null) {
			int y = e.getY();
			
			y = y - (500-listaTop.getHeight());
			
			if (y>0) {
				y = y/(listaTop.getHeight()/10);
				for (int i = 0; i<10; i++) {
					if (i==y) {
						listaLabels[y].setBackground(Color.black);
						listaLabels[y].setForeground(Color.WHITE);
						listaLabels[y].setOpaque(true);;
					} else {
						listaLabels[i].setForeground(Color.BLACK);
						listaLabels[i].setOpaque(false);;
					}
				}
			}
		} 
	}
}
