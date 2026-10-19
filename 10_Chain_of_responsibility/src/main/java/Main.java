import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FeedbackHandler compensationHandler =
                new CompensationHandler();

        FeedbackHandler contactHandler =
                new ContactRequestHandler();

        FeedbackHandler suggestionHandler =
                new DevelopmentSuggestionHandler();

        FeedbackHandler feedbackHandler =
                new GeneralFeedbackHandler();

        // Build chain
        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(feedbackHandler);

        List<Message> messages = new ArrayList<>();

        messages.add(new Message(
                MessageType.COMPENSATION_CLAIM,
                "My package arrived damaged.",
                "alice@email.com"));

        messages.add(new Message(
                MessageType.CONTACT_REQUEST,
                "Please contact me regarding billing.",
                "bob@email.com"));

        messages.add(new Message(
                MessageType.DEVELOPMENT_SUGGESTION,
                "Add dark mode to the application.",
                "charlie@email.com"));

        messages.add(new Message(
                MessageType.GENERAL_FEEDBACK,
                "Great service, thank you!",
                "david@email.com"));

        for (Message message : messages) {
            compensationHandler.handle(message);
        }
    }
}