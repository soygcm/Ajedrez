import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ViewAjedrez extends JFrame{
	
	private ArrayList<ArrayList<JLabel>> tableroLabel;
	private JPanel pantalla;
	private Color color = new Color(237, 233, 104, 255);

	public void arranca() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public ViewAjedrez() {

		setTitle("Ordenar Letras Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pantalla = new JPanel();
        tableroLabel = new ArrayList<ArrayList<JLabel>>();
        
        add(pantalla);
	}

	public void dibujarTablero(int tamanoTablero) {
		
		pantalla.setLayout(new GridLayout(tamanoTablero, tamanoTablero));

		for (int i = 1; i <= tamanoTablero; i++) {
	        ArrayList<JLabel> filasLabel = new ArrayList<JLabel>();
			for (int j = 1; j <= tamanoTablero; j++) {
				JLabel boton = new JLabel();
				boton.setPreferredSize(new Dimension(50, 50));
				boton.setOpaque(true);
				
				if (j%2==0) {
	    				if (i%2 ==0) {
	        				boton.setBackground(color);
	    				}
				}else{
					if (i%2 ==1) {
	    					boton.setBackground(color);
					}
				}
				filasLabel.add(boton);				
				pantalla.add(boton);
			}
			tableroLabel.add(filasLabel);
		}
		pack();
	}

	public void dibujarCaballo(Posicion posicion, int numero) {

		
		JLabel label = tableroLabel.get(posicion.getFila()-1).get(posicion.getColumna()-1);
		
		label.setText("♞" + numero);
		
	}

	public void borrarCaballo(Posicion posicion) {
		JLabel label = tableroLabel.get(posicion.getFila()-1).get(posicion.getColumna()-1);
		
		label.setText("");
		
	}
	
	

}
