public class Fecha {
    
    int dia;
    int mes;
    int anno;

    public Fecha (int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.anno = a;
    }

    public String muestraFecha(){
        return "" + dia + "-" + mes + "-" + anno;
        
    }
}
