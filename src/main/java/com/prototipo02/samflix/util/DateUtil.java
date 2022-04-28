package com.prototipo02.samflix.util;

import org.springframework.stereotype.Component;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

    @Component
    public class DateUtil {
        public String formatLocalDateTimeToDataBaseStyle(LocalDateTime localDateTime){
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
        }
    }

