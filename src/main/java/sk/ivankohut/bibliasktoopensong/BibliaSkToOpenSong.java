package sk.ivankohut.bibliasktoopensong;

import sk.ivankohut.bibliasktoopensong.bibliask.BibliaSkBible;
import sk.ivankohut.bibliasktoopensong.bibliask.BibliaSkPage;
import sk.ivankohut.bibliasktoopensong.bibliask.BookCoordinate;
import sk.ivankohut.bibliasktoopensong.bibliask.StaticBookCoordinates;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BibliaSkToOpenSong {

    private final OpenSongXmlBible openSongXmlBible;

    public BibliaSkToOpenSong(String hostName, String translation, Iterable<BookCoordinate> oldTestament, Iterable<BookCoordinate> newTestament) {
        this.openSongXmlBible = new OpenSongXmlBible(
                new BibliaSkBible(
                        oldTestament,
                        newTestament,
                        (book, chapter) -> new BibliaSkPage(hostName, translation, book, chapter)
                )
        );
    }

    public BibliaSkToOpenSong(String hostName, String translation) {
        this(hostName, translation, new StaticBookCoordinates().oldTestament(), new StaticBookCoordinates().newTestament());
    }

    public void writeTo(String fileName) {
        try {
            Files.writeString(Paths.get(fileName), openSongXmlBible.toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
