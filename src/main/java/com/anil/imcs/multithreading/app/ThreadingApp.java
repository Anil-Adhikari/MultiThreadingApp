package com.anil.imcs.multithreading.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.anil.imcs.multithreading.threads.ReadFileThread;

public class ThreadingApp {
	
	
	public static void main(String[] args) {
		List<String> fileNames = new ArrayList<String>();
		
		fileNames.add("src/main/resources/PropertyInfo1.csv");
		fileNames.add("src/main/resources/PropertyInfo2.csv");
		fileNames.add("src/main/resources/PropertyInfo3.csv");
		fileNames.add("src/main/resources/PropertyInfo4.csv");
		fileNames.add("src/main/resources/PropertyInfo5.csv");
		fileNames.add("src/main/resources/PropertyInfo6.csv");
		fileNames.add("src/main/resources/PropertyInfo7.csv");
		fileNames.add("src/main/resources/PropertyInfo8.csv");
		
		Long startTime = System.nanoTime();
		executeService(fileNames);
		Long endTime = System.nanoTime();
		System.out.println("Total time: " + (endTime - startTime));
	}
	
	private static void executeService(List<String> fileNames) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for(String name: fileNames) {
			executorService.execute(new ReadFileThread(name));
		}
		
		System.out.println("Completed scheduling the jobs..");

		executorService.shutdown();

	}
	
	
	
	
}
