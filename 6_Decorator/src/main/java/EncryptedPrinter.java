public class EncryptedPrinter extends PrinterDecorator {
    public EncryptedPrinter(Printer wrapped){
        super(wrapped);
    }

    @Override
    public void print(String message){
        String encrypted = encrypt(message);
        wrapped.print(encrypted);
    }

    private String encrypt(String input){
        StringBuilder sb  = new StringBuilder();
        for(char c : input.toCharArray()){
            sb.append((char)(c + 3));
        }
        return sb.toString();
    }
}
