package it.cs.unicam.ids.c3.util;

import java.util.List;
import java.util.stream.Collectors;

public interface ObjectStringer<T> {
    String objectToString(T object);
    default String objectToString(List<T> objects){
        String s ="";
        List<String> list = objects.stream().map(this::objectToString).collect(Collectors.toList());
        for (String stringa:list) {
            s +=stringa+"\n";
        }
        return s;
    }
}
