package alex.ru.rate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.lang.Nullable;
import java.io.IOException;

//for "http://www.banki.ru/products/currency/cb/"
public class RateBankiParser implements Parser {

    @Override @Nullable
    public Rate getResult(final Rate rate) {
        try {
            final Document doc = Jsoup.connect(rate.getUrl()).get();

            if (rate.getName().equals("usd")) {
                return defineOrderAndGetResult(doc, rate, 0);

            } else if (rate.getName().equals("eur")) {
                return defineOrderAndGetResult(doc, rate, 1);
            }
            else if (rate.getName().equals("cny")) {
                return defineOrderAndGetResult(doc, rate, 16);
            }
            return null;


        } catch (NullPointerException | IOException e) {
            switch (e.getClass().getSimpleName()) {
                case "NullPointerException":
                    System.out.println("Argument is null.");
                    break;
                case "IOException":
                    System.out.println("Web resource not found. Check connection &| reconfigure urls && rewrite dispatcher");
                    break;
            }
            return null;
        }
    }

    private Rate defineOrderAndGetResult(final Document doc, final Rate rate, int order) {
        final Elements trs = doc.select("tbody > tr");
        final Element tr = trs.get(order);
        final Elements tds = tr.select("td");
        final double moneyQuant = Integer.valueOf(tds.get(1).text());
        final String realValue =  String.valueOf(Double.valueOf(tds.get(3).text()) / moneyQuant);
        rate.setData(realValue);
        return rate;
    }
}
