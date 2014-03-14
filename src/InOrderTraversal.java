import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by szhu on 2/27/2014.
 */
public class InOrderTraversal {

    public static void main(String args[]){

    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null)
            return result;
        stack.push(root);
        TreeNode p,q=root;
        while(!stack.isEmpty()){
            p = stack.peek();
            if(q == p.left){
                result.add(p.val);
                q = p;
                if(p.right != null){
                    stack.push(p.right);
                }else{
                    q = stack.pop();
                }
            }else if(q == p.right){
                q = stack.pop();
            }else{
                p = p.left;
                if(p != null){
                    stack.push(p);
                }else{
                    q = p;
                }
            }
        }
        return result;
    }
}
