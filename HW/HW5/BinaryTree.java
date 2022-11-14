import java.util.ArrayList;


public class BinaryTree {
    
    public static ArrayList<Integer> elements = new ArrayList<>();
    
    public static void add(Integer element) {
        elements.add(element);
        int elementIndex = elements.size() - 1;
        while (!(elementIndex == 0) && !isCorrect(parentNode(elementIndex), elementIndex)) {
            int parent = parentNode(elementIndex);
            swap(elementIndex, parent);
            elementIndex = parent;
        }
    }

    public static void swap(int child, int parent) {
        int temp = elements.get(child);
        elements.set(child, elements.get(parent));
        elements.set(parent, temp);
    }

    public static boolean isCorrect(int parent, int child) {
        if (!isValidIndex(parent) || !isValidIndex(child)) {
            return true;
        }
        return elements.get(parent).compareTo(elements.get(parent)) < 0;
        
    }

    public static boolean isValidIndex(int index) {
        return index < elements.size();
    }

    public static boolean isNode(int index) {
        return !isValidIndex(leftNode(index));
    }

    public static int parentNode(int index) {
        return (index - 1) / 2;
    }
    
    public static int leftNode(int index) {
        return 2 * index + 1;
    }

    public static int rightNode(int index) {
        return 2 * index - 1;
    }

    public static Integer pop() {
        Integer result = elements.get(0);
        int lastElInd = elements.size() - 1;
        swap(0, lastElInd);
        elements.remove(lastElInd);
        int elementIndex = 0;
        while (!isNode(elementIndex) && !(isCorrectParent(elementIndex))) {
            int smallerChildIndex = smallerChildIndex(elementIndex);
            swap(elementIndex, smallerChildIndex);
            elementIndex = smallerChildIndex;
        }
        return result;

    }
    
    public static boolean isCorrectParent(int index) {
        return isCorrect(index, leftNode(index)) && isCorrect(index, rightNode(index));
    }

    public static int smallerChildIndex(int index) {
        int leftChildIndex = leftNode(index);
        int rightChildIndex = rightNode(index);
        
        if (!isValidIndex(rightChildIndex)) {
            return leftChildIndex;
        }

        if (elements.get(leftChildIndex).compareTo(elements.get(rightChildIndex)) < 0) {
            return leftChildIndex;
        }

        return rightChildIndex;

    }

    public static Integer[] sort(Integer[] mixedArray) {
        for (int i = 0; i < mixedArray.length; i++) {
            elements.add(mixedArray[i]);
            System.out.println(i);
        }
        System.out.println(String.valueOf(elements));
        for (int i = 0; i < mixedArray.length; i++) {
            System.out.println(i);
            mixedArray[i] = pop();
            
        }

        return mixedArray;
    }
}