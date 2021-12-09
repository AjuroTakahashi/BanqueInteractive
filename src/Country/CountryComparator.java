package Country;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class CountryComparator implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {

//        if (c1.name.compareTo(c2.name) > 0) {
//            return 1;
//        }
        return c1.name.compareTo(c2.name);
    }
}
