package interfazGrafica;

import com.formdev.flatlaf.FlatLightLaf;

public class InterfazGrafica {

	public static void main(String[] args) {
		FlatLightLaf.install();
		PantallaPrincipal principal = new PantallaPrincipal();
		principal.setLocationRelativeTo( null );
		principal.setVisible(true);
	}
}