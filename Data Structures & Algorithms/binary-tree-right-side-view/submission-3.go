/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func rightSideView(root *TreeNode) []int {
    
    list := make([]int,0)

    var dfs func(node *TreeNode, level int)

    dfs = func(node *TreeNode, level int){

        if node == nil {
            return
        }

        if len(list)==level {
            list = append(list,node.Val)
        }

        dfs(node.Right,level+1)
        dfs(node.Left,level+1)
    }

    dfs(root,0)

    return list

}
