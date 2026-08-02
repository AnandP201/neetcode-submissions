import "slices"

func backtrack(result *[][]int, nums []int , idx int, path []int, sum int){
    if sum == 0 {
       
        pathCopy := make([]int, len(path))
		copy(pathCopy, path)

        *result = append(*result,pathCopy)
        return
    }

    if idx>=len(nums){
        return
    }

    for i:=idx ; i<len(nums); i++{
        if sum < nums[i]{
            break;
        }
        path = append(path,nums[i])
        backtrack(result,nums,i,path,sum-nums[i])
        path = path[:len(path)-1]
    }
}



func combinationSum(nums []int, target int) [][]int {
    var result [][]int
    var path []int

    slices.Sort(nums)

    backtrack(&result,nums,0,path,target)
    return result
}
