package ee.bootcamp.codingwithdhaval;

import java.util.*;

public class Numbers implements List<Integer> {

    private List<Integer> numbers;
    private Filter filter;
    private Aggregator aggregator;

    public Numbers(List<Integer> numbers) {
        this.numbers = new ArrayList<Integer>();
        this.numbers.addAll(numbers);
        filter = new Filter();
        aggregator = new Aggregator();
    }

    public Numbers select(ThatAre... conditions) {
        numbers = filter.select(numbers, conditions);
        return this;
    }

    public Numbers selectInRange(int from, int to) {
        numbers = filter.selectInRange(numbers, from, to);
        return this;
    }

    public int sum() {
        return aggregator.sum(numbers);
    }

    @Override
    public int size() {
        return this.numbers.size();
    }

    @Override
    public boolean isEmpty() {
        return this.numbers.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.numbers.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.numbers.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.numbers.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.numbers.toArray(a);
    }

    @Override
    public boolean add(Integer integer) {
        return this.numbers.add(integer);
    }

    @Override
    public boolean remove(Object o) {
        return this.numbers.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.numbers.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return this.numbers.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        return this.numbers.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.numbers.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.numbers.retainAll(c);
    }

    @Override
    public void clear() {
        this.numbers.clear();
    }

    @Override
    public Integer get(int index) {
        return this.numbers.get(index);
    }

    @Override
    public Integer set(int index, Integer element) {
        return set(index, element);
    }

    @Override
    public void add(int index, Integer element) {
        this.numbers.add(index, element);
    }

    @Override
    public Integer remove(int index) {
        return this.numbers.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.numbers.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.numbers.lastIndexOf(o);
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return this.numbers.listIterator();
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return this.numbers.listIterator(index);
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        return this.numbers.subList(fromIndex, toIndex);
    }
}
