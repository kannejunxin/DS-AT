import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-10
 * Time: 下午3:56
 */
public class Solution864 {
    //根据题目，最大长度为30 ， 钥匙最多为6把， INF在这里可以代表无穷大
    static int N = 35, K = 10,INF = 0X3F3F3F3F;
    //(x,y,state) 三元组状态（其中 (x,y)(x, y)(x,y) 代表当前所在的棋盘位置，statestatestate 代表当前的钥匙收集情况）
    static int[][][] dist = new int[N][N][1 << K];
    //每一个数组代表一个方向
    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length, m = grid[0].length(), cnt = 0;//n/i表示二维网格纵坐标 m/j表示二维网格横坐标  cnt整个棋盘所包含的钥匙数量
        Deque<int[]> d = new ArrayDeque<>();//java中的queue类是队列数据结构管理类

        for(int i = 0; i < n ;i++){
            for(int j = 0; j < m;j++){
                Arrays.fill(dist[i][j],INF);
                char c = grid[i].charAt(j);
                if (c == '@') {//起点
                    d.addLast(new int[]{i, j, 0});//压入队列
                    dist[i][j][0] = 0;//步数为0
                } else if(c >= 'a' && c <= 'z'){
                    cnt++;//计算得出钥匙数
                }
            }
        }
        /*
            1、从栈中弹出第一位的坐标，然后开始向四周前进（即坐标加上方向数组的数），然后判断哪一个可以继续前进。
            2、判断每一次向四周前进时已经存在的步数是否小于当前步数加一，小于的话跳过（确定要是最短路径）
            3、如果当前已获取的钥匙数已经足够，则直接返回步数，否则继续
            4、将满足条件的坐标以及钥匙状态加入栈中等待下一次广度判断
        */
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            //根据之前的定义可知，xy是坐标，cur是当前钥匙状态，step是以走到这一步并且状态为state时的步数是多少
            int x = info[0], y = info[1], cur = info[2], step = dist[x][y][cur];
            for (int[] di : dirs) { //遍历四个方向
                //下一个方向前进一个单位的坐标，循环中四个方向都会计算一次
                int nx = x + di[0], ny = y + di[1];
                //判断是否还在网格内(在存放的时候，x是纵坐标，y是横坐标)  排除越界可能
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //获得下一个方向的字符，来判断行为
                char c = grid[nx].charAt(ny);
                if (c == '#') continue;//相应位置为一堵墙
                //这里，此处是锁但没有钥匙就跳过，有钥匙的情况根据题中的意思是没必要去处理的
                if ((c >= 'A' && c <= 'Z') && (cur >> (c - 'A') & 1) == 0) continue;
                int ncur = cur;
                if (c >= 'a' && c <= 'z') ncur |= 1 << (c - 'a');
                //ncur == (1 << cnt) - 1 表示钥匙全部收集完成
                if (ncur == (1 << cnt) - 1) return step + 1;
                //如果之前有更短的走法已经达到了这一步，则跳过
                if (step + 1 >= dist[nx][ny][ncur]) continue;
                //排除了以上可能之后，更改dist，坐标入栈
                dist[nx][ny][ncur] = step + 1;
                d.addLast(new int[]{nx, ny, ncur});
            }
        }
        return -1;
    }
}
