/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        sb.append(root.val);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left == null) sb.append(',').append('#');
            else{
                sb.append(',').append(curr.left.val);
                q.offer(curr.left);
            }
            if(curr.right == null) sb.append(',').append('#');
            else{
                sb.append(',').append(curr.right.val);
                q.offer(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        for(int i = 1; i < arr.length && !q.isEmpty() ; i++){
            TreeNode curr = q.poll();
            if(arr[i].charAt(0) != '#') {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                curr.left = left;
                q.offer(left);
            }
            i++;
            if(arr[i].charAt(0) != '#') {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                curr.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;