import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Xml extends Archivos {
    @Override
    public void leer(String path, List<Map<String, String>> datos) {
        System.out.println("Leyendo archivo XML...");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea = "";
            Map<String, String> mapa = null;
            
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.matches("^<[^/].*>$")) {
                    mapa = new HashMap<>();
                } 
                else if (linea.matches("^</.*>$")) {
                    if (mapa != null && !mapa.isEmpty()) {
                        datos.add(mapa);
                        mapa = null;
                    }
                } 
                else if (linea.matches("^<.*>.*</.*>$")) {
                    try {
                        String key = linea.substring(1, linea.indexOf('>'));
                        int inicioValor = linea.indexOf('>') + 1;
                        int finValor = linea.indexOf('<', inicioValor);
                        if (finValor > inicioValor) {
                            String value = linea.substring(inicioValor, finValor).trim();
                            
                            if (!value.isEmpty() && mapa != null) {
                                mapa.put(key, value);
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error procesando línea: " + linea);
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Archivo XML leído correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    @Override
    public void exportar(String path, List<Map<String, String>> datos) {
        System.out.println("Exportando a XML...");
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            StringBuilder xml = new StringBuilder();
            xml.append("<registros>\n");
    
            for (Map<String, String> mapa : datos) {
                xml.append("    <registro>\n");
                for (Map.Entry<String, String> entry : mapa.entrySet()) {
                    String key = entry.getKey();
                    String value = escapeXML(entry.getValue());
                    xml.append("        <").append(key).append(">")
                       .append(value).append("</").append(key).append(">\n");
                }
                xml.append("    </registro>\n");
            }
    
            xml.append("</registros>");
            
            bw.write(xml.toString());
            
            System.out.println("Archivo XML exportado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al exportar XML: " + e.getMessage());
        }
    }
    private String escapeXML(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&apos;");
    }
        
}

