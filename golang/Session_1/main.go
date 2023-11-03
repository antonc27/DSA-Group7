package main

import "fmt"

func fizzBuzz(n int) []string {
	ans := make([]string, n)
	for i := 1; i <= n; i++ {
		if i%3 == 0 && i%5 == 0 {
			ans[i-1] = "FizzBuzz"
		} else if i%3 == 0 {
			ans[i-1] = "Fizz"
		} else if i%5 == 0 {
			ans[i-1] = "Buzz"
		} else {
			ans[i-1] = fmt.Sprint(i)
		}
	}
	return ans
}

func containsDuplicate(nums []int) bool {
	set := make(map[int]struct{})
	for _, v := range nums {
		if _, ok := set[v]; ok {
			return true
		}
		set[v] = struct{}{}
	}
	return false
}

func numIdenticalPairs(nums []int) int {
	res := 0
	m := make(map[int]int)
	for _, v := range nums {
		res += m[v]
		m[v]++
	}
	return res
}

func reverseString(s []byte) {
	i := 0
	j := len(s) - 1
	for i < j {
		s[i], s[j] = s[j], s[i]
		i++
		j--
	}
}

func isAnagram(s string, t string) bool {
	m := make(map[rune]int)
	for _, v := range s {
		m[v]++
	}
	for _, v := range t {
		m[v]--
		if m[v] < 0 {
			return false
		}
	}
	for _, v := range m {
		if v != 0 {
			return false
		}
	}
	return true
}

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, v := range nums {
		if j, ok := m[target-v]; ok {
			return []int{j, i}
		}
		m[v] = i
	}
	return []int{}
}

func lengthOfLongestSubstring(s string) int {
	m := make(map[rune]int)
	ans := 0
	min := 0
	for i, v := range s {
		if j, ok := m[v]; ok && j >= min {
			curr := i - min
			if curr > ans {
				ans = curr
			}
			min = j + 1
		}
		m[v] = i
	}
	if len(s)-min > ans {
		ans = len(s) - min
	}
	return ans
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func middleNode(head *ListNode) *ListNode {
	slow := head
	fast := head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}

func hasCycle(head *ListNode) bool {
	slow := head
	fast := head
	madeTurn := false
	for fast != nil && fast.Next != nil {
		if madeTurn && fast == slow {
			return true
		}
		slow = slow.Next
		fast = fast.Next.Next
		madeTurn = true
	}
	return false
}

func reverseList(head *ListNode) *ListNode {
	var res *ListNode
	for head != nil {
		curr := head
		head = head.Next
		curr.Next = res
		res = curr
	}
	return res
}

func findDuplicates(nums []int) []int {
	res := make([]int, 0)
	for i := 0; i < len(nums); i++ {
		vv := abs(nums[i])
		if nums[vv-1] < 0 {
			res = append(res, vv)
		}
		nums[vv-1] *= -1
	}
	return res
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func singleNumber(nums []int) int {
	res := 0
	for _, v := range nums {
		res ^= v
	}
	return res
}

func sortedSquares(nums []int) []int {
	res := make([]int, len(nums))
	i := 0
	j := len(nums) - 1
	idx := j
	for i <= j {
		sqI := nums[i] * nums[i]
		sqJ := nums[j] * nums[j]
		if sqI > sqJ {
			res[idx] = sqI
			i++
		} else {
			res[idx] = sqJ
			j--
		}
		idx--
	}
	return res
}

func main() {
	fmt.Println(fizzBuzz(20))
	fmt.Println(containsDuplicate([]int{1, 2, 3, 1}))
	fmt.Println(numIdenticalPairs([]int{1, 2, 3, 1, 1, 3}))
	str := []byte{'h', 'e', 'l', 'l', 'o'}
	reverseString(str)
	fmt.Println(string(str))
	fmt.Println(isAnagram("anagram", "nagaram"))
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
	fmt.Println(lengthOfLongestSubstring("abcabcbb"))
	ln := &ListNode{Val: 1, Next: &ListNode{2, &ListNode{3, nil}}}
	res := middleNode(ln)
	fmt.Println(res.Val)
	ln2 := &ListNode{Val: 1, Next: nil}
	ln2.Next = ln2
	fmt.Println(hasCycle(ln2))
	fmt.Println(findDuplicates([]int{4, 3, 2, 7, 8, 2, 3, 1}))
	fmt.Println(singleNumber([]int{4, 1, 2, 1, 2}))
	fmt.Println(sortedSquares([]int{-4, -1, 0, 3, 10}))
}
