package sk.ivankohut.bibliasktoopensong;

public interface Bible {

    String copyright();

    Iterable<Book> oldTestament();

    Iterable<Book> newTestament();
}
