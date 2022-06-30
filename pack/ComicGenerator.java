package pack;

import java.io.IOException;

public class ComicGenerator {
    public static void main(String args[]) throws IOException {


        String docPath = "./onePiece1_10";
        String imageDirectory = "./Vol_1-10";

        Comic comic = new Comic("onePiece1-10", "Oda");

        comic.createComic(docPath, imageDirectory);

    }

   
}
