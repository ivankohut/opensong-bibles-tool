package sk.ivankohut.bibliasktoopensong;

import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static sk.ivankohut.bibliasktoopensong.ResourcesUtils.resourceString;

class OpenSongXmlBibleTest {

    @Test
    void xmlRepresentationOfBible() {
        Book genesis = createBook(
                "Genesis",
                List.of(new SimpleVerse(4, "chapter1 verse1"), new SimpleVerse(2, "chapter1 verse2")),
                List.of(new SimpleVerse(1, "chapter2 verse1"), new SimpleVerse(7, "chapter2 verse2"))
        );
        Book mathew = createBook("Matúš");
        Bible bible = createBible(List.of(genesis), List.of(mathew), "copyright line 1\n\ncopyright line 2");
        var sut = new OpenSongXmlBible(bible);
        // exercise
        String result = sut.toString();
        // verify
        assertThat(result).isEqualTo(resourceString("unit/openSongXml.xml"));
    }

    private static Bible createBible(Iterable<Book> oldTestament, Iterable<Book> newTestament, String copyright) {
        Bible result = mock(Bible.class);
        when(result.oldTestament()).thenReturn(oldTestament);
        when(result.newTestament()).thenReturn(newTestament);
        when(result.copyright()).thenReturn(copyright);
        return result;
    }

    @SafeVarargs
    private static Book createBook(String name, Iterable<Verse>... chapters) {
        Book result = mock(Book.class);
        when(result.name()).thenReturn(name);
        List<Chapter> of = List.of(chapters)
                .map(verses -> when(mock(Chapter.class).iterator()).thenReturn(Iterator.ofAll(verses)).getMock());
        when(result.chapters()).thenReturn(of);
        return result;
    }
}