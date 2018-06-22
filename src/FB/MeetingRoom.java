package FB;
import java.util.*;
/**
 * Created by mingyama on 10/22/17.
 */
public class MeetingRoom {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return false;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        int end = -1;
        for (Interval interval : intervals) {
            if (interval.start < end) return false;
            end = interval.end;
        }
        return true;
    }

    public int minMeetingRoomsII(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });

        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval early = heap.poll();
            if (intervals[i].start >= early.end) {
                early.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(early);
        }
        return heap.size();
    }

    public int minMeetingRoomsIIFaster(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int startPointer = 0, endPointer = 0, numOfRooms = 0;
        for (startPointer = 0; startPointer < intervals.length; startPointer++) {
            if (starts[startPointer] < ends[endPointer]) {
                numOfRooms++;
            } else {
                endPointer++;
            }
        }
        return numOfRooms;
    }

    private List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) return intervals;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start < newInterval.start) {
                //
                if (current.end < newInterval.start) {
                    // cant merge into left interval

                }
            }
        }

        return intervals;
    }
}
