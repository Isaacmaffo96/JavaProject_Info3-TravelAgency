package exceptions;

public class CityNotValidException extends Exception {

	public CityNotValidException(String msg) {
		super("Citt� non valida, " + msg);
	}
	
}
