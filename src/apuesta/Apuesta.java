package apuesta;
/**
 * 
 * @author Juanma Sánchez
 *
 */
public class Apuesta {
	/**
	 * Variable global para el dinero disponible
	 */
    private int dineroDisp;
    /**
     * Variable global para los goles del equipo local
     */
    private int golesLocal;
    /**
     * Variable global para los goles del equipo visitante
     */
    private int golesVisitante;
    /**
     * Variable global para la cantidad de dinero a apostar
     */
    private int apostado;

    
    /**
     * Constructor por defecto
     * 
     */
    public Apuesta() {
    	/*Esto es un comentario para que desaparezca la 
    	 * violación del PMD "UncommentedEmptyConstructor".
    	 */
    }

 
    /**
     * Contructor con parámetros
     * Método para guardar los valores en cada variable1
     * @param dineroDisp Dinero disponible
     * @param golesLocal Goles locales
     * @param golesVisitante Goles del equipo visitante
     */
    public Apuesta(int dineroDisp, int golesLocal, int golesVisitante) {
        this.dineroDisp = dineroDisp;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.apostado = 0;//La cantidad a apostar es 0
    }
    
   
    /**
     * Método para obtener el valor del atributp dinero_disp
     * @return Devolverá la cantidad de dinero disponible
     */
    public int getDineroDisp() {
        return dineroDisp;
    }
    

    /**
     * Método para modificar el valor del atributo dinero_disp
     * @param dineroDisp Dinero disponible
     */
    public void setDineroDisp(int dineroDisp) {
        this.dineroDisp = dineroDisp;
    }

    
    /**
     * Método para apostar
     * @param dinero Elección de la cantidad de dinero a apostar.
     * @throws Exception La cantidad a apostar no puede ser
     * 		inferior o al saldo disponible 
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1�");
        }

        if (dinero > dineroDisp) {
            throw new Exception("No se puede apostar m�s de lo que tienes");
        }
        {
            dineroDisp = dinero - dineroDisp;
            apostado = dinero;
        }
    }
    
   
    /**
     * Método que comprueba si se ha acertado el resultado del partido
     * @param local 
     * @param visitante
     * @return En caso de que lo haya acertado, devuelve true
     * @throws Exception Chequea que no se metan menos de 0 goles
     */
    public boolean comprobarResultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if (local < 0 || visitante < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (golesLocal == local && golesVisitante == visitante) {
            acertado = true;
        }
        return acertado;
    }
    
    
    /**
     * Método para cobrar la apuesta 
     * Comprueba que se acierta el resultado y 
     * añade lo apostado multiplicado por 10
     * @param cantGolesLocal
     * @param cantGolesVisit
     * @throws Exception
     */
    void cobrarApuesta(int cantGolesLocal, int cantGolesVisit) throws Exception {

        if (!comprobarResultado(cantGolesLocal, cantGolesVisit)) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dineroDisp = dineroDisp * 10;

    }
}
