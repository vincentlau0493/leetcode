public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {

		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) return res;

		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval t1, Interval t2) {
				if (t1.start == t2.start)
					return t1.end - t2.end;
				return t1.start - t2.start;
			}
		});

		// int i = 0;
		// while (i < intervals.size()) {
		// 	int start = intervals.get(i).start;
		// 	int end = intervals.get(i).end;
		// 	while (i < intervals.size()-1 && end >= intervals.get(i+1).start) {
		// 		i++;
		// 		end = Math.max(end, intervals.get(i).end);
		// 	}
		// 	res.add(new Interval(start, end));
		// 	i++;
		// }

		res.add(intervals.get(0));

		for (int i=1; i<intervals.size(); i++) {
			Interval last = res.get(res.size()-1);
			if (last.end >= intervals.get(i).start) {
				last.end = Math.max(last.end, intervals.get(i).end);
			} else {
				res.add(intervals.get(i));
			}

		}



		return res;
	}



}