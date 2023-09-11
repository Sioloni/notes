package ru.neotoria.gempl.microservices.common_service.util;

import lombok.experimental.UtilityClass;

import java.util.LinkedHashMap;
import java.util.Map;

@UtilityClass
public class ParseUtil {


    public Map<String, Object> stacktraceToMap(StackTraceElement[] stackTraceElements) {
        final Map<String, Object> data = new LinkedHashMap<>();
        for (int i = 0; i < stackTraceElements.length; i++) {
            data.put(
                    String.valueOf(i),
                    stackTraceElements[i].toString()
            );
        }

        return data;
    }

    public Map<String, Object> stringStacktraceToMap(String stackTraceMapString) {
        Map<String, Object> parsedMap = new LinkedHashMap<>();

        stackTraceMapString = stackTraceMapString
                .substring(1, stackTraceMapString.length() - 1);

        String[] entries = stackTraceMapString.split(", ");

        for (String entry : entries) {
            String[] keyValue = entry.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1];
                parsedMap.put(key, value);
            }
        }
        return parsedMap;
    }
}
