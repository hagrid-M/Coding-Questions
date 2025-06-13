import java.util.*;

public class Stacks {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (c == ')' || c == '}' || c == ']') {
                if (st.isEmpty())
                    return false;
                char last = st.pop();
                switch (c) {
                    case ')':
                        if (last != '(')
                            return false;
                        break;
                    case '}':
                        if (last != '{')
                            return false;
                        break;
                    case ']':
                        if (last != '[')
                            return false;
                        break;
                }

            } else {
                st.push(c);
            }
        }
        return st.isEmpty();

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int lengthSubset = nums1.length;
        int lengthArray = nums2.length;
        int[] result = new int[lengthSubset];
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = lengthArray - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                st.pop();
            }
            if (st.isEmpty())
                mp.put(nums2[i], -1);
            else
                mp.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }
        for (int i = 0; i < lengthSubset; i++) {
            result[i] = mp.get(nums1[i]);
        }

        return result;
    }

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % length]) {
                st.pop();
            }
            if (i < length) {
                result[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[i % length]);
        }

        return result;
    }

    public int trap(int[] height) {
        int result = 0;
        int length = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int current = height[right];
            if (height[left] <= current) {
                if (leftMax > height[left]) {
                    result += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left += 1;
            } else {
                if (rightMax > current) {
                    result += rightMax - current;
                } else {
                    rightMax = current;
                }
                right -= 1;
            }
        }
        return result;
    }

    public int[] nextSmallerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int length = arr.length;
        int[] result = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            result[i] = st.isEmpty() ? length : st.peek();

            st.push(i);
        }
        return result;
    }

    public int[] previousSmallerOrEqualElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int length = arr.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();
            result[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
        return result;
    }

    public long sumSubarrayMins(int[] arr) {
        long sum = 0;
        int length = arr.length;
        int[] nse = nextSmallerElement(arr);
        int[] psee = previousSmallerOrEqualElement(arr);
        for (int i = 0; i < length; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            sum = (sum + ((long) left * right * arr[i]));
        }
        return sum;

    }

    public long sumSubArrayMax(int[] arr) {
        long sum = 0;
        int length = arr.length;
        int[] nle = nextLargerElement(arr);
        int[] plee = previousLargerOrEqualElement(arr);

        for (int i = 0; i < length; i++) {
            int left = i - plee[i];
            int right = nle[i] - i;
            sum = (sum + ((long) left * right * arr[i]));
        }
        return sum;
    }

    private int[] previousLargerOrEqualElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int length = arr.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i])
                st.pop();
            result[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
        return result;
    }

    private int[] nextLargerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int length = arr.length;
        int[] result = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            result[i] = st.isEmpty() ? length : st.peek();

            st.push(i);
        }
        return result;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int length = asteroids.length;
        for (int element : asteroids) {
            if (st.isEmpty())
                st.push(element);
            else {
                if ((element > 0 && st.peek() > 0) || (st.peek() < 0))
                    st.push(element);
                else {
                    while (!st.isEmpty() && st.peek() >= 0 && (Math.abs(st.peek()) < Math.abs(element)))
                        st.pop();
                    if (st.isEmpty() || st.peek() < 0)
                        st.push(element);
                    else if ((Math.abs(st.peek()) == Math.abs(element)))
                        st.pop();
                }
            }
        }
        int lengthOfResult = st.size();
        int[] result = new int[lengthOfResult];
        for (int i = lengthOfResult - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }

    public long subArrayRanges(int[] nums) {
        return (sumSubArrayMax(nums) - sumSubarrayMins(nums));
    }

    public String removeKdigits(String num, int k) {
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int length = num.length();
        if (k == length)
            result.append('0');
        for (int i = 0; i < length; i++) {
            char c = num.charAt(i);
            if (st.isEmpty())
                st.push(c);
            else {
                while (!st.isEmpty() && k > 0 && st.peek() > c) {
                    st.pop();
                    k -= 1;
                }
                st.push(c);
            }
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        return result.reverse().toString().replaceFirst("^0+(?!$)", "");

    }

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < length; i++) {
            int curr = heights[i];
            while (!st.isEmpty() && heights[st.peek()] > curr) {
                int element = heights[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, (nse - pse - 1) * element);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int element = heights[st.pop()];
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, (length - pse - 1) * element);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxRectangle = 0;
        int[][] prefixSum = new int[row][col];
        for (int i = 0; i < col; i++) {
            prefixSum[0][i] = (int) matrix[0][i] - '0';
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                prefixSum[i][j] = (matrix[i][j] == '0') ? matrix[i][j] - '0' : prefixSum[i - 1][j] + 1;
            }
        }
        for (int i = 0; i < row; i++) {
            maxRectangle = Math.max(maxRectangle, largestRectangleArea(prefixSum[i]));
        }
        return maxRectangle;

    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MinStack {
    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int x) {
        int min;
        if (st.isEmpty()) {
            min = x;
        } else {
            min = Math.min(st.peek().y, x);
        }
        st.push(new Pair(x, min));
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().x;
    }

    public int getMin() {
        return st.peek().y;
    }
}
class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();

    }

    public int next(int price) {
        int span =1;
        while (!st.isEmpty() && st.peek()[0] <= price){
            span+=st.peek()[1];
            st.pop();
        }
        st.push(new int[]{price,span});
        return span;
    }
}

class LRUCache {
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map < Integer, Node > map = new HashMap();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    class Node {
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}