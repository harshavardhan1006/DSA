/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static Map<Integer,List<int[]>> map;
    private static void fun(TreeNode root,int rootEle){
        if(!map.containsKey(rootEle)){
            return;
        }
        List<int[]> childs = map.get(rootEle);
        for(int[] i:childs){
            if(i[1] == 1){
                root.left = new TreeNode(i[0]);
                fun(root.left,i[0]);
            }
            else{
                root.right = new TreeNode(i[0]);
                fun(root.right,i[0]);
            }
        }
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] i:descriptions){
            int par = i[0];
            int child = i[1];
            int isLeft = i[2];
            set.add(child);
            map.computeIfAbsent(par , k -> new ArrayList<>()).add(new int[]{child,isLeft});
        }
        // for(int i:map.keySet()){
        //     List<int[]> lis = map.get(i);
        //     System.out.print(i+" ");
        //     for(int[] li:lis){
        //         System.out.print(li[0]+" "+li[1]+" ");
        //     }
        //     System.out.println();
        // }
        int rootEle = -1;
        for(int[] i:descriptions){
            if(!set.contains(i[0])){
                rootEle = i[0];
                break;
            }
        }
        TreeNode root = new TreeNode(rootEle);
        fun(root,rootEle);
        return root;
    }
}