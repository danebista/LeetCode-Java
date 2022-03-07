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
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here

        if (intervals == null || intervals.size()==0) return 0;

        Collections.sort(intervals, (a,b)->(a.start-b.start));
        
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b)->(a.end-b.end));
        minHeap.add(intervals.get(0));
        for (int i=1; i< intervals.size();i++){
            Interval current = intervals.get(i);
            Interval prev = minHeap.remove();
            if (current.start>=prev.end){
                prev.end=current.end;
            }
            else{
                minHeap.add(current);
            }
            minHeap.add(prev);
        }
        
        return minHeap.size();
    }
}
