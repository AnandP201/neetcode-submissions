/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func rightSideView(root *TreeNode) []int {
    
	var list []int

	var solve func(root *TreeNode, level int)

	solve = func(root *TreeNode, level int) {

		if root==nil {
			return
		}

		if len(list)==level {
			list = append(list,root.Val)
		}

		solve(root.Right,level+1)
		solve(root.Left,level+1)
	}

	solve(root,0)
	return list

}
