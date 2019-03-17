package sk.ivankohut.bibliasktoopensong.bibliask;

import io.vavr.collection.List;
import sk.ivankohut.bibliasktoopensong.Book;
import sk.ivankohut.bibliasktoopensong.Chapter;

import java.util.function.Supplier;

public class BibliaSkBook implements Book {

    private final BookCoordinate bookCoordinate;
    private final Supplier<Integer> chaptersCount;
    private final BibliaSkHtmlBibleChapters htmlChapters;

    public BibliaSkBook(BookCoordinate bookCoordinate, Supplier<Integer> chaptersCount, BibliaSkHtmlBibleChapters htmlChapters) {
        this.bookCoordinate = bookCoordinate;
        this.chaptersCount = chaptersCount;
        this.htmlChapters = htmlChapters;
    }

    @Override
    public String name() {
        return bookCoordinate.name();
    }

    @Override
    public Iterable<Chapter> chapters() {
        return List.rangeClosed(1, chaptersCount.get())
                .map(chapter -> new BibliaSkChapter(htmlChapters.chapter(bookCoordinate.code(), chapter)));
    }
}
