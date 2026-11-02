import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AccessControlService {

    private static AccessControlService instance;

    private HashMap<String, Set<String>> permissions;

    private AccessControlService() {
        permissions = new HashMap<>();
    }

    public static AccessControlService getInstance() {

        if(instance == null) {
            instance = new AccessControlService();
        }

        return instance;
    }

    public void grantAccess(
            String username,
            String documentId) {

        permissions
                .computeIfAbsent(
                        username,
                        k -> new HashSet<>())
                .add(documentId);
    }

    public boolean isAllowed(
            String documentId,
            String username) {

        Set<String> docs =
                permissions.get(username);

        return docs != null &&
                docs.contains(documentId);
    }
}