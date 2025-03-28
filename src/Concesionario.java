import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
/**
 * * Clase principal del programa que permite seleccionar una carpeta, leer un fichero y convertirlo a diferentes formatos.
 * @author Rodas y Juanfran
 * @version 1.0
 */
public class Concesionario {
    static Scanner sc = new Scanner(System.in);
    static String carpetaSeleccionada = "";
    static List<Map<String, String>> datos = new ArrayList<>();
    static Archivos archivos;

    public static void main(String[] args) {
        while (true) {
            System.out.println(menu());
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    seleccionarCarpeta();
                    break;
                case 2:
                    leerFichero();
                    break;
                case 3:
                    menuConversion();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void seleccionarCarpeta() {
        System.out.print("Introduce la ruta de la carpeta: ");
        carpetaSeleccionada = sc.nextLine();
        File carpeta = new File(carpetaSeleccionada);

        if (carpeta.exists() && carpeta.isDirectory()) {
            System.out.println("Contenido de la carpeta:");
            for (String archivo : Objects.requireNonNull(carpeta.list())) {
                System.out.println("- " + archivo);
            }
        } else {
            System.err.println("La ruta proporcionada no es válida.");
            carpetaSeleccionada = "";
        }
    }

    public static String leerFichero() {
        if (carpetaSeleccionada.isEmpty()) {
            System.err.println("Primero debes seleccionar una carpeta.");
            return "";
        }
        System.out.print("Introduce el nombre del archivo a leer: ");
        String nombreArchivo = sc.nextLine();
        File archivo = new File(carpetaSeleccionada, nombreArchivo);

        if (archivo.exists() && archivo.isFile()) {
            String extension = obtenerExtension(nombreArchivo);
            datos.clear();

            switch (extension) {
                case "csv":
                    archivos = new Csv();
                    break;
                case "xml":
                    archivos = new Xml();
                    break;
                case "json":
                    archivos = new Json();
                    break;
                default:
                    System.err.println("Formato de archivo no soportado.");
                    return "";
            }
            archivos.leer(archivo.getPath(), datos);
            return nombreArchivo;
        } else {
            System.err.println("El archivo no existe en la carpeta seleccionada.");
            return "";
        }
    }



    private static String obtenerExtension(String nombreArchivo) {
        int i = nombreArchivo.lastIndexOf('.');
        return (i > 0) ? nombreArchivo.substring(i + 1) : "";
    }
    public static String menu(){
        String ficheroSeleccionado = "";
        String tVerde = "\u001B[32m";
        String fBlanco = "\u001B[32;40m";
        String reset = "\u001B[0m";
        String menu= tVerde +"------------------------------------------------------------\n"
                            + "|                                                          |\n"
                            + "|       "+fBlanco+"¿Qué desea hacer?" + reset + tVerde+"                                  |\n"
                            + "|                                                          |\n"
                            + "| Fichero seleccionado: " + (ficheroSeleccionado.isEmpty() ? "Ninguno" : ficheroSeleccionado)+  "                            |\n"
                            + "| Carpeta seleccionada: " + (carpetaSeleccionada.isEmpty() ? "Ninguna" : carpetaSeleccionada)+  "                            |\n"
                            + "|                                                          |\n"
                            + "|----------------------------------------------------------|\n"
                            + "|      1. Seleccionar carpeta                              |\n" 
                            + "|      2. Leer fichero                                     |\n"
                            + "|      3. Convertir                                        |\n"
                            + "|      4. Salir                                            |\n"
                            + "------------------------------------------------------------\n"
                            + "Elija una opción:\n" + reset;
        return menu;
    }
    public static String menuConversionDibujar(){
        String tVerde = "\u001B[32m";
        String fBlanco = "\u001B[32;40m";
        String reset = "\u001B[0m";
        String menu= tVerde +"-----------------------------------\n"
                            + "|                                 |\n"
                            + "|    "+fBlanco+"¿A que desea convertir?" + reset + tVerde+"      |\n"
                            + "|                                 |\n"
                            + "|---------------------------------|\n"
                            + "|      1. Convertir a csv         |\n" 
                            + "|      2. Convertir a json        |\n"
                            + "|      3. Convertir a xml         |\n"
                            + "|      4. Volver al menu          |\n"
                            + "-----------------------------------\n"
                            + "Elija una opción:\n" + reset;
        return menu;
    }
    public static void menuPrincipal(){
        int opcion;
        do{
            System.out.println(menu());
            opcion = Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1 -> seleccionarCarpeta();
                case 2 -> leerFichero();
                case 3 -> menuConversion();
                case 4 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida");
            }
        }while(opcion !=4);     
    }
    public static void menuConversion(){
        if (datos.isEmpty()) {
            System.err.println("Primero debes leer un archivo.");
            return;
        }
        int opcion;
        System.out.println("Introduce el nombre del archivo de salida (sin extensión): ");
        String nombreSalida = sc.nextLine();
        do{
            System.out.println(menuConversionDibujar());
            opcion = Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1:
                    archivos = new Csv();
                    archivos.exportar(nombreSalida + ".csv", datos);
                break;
                case 2:
                    archivos = new Json();
                    archivos.exportar(nombreSalida + ".json", datos);
                break;
                case 3:
                    archivos = new Xml();
                    archivos.exportar(nombreSalida + ".xml", datos);
                break;
                case 4:
                    System.out.println("Saliendo del programa...");
                break;
                default: 
                    System.out.println("Opcion no valida");
            }
        }while(opcion !=4);     
    }
}
