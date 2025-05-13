package Aufgaben_2_7;

import java.io.File;
import java.io.FileFilter;

public class Aufgabe_5_loes {

	public static void main(String[] args) {
		
		final FileFilter directoryFilter = File::isDirectory;
		
		System.out.println(directoryFilter.accept(
				new File("C:\\Users\\Public\\eclipse_workspaces\\integrata_java8\\Aufgaben_Loes")));
		//FileFilter directoryFilter = pathname -> pathname.isDirectory();
				
		/*new FileFilter() {
			@Override
			public boolean accept(final File pathname) {
				return pathname.isDirectory();
			}
		};*/
		
		final FileFilter pdfFileFilter = pathname -> 
								pathname.isFile() && pathname.getName().toLowerCase().endsWith(".pdf");
		
		/*
		 * final FileFilter pdfFileFilter = new FileFilter() {
		 * 
		 * @Override public boolean accept(final File pathname) { return
		 * (pathname.isFile() && pathname.getName().toLowerCase().endsWith(".pdf")); }
		 * };
		 */
	}

}
