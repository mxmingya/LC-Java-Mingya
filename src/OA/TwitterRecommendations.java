package OA;
import java.util.*;
/**
 * Created by mingyama on 9/26/17.
 */
public class TwitterRecommendations {
    public int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges,
                                      int targetUser, int minLikeThreshold) {
        List<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> followedUsers = new HashSet<>();

        // get all followed users
        for (int[] chuck : followGraph_edges) {
            if (chuck[0] == targetUser) {
                System.out.printf("followed: %d", chuck[1]);
                followedUsers.add(chuck[1]);
            }
        }
        System.out.println("------------");

        for (int[] edge : likeGraph_edges) {
            // edge[0] user, edge[1] tweet
            // if this tweet is liked by the followed user by target user
            if (followedUsers.contains(edge[0])) {
                if (map.containsKey(edge[1])) {
                    map.put(edge[1], map.get(edge[1])+1);
                } else {
                    map.put(edge[1], 1);
                }
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) >= minLikeThreshold) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {
                {4, 3},
                        {1, 2},
                                {1, 3},
                                        {1, 4},
                                                {5, 6},
        };
        int[][] test2 = new int[][] {
                {2, 10},
                        {3, 10},
                                {4, 10},
                                        {2, 11},
                                                {3, 12},
                                                        {4, 11},
        };
        for (int i : new TwitterRecommendations().getRecommendedTweets(test, test2,1,3)){
            System.out.println(i);
        }
    }
}
