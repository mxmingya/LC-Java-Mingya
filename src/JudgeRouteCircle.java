/**
 * Created by mingyama on 10/3/17.
 */
import java.util.*;
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) return true;
        int x=0, y=0;
        for (int i = 0; i <moves.length(); i++ ) {
            Character cur = moves.charAt(i);
            if (cur == 'U') x--;
            else if (cur == 'L') y--;
            else if (cur == 'D') x++;
            else if (cur == 'R') y++;
        }
        return x == 0 && y == 0;
    }
}
