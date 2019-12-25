package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplianceReader implements Closeable {

	private FileReader applianceReader;

	public ApplianceReader(String fileName) throws FileNotFoundException {
		applianceReader = new FileReader(fileName);
	}

	public List<String> read(String applianceType) throws IOException {
		if (applianceType == null) {
			return readAll();
		} else {
			return readWithType(applianceType);
		}
	}

	private List<String> readAll() throws IOException {
		List<String> appliances = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(applianceReader);
		String appliance = reader.readLine();
		while (appliance != null) {
			appliances.add(appliance);
			appliance = reader.readLine();
		}
		return appliances;
	}

	private List<String> readWithType(String applianceType) throws IOException {
		List<String> appliances = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(applianceReader);
		String appliance = reader.readLine();
		while (appliance != null) {
			if (appliance.contains(applianceType)) {
				appliances.add(appliance);
			}
			appliance = reader.readLine();
		}
		return appliances;
	}

	@Override
	public void close() throws IOException {
		applianceReader.close();
	}

}
