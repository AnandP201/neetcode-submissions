func searchRange(nums []int, target int) []int {
	L := 0 
	R := len(nums)-1

	ans := []int{-1,-1}
	// left position
	for L<=R {
		mid := L + (R-L)/2
		if nums[mid]>target {
			R = mid - 1
		}else{
			L = mid + 1
		}
		if nums[mid]==target{
			ans[1]=mid
		}
	}


	// right position
	L = 0 
	R = len(nums)-1

	for L<=R {
		mid := L + (R-L)/2
		if nums[mid]<target {
			L = mid + 1
		}else{
			R = mid - 1
		}
		if nums[mid]==target{
			ans[0]=mid
		}
	}

	return ans

}
