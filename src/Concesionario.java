import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Concesionario {
    static Scanner sc = new Scanner(System.in);
    static String carpetaSeleccionada = "";
    static List<Map<String, String>> datos = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        seleccionarCarpeta();
        leerFichero();
        convertirFormato();
        obtenerExtension(carpetaSeleccionada);
        leerCsv(carpetaSeleccionada);
        leerJson(carpetaSeleccionada);
        leerXml(carpetaSeleccionada);
        exportarCsv(carpetaSeleccionada);
        exportarJson(carpetaSeleccionada);
        exportarXml(carpetaSeleccionada);
    }

    private static void exportarXml(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportarXml'");
    }

    private static void exportarJson(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportarJson'");
    }

    private static void exportarCsv(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportarCsv'");
    }

    private static void leerXml(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerXml'");
    }

    private static void leerJson(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerJson'");
    }

    private static void leerCsv(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerCsv'");
    }

    private static void obtenerExtension(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerExtension'");
    }

    private static void convertirFormato() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertirFormato'");
    }

    private static void leerFichero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerFichero'");
    }

    private static void seleccionarCarpeta() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'seleccionarCarpeta'");
    }
}