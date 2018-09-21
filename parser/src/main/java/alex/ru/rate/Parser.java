package alex.ru.rate;

import org.springframework.lang.Nullable;

public interface Parser {

    @Nullable
    Rate getResult(final Rate rate);
}
