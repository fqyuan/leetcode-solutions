/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        List<Interval> res =  new ArrayList<>();
        intervals.sort((a, b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval e : intervals){
            if(e.start <= end) {
                if(e.end > end) end = e.end;
               
            } else {
                res.add(new Interval(start, end));
                start = e.start;
                end = e.end;
            }
        }
        res.add(new Interval(start,end));  // last remains!!
        return res;
    }
}
/*
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        	// sort start&end
	int n = intervals.size();
	int[] starts = new int[n];
	int[] ends = new int[n];
	for (int i = 0; i < n; i++) {
		starts[i] = intervals.get(i).start;
		ends[i] = intervals.get(i).end;
	}
	Arrays.sort(starts);
	Arrays.sort(ends);
	// loop through
	List<Interval> res = new ArrayList<Interval>();
	for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
		if (i == n - 1 || starts[i + 1] > ends[i]) {
			res.add(new Interval(starts[j], ends[i]));
			j = i + 1;
		}
	}
	return res;
    }
}*/