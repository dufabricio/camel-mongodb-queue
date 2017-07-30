package com.edufabricio.server.route.utils;

import lombok.experimental.UtilityClass;

import java.util.Iterator;
import java.util.List;

@UtilityClass
public class RouteBuilderUtils {

    public static String toString(List<Long> longList) {
        StringBuilder sb = new StringBuilder();
        Iterator<Long> it = longList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

}
