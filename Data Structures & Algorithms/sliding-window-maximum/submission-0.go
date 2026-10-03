func maxSlidingWindow(nums []int, k int) []int {
    n := len(nums)
    deque := make([]int,0)
    ans := make([]int,0)

    for i:=0;i<n;i++ {

        // if idx in deque is out of current window
        for len(deque)!=0 && (deque[0] < (i+1)-k) {
            deque = deque[1:]
        }

        // if front element is smaller than the incoming one
        for len(deque)!=0 && (nums[deque[len(deque)-1]] < nums[i]){
            deque = deque[:len(deque)-1]
        }

        deque = append(deque,i)

        if i >= k-1 {
            // k sized window
            ans = append(ans,nums[deque[0]])
        }

    }

    return ans
}
