import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner leer = new Scanner(System.in);
        TablaDispersaEnlazada tabla = new TablaDispersaEnlazada();
        int op, codBuscado, dia, mes, anio, edad, codigo;
        String name;

        limpiarConsola();

        do{
            menu();
            op = controlOp();
            limpiarConsola();

            switch (op) {
                case 1:
                    System.out.println("CARGA DE SOCIOS");
                    System.out.println("Ingrese el nombre: ");
                    name = leer.nextLine();
                    System.out.println("Ingrese la edad: ");
                    edad = leer.nextInt();
                    System.out.println("");
                    System.out.println("-Fecha de alta del socio-");
                    System.out.println("Ingrese el dia:");
                    dia = leer.nextInt();
                    System.out.println("Ingrese el mes: ");
                    mes = leer.nextInt();
                    System.out.println("Ingrese el año: ");
                    anio = leer.nextInt();
                    System.out.println("");
                    System.out.println("Ingrese el codigo o numero del socio: ");
                    codigo = leer.nextInt();

                    TipoSocio socioNuevo = new TipoSocio(name, codigo, edad, dia, mes, anio);
                    tabla.insertar(socioNuevo);

                    limpiarConsola();
                    System.out.println("El socio fue ingresado correctamente.");
                    pause();
                    break;
                case 2:
                    System.out.println("BUSCAR UN SOCIO");
                    System.out.println("");
                    System.out.println("Ingrese el codigo del socio que quiere buscar:");
                    codBuscado = leer.nextInt();
                    leer.nextLine();
                    
                    Elemento socioBuscado = tabla.buscar(codBuscado);

                    while (socioBuscado != null){
                        if (socioBuscado != null){
                            System.out.println("DATOS DEL SOCIO");
                            System.out.println("");
                            System.out.println("nombre: " + socioBuscado.getSocio().getNombre());
                            System.out.println("Edad: " + socioBuscado.getSocio().getEdad());
                            System.out.println("Codigo: " + socioBuscado.getSocio().getnumSocio());
                            System.out.println("Fecha de Alta: " + socioBuscado.getSocio().getFechaAlta());
                            System.out.println("");
                        }
                        else{
                            System.out.println("Socio no encontrado.");
                        }
                        socioBuscado = socioBuscado.sgte;
                    }

                    break;
                case 3:
                    
                    System.out.println("ELIMINAR SOCIO");
                    System.out.println("");
                    System.out.println("Ingrese el codigo del socio a elminar: ");
                    codBuscado = leer.nextInt();

                    Elemento socioElim = tabla.buscar(codBuscado);

                    if (socioElim != null){
                        tabla.elminar(codBuscado);
                        System.out.println("Socio " + socioElim.getSocio().getnumSocio() + " eliminado.");
                        System.out.println("");
                        pause();
                        limpiarConsola();
                    }
                    else{
                        System.out.println("Socio no encontrado");
                    }
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                default:

            }
        }
        while (op != 5);
    }

    //PROCEDIMIENTOS

    //MENU
    public static void menu(){
        System.out.println("======================");
        System.out.println("(1) INNGRESAR SOCIO");
        System.out.println("(2) BUSCAR SOCIO");
        System.out.println("(3) ELIMINAR SOCIO");
        System.out.println("(4) MOSTRAR LISTA DE SOCIOS");
        System.out.println("(5) SALIR");
        System.out.println("======================");
        System.out.println("");
        //falta el pause
    }

    //Limpiar consola
    public static void limpiarConsola(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Esperar tecla para continuar
    public static void pause(){
        Scanner leer = new Scanner (System.in);
        System.out.println("Presiona una tecla para continuar...");
        leer.nextLine();
    }

    //Controla la opcion ingresada
    public static int controlOp(){
        Scanner leer = new Scanner (System.in);
        int op = 0;
        boolean opcionVal = false;
        String input;

        while (!opcionVal){ 
            System.out.println("Elija una opcion del menu: ");

            input = leer.nextLine();

            try {
                op = Integer.parseInt(input);
                if (op>=1 && op<=5){
                    opcionVal = true;
                }
                else{
                    System.out.println("");
                    System.out.println("Opcion no existente.");
                    pause();
                    limpiarConsola();
                    menu();
                }
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Debe ingresar un valor numerico.");
                pause();
                limpiarConsola();
                menu();
            }
        }
        return op;
    }

}
