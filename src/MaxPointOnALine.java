/**
 * Created by szhu on 2014-03-03.
 */

import java.util.Collections;
import java.util.HashMap;
public class MaxPointOnALine {
    public static void main(String [] args){
        Point [] points = {new Point(0,9),new Point(138,429),new Point(115,359),new Point(115,359),new Point(-30,-102),new Point(230,709),new Point(-150,-686),
                new Point(-135,-613),new Point(-60,-248),new Point(-161,-481),new Point(207,639),new Point(23,79),new Point(-230,-691),
                new Point(-115,-341),new Point(92,289),new Point(60,336),new Point(-105,-467),new Point(135,701),new Point(-90,-394),new Point(-184,-551),new Point(150,774)};
        MaxPointOnALine maxPointOnALine = new MaxPointOnALine();
        System.out.println(maxPointOnALine.maxPoints(points));
    }

    public int maxPoints(Point[] points){
        int result = 0;
        if(points.length < 3)
            result = points.length;
        else{

            for(int i = 0; i < points.length; i++){
                int a = 0, b = 0,  c= 0, x, y;
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                for(int j = 0; j < points.length; j++){
                    x = points[j].x - points[i].x;
                    y = points[j].y - points[i].y;
                    if(x == 0 && y == 0)
                        a++;
                    else if(x == 0)
                        b++;
                    else{
                        c = (int)(1e6*y/x);
                        if(map.get(c) == null)
                            map.put(c, 1);
                        else{
                            map.put(c, map.get(c)+ 1);
                        }
                    }
                }
                if(b + a > result)
                    result = b + a;
                if(!map.values().isEmpty() && Collections.max(map.values()) + a > result)
                    result = a + Collections.max(map.values());
            }
        }
        return result;
    }
}
