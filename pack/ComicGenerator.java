package pack;

import java.io.IOException;

public class ComicGenerator {
    public static void main(String args[]) throws IOException {
        
        Comic comic = new Comic("myName", "myAuthor");


        comic.createManga("./goku.pdf", "otherPath");

    }
}
