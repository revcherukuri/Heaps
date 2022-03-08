import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxHeap {
    private int[] heap;                                                                 //Array as implicit data structure
    private int size;                                                                   //Size of array/heap

    public MaxHeap(int capacity) {                                                      //Default constructor, initializes heap array with certain capacity
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int value) {                                                     //Method to insert value to heap
        if (size == heap.length) {
            int newSize = heap.length * 2;
            heap = Arrays.copyOf(heap, newSize);
        }
        heap[size] = value;                                                             //Puts value to end of heap

        int currentIndex = size;                                                        //Temporary variable holds index of new value
        while(heap[currentIndex] > heap[getParent(currentIndex)]) {                     //Sort -- Loop through heap, if value at index of new value is greater than its parent, swap them
            swap(currentIndex, getParent(currentIndex));                                //Calling swap and passing indices will swap values of new value and its parent
            currentIndex = getParent(currentIndex);                                     //Update index for next iteration by setting it to parent's index, which currently holds the new value
        }
        size++;
    }

    public int removeMax() {                                                            //Method to remove max value (Root)
        int currentMax = heap[0];                                                       //Create current max variable and assign it to first value in heap (max value)
        heap[0] = heap[size-1];                                                           //Set first value of heap equal to value at end of heap
        size--;                                                                         //decrement size of heap, truncating value at end of heap which was formerly the max
        heapify(0);                                                               //call heapify with new first value to place it in correct position and reorder tree
        return currentMax;                                                              //return variable that held the original max value at the front of the heap;

    }

    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    public void heapify(int index) {                                                    //recursive method
        if (isLeaf(index))
            return;

        if (heap[index] < heap[getLeftChild(index)] || heap[index] < heap[getRightChild(index)]) {  //If node is less than both children
            if (heap[getLeftChild(index)] > heap[getRightChild(index)]) {                           //If left child is greater than right, swap parent with left
                swap(index, getLeftChild(index));                                 //Swap node at index with left child of node at index
                heapify(getLeftChild(index));                                           //Call heapify again with index of left child (Original index value always stays the same)
            }
            else {
                swap(index, getRightChild(index));                                //Swap node at index with right child of node at index
                heapify(getRightChild(index));                                                   //Call heapify again with index of right child ( "" )
            }
        }

    }

    public int getParent(int index) {
        return ((index - 1) / 2);                                                       //return parent's index
    }

    public int getLeftChild(int index) {
        return ((index * 2) + 1);                                                       //return left child's index
    }

    public int getRightChild(int index) {
        return ((index * 2) + 2);                                                       //return right child's index
    }

    public void swap(int index1, int index2) {                                          //Swaps values at 2 given indices
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void print() {
        for (int i = 0; i < size/2; i++) {
            try {
                int leftChild =  heap[(2*i)+1];
                int rightChild = heap[(2*i)+2];
                System.out.println(
                        "Parent: " + heap[i]
                                + " Left Child: " + leftChild
                                + " Right Child: " + rightChild
                );
            }
            catch (ArrayIndexOutOfBoundsException e) {
                if ((2*i)+1 > size) {
                    System.out.println("Parent: " + heap[i]);
                }
                else {
                    System.out.println("Parent: " + heap[i] + " Left Child: " + heap[(2*i)+1]);
                }
            }

        }
    }

}
