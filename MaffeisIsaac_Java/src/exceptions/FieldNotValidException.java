package exceptions;

public class FieldNotValidException extends Exception {

	public FieldNotValidException(String msg){
		super("Campo non valido, " + msg);
	}
	
}
