package com.mockitoCourse.listTransformer;

import java.util.List;
import java.util.stream.Collectors;

public class ListTransformer {

    public List<Item> contaisLetter(CharSequence letter, List<Item> list){
        return list.stream()
                .filter(item -> item.getDescription().contains(letter))
                .collect(Collectors.toList());
    }

    public List<Item> containsLetterandSort(CharSequence letter, List<Item> list){
        return list.stream()
                .filter(item -> item.getDescription().contains(letter))
                .sorted()
                .collect(Collectors.toList());
    }

}
