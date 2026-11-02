import java.util.ArrayList;
import java.util.List;

public class SearchVisitor
        implements FileSystemVisitor {

    private String searchPattern;

    private List<File> matchingFiles =
            new ArrayList<>();

    public SearchVisitor(String searchPattern) {

        this.searchPattern =
                searchPattern.toLowerCase();
    }

    @Override
    public void visit(File file) {

        if (file.getName()
                .toLowerCase()
                .contains(searchPattern)) {

            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {

        // Nothing needed here.
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}