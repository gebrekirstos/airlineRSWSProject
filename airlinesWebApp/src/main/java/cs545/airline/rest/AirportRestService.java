package cs545.airline.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;

@Named
@Path("airport")
public class AirportRestService {
	@Inject
	private AirportService airportService;
	
	@GET
	public String helloAirport(@DefaultValue("Airport") @QueryParam("name") String name){
		return "Welcome to "+ name +" Airport";
	}
	
	@GET
	@Path("code")
	public Airport getByCode(){
		Airport airport = airportService.findByCode("ORD");
		return airport;
	}
}
