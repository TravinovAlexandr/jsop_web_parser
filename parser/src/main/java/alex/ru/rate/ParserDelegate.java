package alex.ru.rate;

import java.util.*;

public class ParserDelegate implements Delegate {

    private final Deque<Rate> rates = new ArrayDeque<>();

    private Parser courseParser;

    public ParserDelegate(final Parser courseParser) {
        this.courseParser = courseParser;
    }

    @Override
    public ParserDelegate put(final Rate rate) {
        rates.add(rate);
        return this;
    }

    @Override
    public boolean add(final Rate rate) {
        return rates.add(rate);
    }

    private Rate pollLast() {
        return rates.pollFirst();
    }

    @Override
    public List<Rate> getResult() {
        final List<Rate> resultCours = new ArrayList<>();
        Rate rate = null;
        while(rates.size() > 0) {
            rate = courseParser.getResult(pollLast());
            if(rate != null)
                resultCours.add(rate);
        }
        return resultCours;
    }
}
