package BackTracking;
import java.util.*;

class BeautifulArragement {
    public int countArrangement_slow(int N) {
        Set<List<Integer>> res = new HashSet<>();
        backtrack_slow(N, new LinkedList<Integer>(), res);
        return res.size();
    }

    private void backtrack_slow(int N, List<Integer> current, Set<List<Integer>> res) {
        if (current.size() == N) {
            if (valid(current, N) && !res.contains(current)) {
                res.add(new ArrayList<>(current));
                for (int i : current) {
					System.out.printf("%d,", i);
				}
				System.out.println("");
			}
            return;
        }   

        for (int i = 1; i <= N; i++) {
            if (current.contains(i)) continue;
            current.add(i);
            backtrack_slow(N, current, res);
            current.remove(current.size()-1);
        }


    }

    private boolean valid(List<Integer> current, int N) {
        for (int i = 1; i <= N; i++) {
            if (i % current.get(i-1) == 0 || current.get(i-1) % i == 0) continue;
            else {
                return false;
            }
        }

        return true;
    }

	public int countArrangement(int N) {
    	// use a int[] to mark which number is already used
		int[] count = new int[1];
		backtrack(N, 0, new int[N], count);
		return count[0];
	}

	private void backtrack(int N, int cur, int[] used, int[] resCount) {
    	if (cur > N) {
    		resCount[0]++;
    		return;
		}
        for (int i = 1; i <= N; i++) {
    	    if (used[i-1] == 0 && (i % cur == 0 || cur % i == 0)) {
    	        used[i-1] = 1;
    	        backtrack(N, cur+1, used, resCount);
    	        used[i-1] = 0;
            }
        }

	}


    public static void main(String[] args) {
		System.out.println(new BeautifulArragement().countArrangement(4));
	}
}