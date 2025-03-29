import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Json extends Archivos {

    @Override
    public void leer(String path, List<Map<String, String>> datos, Scanner sc) {
        System.out.println("Leyendo archivo JSON...");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                jsonBuilder.append(linea.trim());
            }
            String json = jsonBuilder.toString();
            json = json.substring(1, json.length() - 1);
            String[] items = json.split("\\},\\{");
            for (String item : items) {
                item = item.replace("{", "").replace("}", "");
                String[] pares = item.split(",");
                Map<String, String> fila = new HashMap<>();
                for (String par : pares) {
                    String[] claveValor = par.split(":");
                    String key = claveValor[0].replace("\"", "").trim();
                    String value = claveValor[1].replace("\"", "").trim();
                    fila.put(key, value);
                }
                datos.add(fila);
            }
            System.out.println("Archivo JSON leído correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void exportar(String path, List<Map<String, String>> datos, Scanner sc) {
        System.out.println("Exportando a JSON...");
        String extension = "src\\json";
        File carpeta = new File(extension);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        path = carpeta.getAbsolutePath() + File.separator + path;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("[\n");
            for (int i = 0; i < datos.size(); i++) {
                Map<String, String> fila = datos.get(i);
                bw.write("  {\n");
                int j = 0;
                for (Map.Entry<String, String> entry : fila.entrySet()) {
                    bw.write("    \"" + entry.getKey() + "\": \"" + entry.getValue() + "\"");
                    if (++j < fila.size())
                        bw.write(",");
                    bw.write("\n");
                }
                bw.write("  }");
                if (i < datos.size() - 1)
                    bw.write(",");
                bw.write("\n");
            }
            bw.write("]");
            System.out.println("Archivo JSON exportado correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}