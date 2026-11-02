public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        library.addPublicDocument(
                "DOC-1",
                "Public company handbook");

        library.addProtectedDocument(
                "DOC-2",
                "Employee salary information");

        library.addProtectedDocument(
                "DOC-3",
                "Management strategy report");

        User alice = new User("alice");
        User bob = new User("bob");
        User john = new User("john");

        AccessControlService service =
                AccessControlService.getInstance();

        service.grantAccess("alice","DOC-2");

        service.grantAccess("john","DOC-2");
        service.grantAccess("john","DOC-3");

        testAccess(
                library.getDocument("DOC-1"),
                alice);

        testAccess(
                library.getDocument("DOC-2"),
                alice);

        testAccess(
                library.getDocument("DOC-2"),
                bob);

        testAccess(
                library.getDocument("DOC-3"),
                john);

        testAccess(
                library.getDocument("DOC-3"),
                alice);
    }

    private static void testAccess(
            IDocument document,
            User user) {

        try {

            System.out.println(
                    "\nUser: "
                            + user.getUsername());

            System.out.println(
                    "Document: "
                            + document.getId());

            System.out.println(
                    "Created: "
                            + document.getCreationDate());

            System.out.println(
                    "Content: "
                            + document.getContent(user));

        }

        catch (AccessDeniedException e) {

            System.out.println(
                    "ERROR: "
                            + e.getMessage());
        }
    }
}