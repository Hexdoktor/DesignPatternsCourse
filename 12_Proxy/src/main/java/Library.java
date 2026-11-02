import java.util.HashMap;

public class Library {

    private HashMap<String, IDocument> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addPublicDocument(
            String id,
            String content) {

        Document document =
                new Document(id, content);

        documents.put(id, document);
    }

    public void addProtectedDocument(
            String id,
            String content) {

        Document realDocument =
                new Document(id, content);

        DocumentProxy proxy =
                new DocumentProxy(realDocument);

        documents.put(id, proxy);
    }

    public IDocument getDocument(String id) {
        return documents.get(id);
    }
}