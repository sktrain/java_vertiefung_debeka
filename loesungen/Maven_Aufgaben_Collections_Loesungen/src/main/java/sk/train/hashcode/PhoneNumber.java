package sk.train.hashcode;

//Shows the need for overriding hashcode when you override equals
//nach "Effective Java Programming", Joshua Bloch

import java.util.*;

public final class PhoneNumber {
 private final short areaCode;
 private final short prefix;
 private final short lineNumber;

 public PhoneNumber(int areaCode, int prefix,
                    int lineNumber) {
     rangeCheck(areaCode,    999, "area code");
     rangeCheck(prefix,      999, "prefix");
     rangeCheck(lineNumber, 9999, "line number");
     this.areaCode  = (short) areaCode;
     this.prefix  = (short) prefix;
     this.lineNumber = (short) lineNumber;
 }

 private static void rangeCheck(int arg, int max,
                                String name) {
     if (arg < 0 || arg > max)
        throw new IllegalArgumentException(name +": " + arg);
 }

 @Override public boolean equals(Object o) {
     if (o == this)
         return true;
     if (!(o instanceof PhoneNumber))
         return false;
     PhoneNumber pn = (PhoneNumber)o;
     return pn.lineNumber == lineNumber
         && pn.prefix  == prefix
         && pn.areaCode  == areaCode;
 }

 
//@Override public int hashCode() {
//   int result = 17;
//   result = 31 * result + areaCode;
//   result = 31 * result + prefix;
//   result = 31 * result + lineNumber;
//   return result;
//}
 
 //Generierung durch Eclipse

//@Override
//public int hashCode() {
//	final int prime = 31;
//	int result = 1;
//	result = prime * result + areaCode;
//	result = prime * result + lineNumber;
//	result = prime * result + prefix;
//	return result;
//}
//
//@Override
//public boolean equals(Object obj) {
//	if (this == obj)
//		return true;
//	if (obj == null)
//		return false;
//	if (getClass() != obj.getClass())
//		return false;
//	PhoneNumber other = (PhoneNumber) obj;
//	if (areaCode != other.areaCode)
//		return false;
//	if (lineNumber != other.lineNumber)
//		return false;
//	if (prefix != other.prefix)
//		return false;
//	return true;
//}




public static void main(String[] args) {
    Map<PhoneNumber, String> m
        = new HashMap<PhoneNumber, String>();
    m.put(new PhoneNumber(707, 867, 5309), "Jenny");
    System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
}
}
