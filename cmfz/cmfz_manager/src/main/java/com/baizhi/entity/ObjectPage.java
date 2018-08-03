package com.baizhi.entity;

import java.util.List;

public class ObjectPage<T> {
	private List<T> rows;
	private Integer total;
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public ObjectPage() {
		super();
	}
	public ObjectPage(List<T> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	@Override
	public String toString() {
		return "ObjectPage [rows=" + rows + ", total=" + total + "]";
	}
	
	
}
