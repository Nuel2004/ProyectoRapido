import java.util.List;
import java.util.Map;

public interface Archivos {
    public void aTextoPlano(String path, List<Map<String, String>> datos);
    public void darFormato(String path, List<Map<String, String>> datos);
}
