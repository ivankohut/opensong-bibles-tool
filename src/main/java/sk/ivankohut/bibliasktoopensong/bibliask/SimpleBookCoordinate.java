package sk.ivankohut.bibliasktoopensong.bibliask;

public class SimpleBookCoordinate implements BookCoordinate {

    private final String code;
    private final String name;

    public SimpleBookCoordinate(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String code() {
        return code;
    }

    public String name() {
        return name;
    }
}
