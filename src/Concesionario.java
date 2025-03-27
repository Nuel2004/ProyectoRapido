import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Concesionario {
    static Scanner sc = new Scanner(System.in);
    static String carpetaSeleccionada = "";
    static List<Map<String, String>> datos = new ArrayList<>();
    static Archivos archivoHandler;

    public static void main(String[] args) {
        String ficheroSeleccionado = "";

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("Carpeta seleccionada: " + (carpetaSeleccionada.isEmpty() ? "Ninguna" : carpetaSeleccionada));
            if (!carpetaSeleccionada.isEmpty()) {
                System.out.println("Contenido de la carpeta:");
                File carpeta = new File(carpetaSeleccionada);
                for (String archivo : Objects.requireNonNull(carpeta.list())) {
                    System.out.println("- " + archivo);
                }
            }
            System.out.println("Fichero seleccionado: " + (ficheroSeleccionado.isEmpty() ? "Ninguno" : ficheroSeleccionado));
            System.out.println("\n1. Seleccionar carpeta");
            System.out.println("2. Leer fichero");
            System.out.println("3. Convertir a otro formato");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    seleccionarCarpeta();
                    break;
                case 2:
                    ficheroSeleccionado = leerFichero();
                    break;
                case 3:
                    convertirFormato();
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
            System.out.println("Carpeta seleccionada: " + carpetaSeleccionada);
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
                    archivoHandler = new Csv();
                    break;
                case "xml":
                    archivoHandler = new Xml();
                    break;
                case "json":
                    archivoHandler = new Json();
                    break;
                default:
                    System.err.println("Formato de archivo no soportado.");
                    return "";
            }
            archivoHandler.leer(archivo.getPath(), datos);
            return nombreArchivo;
        } else {
            System.err.println("El archivo no existe en la carpeta seleccionada.");
            return "";
        }
    }

    public static void convertirFormato() {
        if (datos.isEmpty()) {
            System.err.println("Primero debes leer un archivo.");
            return;
        }
        System.out.println("Selecciona el formato de salida:");
        System.out.println("1. CSV");
        System.out.println("2. JSON");
        System.out.println("3. XML");
        int opcion = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce el nombre del archivo de salida (sin extensión): ");
        String nombreSalida = sc.nextLine();

        switch (opcion) {
            case 1:
                archivoHandler = new Csv();
                archivoHandler.exportar(nombreSalida + ".csv", datos);
                break;
            case 2:
                archivoHandler = new Json();
                archivoHandler.exportar(nombreSalida + ".json", datos);
                break;
            case 3:
                archivoHandler = new Xml();
                archivoHandler.exportar(nombreSalida + ".xml", datos);
                break;
            default:
                System.err.println("Opción no válida.");
        }
    }

    private static String obtenerExtension(String nombreArchivo) {
        int i = nombreArchivo.lastIndexOf('.');
        return (i > 0) ? nombreArchivo.substring(i + 1) : "";
    }
}