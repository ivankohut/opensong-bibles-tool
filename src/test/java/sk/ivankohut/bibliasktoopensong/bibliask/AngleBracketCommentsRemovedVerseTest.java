package sk.ivankohut.bibliasktoopensong.bibliask;

import org.junit.jupiter.api.Test;
import sk.ivankohut.bibliasktoopensong.SimpleVerse;

import static org.assertj.core.api.Assertions.assertThat;

class AngleBracketCommentsRemovedVerseTest {

    @Test
    void commentsAreRemoved() {
        var sut = new AngleBracketCommentsRemovedVerse(new SimpleVerse(
                0,
                "a<comment1>b <comment2>c<comment3> d <comment4> e"
        ));
        // exercise
        var result = sut.text();
        // verify
        assertThat(result).isEqualTo("abc d e");
    }
}
