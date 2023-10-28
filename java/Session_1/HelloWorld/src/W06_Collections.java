import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
}
