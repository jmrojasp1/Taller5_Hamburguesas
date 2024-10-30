package uniandes.dpoo.hamburguesas.excepciones;

/**
 * La clase utilizada para agrupar las excepciones propias de la aplicación
 */
@SuppressWarnings("serial")
public class HamburguesaException extends Exception
{
	@Override
    public String getMessage( )
    {
        return "No existe esta hamburguesa";
    }

}
