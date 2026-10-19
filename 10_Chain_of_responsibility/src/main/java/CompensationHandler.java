import java.sql.SQLOutput;

public class CompensationHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message){
        return message.getType() == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected void process(Message message){
        System.out.println("\nCOMPENSATION CLAIM");
        System.out.println("From: " + message.getSenderEmail());
        System.out.println("Reviewing compensation claim...");

        boolean approved = Math.random() > 0.5;

        if (approved){
            System.out.println("Claim APPROVED.");
        }else{
            System.out.println("Claim REJECTED");
        }
    }
}
