package cs545.airline.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@Named
@Path("flight")
public class FlightRestService {
	@Inject
	private FlightService flightService;
	
	@GET
	public String helloFlight(@DefaultValue("Flight") @QueryParam("name") String name){
		return "welcome to " + name + "Flight!";
	}
	
	@Path("number")
	@GET
	public List<Flight> getAllFlightsByNumber(){
		List<Flight> flights = new ArrayList<Flight>();
		flights = flightService.findByNumber("NW 36");
		return flights;
	}

}
