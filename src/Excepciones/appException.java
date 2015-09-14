package Excepciones;

public class appException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	private Throwable causa;

	public String getMensaje()
	{
		return mensaje;
	}
	
	public Throwable getCausa()
	{
		return causa;
	}
	public appException(String mensaje,Throwable causa)
	{
		this.mensaje=mensaje;
		this.causa=causa;
	}
}