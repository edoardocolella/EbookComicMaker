package mangaProject;

import java.io.IOException;

public class MangaGenerator {
    public static void main(String args[]) throws IOException {
        
        Manga manga = new Manga("myName", "myAuthor");


        manga.createManga("./goku.pdf", "otherPath");

    }
}
