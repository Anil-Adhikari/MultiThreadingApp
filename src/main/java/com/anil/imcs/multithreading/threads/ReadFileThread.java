package com.anil.imcs.multithreading.threads;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.anil.imcs.multithreading.bean.PropertyInfo;
import com.anil.imcs.multithreading.service.FileDBService;
import com.anil.imcs.multithreading.service.FileReaderService;

public class ReadFileThread implements Runnable {

	private String fileName;

	private FileReaderService service = new FileReaderService();
	private FileDBService dbService = new FileDBService();

	public ReadFileThread(String fileName) {
		super();
		this.fileName = fileName;
	}
	
	public void run() {
		try {
			Long threadId = Thread.currentThread().getId();
			List<PropertyInfo> propertyList = service.readFileAndValidateInfo(fileName);
			for (PropertyInfo info : propertyList) {
				dbService.addIntoDB(info);				
				System.out.printf("\nProperty with id %d from file %s added successfully by Thread %d", info.getPropertyId(), fileName,threadId);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileReaderService getService() {
		return service;
	}

	public void setService(FileReaderService service) {
		this.service = service;
	}

}
