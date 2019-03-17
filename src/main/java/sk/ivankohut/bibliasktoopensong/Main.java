package sk.ivankohut.bibliasktoopensong;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalStateException("One argument is expected - Bible translation code, e.g. seb");
        }
        var translation = args[0];
        new BibliaSkToOpenSong("www.biblia.sk", translation).writeTo(translation + ".xml");
    }
}
