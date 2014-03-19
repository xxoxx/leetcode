import com.sun.swing.internal.plaf.synth.resources.synth_sv;

import java.util.LinkedList;

/**
 * Created by szhu on 2014-03-13.
 */
public class SurroundedRegion {
    public static void main(String []args){
/*        String []origin = {
                "XOXXOOXOXXXXOXOXXXXO",
                "OXOOXOXOXXXXXXOXXOXX",
                "XOOXOXOXOXXOXXXOOXXO",
                "OXXOOXXOXXXXOOXOOOXX",
                "XXOXOOXOOOXOXOXXXOXX",
                "OOOOXOXXOOXOOXOXXXXO",
                "XOXXXXOXXOXXOXXXOOXO",
                "OXXOOOXOOXOXXXOOXXOX",
                "OOOOXXOXOOXXOXOOXOXO",
                "OOXXXOXOXOXXXOXXXXXO",
                "XOXOXXXOXXXOXOXOXOXX",
                "OOXXXXOXXXOXOOOXXXOX",
                "XXXOOOOOXXOXXXOXXXXO",
                "OOXXXOOXOOXXXXXXOXXO",
                "OOOXXOOOOXXOXOOXXXXX",
                "OXXXOXOOXXXXXOXXXOOX",
                "OOOOXXXXOOOOXOOOOXXO",
                "XXXXXXXXXXOXXOXXXXXX",
                "OXOOXOOXXXXXXOXOXXXX",
                "OOXXXXXOOOXXXXXXOXXO"};*/

        String [] origin={
                "OXOOOX",
                "OOXXXO",
                "XXXXXO",
                "OOOOXX",
                "XXOOXO",
                "OOXXXX"
            };
        char [][] board = new char[origin.length][origin[0].length()];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] =  origin[i].charAt(j);
            }
        }

        SurroundedRegion surroundedRegion = new SurroundedRegion();
        surroundedRegion.solve(board);

        System.out.println("");
    }
    private class Point{
        int i;
        int j;
        Point(int i, int j){this.i = i; this.j = j;}
    }

    public void solve(char[][] board) {
        if(board.length <= 2)
            return;
        LinkedList<Point> linkedList = new LinkedList<Point>();
        int i = 0, j = 0;
        for(j = 0; j < board[0].length; j++){
            if(board[i][j] == 'O'){
                board[i][j] = 'Y';
                if(board[i + 1][j] == 'O' && j != 0 && j != board[0].length - 1){
                    linkedList.add(new Point(i + 1, j));
                    board[i + 1][j] = 'Y';
                }
            }
        }
        j = board[0].length - 1;
        for(i  = 1; i < board.length; i++){
            if(board[i][j] == 'O'){
                board[i][j] = 'Y';
                if(board[i][j - 1] == 'O' && i != board.length - 1 ){
                    linkedList.add(new Point(i, j - 1));
                    board[i][j - 1] = 'Y';
                }
            }
        }
        i = board.length - 1;
        for(j = board[0].length - 2; j >= 0; j--){
            if(board[i][j] == 'O'){
                board[i][j] = 'Y';
                if(board[i - 1][j] == 'O'&& j != 0){
                    linkedList.add(new Point(i - 1, j));
                    board[i - 1][j] = 'Y';
                }
            }
        }
        j = 0;
        for(i = board.length - 2; i > 0; i--){
            if(board[i][j] == 'O'){
                board[i][j] = 'Y';
                if(board[i][j + 1] == 'O'){
                    linkedList.add(new Point(i, j + 1));
                    board[i][j + 1] = 'Y';
                }
            }
        }

        while(!linkedList.isEmpty()){
            Point point = linkedList.pop();
            if(board[point.i - 1][point.j] == 'O'){
                linkedList.add(new Point(point.i - 1, point.j));
                board[point.i - 1][point.j] = 'Y';
            }
            if(board[point.i][point.j - 1] == 'O'){
                linkedList.add(new Point(point.i, point.j - 1));
                board[point.i][point.j - 1] = 'Y';
            }
            if(board[point.i + 1][point.j] =='O'){
                linkedList.add(new Point(point.i + 1, point.j));
                board[point.i + 1][point.j] = 'Y';
            }
            if(board[point.i][point.j + 1] == 'O'){
                linkedList.add(new Point(point.i, point.j + 1));
                board[point.i][point.j + 1] = 'Y';
            }
        }

        for(i = 0; i < board.length; i++){
            for(j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'Y')
                    board[i][j] = 'O';
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
}
