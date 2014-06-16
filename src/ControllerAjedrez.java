import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ControllerAjedrez {



	private static final int TAMANO_TABLERO = 8;
	private ViewAjedrez vista;
	private ArrayList<Posicion> posicionesVisitadas;

	public ControllerAjedrez(ViewAjedrez vista) {
		this.vista = vista;
		this.iniciar();
	}

	private void iniciar() {
		vista.dibujarTablero(TAMANO_TABLERO);
		posicionesVisitadas = new ArrayList<Posicion>();
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
