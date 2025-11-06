package es.upm.grise.profundizacion.cruiseControl;

public class IncorrectSpeedSetException extends RuntimeException{
	public IncorrectSpeedSetException(String mensaje) {
		super(mensaje);
	}
}
