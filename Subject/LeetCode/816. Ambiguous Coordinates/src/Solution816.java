import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-08
 * Time: 下午7:23
 */
public class Solution816{
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList();
        s=s.substring(1,s.length()-1);//取出数字i
        for (int i = 1; i < s.length(); i++){   //将s划分成【x轴】和【y轴】
            for(String x : splitNums(s.substring(0,i))){ // 获得x轴 以及 其可能出现的所有形式
                for(String y : splitNums(s.substring(i))){
                    // 拼装在最终结果【n*m种】
                    result.add(new StringBuilder("(").append(x).append(", ").append(y).append(")").toString());
                }
            }
        }
        return  result;
    }
    //将num用小数点分割
    public List<String> splitNums(String num){
        List<String> list = new ArrayList();
        String left, right;
        int i = 1;
        while(i <= num.length() ){
            left = num.substring(0,i); //分割整数部分
            right = num.substring(i++); //分割小数部分
            if((!left.equals("0") && left.charAt(0)=='0')
                    ||(!right.isEmpty()&&right.charAt(right.length() - 1) == '0')){
                //对于整数部分，不允许以0开头，除非这个整数就是0本身
                //对于小数部分 不可以以0结尾
                continue;
            }
            if(right.isEmpty()){
                list.add(left);
            } else{
                list.add(new StringBuilder(left).append(".").append(right).toString());
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
