import java.time.LocalTime;
import java.util.Date;

/**
 * @Author: Yizhen Yuan
 * @Date: 2020.06.29
 * @Description:
 */
public class MyTimer {
    private long start;
    MyTimer(){
        start=new Date().getTime();
    }
    long tick(){
        long answer=new Date().getTime()-start;
        start+=answer;
        return answer;
    }
    long end(){
        return new Date().getTime()-start;
    }
}


