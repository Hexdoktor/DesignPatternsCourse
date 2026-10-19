public class DevelopmentSuggestionHandler extends FeedbackHandler{

    @Override
    protected boolean canHandle(Message message){
        return message.getType() == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected void process(Message message){
        System.out.println("\nDEVELOPMENT SUGGESTION");
        System.out.println("From: " + message.getSenderEmail());
        System.out.println("Suggestion logged.");
        System.out.println("Priority assigned: Medium");
    }
}
