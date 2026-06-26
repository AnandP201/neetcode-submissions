class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty())
                return false;

            char check = stack.peek();

            if ((ch == ')' && check != '(') || (ch == '}' && check != '{')
                || (ch == ']' && check != '[')) {
                return false;
            }

            stack.pop();
        }

        return stack.isEmpty();
    }
}
