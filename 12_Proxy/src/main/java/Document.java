import java.time.LocalDateTime;

public class Document implements IDocument {

    private String id;
    private LocalDateTime creationDate;
    private String content;

    public Document(String id, String content) {

        this.id = id;
        this.content = content;
        this.creationDate = LocalDateTime.now();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}