public class Elemento {
    
    TipoSocio socio;
    Elemento sgte;//puntero siguiente
    
    public Elemento(TipoSocio socio){//constructor de los nodos de la lista enlazada
        this.socio = socio;
        this.sgte = null;
    }

    public TipoSocio getSocio() {
        return socio;
    }

    
}
