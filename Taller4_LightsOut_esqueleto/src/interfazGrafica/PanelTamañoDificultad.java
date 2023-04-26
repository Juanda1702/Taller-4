package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PanelTama�oDificultad extends JPanel implements ActionListener {

	final Color colorFondo = Color.decode("#69a8f5");
	JComboBox<String> listTama�o;
	PantallaPrincipal principal;
	ButtonGroup difGRupo;
	
	public PanelTama�oDificultad(PantallaPrincipal principal) {
		this.principal = principal;
		setBackground(colorFondo);		
		setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
		
		JLabel size = new JLabel("Tama�o:");
		add(size);
		
		String[] optionsTama�o = {"5x5", "7x7", "9x9"};
		listTama�o = new JComboBox<>(optionsTama�o);
		listTama�o.setPreferredSize(new Dimension(100, 25));
		add(listTama�o);
		
		listTama�o.addActionListener( this );
		listTama�o.setActionCommand("listTama�o");
		
		JLabel difLabel = new JLabel("Dificultad:");
		add(difLabel);
		difGRupo = new ButtonGroup();
		
		crearBotones();
	}

	public void crearBotones() {
		JRadioButton botonFacil = new JRadioButton();
		JRadioButton botonMedio = new JRadioButton();
		JRadioButton botonDificil = new JRadioButton();		
				
		difGRupo.add(botonFacil);
		difGRupo.add(botonMedio);
		difGRupo.add(botonDificil);
		
		botonFacil.setText("Facil");
		botonFacil.setActionCommand("Facil");
		
		botonMedio.setText("Medio");
		botonMedio.setActionCommand("Medio");
		
		botonDificil.setText("Dificil");
		botonDificil.setActionCommand("Dificil");
		
		add(botonFacil);
		add(botonMedio);
		add(botonDificil);
		
		botonFacil.setSelected(true);
	}

	public int getDificultad() {
		ButtonModel selected = difGRupo.getSelection();
		String dificultad = selected.getActionCommand();
		
		int num = 0;
		
		switch (dificultad) {
		case "Facil":
			num = 1;
			break;
		case "Medio":
			num = 30;
			break;
		case "Dificil":
			num = 50;
			break;

		default:
			break;
		}
		
		return num;
	}
	
    public void actionPerformed( ActionEvent e ){
		String[] selecionado = ((String)listTama�o.getSelectedItem()).split("");		   
		principal.setTama�oTablero(Integer.parseInt(selecionado[0]));
	}
}
