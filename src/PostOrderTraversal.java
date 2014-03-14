import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by szhu on 2/25/2014.
 */

public class PostOrderTraversal {
    public static void main(String []args){

    }
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null)
            return result;
        stack.push(root);
        TreeNode q = root, p = null;
        while(!stack.empty()){
            p = stack.peek();
            if(q == p.right){
                q = stack.pop();
                result.add(q.val);
            }
            else if(q == p.left){
                q = p.right;
                if(q != null)
                    stack.push(q);
            }else{
                q = p.left;
                if(q != null)
                    stack.push(q);
            }

        }
        return result;
    }
}
