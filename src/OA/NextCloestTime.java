package OA;
import java.util.*;

/**
 * Created by mingyama on 2/27/18.
 */
public class NextCloestTime {

    public String solution(String time) {
        String[] strs = time.split(":");
        List<Integer> list = new LinkedList<>();
        int hour = Integer.parseInt(strs[0]);
        int min = Integer.parseInt(strs[1]);
        int hour1 = hour / 10;
        int hour2 = hour % 10;
        int min1 = min / 10;
        int min2 = min % 10;
        list.add(hour1);
        list.add(hour2);
        list.add(min1);
        list.add(min2);

        List<List<Integer>> res = permute(list);
        List<String> ret = new LinkedList<>();
        for (List<Integer> l : res ) {
            if (isValid(l)) {
                StringBuilder sb = new StringBuilder();
                for (int i : l) {
                    sb.append(i);
                }
                sb.insert(2, ":");
                ret.add(sb.toString());
            }
        }
//        System.out.println(ret.size());
        Collections.sort(ret);
        int index = ret.indexOf(time);
        return index == ret.size() - 1 ? ret.get(0) : ret.get(index + 1);
    }

    private boolean isValid(List<Integer> list) {
        int hour = list.get(0) * 10 + list.get(1);
        int minute = list.get(2) * 10 + list.get(3);
        return hour <= 23 && minute <= 59;
    }

    public List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer> > ret = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        helper(ret, new LinkedList<>(), nums, map);
        return ret;
    }

    public void helper(List<List<Integer> > ret, List<Integer> temp, List<Integer> nums, HashMap<Integer, Integer> map){
        if(temp.size() == nums.size()){
            if (!ret.contains(temp)) {
                ret.add(new LinkedList<>(temp));
            }
        }
        for(int i=0; i<nums.size(); i++){
            int cur = nums.get(i);
            if (getCount(temp, cur) == getCount(nums, cur)) continue;
            temp.add(nums.get(i));
            helper(ret, temp, nums, map);
            temp.remove(temp.size()-1);
        }
    }

    private int getCount(List<Integer> list, int num) {
        int res = 0;
        for (int i : list) {
            if (i == num) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NextCloestTime().solution("19:34"));
        System.out.println(new NextCloestTime().solution("23:59"));
        System.out.println(new NextCloestTime().solution("23:58"));
        System.out.println(new NextCloestTime().solution("11:00"));
    }
}
