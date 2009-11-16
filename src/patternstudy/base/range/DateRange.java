package patternstudy.base.range;

import patternstudy.temporal.timepoint.DateTime;

public class DateRange {
	private DateTime start;
	private DateTime end;

	public static DateRange EMPTY = new DateRange(DateTime.on(2000, 4, 1), DateTime.on(2000, 1, 1));

	public static DateRange upTo(DateTime end) {
		return new DateRange(DateTime.PAST, end);
	}
	
	public static DateRange startingOn(DateTime start) {
		return new DateRange(start, DateTime.FUTURE);
	}
	
	public DateRange(DateTime start, DateTime end) {
		this.start = start;
		this.end = end;
	}
	
	public DateTime start() {
		return start;
	}
	
	public DateTime end() {
		return end;
	}
	
	public String toString() {
		if (isEmpty()) return "Empty Date Range";
		return start.toString() + "-" + end.toString();
	}
	
	public boolean isEmpty() {
		return start.isAfter(end);
	}
	
	public boolean includes(DateTime arg) {
		return !arg.isBefore(start) && !arg.isAfter(end);
	}
	
	public boolean equals(Object arg) {
		if (!(arg instanceof DateRange)) return false;
		DateRange other = (DateRange)arg;
		return start.equals(other.start) && end.equals(other.end);
	}
	
	public int hashCode() {
		return start.hashCode();
	}
}