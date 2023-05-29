public class TipoSocio {
    
    int numSocio;
    private String nombre;
    private int edad;
    Fecha fechaAlta;

    public TipoSocio(String nom, int num, int e, int d, int m, int a) {
        this.numSocio = num;
        this.nombre = nom;
        this.edad = e;
        this.fechaAlta = new Fecha(d, m, a);
    }

    public int getnumSocio() {
        return numSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Fecha getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Fecha fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
}
