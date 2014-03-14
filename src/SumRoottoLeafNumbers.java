import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by szhu on 2014-03-12.
 */
public class SumRoottoLeafNumbers {
    public static void main(String []args){
        TreeNode [] treeNodes = {new TreeNode(1), new TreeNode(2), new TreeNode(3), new TreeNode(4)};
        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[3];
        treeNodes[3].left = treeNodes[2];
        SumRoottoLeafNumbers sumRoottoLeafNumbers =  new SumRoottoLeafNumbers();
        sumRoottoLeafNumbers.sumNumbers(treeNodes[0]);
    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        TreeNode p = root, q = root;
        ArrayList<TreeNode> arrayList = new ArrayList<TreeNode>();
        arrayList.add(p);
        while(!arrayList.isEmpty()){
            p = arrayList.get(arrayList.size() - 1);
            if(p.left == null && p.right == null){
                int size =  arrayList.size();
                int integer = 0;
                for(int i = 0; i < size; i++){
                    integer = integer * 10 + arrayList.get(i).val;
                }
                sum += integer;
                q = p;
                arrayList.remove(p);
                continue;
            }
            if(q == p.left){
                q = p.right;
                if(q != null){
                    arrayList.add(q);
                }
            }else if(q == p.right){
                arrayList.remove(p);
                q = p;
                if(arrayList.size() - 1 > 0)
                    p = arrayList.get(arrayList.size() - 1);
            }else{
                if(p.left != null)
                    q = p.left;
                else if (p.right != null)
                    q = p.right;
                p = q;
                arrayList.add(p);
            }
        }
        return sum;
    }
}
