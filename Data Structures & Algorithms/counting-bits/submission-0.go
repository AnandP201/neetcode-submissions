func countBits(n int) []int {

	ans := make([]int,0)
	for i:=0; i<=n;i++ {
		count := 0
		for j:=0;j<32;j++ {
			if 1<<j & i != 0 {
				count++
			}
		}
		ans = append(ans,count)
	}
	return ans

}
