package excepciones;

public class ClienteNoExisteException extends Exception {
	public ClienteNoExisteException(String n) {
		super(n);
	}
}
