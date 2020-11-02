package collections.list;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class MyArrayList implements List, RandomAccess {
  private static final int DEFAULT_SIZE = 10;
  private Object[] elementData;
  private int size;

  public MyArrayList() {
    // TODO: Implement Me
    elementData = new Object[DEFAULT_SIZE];
  }

  @Override
  public int size() {
    // TODO: Implement Me
    return size;
  }

  @Override
  public boolean isEmpty() {
    // TODO: Implement Me
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    // TODO: Implement Me
    return false;
  }

  @Override
  public Iterator iterator() {
    // DO NOT NEED TO IMPLEMENT
    return null;
  }

  @Override
  public Object[] toArray() {
    // TODO: Implement Me
    return new Object[0];
  }

  @Override
  public Object[] toArray(Object[] a) {
    // DO NOT NEED TO IMPLEMENT
    return new Object[0];
  }

  @Override
  public boolean add(Object o) {
    // TODO: Implement Me
    if (size == elementData.length) {
      elementData = grow(elementData.length);
    }
    elementData[size] = o;
    size++;
    return true;
  }

  private Object[] grow(int minCapacity) {
    return elementData = Arrays.copyOf(elementData, minCapacity + minCapacity / 2);
  }

  @Override
  public boolean remove(Object o) {
    // TODO: Implement Me
    // find the index of Object o; (linear search)
    // shift all the elements after the index to left
    return false;
  }

  @Override
  public boolean containsAll(Collection c) {
    // TODO: Implement Me
    return false;
  }

  @Override
  public boolean addAll(Collection c) {
    // TODO: Implement Me
    return false;
  }

  @Override
  public boolean addAll(int index, Collection c) {
    // TODO: Implement Me
    return false;
  }

  @Override
  public boolean removeAll(Collection c) {
    // TODO: Implement Me
    return false;
  }

  @Override
  public boolean retainAll(Collection c) {
    // TODO: Implement Me
    return false;
  }

  @Override
  public void clear() {
    // TODO: Implement Me
    for (int i = 0; i < size; i++) {
      elementData[i] = null;
    }
  }

  @Override
  public Object get(int index) {
    // TODO: Implement Me
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    return elementData[index];
  }

  @Override
  public Object set(int index, Object element) {
    // TODO: Implement Me
    return null;
  }

  @Override
  public void add(int index, Object element) {
    // TODO: Implement Me
  }

  @Override
  public Object remove(int index) {
    // TODO: Implement Me
    return null;
  }

  @Override
  public int indexOf(Object o) {
    // TODO: Implement Me
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    // TODO: Implement Me
    return 0;
  }

  @Override
  public ListIterator listIterator() {
    // DO NOT NEED TO IMPLEMENT
    return null;
  }

  @Override
  public ListIterator listIterator(int index) {
    // DO NOT NEED TO IMPLEMENT
    return null;
  }

  @Override
  public List subList(int fromIndex, int toIndex) {
    // TODO: Implement Me
    return null;
  }
}
