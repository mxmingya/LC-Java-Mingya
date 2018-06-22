package Tree;

public class MyIntegerStack {

    private int[] data;
    private int currentPosition;
    private int size; // current size of data[]

    public MyIntegerStack() {
        data = new int[20];
        currentPosition = 0;
        size = 20;
    }

    public void push(int n) {
        if (currentPosition == size - 1) {
            int[] newArr = new int[size * 2];
            addAll(data, newArr);
            data = newArr;
            size = newArr.length;
        }
        data[++currentPosition] = n;
    }

    public int peek() throws Exception {
        if (currentPosition == 0) {
            throw new Exception("Empty Stack Exception!");
        }
        return data[currentPosition];
    }

    public int pop() throws Exception {
        if (currentPosition == 0) {
            throw new Exception("Empty Stack Exception!");
        }
        int popData = data[currentPosition];
        currentPosition--;
        return popData;
    }

    public boolean empty() {
        return currentPosition == 0;
    }

    private void addAll(int[] previous, int[] newArr) {
        assert previous != null && newArr != null && previous.length <= newArr.length;
        for (int i = 0 ; i < previous.length; i++) {
            newArr[i] = previous[i];
        }
    }

    public static void main(String[] args) throws Exception {
        MyIntegerStack s = new MyIntegerStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.empty());
        System.out.println(s.currentPosition);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.currentPosition);
        while (!s.empty()) {
            System.out.println(s.pop());
        }
        System.out.println(s.empty());
        if (s.empty()) {
            System.out.println(s.pop());
        }
        // test output:
        /*
            false
            5
            5
            4
            3
            3
            2
            1
            true
            Exception in thread "main" java.lang.Exception: Empty Stack Exception!
                at Tree.MyIntegerStack.pop(MyIntegerStack.java:34)
                at Tree.MyIntegerStack.main(MyIntegerStack.java:68)
            */
    }

}
