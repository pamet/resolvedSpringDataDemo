package demo.model;

import demo.domain.Person;

public class GridResponse {

	private Iterable<Person> currentPage;
	private long totalRows;
	
	public Iterable<Person> getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Iterable<Person> currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

}
