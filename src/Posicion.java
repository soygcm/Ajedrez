
public class Posicion {

	private int columna;
	private int fila;
	
	public Posicion(int col, int fil) {
		columna = col;
		fila = fil;
	}

	public int getColumna() {
		return columna;
	}

	public int getFila() {
		return fila;
	}

	public Posicion nuevaPosicion(int moverColumna, int moverFila){
		
		return new Posicion(columna+moverColumna, fila+moverFila);
		
	}

	public boolean esValida(int tamanoTablero) {
		if ( (getColumna()>tamanoTablero || getFila()>tamanoTablero)
				|| (getColumna()<1 || getFila()<1) 
				)
		{
			return false;
		}else{
			return true;
		}
	}
	
	
	
}
