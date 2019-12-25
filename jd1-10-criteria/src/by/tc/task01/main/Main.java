package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import java.util.List;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ApplianceServiceException;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 32);

		try {
			appliance = service.find(criteriaOven);
			PrintApplianceInfo.print(appliance);
			System.out.println("-----------------------------------------------------------------------------------");
		} catch (ApplianceServiceException e) {
			System.out.println(e.getMessage());
		}

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 45);
		criteriaOven.add(Oven.DEPTH.toString(), 60);

		try {
			appliance = service.find(criteriaOven);
			PrintApplianceInfo.print(appliance);
			System.out.println("-----------------------------------------------------------------------------------");
		} catch (ApplianceServiceException e) {
			System.out.println(e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);

		try {
			appliance = service.find(criteriaTabletPC);
			PrintApplianceInfo.print(appliance);
		} catch (ApplianceServiceException e) {
			System.out.println(e.getMessage());
		}
	}

}
