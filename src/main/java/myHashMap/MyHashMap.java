package myHashMap;

import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private MyNode<K,V>[] nodeList = new MyNode[15];
    private int size = 0;
    private int capacity;

    public MyHashMap() {
        int defaultMapIndex = nodeList.length;
        capacity = (int) (defaultMapIndex * 0.75);
    }

    @Override
    public boolean containsKey(Object key) {
        if(size == 0) {
            throw new IllegalStateException("Map is empty");
        }
        int index = getIndex(key.hashCode(), nodeList.length);
        if (index > nodeList.length) {
            throw new IndexOutOfBoundsException("Invalid key, please check again!");
        }
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        if(size == 0) {
            throw new IllegalStateException("Map is empty");
        }
        int index = 0;
        while(index <nodeList.length) {
            MyNode<K,V> listNodeAtIndex = nodeList[index];
            while(listNodeAtIndex != null) {
                if(listNodeAtIndex.getValue() == value) {
                    return true;
                }
                listNodeAtIndex = listNodeAtIndex.getNext();
            }
            index++;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        if(size == 0) {
            throw new IllegalStateException("Map is empty");
        }
        int index = getIndex(key.hashCode(), nodeList.length);
        if(index > nodeList.length) {
            throw new IllegalArgumentException("Object type may be incompatible");
        }
        if(nodeList[index] == null) {
            return null;
        }
        MyNode<K,V> nodeAtIndex = nodeList[index];
        while(nodeAtIndex != null) {
            if(nodeAtIndex.getHashCode() == key.hashCode()) {
                return nodeAtIndex.getValue();
            }
            nodeAtIndex = nodeAtIndex.getNext();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        if(size == 0) {
            throw new IllegalStateException("List is empty");
        }
        Set<K> keySet = new HashSet<>();
        int index = 0;
        MyNode<K,V> listNodeAtIndex = null;
        while(index < nodeList.length) {
            if(nodeList[index] != null) {
               listNodeAtIndex = nodeList[index];
            }
            while(listNodeAtIndex != null) {
                keySet.add(listNodeAtIndex.getKey());
                listNodeAtIndex = listNodeAtIndex.getNext();
            }
            index++;
        }
        return keySet;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<V> valueSet() {
        if(size == 0) {
            return null;
        }
        Set<V> valueSet = new HashSet<>();
        int index = 0;
        while(index < nodeList.length) {
            MyNode<K,V> listNodeAtIndex = nodeList[index];
            while(listNodeAtIndex != null) {
                valueSet.add(listNodeAtIndex.getValue());
                listNodeAtIndex = listNodeAtIndex.getNext();
            }
            index++;
        }
        return valueSet;
    }

    @Override
    public void put(K key, V value) {
        if(size > capacity) {
            resize();
        }
        long hashCode = key.hashCode();
        int index = getIndex(hashCode, nodeList.length);
        if (index > nodeList.length) {
            throw new IndexOutOfBoundsException("Invalid key, please check again!");
        }
        MyNode<K, V> newNode = new MyNode<>();
        newNode.setHashCode(hashCode);
        newNode.setKey(key);
        newNode.setValue(value);

        if (nodeList[index] != null) {
            MyNode<K, V> listNodeAtIndex = nodeList[index];
            if (listNodeAtIndex.getHashCode() == key.hashCode()) {
                listNodeAtIndex.setValue(value);

            } else {
                while (listNodeAtIndex.getNext() != null) {
                    if (listNodeAtIndex.getHashCode() == key.hashCode()) {
                        listNodeAtIndex.setValue(value);
                        return;
                    }
                    listNodeAtIndex = listNodeAtIndex.getNext();
                }
                listNodeAtIndex.setNext(newNode);
                size++;
            }
        } else {
            nodeList[index] = newNode;
            size++;
        }
    }

    @Override
    public void remove(Object key) {
       if(size == 0) {
           throw new IllegalStateException("List is empty");
       }
       int index = getIndex(key.hashCode(), nodeList.length);
       if(index > nodeList.length) {
           throw new IndexOutOfBoundsException("Invalid key, please check again!");
       }
       MyNode<K,V> nodeAtIndex = nodeList[index];
       if(nodeAtIndex == null) {
           throw new NoSuchElementException("Element doesn't exist in map, nothing to remove");
       }

       MyNode<K,V> previous = null;
       while(nodeAtIndex != null) {
           if(nodeAtIndex.getHashCode() == key.hashCode()) {
               break;
           }
           previous = nodeAtIndex;
           nodeAtIndex = nodeAtIndex.getNext();
       }
       if(previous == null) {
          MyNode<K,V> node = nodeList[index].getNext();
          nodeList[index] = node;
          size--;
          return;
       }
       MyNode<K,V> next = nodeAtIndex.getNext();
       previous.setNext(next);
       nodeAtIndex.setNext(null);
       size--;
    }

    private int getIndex(long hashCode, int size) {
        return (int) hashCode & (size-1);
    }

    private void resize() {
        int newIndexSize = nodeList.length * 2;
        capacity = newIndexSize;
        MyNode<K,V>[] newNodeList = new MyNode[newIndexSize];
        int indexOfOldMap = 0;
        int newIndexPosition;
        MyNode<K,V> listNodeFromOldIndex;
        MyNode<K,V> listNodeFromNewIndex;
        while(indexOfOldMap < nodeList.length) {
            if(nodeList[indexOfOldMap] == null) {
                indexOfOldMap++;
                continue;
            }
            listNodeFromOldIndex = nodeList[indexOfOldMap];
            while(listNodeFromOldIndex != null) {
                newIndexPosition = getIndex(listNodeFromOldIndex.getHashCode(), newIndexSize);
                MyNode<K,V> movedNode = new MyNode<>();
                movedNode.setValue(listNodeFromOldIndex.getValue());
                movedNode.setHashCode(listNodeFromOldIndex.getHashCode());
                movedNode.setKey(listNodeFromOldIndex.getKey());
                if(newNodeList[newIndexPosition] == null) {
                    newNodeList[newIndexPosition] = movedNode;
                } else {
                    listNodeFromNewIndex = newNodeList[newIndexPosition];
                    while(listNodeFromNewIndex.getNext() != null) {
                        listNodeFromNewIndex = listNodeFromNewIndex.getNext();
                    }
                    listNodeFromNewIndex.setNext(movedNode);
                }
                listNodeFromOldIndex = listNodeFromOldIndex.getNext();
            }
            indexOfOldMap++;
        }
        nodeList = newNodeList;
    }

    public void clear() {
        nodeList = new MyNode[nodeList.length];
        size = 0;
        capacity = (int) (nodeList.length * 0.75);
    }
}
