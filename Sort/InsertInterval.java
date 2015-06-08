public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		int i = 0;
		List<Interval> res = new ArrayList<>();
		
		while (i<intervals.size() && intervals.get(i).end < newInterval.start)
			res.add(intervals.get(i++));

		if (i < intervals.size())
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);

		res.add(newInterval);
		while (i<intervals.size() && intervals.get(i).start <= newInterval.end)
			newInterval.end = Math.max(newInterval.end, intervals.get(i++).end);

		while (i<intervals.size())
			res.add(intervals.get(i++));
		
		return res;
	}


}