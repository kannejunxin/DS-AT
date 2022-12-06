/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-20
 * Time: 下午4:35
 */
public class Solution799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+2][query_row+2];
        dp[1][1] = poured;//下标（0,0）的酒杯我们存放在dp[1][1]的位置上
        for(int row=2;row<query_row+2;row++){
            for(int column = 1;column<=row;column++){
                dp[row][column] = Math.max(dp[row - 1][column - 1] - 1, 0) /
                        2 + Math.max(dp[row - 1][column] - 1, 0) / 2;
            }
        }
        return Math.min(dp[query_row + 1][query_glass + 1], 1);
    }
}
