package ru.javaops.restaurantvoting;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Utils {

    private Utils() {
    }

    protected static Date getYesterday() {
        return Date.from(LocalDate.now().minusDays(1).atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
