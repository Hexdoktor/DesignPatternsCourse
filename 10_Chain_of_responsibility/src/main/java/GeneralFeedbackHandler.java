public class GeneralFeedbackHandler extends FeedbackHandler{

    @Override
    protected boolean canHandle(Message message){
        return message.getType() == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected void process(Message message){
        System.out.println("\nGENERAL FEEDBACK");
        System.out.println("From: " + message.getSenderEmail());
        System.out.println("Feedback recorded.");
        System.out.println("Automatic thank-you response sent.");
    }
}
