package alex.ru.rate;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class RateFacade {

    private List<Rate> rates;

    public boolean computeRate() {
        try {
            final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            final String[] names = context.getBeanNamesForType(Rate.class);

            final Parser parser = context.getBean(Parser.class);
            final Delegate parserDelegate = new ParserDelegate(parser);
            for (final String name : names) {
                parserDelegate.add((Rate) context.getBean(name));
            }
            rates = parserDelegate.getResult();

            if (rates == null || rates.size() == 0)
                return false;
            else
                return true;
        } catch (NullPointerException | BeansException e) {
            System.out.println("Bean(s) not found");
            System.exit(-1);
        }
        return false;
    }

    public String printRate() {
        final StringBuilder result = new StringBuilder();
        int listSize = rates.size();
        for(Rate rate : rates) {
            result.append(rate.getName())
                    .append("=")
                    .append(rate.getData());
            listSize--;
                    if(listSize != 0)
                        result.append("\n");
        }
        return result.toString();
    }


}
