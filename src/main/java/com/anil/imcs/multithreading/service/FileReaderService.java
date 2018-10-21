package com.anil.imcs.multithreading.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.anil.imcs.multithreading.bean.PropertyInfo;

public class FileReaderService {

	public List<PropertyInfo> readFileAndValidateInfo(String fileName) throws IOException {
		File file = new File(fileName);
		
		List<PropertyInfo> infoList = new ArrayList<PropertyInfo>();
		
		String line = null;
		
		BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
		while((line = bufferedreader.readLine()) != null) {
			String[] lineArr = line.split(",");
			PropertyInfo info = parse(lineArr);
			infoList.add(info);
		}
		
		List<PropertyInfo> validPropertyList = validatePropertyList(infoList);
		
		return validPropertyList;
	}

	private List<PropertyInfo> validatePropertyList(List<PropertyInfo> infoList) {
		List<PropertyInfo> valid = new ArrayList<PropertyInfo>();
		for(PropertyInfo info : infoList) {
			if(info.getTaxAmount() > 500) {
				valid.add(info);
			}
		}
		return valid;
	}

	private PropertyInfo parse(String[] lineArr) {
		PropertyInfo info = new PropertyInfo();
		
		info.setPropertyId(Integer.parseInt(lineArr[0]));
		info.setPropertyName(lineArr[1]);
		info.setPropertyAddress(lineArr[2]);
		info.setTaxAmount(Double.parseDouble(lineArr[3]));
		info.setFilingDate(LocalDate.parse(lineArr[4]));
		
		return info;
	}

}
