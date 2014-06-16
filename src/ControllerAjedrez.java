import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


public class ControllerAjedrez {

	
	
	private static final int TAMANO_TABLERO = 8;
	private ViewAjedrez vista;
	private ArrayList<Posicion> posicionesVisitadas;

	public ControllerAjedrez(ViewAjedrez vista) {
		this.vista = vista;
		this.iniciar();
//		vista.setControlador(this);
	}

	private void iniciar() {
		
		vista.dibujarTablero(TAMANO_TABLERO);
		
		posicionesVisitadas = new ArrayList<Posicion>();
		
//		ArrayList<Posicion> siguientesMovimientos = siguientesMovimientos(new Posicion(5, 5));
//		
//		for (Posicion posicion : siguientesMovimientos) {
////			System.out.println(posicion.getFila()+", "+ posicion.getColumna()+" ♞");
//			
////			visitar(posicion);
//			
//			vista.dibujarCaballo(posicion);
//			posicionesVisitadas.add(posicion);			
//		}
//		
//		siguientesMovimientos = siguientesMovimientos(new Posicion(7, 5));
//		
//		for (Posicion posicion : siguientesMovimientos) {
////			System.out.println(posicion.getFila()+", "+ posicion.getColumna()+" ♞");
//			
//			if (yaFueVisitada(posicion)) {
//				vista.borrarCaballo(posicion);
////				posicionesVisitadas.re
//			}else{
//				vista.dibujarCaballo(posicion);				
//				posicionesVisitadas.add(posicion);			
//			}
//		
//		}
//		
//		siguientesMovimientos = siguientesMovimientos(new Posicion(2, 5));
//		
//		siguientesMovimientos = ordenar(siguientesMovimientos);
//		
//		for (Posicion posicion : siguientesMovimientos) {
//			
//			System.out.println(posicion.getFila()+", "+ posicion.getColumna()+": "+siguientesMovimientos(posicion).size());
//			
//		}
		
//		vista.dibujarCaballo(new Posicion(5, 3));
		rellenarTableroDesde(new Posicion(1, 1));
		
	}

	private ArrayList<Posicion> ordenar(ArrayList<Posicion> siguientesMovimientos) {
		
		Collections.sort(siguientesMovimientos, new Comparator<Posicion>() {

			@Override
			public int compare(Posicion o1, Posicion o2) {
				int sig2 = 	siguientesMovimientos(o2).size();
				int sig1 = 	siguientesMovimientos(o1).size();
				
				return new Integer(sig1).compareTo(new Integer(sig2));
			}
		
		
		
		});
		
		return siguientesMovimientos;
		
	}

	private boolean yaFueVisitada(Posicion posicion) {

		for (Posicion posicionVisitada : posicionesVisitadas) {
			if (posicion.getColumna() == posicionVisitada.getColumna() && posicion.getFila() == posicionVisitada.getFila()) {
				return true;
			}
		}
		
		return false;
	}

	private boolean rellenarTableroDesde(Posicion posicion) {
		visito(posicion);
		ArrayList<Posicion> siguientesMovimientos = siguientesMovimientos(posicion);
		siguientesMovimientos = ordenar(siguientesMovimientos);

		if (posicionesVisitadas.size()<TAMANO_TABLERO*TAMANO_TABLERO) {
			if (siguientesMovimientos.isEmpty()) {
				desvisitoUltima(posicion);
			}else{
				for (Posicion posicionSiguiente : siguientesMovimientos) {
					if (rellenarTableroDesde(posicionSiguiente)){
//						visito(posicion);
						return true;
					}else{
						desvisitoUltima(posicion);
					}
				}
			}
		}else{
			return true;
		}
		
		
		return false;
		
		// Si no hay siguientes posiciones, borrar el ultimo visitado??
		// Si no he visitado todo
			// 
			// visitar la siguiente posicion (ordenadamente)
			// 
			// 
		
		
	}

	private void visito(Posicion posicion) {
		posicionesVisitadas.add(posicion);
		vista.dibujarCaballo(posicion, posicionesVisitadas.size());
	}

	private void desvisitoUltima(Posicion posicion) {
		posicionesVisitadas.remove(posicionesVisitadas.size()-1);
		vista.borrarCaballo(posicion);
	}

	private ArrayList<Posicion> siguientesMovimientos(Posicion posicion) {

		//for hasta 8 
			// si la posicion es valida agregarla a un array
		ArrayList<Posicion> posiblesMovimientos = new ArrayList<Posicion>();
		
		int iS = 1;
		for (int i = 0; i < 2; i++) {
			int jS = 1;
			for (int j = 0; j < 2; j++) {
				
				if (posicion.nuevaPosicion(2*iS, 1*jS).esValida(TAMANO_TABLERO)
						&& !yaFueVisitada(posicion.nuevaPosicion(2*iS, 1*jS))
						)
					posiblesMovimientos.add(posicion.nuevaPosicion(2*iS, 1*jS));
				if (posicion.nuevaPosicion(1*iS, 2*jS).esValida(TAMANO_TABLERO)
						&& !yaFueVisitada(posicion.nuevaPosicion(1*iS, 2*jS))
						)
					posiblesMovimientos.add(posicion.nuevaPosicion(1*iS, 2*jS));
				
				jS = -1;
			}
			iS = -1;
		}
		
		return posiblesMovimientos;
	}
	
	
	
}
