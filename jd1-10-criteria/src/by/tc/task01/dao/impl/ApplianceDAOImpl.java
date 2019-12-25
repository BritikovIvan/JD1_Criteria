package by.tc.task01.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public class ApplianceDAOImpl implements ApplianceDAO{

	private static final String FILE = "resources\\appliances.txt";
	
	@Override
	public List<Appliance> find(Criteria criteria) throws ApplianceDAOException {
		List<Appliance> appliances;
		try {
			ApplianceReader reader = new ApplianceReader(FILE);
			ApplianceMatcher matcher = new ApplianceMatcher();
			AppliancesFactory factory = new AppliancesFactory();
			
			List<String> strAppliancesData;
			strAppliancesData = reader.read(criteria.getGroupSearchName());
			strAppliancesData = matcher.match(strAppliancesData, criteria);
			
			appliances = factory.create(strAppliancesData);
			
			reader.close();
		} catch (Exception e) {
			throw new ApplianceDAOException(e);
		}
		return appliances;
	}

}