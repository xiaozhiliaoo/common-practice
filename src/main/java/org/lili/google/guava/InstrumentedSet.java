package org.lili.google.guava;

import com.google.common.collect.ForwardingSet;

import java.util.NavigableSet;
import java.util.Set;

/**
 * @author lili
 * @date 2020/10/9 13:01
 * @notes
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {

    private int addCount = 0;
    private final Set<E> forward;

    InstrumentedSet(Set<E> forward) {
        this.forward = forward;
    }

    @Override
    protected Set<E> delegate() {
        return forward;
    }

    @Override
    public boolean add(E element) {
        addCount++;
        return super.add(element);
    }

    public int getAddCount() {
        return addCount;
    }
}
