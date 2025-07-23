# 🔷 Java Collections – Full Interview Revision

## 📚 1. Overview: Core Interfaces in Java Collections

| Interface    | Description                         | Key Implementations                                |
|--------------|-------------------------------------|----------------------------------------------------|
| `Collection` | Root interface for all collections  | `List`, `Set`, `Queue`                             |
| `List`       | Ordered, allows duplicates          | `ArrayList`, `LinkedList`, `Vector`                |
| `Set`        | No duplicates, unordered or ordered | `HashSet`, `LinkedHashSet`, `TreeSet`              |
| `Queue`      | FIFO or priority-based access       | `LinkedList`, `PriorityQueue`, `Deque`             |
| `Map`        | Key-value pairs, unique keys        | `HashMap`, `TreeMap`, `LinkedHashMap`, `Hashtable` |

## 🔍 2. Frequently Asked Interview Questions & Answers

### Q1: What is the difference between `ArrayList` and `LinkedList`?
**Answer:**

| Feature            | `ArrayList`                                                         | `LinkedList`                                                           |
|--------------------|---------------------------------------------------------------------|------------------------------------------------------------------------|
| Structure          | Dynamic array                                                       | Doubly linked list                                                     |
| Access Time        | Fast (O(1))                                                         | Slow (O(n))                                                            |
| Insertion/Deletion | Slow (O(n))                                                         | Fast (O(1)) for head/tail                                              |
| Memory             | Less overhead                                                       | More (due to pointers)                                                 |
| Usage              | Better for storing and accessing data, Read operations and frequent | Good for manipulating data, frequent insertions/deletions are required |

```java
import java.util.LinkedList;

public class ListComparison {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.addFirst("Mango"); // Adding at the beginning
        linkedList.addLast("Orange"); // Adding at the end
        System.out.println("LinkedList: " + linkedList);
        
        ArratList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        arrayList.add(0, "Mango"); // Adding at the beginning
        arrayList.add(arrayList.size(), "Orange"); // Adding at the end
        System.out.println("ArrayList: " + arrayList);
    }
}
```
- If you want to access and manipulate data frequently, `ArrayList` is generally preferred. Because the ArrayList provides faster access time due to its underlying array structure. It allows for quick retrieval of elements using an index. 
- However, if you need to perform many insertions and deletions, especially at the beginning or end, `LinkedList` is more efficient. Because the `LinkedList` allows for constant time insertions and deletions at both ends, making it suitable for scenarios where data manipulation is frequent. The node structure of `LinkedList` allows for efficient memory usage when adding or removing elements, as it does not require shifting elements like `ArrayList` does.
> Why use `ArrayList` over `Array`?  
> **Answer:** `ArrayList` provides dynamic resizing, built-in methods for manipulation, and better memory management compared to fixed-size arrays. It allows for easy addition and removal of elements without needing to manage the size manually.
