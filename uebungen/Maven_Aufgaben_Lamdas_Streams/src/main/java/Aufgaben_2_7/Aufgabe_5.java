package Aufgaben_2_7;

import java.io.File;
import java.io.FileFilter;

public class Aufgabe_5 {

	public static void main(String[] args) {

		final FileFilter directoryFilter = new FileFilter() {
			@Override
			public boolean accept(final File pathname) {
				return pathname.isDirectory();
			}
		};
		
		final FileFilter pdfFileFilter = new FileFilter() {
			@Override
			public boolean accept(final File pathname) {
				return (pathname.isFile() && pathname.getName().toLowerCase().endsWith(".pdf"));
			}
		};

	}

}
