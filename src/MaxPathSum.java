/**
 * Created by szhu on 2/27/2014.
 */
public class MaxPathSum {
    public static void main(String []args){
        //create a tree
/*        TreeNode  r = new TreeNode(5);
        TreeNode  l = new TreeNode(-2);
        TreeNode  l1 = new TreeNode(-1);
        TreeNode  l2 = new TreeNode(1);
        TreeNode  r2 = new TreeNode(4);
        r.right = l;
        l.left = l2;
        l.right = l1;
        l1.right=r2;*/
        TreeNode  r = new TreeNode(1);
        TreeNode  l = new TreeNode(2);
        TreeNode  ri = new TreeNode(3);
        r.left = l;
        r.right = ri;
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(r));
    }

    public int maxPathSum(TreeNode root){

        int max;
        int [] result;
        result = maxPath(root);
        max = result[0] > result[1]? result[0]:result[1];
        return max;
    }

    public int [] maxPath(TreeNode root){
        //result[0] path max
        //result[1] overall max
        int [] result = new int[2];
        int [] resultLeft = new int[2];
        if(root.left == null && root.right ==null){
            result[0] = root.val;
            result[1] = root.val;
        }else if(root.left != null && root.right == null){
            result = maxPath(root.left);
            result[0] = root.val > result[0]+root.val?root.val:result[0]+root.val;
            result[1] = root.val > result[1]? root.val:result[1];
            if(result[0] > result[1])
                result[1] = result[0];
        }else if(root.right != null && root.left == null){
            result = maxPath(root.right);
            result[0] = root.val > result[0] + root.val?root.val:result[0] + root.val;
            result[1] = root.val > result[1]? root.val:result[1];
            if(result[0] > result[1])
                result[1] = result[0];
        }else{
            resultLeft = maxPath(root.left);
            result = maxPath(root.right);
            result[1] = result[1] > resultLeft[1]? result[1]:resultLeft[1];
            if(result[1] < result[0] + resultLeft[0] + root.val)
                result[1] = result[0] + resultLeft[0] + root.val;
            result[0] = result[0] > resultLeft[0]? result[0] + root.val :resultLeft[0] + root.val;
            result[0] = root.val > result[0] ? root.val : result[0];
            if(result[0] > result[1])
                result[1] = result[0];
        }
        return result;
    }

}
