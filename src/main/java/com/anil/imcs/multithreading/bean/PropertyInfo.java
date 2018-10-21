package com.anil.imcs.multithreading.bean;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class PropertyInfo {
	private Integer propertyId;
	private String propertyName;
	private String propertyAddress;
	private Double taxAmount;
	private LocalDate filingDate;
}
