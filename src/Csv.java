import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Csv implements Archivos{

    @Override
    public void aTextoPlano(String path, List<Map<String, String>> datos) {
        System.out.println("Leyendo archivo CSV...");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea = br.readLine();
            if (linea != null) {
                String[] arrayEncabezado = linea.split(",");
                while ((linea = br.readLine()) != null) {
                    String[] valores = linea.split(",");
                    Map<String, String> fila = new HashMap<>();
                    for (int i = 0; i < arrayEncabezado.length; i++) {
                        fila.put(arrayEncabezado[i], valores[i]);
                    }
                    datos.add(fila);
                }
            }
            System.out.println("Archivo CSV leído correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void darFormato(String path, List<Map<String, String>> datos) {
        System.out.println("Exportando a CSV...");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            if (!datos.isEmpty()) {
                Set<String> arrayEncabezado = datos.get(0).keySet();
                bw.write(String.join(",", arrayEncabezado));
                for (Map<String, String> fila : datos) {
                    bw.write(String.join(",", fila.values()));
                }
            }
            System.out.println("Archivo CSV exportado correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}
