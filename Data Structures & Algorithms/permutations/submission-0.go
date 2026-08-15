import "slices"

func backtrack(nums []int, result *[][]int, path []int){
	if len(nums)==len(path){
		copyPath := make([]int,len(path))
		copy(copyPath,path)
		*result = append(*result,copyPath)
		return
	}

	for i:=0 ; i<len(nums); i++ {
		if slices.Contains(path,nums[i]){
			continue
		}
		path = append(path,nums[i])
		backtrack(nums,result,path)
		path = path[:len(path)-1]
	}
}

func permute(nums []int) [][]int {
	result := make([][]int,0)
	path := make([]int,0)
	backtrack(nums,&result,path)
	return result
}
