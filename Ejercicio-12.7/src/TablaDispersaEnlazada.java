public class TablaDispersaEnlazada {
    
    static final double R = 0.6180334;
    static int M = 97;
    private Elemento [] tabla;
    private int numElementos;

    public TablaDispersaEnlazada(){
        tabla = new Elemento[M];
        for(int i=0; i<M; i++){
            tabla[i] = null;
        }
        numElementos = 0;
    }

    //obtengo el numero de lista enlazada que le corresponde
    public int dispersion(long clave){
        double decimal;
        int posicion;
        int M = 97;
        decimal = R * clave - Math.floor(R*clave); 
        posicion = (int) (M*decimal);
        return posicion; 
    }

    //INSERTAR
    public void insertar(TipoSocio socio){
        int posicion;
        Elemento nuevo; //crea el nodo nuevo de la lista
        posicion =dispersion(socio.getnumSocio());
        nuevo = new Elemento(socio);
        nuevo.sgte = tabla[posicion];
        numElementos++;
    }

    //SIRVE PARA SABER SI ENCONTRO EL SOCIO
    public boolean conforme(int numSocio){
        return true;
    }

    //BUSCAR
    public Elemento buscar(int numSocio){
        Elemento p = null;
        int posicion;

        posicion = dispersion(numSocio);

        if (tabla[posicion] != null){
            p = tabla[posicion];
            while (p.sgte != null && p.socio.numSocio != numSocio){
                p = p.sgte;
            }
            if (p.socio.numSocio != numSocio){
                p = null;
            }
        }
        return p;
    }

    //ELIMINAR
    public void elminar(int numSocio){
        int posicion;

        posicion = dispersion( numSocio);

        if (tabla[posicion] != null){//quiere decir que la lista no esta vacia
            Elemento anterior, actual;

            anterior = null;
            actual = tabla[posicion];

            while (actual.sgte !=null && actual.getSocio().getnumSocio() != numSocio){
                anterior = actual;
                actual = actual.sgte;
            }
            if (actual.getSocio().getnumSocio() != numSocio){
                System.out.println("No se encuentra en la tabla el socio numero: " + numSocio);
            }
            else if (conforme(actual.getSocio().getnumSocio())){//se retira el nodo
                if (anterior == null){//es el primer nodo
                    tabla[posicion] = actual.sgte;
                }
                else{
                    anterior.sgte = actual.sgte;
                    actual = null;
                    numElementos--;
                }
            }
        } 
    }


    //MOSTRAR LISTA

}
