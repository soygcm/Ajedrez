
public class ControllerApp {

	public static void main(String[] args) {
		new ControllerApp().iniciar();
	}

	private void iniciar() {
		
		ViewAjedrez vista =  new ViewAjedrez();
		new ControllerAjedrez(vista);
		vista.arranca();

	}

}
