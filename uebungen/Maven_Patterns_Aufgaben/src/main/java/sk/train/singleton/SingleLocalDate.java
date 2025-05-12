package sk.train.singleton;

import java.io.Serializable;
import java.time.LocalDate;

//lazy initialization, thread-safety is important, Serializable is dangerous
@SuppressWarnings("serial")
public class SingleLocalDate implements Serializable {
	
	private static SingleLocalDate singleDate;
	
	private LocalDate date ;

	private SingleLocalDate(LocalDate date) {
		super();
		this.date = date;
	}
	
	public synchronized static SingleLocalDate getInstance() {
		if (singleDate == null) {
			singleDate = new SingleLocalDate(LocalDate.of(2000, 1, 1));
		}
		return singleDate;
	}

	
	public LocalDate getDate() {
		return date;
	}

	//is syntatically ok, ?
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
