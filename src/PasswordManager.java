import java.util.HashMap;
import java.util.Map;

public class PasswordManager {
    private Map<String, String> credentials = new HashMap<>();

    public void addCredential(String site, String password) {
        credentials.put(site, password);
        System.out.println("Credential added successfully.");
    }

    public String getCredential(String site) {
        return credentials.getOrDefault(site, "Site not found.");
    }

    public void listCredentials() {
        if (credentials.isEmpty()) {
            System.out.println("No stored credentials.");
        } else {
            credentials.forEach((site, pass) -> 
                System.out.println(site + " : " + pass));
        }
    }
}
