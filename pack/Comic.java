package pack;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Comic {
    private String name;
    private String author;
    private List<String> paths = new ArrayList<>();


    public Comic(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public void createComic(String docPath, String imageDirectory) throws IOException {

        // Loading an existing document
        File file = new File(docPath);
        PDDocument doc = new PDDocument();

        doc.save(file);

        searchImages(imageDirectory, paths);

        for (String path : paths) {
            addPage(doc, path);
        }

        // Saving the document
        doc.save(file);

        // Closing the document
        doc.close();

    }

    private void addPage(PDDocument doc, String path) throws IOException {
        // Creating PDImageXObject object
        PDImageXObject pdImage = PDImageXObject.createFromFile(path, doc);

        int height = pdImage.getHeight();
        int width = pdImage.getWidth();

        while (width > 1000 || height > 1500) {
            width = (int) (0.85 * width);
            height = (int) (0.65 * height);
            System.out.println("new: " + width + " " + height);
            pdImage.setHeight(height);
            pdImage.setWidth(width);
        }

        PDRectangle mediaBox = new PDRectangle(width, height);
        PDPage page = new PDPage(mediaBox);
        doc.addPage(page);

        // creating the PDPageContentStream object
        PDPageContentStream contents = new PDPageContentStream(doc, page);

        // Drawing the image in the PDF document
        contents.drawImage(pdImage, 0, 0);

        System.out.println("Image inserted Successfully.");

        // Closing the PDPageContentStream object
        contents.close();

    }

    private static void searchImages(String path, List<String> paths) {

        String[] accepted = { "jpeg", "png", "jpg" };
        File root = new File(path);
        File[] list = root.listFiles();

        for (File f : list) {

            if (f.isDirectory()) {
                // System.out.println(f.getName());
                searchImages(f.getAbsolutePath(), paths);
            } else {

                for (String acc : accepted) {
                    if (acc.equals(FilenameUtils.getExtension(f.getName()))) {
                        System.out.println(f.getName());
                        paths.add(f.getAbsolutePath());
                    }
                }
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
