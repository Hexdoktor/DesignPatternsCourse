public class Main {

    public static void main(String[] args) {

        Directory root =
                new Directory("Root");

        Directory documents =
                new Directory("Documents");

        Directory images =
                new Directory("Images");

        File report =
                new File("report.pdf", 5.2);

        File notes =
                new File("notes.txt", 1.1);

        File image1 =
                new File("vacation.jpg", 8.7);

        File image2 =
                new File("profile.jpg", 2.5);

        File presentation =
                new File("presentation.pdf", 10.0);

        documents.add(report);
        documents.add(notes);
        documents.add(presentation);

        images.add(image1);
        images.add(image2);

        root.add(documents);
        root.add(images);

        System.out.println(
                "===== SIZE CALCULATOR ====="
        );

        SizeCalculatorVisitor sizeVisitor =
                new SizeCalculatorVisitor();

        root.accept(sizeVisitor);

        System.out.println(
                "Total file size: "
                        + sizeVisitor.getTotalSize()
                        + " MB"
        );

        System.out.println(
                "\n===== SEARCH VISITOR ====="
        );

        SearchVisitor searchVisitor =
                new SearchVisitor(".pdf");

        root.accept(searchVisitor);

        for (File file :
                searchVisitor.getMatchingFiles()) {

            System.out.println(
                    "Found: "
                            + file.getName()
                            + " ("
                            + file.getSize()
                            + " MB)"
            );
        }
    }
}