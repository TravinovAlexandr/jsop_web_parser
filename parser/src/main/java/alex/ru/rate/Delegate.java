package alex.ru.rate;

import java.util.List;

public interface Delegate {

    ParserDelegate put(final Rate rate);
    boolean add(final Rate rate);
    List<Rate> getResult();
}
