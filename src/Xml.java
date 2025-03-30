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

public class Xml extends Archivos {
    private String etiquetaAgrupacion;
    @Override
    public void leer(String path, List<Map<String, String>> datos, Scanner sc) {
        System.out.println("Leyendo archivo XML...");
        
        System.out.println("Escribe la etiqueta de agrupacion del XML: ");
        this.etiquetaAgrupacion = sc.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            Map<String, String> etiqueta = null;
            
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                etiquetaAgrupacion = etiquetaAgrupacion.trim().toLowerCase();
                
                
                if (linea.startsWith("<" + etiquetaAgrupacion + ">")) {
                    etiqueta = new HashMap<>();
                } else if (linea.startsWith("</" + etiquetaAgrupacion + ">")) {
                    if (etiqueta != null && !etiqueta.isEmpty()) {
                        datos.add(etiqueta);
                        etiqueta = null;
                    }
                } 
                else if (linea.matches("^<.*>.*</.*>$")) {
                    try {
                        String key = linea.substring(1, linea.indexOf('>'));
                        int inicioValor = linea.indexOf('>') + 1;
                        int finValor = linea.indexOf('<', inicioValor);
                        if (finValor > inicioValor) {
                            String value = linea.substring(inicioValor, finValor).trim();
                            if (!value.isEmpty() && etiqueta != null) {
                                etiqueta.put(key, value);
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
    public void exportar(String path, List<Map<String, String>> datos, Scanner sc) {
        System.out.println("Exportando a XML...");
        String extension = "src\\xml";
        File carpeta = new File(extension);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        path = carpeta.getAbsolutePath() + File.separator + path;
        System.out.println("Escribe la etiqueta de agrupacion del XML: ");
        this.etiquetaAgrupacion = sc.nextLine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            StringBuilder xml = new StringBuilder();
            
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xml.append("<"+ this.etiquetaAgrupacion + "s>\n");
            
            for (Map<String, String> etiquetaAgr : datos) {
                xml.append("    <" + this.etiquetaAgrupacion + ">\n");
                for (Map.Entry<String, String> entry : etiquetaAgr.entrySet()) {
                    String key = entry.getKey();
                    String value = escapeXML(entry.getValue());
                    xml.append("        <").append(key).append(">")
                    .append(value).append("</").append(key).append(">\n");
                }
                xml.append("    </"+ this.etiquetaAgrupacion + ">\n");
            }
            
            xml.append("</" + this.etiquetaAgrupacion + "s>\n");
            
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
