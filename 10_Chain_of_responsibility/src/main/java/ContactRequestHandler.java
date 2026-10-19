public class ContactRequestHandler extends FeedbackHandler{
    @Override
    protected boolean canHandle(Message message){
        return message.getType() == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected void process(Message message){
        System.out.println("\nCONTACT REQUEST");
        System.out.println("From: " + message.getSenderEmail());
        System.out.println("Forwarding request to customer service.");
    }
}
