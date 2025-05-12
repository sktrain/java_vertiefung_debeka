package sk.train.singleton;

import java.time.LocalDate;

//eager initialization, thread-safety is not important (Classloader is usually single-threaded)
public class SingleLocalDateEager {
	
	private static SingleLocalDateEager singleDate = new SingleLocalDateEager(LocalDate.of(2000, 1, 1));
	
	private LocalDate date ;

	private SingleLocalDateEager(LocalDate date) {
		super();
		this.date = date;
	}
	
	public static SingleLocalDateEager getInstance() {
		return singleDate;
	}
	
	public LocalDate getDate() {
		return date;
	}

	//syntactically ok, but semantically?
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
