package explore.topics.ocp;

public class CreateAndUserCollections {
    public static void main(String[] args) {

    }
}

/* Arraylist  Arraylist  Arraylist  Arraylist  Arraylist*************************
a resizable array impl of the List interface
capacity grows automatically
size of backing array can be managed

COMPLEXITY
size, isEmpty, get, set, iterator and listIterator operations  - Constant Time
add - amortized Constant Time
others - Linear

CONSTRUCTORS
ArrayList() [10 initial capacity]   , ArrayList(int capacity),   Arraylist(Collection<? extends E> c)

METHODS
add: to the end of list, add(index)
set: replaces
remove: fist element matching argument, or the index position
indexOf: index of first occurance or -1, lastIndexof
listIterator
----to manipulate the backing array
ensureCapacity:
trimToSize: trims the capacity to its current size
*/


/* TreeSet  TreeSet  TreeSet  TreeSet  TreeSet *************************
impl of set interface that sort elements based on their ordering
ordered natural ordering, by comparator provided at the creation time, depending on the cons used
Ordering consistent with equals method - recommendation (Treeset uses compare methods of com/comp interfaces), set compares using equals methods

COMPLEXITY


CONSTRUCTORS
treeSet() -> new, empty treeset, sorted according to natural ordering of elements
Treeset(SortedSet<E> s -> same elements from s, suing same ordereing as s
Treeset(Collection<? extends E> c) - new ts, sorted according to natural ordering
Treeset(Comparator<? extends E> c) - empty treeset, , sorted according to Comparator

METHODS
add -> if not present, boolean returns
remove -> if present, boolean returns
contains -> true
iteartor -> ascending order iterator

Which dont come from set interface

ceiling -> least element >= specified element (higher trictly)
floor -> greatest element =< specified element (lower)
headset -> <elements
tailSet > element
descendingIteartor:
comparator, used in set, or NO (atural ordering)

        List<String> listElements = Arrays.asList("A", "B", "B", "A");
        TreeSet<String> stringTreeSet = new TreeSet<>(listElements);
        Iterator<String> iterator = stringTreeSet.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

*/

/* ArrayDeque  ArrayDeque  ArrayDeque  ArrayDeque  ArrayDeque *************************
resizable array impl of Deque interface supporting CRUD at both ends
Most ArrayDeque operations are amortized contant time
No capacity restrictions

COMPLEXITY


CONSTRUCTORS
treeSet() -> new, empty treeset, sorted according to natural ordering of elements
Treeset(SortedSet<E> s -> same elements from s, suing same ordereing as s
Treeset(Collection<? extends E> c) - new ts, sorted according to natural ordering
Treeset(Comparator<? extends E> c) - empty treeset, , sorted according to Comparator

METHODS
add -> if not present, boolean returns
remove -> if present, boolean returns
contains -> true
iteartor -> ascending order iterator

Which dont come from set interface

ceiling -> least element >= specified element (higher trictly)
floor -> greatest element =< specified element (lower)
headset -> <elements
tailSet > element
descendingIteartor:
comparator, used in set, or NO (atural ordering)

        List<String> listElements = Arrays.asList("A", "B", "B", "A");
        TreeSet<String> stringTreeSet = new TreeSet<>(listElements);
        Iterator<String> iterator = stringTreeSet.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

*/