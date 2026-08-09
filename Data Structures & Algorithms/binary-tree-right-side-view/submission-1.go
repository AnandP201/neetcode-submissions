/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func solve(root *TreeNode, level int, res *[]int){
	if root==nil {
		return
	}
	if len(*res)==level {
		*res = append(*res,root.Val)
	}

	solve(root.Right,level+1,res)
	solve(root.Left,level+1,res)
}

func rightSideView(root *TreeNode) []int {
	res := make([]int,0)
	solve(root,0,&res)
	return res
}