package com.ApiStudy.Hero;

import java.util.List;

public class HeroBoot {

	private Integer total;
	private String first;
	private Object next;
	private Object previous;
	private String last;
	private List<HeroBean> data = null;

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

	public Object getNext() {
		return next;
	}

	public void setNext(Object next) {
		this.next = next;
	}

	public Object getPrevious() {
		return previous;
	}

	public void setPrevious(Object previous) {
		this.previous = previous;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public List<HeroBean> getData() {
		return data;
	}

	public void setData(List<HeroBean> data) {
		this.data = data;
	}

}
