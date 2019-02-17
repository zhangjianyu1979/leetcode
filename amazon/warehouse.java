import java.util.PriorityQueue;
import java.util.Comparator;

class point{
    int x;
    int y;
    public point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class warehouse{
    public static void main(String[] args){
        System.out.println("Amazon OA warehouse ");
        point[] pts = {new point(1,2), new point(3,4), new point(4,6),new point(2,4),new point(4,1)};
        warehouse wh = new warehouse(pts, new point(0,0));
        pts = wh.findKPoints(3);
        System.out.println("-----------");
        for(int i =0 ; i < pts.length;i++){
            System.out.println(pts[i].x);
            System.out.println(pts[i].y);
        }
        System.out.println("-----------");
    }
    private point orig ;
    private point[] points;
    public warehouse(point[] points, point orig){
        this.points = points;
        if(orig == null)
            this.orig = new point(0,0);
        else 
            this.orig = orig;
    }

    private int getDistance(point p1, point p2){
        System.out.println("getDistance");
        int res = (p1.x - p2.x)*(p1.x - p2.x)+(p1.y - p2.y)*(p1.y - p2.y);
        System.out.println(res);
        return res;
    }
    public point[] findKPoints(int k){
        PriorityQueue<point> pq = new PriorityQueue<point>(k, new Comparator<point>(){
            @Override
            public int compare(point p2, point p1){
                int res = getDistance(p1, orig) - getDistance(p2, orig);
                if(res == 0){
                    if(p1.x != p2.x)
                        return p1.x - p2.x;
                    else
                        return p1.y - p2.y;
                }else
                    return res;
                }
        });
        for(int i = 0; i < points.length; i++){
            pq.offer(points[i]);
            if(pq.size() > k)
                pq.poll();
        }

        int cnt = pq.size();
        point[] res = new point[cnt];
        while(!pq.isEmpty())
            res[--k] = pq.poll();
        return res;
    }

}
