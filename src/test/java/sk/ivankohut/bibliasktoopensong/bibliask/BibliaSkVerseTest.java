package sk.ivankohut.bibliasktoopensong.bibliask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BibliaSkVerseTest {

    @Test
    void numberParsedAsInteger() {
        var sut = new BibliaSkVerse("123", null);
        // exercise
        var result = sut.number();
        // verify
        assertThat(result).isEqualTo(123);
    }

    @Test
    void notesAreRemovedFromText() {
        var sut = new BibliaSkVerse(null, "a<note>note</note>b");
        // exercise
        var result = sut.text();
        // verify
        assertThat(result).isEqualTo("ab");
    }

    @Test
    void titlesAreRemovedFromText() {
        var sut = new BibliaSkVerse(null, "a<h3>title</h3>b");
        // exercise
        var result = sut.text();
        // verify
        assertThat(result).isEqualTo("ab");
    }

    @ParameterizedTest
    @CsvSource({
            "a<char class=\"qt\">b</char>c,abc",
            "a <char class=\"qt\"> b</char>c,a  bc",
            "a<char class=\"qt\">b </char>c,abc",
            "a<char class=\"qt\">b</char> c,ab c",
            "a<char class=\"qt\">b </char> c,ab c",
    })
    void textModifiersAreAreRemovedFromTextWithSpaceRemovedFromBeforeEndingTag(String text, String expected) {
        var sut = new BibliaSkVerse(null, text);
        // exercise
        var result = sut.text();
        // verify
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void textIsTrimmed() {
        var sut = new BibliaSkVerse(null, " a b ");
        // exercise
        var result = sut.text();
        // verify
        assertThat(result).isEqualTo("a b");
    }
}
