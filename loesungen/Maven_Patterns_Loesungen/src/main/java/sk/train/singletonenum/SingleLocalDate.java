package sk.train.singletonenum;

import java.time.LocalDate;

public enum SingleLocalDate {
	
	S(LocalDate.of(2000, 1, 1));
	//S(2000, 1, 1);
	
	private LocalDate l;
	
//	private SingleLocalDate(int y, int m, int d) {
//		this.l = LocalDate.of(y, m, d);
//	}

	private SingleLocalDate(LocalDate d) {
		l = d;
	}
	
	public LocalDate getL() {
		return l;
	}
	
	public void setL(LocalDate l) {
		this.l = l;
	}


//	private LocalDate secondDate ;//	
//	
//	public void setSecondDate(int y) {
//		secondDate = this.l.minusYears(y);
//	}
	
}
