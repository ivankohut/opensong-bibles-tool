package sk.ivankohut.bibliasktoopensong;

import io.vavr.collection.List;

/**
 * Note: number of verses is real number of verses, not the number of the last verse of chapter.
 */
public class OpenSongXmlBible {

    private final Bible bible;

    public OpenSongXmlBible(Bible bible) {
        this.bible = bible;
    }

    @Override
    public String toString() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<bible>\n" +
                "\t<!--\n" +
                List.of(bible.copyright().split("\\n")).map(line -> line.isEmpty() ? "\n" : "\t\t" + line + "\n").mkString() +
                "\t-->\n" +
                listOfBooks("OT", bible.oldTestament()) +
                listOfBooks("NT", bible.newTestament()) +
                "\n" +
                chaptersOfBooks(bible.oldTestament()) +
                "\n" +
                chaptersOfBooks(bible.newTestament()) +
                "</bible>";
    }

    private String chaptersOfBooks(Iterable<Book> books) {
        return List.ofAll(books)
                .map(book -> {
                    var chapters = List.ofAll(book.chapters()).zipWithIndex();
                    return "\t<b n=\"" + book.name() + "\" CHAPTERS=\"" + chapters.size() + "\">\n" +
                            chapters.map(chapter -> chapterString(chapter._1, chapter._2 + 1)).mkString() +
                            "\t</b>\n";
                })
                .mkString();
    }

    private static String chapterString(Chapter chapter, int number) {
        var verses = List.ofAll(chapter);
        return "\t\t<c n=\"" + number + "\" VERSES=\"" + verses.size() + "\">\n"
                + verses.map(verse -> "\t\t\t<v n=\"" + verse.number() + "\">" + verse.text() + "</v>\n").mkString()
                + "\t\t</c>\n";
    }

    private String listOfBooks(String name, Iterable<Book> books) {
        return "\t<" + name + ">\n" +
                List.ofAll(books).map(book -> "\t\t<book n=\"" + book.name() + "\"/>\n").mkString() +
                "\t</" + name + ">\n";
    }
}
