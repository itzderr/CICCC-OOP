package collections.list;


import java.util.*;

public class MyArrayList implements List, RandomAccess, Iterable {
    private static final int DEFAULT_SIZE = 10;
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_SIZE];         // create a new Object with a default size
        this.size = DEFAULT_SIZE;                       // the initial value of size is default
    }

    // not to take initial capacity other than 10;
    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }
    

    public MyArrayList(Collection c) {
        elementData = c.toArray();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++){
            if(o.equals(elementData[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        // DO NOT NEED TO IMPLEMENT
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        for (int i = 0; i < size; i++){
            System.arraycopy(elementData,i, newArray,i, size);
        }
        return newArray;
    }

    @Override
    public Object[] toArray(Object[] a) {
        // DO NOT NEED TO IMPLEMENT
        return new Object[0];
    }

    // [1, 2]
    // size = 2;
    @Override
    public boolean add(Object o) {
        if (size == elementData.length) {
            //resize (create a new array, 50% larger)
            elementData = grow(size + 1);
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
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                if (i == size - 1) {
                    elementData[i] = null;
                } else {
                    elementData[i] = elementData[i + 1];
                }
                size = size - 1;
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection c) {
        int count = 0;
        Iterator<Collection> it = c.iterator();
        int collectionSize = c.size();
        if (collectionSize == 0){
            return false;
        } while(it.hasNext()){
            for (int i = 0; i < size; i++) {
                if ((it.next()).equals(elementData[i])){
                    count++;
                }
            }
            if (count > collectionSize){
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean addAll(Collection c) {
        Object[] array = c.toArray();
        int arrayLength = array.length;
        if (arrayLength == 0)
            return false;
        Object[] elementData;
        final int s;
        if (arrayLength > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + arrayLength);
        System.arraycopy(array, 0, elementData, s, arrayLength);
        size = s + arrayLength;
        return true;
    }


    @Override
    public boolean addAll(int index, Collection c) {
        Object[] array = c.toArray();
        int arrayLength = array.length;
        if (arrayLength == 0)
            return false;
        Object[] elementData;
        final int s;
        if (arrayLength > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + arrayLength);
            System.arraycopy(array,0,elementData,s, arrayLength);
            size = s + arrayLength;
            return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        Object[] array = c.toArray();
        int arrayLength = array.length;
        int count = 0;
        if (arrayLength == 0){
            return false;
        }
        for (int i = 0; i < size; i++){
            for(int j = 0; j < arrayLength; j++){
                if(elementData[i].equals(array[j]))  {
                    elementData[i] = elementData[i + 1];
                    count++;
                }
            }
        }
        if(count == arrayLength){
            size = size - arrayLength;
            return true;
        }
        return false;
    }


    @Override
    public boolean retainAll(Collection c) {
        int collectionSize = c.size();
        if (collectionSize == 0){
            return false;
        }
        Iterator<Collection> it = c.iterator();
        for (int i = 0; i < size; i++){
            while (it.hasNext()) {
                if (elementData[i].equals(it.next())) {
                    elementData[i] = elementData[i];
                } else {
                    elementData[i] = elementData[i + 1];
                    elementData[size - 1] = null;
                    size = size - 1;
                }
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elementData[index];
    }

    @Override
    public Object set(int index, Object element) {
        // check if the index exist
        if (index > size){
            return false;
        }
        elementData[index] = new Object();
        elementData[index] = element;
        return true;
    }

    @Override
    public void add(int index, Object element) {
        //replace element in the index
        if(index <= size){
            Object temp = elementData[index];
            elementData[index] = new Object();
            elementData[index] = element;
            size = size + 1;
            for (int i = index; i < size; i++){
                elementData[i + 1] = elementData[i + 2];
            } elementData[index + 1] = temp;
        }
    }

    @Override
    public Object remove(int index) {
        if (index < size){
            for (int i = index; i < size; i++) {
                elementData[i] = elementData[index + 1];
            }
        }
        size = size - 1;
        return elementData;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++){
            if(elementData[i].equals(o)){
                return i;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size -1; i >= 0; i--){
            if(elementData[i].equals(o)){
                return i;
            }
        }
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

        List<Object> sub = new ArrayList<>();
        for (int i = fromIndex; i < toIndex + 1; i++){
            sub.add(elementData[i]);
        }
        return sub;
    }

}