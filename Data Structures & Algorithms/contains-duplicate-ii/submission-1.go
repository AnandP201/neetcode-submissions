func containsNearbyDuplicate(nums []int, k int) bool {

	R:=0

	hash := make(map[int]int,0)

	for R < len(nums) {

		if idx, exists := hash[nums[R]]; exists  {
			if R - idx <= k {
				return true
			}
		}

		hash[nums[R]]=R
		R+=1

	}	

	return false
}
