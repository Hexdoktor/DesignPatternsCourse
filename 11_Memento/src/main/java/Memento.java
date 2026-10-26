import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {

    private final int[] options;
    private final boolean isSelected;
    private final LocalDateTime timestamp;

    public Memento(int[] options, boolean isSelected) {

        this.options = options.clone();
        this.isSelected = isSelected;
        this.timestamp = LocalDateTime.now();

        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options.clone();
    }

    public boolean isSelected() {
        return isSelected;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String getDescription() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("HH:mm:ss");

        return timestamp.format(formatter)
                + " | Colors: ["
                + options[0] + ", "
                + options[1] + ", "
                + options[2] + "]"
                + " | Selected: "
                + isSelected;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}