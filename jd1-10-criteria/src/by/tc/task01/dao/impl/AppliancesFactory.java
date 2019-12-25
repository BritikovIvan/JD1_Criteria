package by.tc.task01.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;

public class AppliancesFactory {
	
	private static final String OVEN = "Oven";
	private static final String LAPTOP = "Laptop";
	private static final String REFRIGERATOR = "Refrigerator";
	private static final String SPEAKERS = "Speakers";
	private static final String TABLETPC = "TabletPC";
	private static final String VACUUM_CLEANER = "VacuumCleaner";

	public List<Appliance> create(List<String> strAppliancesData) {
		List<Appliance> results = new ArrayList<Appliance>();

		for (String data : strAppliancesData) {
			results.add(create(data));
		}
		return results;
	}

	public Appliance create(String data) {
		String regex = ":";
		String[] applianceData = data.split(regex);
		String appliance = applianceData[0];

		regex = ",";
		List<String> values = values(applianceData[1].trim().split(regex));

		switch (appliance) {
		case OVEN:
			return createOven(values);
		case LAPTOP:
			return createLaptop(values);
		case REFRIGERATOR:
			return createRefrigerator(values);
		case VACUUM_CLEANER:
			return createVacuumCleaner(values);
		case TABLETPC:
			return createTabletPC(values);
		case SPEAKERS:
			return createSpeakers(values);
		}

		return null;
	}

	private Appliance createOven(List<String> values) {
		int powerConsumption = Integer.parseInt(values.get(0));
		double weight = Double.parseDouble(values.get(1));
		int capacity = Integer.parseInt(values.get(2));
		double depth = Double.parseDouble(values.get(3));
		double hight = Double.parseDouble(values.get(4));
		double width = Double.parseDouble(values.get(5));
		return new Oven(powerConsumption, weight, capacity, depth, hight, width);
	}

	private Appliance createLaptop(List<String> values) {
		double batteryCapacity = Double.parseDouble(values.get(0));
		String os = values.get(1);
		int memoryRom = Integer.parseInt(values.get(2));
		int systemMemory = Integer.parseInt(values.get(3));
		double cpu = Double.parseDouble(values.get(4));
		int displayInchs = Integer.parseInt(values.get(5));
		return new Laptop(batteryCapacity, os, memoryRom, systemMemory, cpu, displayInchs);
	}

	private Appliance createRefrigerator(List<String> values) {
		int powerConsumption = Integer.parseInt(values.get(0));
		double weight = Double.parseDouble(values.get(1));
		int freezerCapacity = Integer.parseInt(values.get(2));
		double overallCapacity = Double.parseDouble(values.get(3));
		double height = Double.parseDouble(values.get(4));
		double width = Double.parseDouble(values.get(5));
		return new Refrigerator(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
	}
	
	private Appliance createVacuumCleaner(List<String> values) {
		int powerConsumption = Integer.parseInt(values.get(0));
		char filterType = values.get(1).charAt(0);
		String bagType = values.get(2);
		String wandType = values.get(3);
		int motorSpeedRegulation = Integer.parseInt(values.get(4));
		int cleaningWidth = Integer.parseInt(values.get(5));
		return new VacuumCleaner(powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth);
	}

	private Appliance createTabletPC(List<String> values) {
		int batteryCapacity = Integer.parseInt(values.get(0));
		int displayInches = Integer.parseInt(values.get(1));
		int memoryRom = Integer.parseInt(values.get(2));
		int flashMemoryCapacity = Integer.parseInt(values.get(3));
		String color = values.get(4);
		return new TabletPC(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
	}
	
	private Appliance createSpeakers(List<String> values) {
		int powerConsumption = Integer.parseInt(values.get(0));
		int numberOfSpeakers = Integer.parseInt(values.get(1));
		String frequencyRange = values.get(2);
		int cordLength = Integer.parseInt(values.get(3));
		return new Speakers(powerConsumption, numberOfSpeakers, frequencyRange, cordLength);
	}
	
	private List<String> values(String[] data) {
		List<String> values = new ArrayList<String>();
		char divider = '=';

		for (String criteria : data) {
			int index = criteria.indexOf(divider);
			values.add(criteria.substring(index + 1));
		}

		return values;
	}

}
