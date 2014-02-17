package us.marek.java.lambda.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Range implements Iterable<Integer> {

    final private List<Integer> l;

    public Range(final int from, final int until) {
        l = new ArrayList<Integer>(until - from);
        for (int i = from; i < until; i++) {
            l.add(i);
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return l.iterator();
    }

    @Override
    public String toString() {
        return l.toString();
    }
}
