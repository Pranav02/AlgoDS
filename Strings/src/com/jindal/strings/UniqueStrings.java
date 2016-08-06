package com.jindal.strings;
import java.util.HashSet;
import java.util.Iterator;

public class UniqueStrings {

	public static void main(String[] args) {

		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("877410996");
		hashSet.add("84d6caa7f");
		hashSet.add("1f8cd2f6f");
		hashSet.add("83d6a934f");
		hashSet.add("ea0ba1519");
		hashSet.add("84d6caa7f");
		hashSet.add("1f8cd2f6f");

		hashSet.add("83d6a934f");
		hashSet.add("ea0ba1519");
		hashSet.add("84d6caa7f");
		hashSet.add("1f8cd2f6f");

		hashSet.add("cf6039fe0");

		Iterator<String> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
