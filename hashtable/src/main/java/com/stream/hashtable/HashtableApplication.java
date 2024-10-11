package com.stream.hashtable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class HashtableApplication {

	public static void main(String[] args) {
		SpringApplication.run(HashtableApplication.class, args);


		Map<Integer, String> hashtable = new Hashtable<>();
		hashtable.put(10, "Oracle");
		hashtable.put(11, "Microsoft");
		hashtable.put(12, "Google");


		System.out.println("hashtable.get(10) " + hashtable.get(10));
		System.out.println("hashtable.containsKey(10) " + hashtable.containsKey(10));
		System.out.println("hashtable.containsValue(\"Google\") "+ hashtable.containsValue("Google"));
		System.out.println("hashtable.entrySet() "+ hashtable.entrySet());
		System.out.println("hashtable.keySet() "+ hashtable.keySet());
		System.out.println("hashtable.values() "+ hashtable.values());

		hashtable.clear();// remove all element from hashtable

		System.out.println("hashtable.size() "+ hashtable.size());



		// Hashtable - Iterate on keys by obtaining keySet, Iterate on values by obtaining values, Iterate on entry by obtaining entrySet.

		hashtable.put(10, "Oracle");
		hashtable.put(11, "Microsoft");
		hashtable.put(12, "Google");

		Set<Map.Entry<Integer, String> > entry = hashtable.entrySet();
		for(Map.Entry<Integer, String> e: entry){
			System.out.println(e.getKey() + "  "+e.getValue());
		}
		Iterator<Map.Entry<Integer, String>> entryIterator=hashtable.entrySet().iterator();
		while(entryIterator.hasNext()){
			System.out.println(entryIterator.next());
		}



		Iterator<Integer> keyIterator = hashtable.keySet().iterator();
		while(keyIterator.hasNext()){
			System.out.println(keyIterator.next());
		}
		Set<Integer> keySet=hashtable.keySet();

		for(Integer key :keySet){
			System.out.println(key);
		}



		Iterator<String> valueIterator=hashtable.values().iterator();
		while(valueIterator.hasNext()){
			System.out.println(valueIterator.next());
		}
		Collection<String> collection = hashtable.values();
		for(String value :collection){
			System.out.println(value);
		}


		// Hashtable - Iterator on keySet, values and entrySet is fail-fast in java
		// Hashtable - Iterator on keySet, values and  entrySet is  fail-safe or fail-fast?

		// The iterators returned by the iterator() method of the collections returned by all three Map's “collection view methods" are fail-fast.
		// Means any structural modification made to Hashtable like adding or removing elements during Iteration will throw java.util.ConcurrentModificationException.

		hashtable.clear();

		hashtable.put(10, "Oracle");
		hashtable.put(11, "Microsoft");
		hashtable.put(12, "Google");


		//fail-fast
		// add a new entry
		Iterator<Integer> keyIteratorr=hashtable.keySet().iterator();
		while(keyIteratorr.hasNext()){
			//hashtable.put(1,"newEle1");//unComment to see ConcurrentModificationException
			System.out.println(keyIteratorr.next());
		}



		//fail-fast
		// remove a entry
		Iterator<String> valueIteratorr=hashtable.values().iterator();
		while(valueIteratorr.hasNext()){
			//hashtable.remove(1,"newEle1");//unComment to see ConcurrentModificationException
			System.out.println(valueIteratorr.next());
		}


		//fail-fast
		// update a entry
		Iterator<Map.Entry<Integer, String>> entryIteratorr=hashtable.entrySet().iterator();
		while(entryIteratorr.hasNext()){
			//hashtable.put(1,"newEle2");//unComment to see ConcurrentModificationException
			System.out.println(entryIteratorr.next());
		}



		// Hashtable - making map unmodifiable using Collections.unmodifiableMap in java

		hashtable.clear();

		hashtable.put(10, "Oracle");
		hashtable.put(11, "Microsoft");
		hashtable.put(12, "Google");
		//getting unmodifiable Hashtable
		Map<Integer,String> unmodifiableMap = Collections.unmodifiableMap(hashtable);


		/*
		 * Now any attempt to modify map will throw java.lang.UnsupportedOperationException
		 */
		// unmodifiableMap.put(41,"java");// unComment to see java.lang.UnsupportedOperationException



	}

}
