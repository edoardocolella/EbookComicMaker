package pack;

import java.io.IOException;

public class ComicGenerator {
    public static void main(String args[]) throws IOException {


        String docPath = "./goku.pdf";
        String imageDirectory = "./";

        Comic comic = new Comic("myName", "myAuthor");

        comic.createComic(docPath, imageDirectory);

    }

   
}
