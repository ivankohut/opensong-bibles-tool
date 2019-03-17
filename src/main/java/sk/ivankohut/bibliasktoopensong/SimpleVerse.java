package sk.ivankohut.bibliasktoopensong;

public class SimpleVerse implements Verse {

    private final int number;
    private final String text;

    public SimpleVerse(int number, String text) {
        this.number = number;
        this.text = text;
    }

    @Override
    public Integer number() {
        return number;
    }

    @Override
    public String text() {
        return text;
    }
}
