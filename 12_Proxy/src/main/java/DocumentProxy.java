import java.time.LocalDateTime;

public class DocumentProxy implements IDocument {

    private Document document;

    private AccessControlService accessControl;

    public DocumentProxy(Document document) {

        this.document = document;

        this.accessControl =
                AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return document.getId();
    }

    @Override
    public LocalDateTime getCreationDate() {
        return document.getCreationDate();
    }

    @Override
    public String getContent(User user)
            throws AccessDeniedException {

        boolean allowed =
                accessControl.isAllowed(
                        document.getId(),
                        user.getUsername());

        if(allowed) {
            return document.getContent(user);
        }

        throw new AccessDeniedException(
                "Access denied for user "
                        + user.getUsername()
                        + " to document "
                        + document.getId()
        );
    }
}