package sk.ivankohut.bibliasktoopensong.bibliask;

import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import sk.ivankohut.bibliasktoopensong.Bible;
import sk.ivankohut.bibliasktoopensong.Book;

import java.time.Clock;

public class BibliaSkBible implements Bible {

    private final BibliaSkHtmlBibleChapters htmlChapters;
    private final Iterable<BookCoordinate> oldTestament;
    private final Iterable<BookCoordinate> newTestament;

    public BibliaSkBible(Iterable<BookCoordinate> oldTestament, Iterable<BookCoordinate> newTestament, BibliaSkHtmlBibleChapters htmlChapters) {
        this.oldTestament = oldTestament;
        this.newTestament = newTestament;
        this.htmlChapters = htmlChapters;
    }

    @Override
    public String copyright() {
        return Iterator.concat(oldTestament, newTestament).headOption()
                .map(bookCoordinate -> new BibleSkCopyright(htmlChapters.chapter(bookCoordinate.code(), 1), Clock.systemDefaultZone()))
                .getOrElseThrow(() -> new IllegalArgumentException("No any book coordinates provided."))
                .toString();
    }

    @Override
    public Iterable<Book> oldTestament() {
        return testament(oldTestament);
    }

    @Override
    public Iterable<Book> newTestament() {
        return testament(newTestament);
    }

    private List<Book> testament(Iterable<BookCoordinate> bookCoordinates) {
        return List.ofAll(bookCoordinates)
                .map(bookCoordinate -> {
                    var firstChapterHtml = htmlChapters.chapter(bookCoordinate.code(), 1);
                    return new BibliaSkBook(bookCoordinate, new BibliaSkChaptersCount(firstChapterHtml), htmlChapters);
                });
    }
}

