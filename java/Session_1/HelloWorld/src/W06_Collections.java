import java.util.*;

public class W06_Collections {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (j < n) {
            char c = s.charAt(j);
            if (set.contains(c)) {
                res = Math.max(res, j-i);
                while (i < j && s.charAt(i) != c) {
                    set.remove(s.charAt(i));
                    i++;
                }
                if (i < j) {
                    i++;
                }
            }
            set.add(c);
            j++;
        }
        res = Math.max(res, j-i);
        return res;
    }

    public static ListNode middleNode(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static boolean hasCycle(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == null && fast == null) {
                break;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode curr = head;
            head = head.next;

            curr.next = res;
            res = curr;
        }
        return res;
    }

    public static boolean isValid(String s) {
        // ')' -> '(', etc.
        Map<Character, Character> map = buildBracketsMap();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char cc = stack.peek();
                    stack.pop();
                    if (map.get(c) != cc) {
                        return false;
                    }
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private static Map<Character, Character> buildBracketsMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        return map;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = ~(1 << 31) & nums[i];
            if ((nums[num - 1] & (1 << 31)) != 0) {
                res.add(num);
            }
            nums[num - 1] = nums[num - 1] | (1 << 31);
        }
        return res;
    }
}
