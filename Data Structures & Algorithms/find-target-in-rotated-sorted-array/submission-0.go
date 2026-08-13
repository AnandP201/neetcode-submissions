func search(nums []int, target int) int {
	L:=0
	R:=len(nums)-1

	for L<=R {
		mid := L+(R-L)/2

		if nums[mid]==target {
			return mid
		}

		if nums[L] <= nums[mid] {
			// left array is 100% sorted
			if target >= nums[L] && target <= nums[mid] {
				R = mid - 1
			}else{
				L=mid+1
			}
		}else{
			// right array is 100% sorted
			if target >= nums[mid] && target <= nums[R] {
				L = mid + 1
			}else{
				R = mid - 1
			}
		}
	}

	return -1
}
