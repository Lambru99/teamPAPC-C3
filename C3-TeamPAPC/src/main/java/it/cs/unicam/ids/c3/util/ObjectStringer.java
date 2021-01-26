package it.cs.unicam.ids.c3.util;

import java.util.List;
import java.util.stream.Collectors;

/**
 * interfaccia funzionale che si occupa di restituire una stringa associata ad un'istanza di tipo generico <T>
 *     a secondo della sua implementazione
 * @param <T>
 */
@FunctionalInterface
public interface ObjectStringer<T> {
    String objectToString(T object);

    default String objectToString(List<T> objects){
        StringBuilder s = new StringBuilder();
        s.append("[ ");
        List<String> list = objects.stream().map(this::objectToString).collect(Collectors.toList());
        for (String stringa:list) {
            s.append(stringa).append("\n");
        }
        s.append(" ]");
        return s.toString();
    }
}
