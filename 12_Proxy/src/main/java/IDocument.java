import java.time.LocalDateTime;

public interface IDocument {

    String getId();

    LocalDateTime getCreationDate();

    String getContent(User user) throws AccessDeniedException;
}