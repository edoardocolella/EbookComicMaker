package mangaProject;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Manga {
    private String name;
    private String author;

    public Manga(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public void createManga(String docPath, String imageDirectory) throws IOException {

        // Loading an existing document
        File file = new File(docPath);
        PDDocument doc = new PDDocument();

        
        addPage(doc, "./java.jpeg");

        // Saving the document
        doc.save(file);

        // Closing the document
        doc.close();

    }

    private void addPage(PDDocument doc, String path) throws IOException {
        // Retrieving the page
        PDPage page = new PDPage();
        doc.addPage(page);

        // Creating PDImageXObject object
        PDImageXObject pdImage = PDImageXObject.createFromFile(path, doc);

        // creating the PDPageContentStream object
        PDPageContentStream contents = new PDPageContentStream(doc, page);

        // Drawing the image in the PDF document
        contents.drawImage(pdImage, 250, 300);

        System.out.println("Image inserted Successfully.");

        // Closing the PDPageContentStream object
        contents.close();
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
