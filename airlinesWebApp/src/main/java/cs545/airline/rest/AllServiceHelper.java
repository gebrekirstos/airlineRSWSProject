package cs545.airline.rest;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import cs545.airline.model.Airline;

@Named
@ApplicationScoped
public class AllServiceHelper implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	AirlineRestService airlineService;
	
	public void changeEditStatus(Airline airline) {
		if(airline.isEditable())
			airlineService.update(airline);
		airline.setEditable(!airline.isEditable());
	}
	

}
