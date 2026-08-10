func containsNearbyDuplicate(nums []int, k int) bool {

	hash := make(map[int]int,0)

	for i,num := range nums {
		if idx , exists := hash[num]; exists && i - idx <= k {
			return true
		}
		hash[num]=i
	}	

	return false
}
