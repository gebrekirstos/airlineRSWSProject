package cs545.airline.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;

@Named
@Path("airplane")
public class AirplaneRestService {
	@Inject
	private AirplaneService airplaneService;
	
	@GET
	public String helloAirplane(@DefaultValue("Airplane") @QueryParam("name") String name){
		return "Welcome to " + name+ " Airplane";
	}
	
	@Path("serial")
	@GET
	public Airplane getBySerialNumber(){
		Airplane airplane = airplaneService.findBySrlnr("12345");
		return airplane;
	}

}
