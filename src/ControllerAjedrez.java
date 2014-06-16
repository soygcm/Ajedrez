import java.util.ArrayList;
import java.util.Iterator;


public class ControllerAjedrez {

	
	
	private static final int TAMANO_TABLERO = 8;
	private ViewAjedrez vista;

	public ControllerAjedrez(ViewAjedrez vista) {
		this.vista = vista;
		this.iniciar();
//		vista.setControlador(this);
	}

	private void iniciar() {
		
		vista.dibujarTablero(TAMANO_TABLERO);
		
		
		
//		for (int i = 0; i < 10; i++) {	
//			
//			
//			
//		}	
		
		ArrayList<Posicion> posiblesMovimientos = posiblesMovimientos(new Posicion(5, 5));
		
		for (Posicion posicion : posiblesMovimientos) {
			System.out.println(posicion.getFila()+", "+ posicion.getColumna()+" ♞");
			vista.dibujarCaballo(posicion);
		}
		
//		vista.dibujarCaballo(new Posicion(5, 3));
		
//		rellenarTablero(new Posicion(1, 1));
		
	}

	private void rellenarTablero(Posicion posicion) {

		ArrayList<Posicion> posiblesMovimientos = posiblesMovimientos(posicion);
		// posiblesMovimientos
		// ordenar posibles movimientos
		// repetir hasta que el tablero este lleno
			// no hay posibles movimientos > borrar nodo
		
		
	}

	private ArrayList<Posicion> posiblesMovimientos(Posicion posicion) {

		//for hasta 8 
			// si la posicion es valida agregarla a un array
		ArrayList<Posicion> posiblesMovimientos = new ArrayList<Posicion>();
		
		int iS = 1;
		for (int i = 0; i < 2; i++) {
			int jS = 1;
			for (int j = 0; j < 2; j++) {
				
				if (posicion.nuevaPosicion(2*iS, 1*jS).esValida(TAMANO_TABLERO))
					posiblesMovimientos.add(posicion.nuevaPosicion(2*iS, 1*jS));
				if (posicion.nuevaPosicion(1*iS, 2*jS).esValida(TAMANO_TABLERO))
					posiblesMovimientos.add(posicion.nuevaPosicion(1*iS, 2*jS));
				
				jS = -1;
			}
			iS = -1;
		}
		
		return posiblesMovimientos;
	}
	
	
	
}
