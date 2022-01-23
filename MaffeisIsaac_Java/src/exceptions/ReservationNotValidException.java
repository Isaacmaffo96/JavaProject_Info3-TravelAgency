package exceptions;

public class ReservationNotValidException extends Exception{

	public ReservationNotValidException(String msg) {
		super("Prenotazione non valida, " + msg);
	}
	
}
