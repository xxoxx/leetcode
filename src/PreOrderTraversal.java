import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by szhu on 2/25/2014.
 */
public class PreOrderTraversal {
    public static void main(String []args){

    }
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(root == null)
            return result;
        stack.add(root);
        result.add(root.val);
        TreeNode p, q = root;
        while(!stack.isEmpty()){
            p = stack.peek();
            if(q == p.right){
                q = stack.pop();
            }else if(q == p.left){
                q = p.right;
                if(q != null){
                    stack.push(q);
                    result.add(q.val);
                }
            }else{
                q = p.left;
                if(q != null){
                    stack.add(q);
                    result.add(q.val);
                }
            }
        }
        return result;
    }

/*    iterativePreorder(node)
    parentStack = empty stack
    parentStack.push(null)
    top =  node
    while ( top != null )
    visit( top )
    if ( top.right != null )
            parentStack.push(top.right)
            if ( top.left != null )
            parentStack.push(top.left)
    top = parentStack.pop();*/
}
