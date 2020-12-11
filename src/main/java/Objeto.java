public class Objeto implements Consola{

    private String nombre;
    private String descripcion;
    private String accion;
    private Objeto dar;
    private Objeto activacion;

    public Objeto(){}

    public Objeto(String nombre, String descripcion, String accion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.accion = accion;
        this.dar=null;
        this.activacion=null;
    }

    public Objeto(String nombre, String descripcion, String accion, Objeto dar) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.accion = accion;
        this.dar = dar;
        this.activacion=null;
    }

    public Objeto(String nombre, String descripcion, String accion, Objeto dar, Objeto activacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.accion = accion;
        this.dar = dar;
        this.activacion = activacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getAccion() {
        return accion;
    }

    public Objeto getDar() {
        return dar;
    }

    public Objeto getActivacion() {
        return activacion;
    }


    private boolean isHasDar(){
        if(this.dar!=null)
            return true;
        else
            return false;
    }

    private boolean isHasActivacion(){
        if(this.activacion!=null)
            return true;
        else
            return false;
    }


    @Override
    public String investigar(Juego juego) {

            return descripcion;
    }

    @Override
    public String mostrar(Juego juego) {
        return null;
    }
}
