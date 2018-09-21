package alex.ru.ep;

import alex.ru.rate.*;
import alex.ru.statistic.Stat;
import alex.ru.statistic.StatWrapper;

public class App {

    public static void main(String[] args) {

        final RateFacade rateFacade = new RateFacade();

        if (args.length > 0 && args.length < 4 && args[0].equals("log")) {

            final Stat statistic = new StatWrapper();

            if(args.length == 3) {
                statistic.compute(rateFacade, args[1], args[2]);
            }
            else if(args.length == 2) {
                statistic.compute(rateFacade, args[1]);
            }
        } else {

            boolean isOk = rateFacade.computeRate();
            if(isOk)
                rateFacade.printRate();
        }

    }
}
