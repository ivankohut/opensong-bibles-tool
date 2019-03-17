package sk.ivankohut.bibliasktoopensong.bibliask;

import io.vavr.collection.List;
import sk.ivankohut.bibliasktoopensong.bibliask.BookCoordinate;
import sk.ivankohut.bibliasktoopensong.bibliask.SimpleBookCoordinate;

public class StaticBookCoordinates {

    public Iterable<BookCoordinate> oldTestament() {
        return List.of(
                new SimpleBookCoordinate("gn", "Genezis"),
                new SimpleBookCoordinate("ex", "Exodus"),
                new SimpleBookCoordinate("lv", "Levitikus"),
                new SimpleBookCoordinate("nm", "Numeri"),
                new SimpleBookCoordinate("dt", "Deuteronómium"),
                new SimpleBookCoordinate("joz", "Jozua"),
                new SimpleBookCoordinate("sdc", "Sudcovia"),
                new SimpleBookCoordinate("rut", "Rút"),
                new SimpleBookCoordinate("1sam", "1. Samuelova"),
                new SimpleBookCoordinate("2sam", "2. Samuelova"),
                new SimpleBookCoordinate("1krl", "1. kráľov"),
                new SimpleBookCoordinate("2krl", "2. kráľov"),
                new SimpleBookCoordinate("1krn", "1. kroník"),
                new SimpleBookCoordinate("2krn", "2. kroník"),
                new SimpleBookCoordinate("ezd", "Ezdráš"),
                new SimpleBookCoordinate("neh", "Nehemiáš"),
                new SimpleBookCoordinate("est", "Ester"),
                new SimpleBookCoordinate("job", "Jób"),
                new SimpleBookCoordinate("z", "Žalmy"),
                new SimpleBookCoordinate("pris", "Príslovia"),
                new SimpleBookCoordinate("koh", "Kazateľ"),
                new SimpleBookCoordinate("vlp", "Veľpieseň"),
                new SimpleBookCoordinate("iz", "Izaiáš"),
                new SimpleBookCoordinate("jer", "Jeremiáš"),
                new SimpleBookCoordinate("nar", "Náreky"),
                new SimpleBookCoordinate("ez", "Ezechiel"),
                new SimpleBookCoordinate("dan", "Daniel"),
                new SimpleBookCoordinate("oz", "Ozeáš"),
                new SimpleBookCoordinate("joel", "Joel"),
                new SimpleBookCoordinate("am", "Amos"),
                new SimpleBookCoordinate("abd", "Abdiáš"),
                new SimpleBookCoordinate("jon", "Jonáš"),
                new SimpleBookCoordinate("mich", "Micheáš"),
                new SimpleBookCoordinate("nah", "Nahum"),
                new SimpleBookCoordinate("hab", "Habakuk"),
                new SimpleBookCoordinate("sof", "Sofoniáš"),
                new SimpleBookCoordinate("ag", "Aggeus"),
                new SimpleBookCoordinate("zach", "Zachariáš"),
                new SimpleBookCoordinate("mal", "Malachiáš")
                // Deuterokanonicke knihy zatial ignorujem, pretoze obsahuje nestandardne veci, ktore zatial neviem spracovat:
                // - Ester - nenumericke cisla versov (napr. 1a)
                // - Sirachovec - Predhovor ako kapitola s cislom 0
                // - Sirachovec - chyba vo vstupnych datach - 26,18 - nekorektne ukoncena poznamka - chybaju koncove tagy </char> a </note>
//                new SimpleBookCoordinate("tob", "Tobiáš"),
//                new SimpleBookCoordinate("jdt", "Judita"),
//                new SimpleBookCoordinate("estgr", "Ester (grécka verzia)"),
//                new SimpleBookCoordinate("mud", "Kniha múdrosti"),
//                new SimpleBookCoordinate("sir", "Kniha Sirachovca"),
//                new SimpleBookCoordinate("bar", "Baruch (a Jeremiášov list)"),
//                new SimpleBookCoordinate("dangr", "Prídavky ku knihe Daniel"),
//                new SimpleBookCoordinate("1mak", "1. Makabejcov"),
//                new SimpleBookCoordinate("2mak", "2. Makabejcov")
        );
    }

    public Iterable<BookCoordinate> newTestament() {
        return List.of(
                new SimpleBookCoordinate("mt", "Matúš"),
                new SimpleBookCoordinate("mk", "Marek"),
                new SimpleBookCoordinate("lk", "Lukáš"),
                new SimpleBookCoordinate("jn", "Ján"),
                new SimpleBookCoordinate("sk", "Skutky"),
                new SimpleBookCoordinate("rim", "Rimanom"),
                new SimpleBookCoordinate("1kor", "1.Korinťanom"),
                new SimpleBookCoordinate("2kor", "2.Korinťanom"),
                new SimpleBookCoordinate("ga", "Galaťanom"),
                new SimpleBookCoordinate("ef", "Efežanom"),
                new SimpleBookCoordinate("flp", "Filipanom"),
                new SimpleBookCoordinate("kol", "Kolosanom"),
                new SimpleBookCoordinate("1tes", "1. Tesaloničanom"),
                new SimpleBookCoordinate("2tes", "2. Tesaloničanom"),
                new SimpleBookCoordinate("1tim", "1. Timoteovi"),
                new SimpleBookCoordinate("2tim", "2. Timoteovi"),
                new SimpleBookCoordinate("tit", "Títovi"),
                new SimpleBookCoordinate("flm", "Filemonovi"),
                new SimpleBookCoordinate("heb", "Hebrejom"),
                new SimpleBookCoordinate("jk", "Jakub"),
                new SimpleBookCoordinate("1pt", "1. Petrov"),
                new SimpleBookCoordinate("2pt", "2. Petrov"),
                new SimpleBookCoordinate("1jn", "1. Jánov"),
                new SimpleBookCoordinate("2jn", "2. Jánov"),
                new SimpleBookCoordinate("3jn", "3. Jánov"),
                new SimpleBookCoordinate("jud", "Júda"),
                new SimpleBookCoordinate("zj", "Zjavenie Jána")
        );
    }
}
