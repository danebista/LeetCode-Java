/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for (int i=0; i<intervals.size(); i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i=0; i<starts.length-1; i++){
            if (starts[i+1] < ends[i]) return false;
        }

        return true;
    }
}
