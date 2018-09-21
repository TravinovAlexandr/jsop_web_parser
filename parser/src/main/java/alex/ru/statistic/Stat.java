package alex.ru.statistic;

import alex.ru.rate.RateFacade;

public interface Stat {

    void compute(final RateFacade rateFacade);
    void compute(final RateFacade rateFacade, final String pathToLog);
    void compute(final RateFacade rateFacade, final String pathToLog, final String fileName);
}
