import java.util.List;
import java.util.Map;

public abstract class Archivos {
    public abstract void leer(String path, List<Map<String, String>> datos);

    public abstract void exportar(String path, List<Map<String, String>> datos);
}