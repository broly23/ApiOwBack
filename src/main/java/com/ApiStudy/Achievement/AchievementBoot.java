package com.ApiStudy.Achievement;

import java.util.List;

public class AchievementBoot {

	private Integer total;
	private String first;
	private String next;
	private String previous;
	private String last;
	private List<Achievement> data = null;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public List<Achievement> getData() {
		return data;
	}

	public void setData(List<Achievement> data) {
		this.data = data;
	}

}
