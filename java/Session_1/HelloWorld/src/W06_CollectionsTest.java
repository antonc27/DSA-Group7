import org.junit.Test;

import static org.junit.Assert.*;

public class W06_CollectionsTest {
    @Test
    public void twoSum() {
        assertArrayEquals(new int[] {0, 1}, W06_Collections.twoSum(new int[] {2,7,11,15}, 9));
        assertArrayEquals(new int[] {1, 2}, W06_Collections.twoSum(new int[] {3,2,4}, 6));
        assertArrayEquals(new int[] {0, 1}, W06_Collections.twoSum(new int[] {3,3}, 6));
    }

    @Test
    public void lengthOfLongestSubstring() {
        assertEquals(3, W06_Collections.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, W06_Collections.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, W06_Collections.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void middleNode() {
        var list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        assertEquals(3, W06_Collections.middleNode(list1).val);
        var list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        assertEquals(4, W06_Collections.middleNode(list2).val);

    }
}