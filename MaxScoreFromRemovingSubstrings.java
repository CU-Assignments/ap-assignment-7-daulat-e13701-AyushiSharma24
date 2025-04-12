import java.util.Stack;

public class MaxScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        if (y > x) {
            return maximumGain(s.replace('a', 'z').replace('b', 'a').replace('z', 'b'), y, x);
        }
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'a' && c == 'b') {
                stack.pop();
                res += x;
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        s = sb.reverse().toString();
        stack.clear();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                stack.pop();
                res += y;
            } else {
                stack.push(c);
            }
        }
        return res;
    }
}
