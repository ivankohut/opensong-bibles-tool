package sk.ivankohut.bibliasktoopensong;

public interface Book {

    String name();

    Iterable<Chapter> chapters();
}
