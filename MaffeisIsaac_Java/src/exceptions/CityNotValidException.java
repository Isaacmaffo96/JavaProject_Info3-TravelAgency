package exceptions;

public class CityNotValidException extends Exception {

	public CityNotValidException(String msg) {
		super("Città non valida, " + msg);
	}
	
}
