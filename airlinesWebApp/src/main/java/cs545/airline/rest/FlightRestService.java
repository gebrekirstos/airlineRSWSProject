package cs545.airline.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

@Named
@ApplicationScoped 
public class FlightRestService implements Serializable {
	
	private String airlineQ;
	private String origin;
	private String destination;
	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAirlineQ() {
		return airlineQ;
	}

	public void setAirlineQ(String airlineQ) {
		this.airlineQ = airlineQ;
	}



	private static final long serialVersionUID = 1L;
	@Inject
	private FlightService flightService;
	@Inject
	private AirlineService airlineServic;	
	@Inject
	private AirportService airportService;
	
	private List<Flight> flightList = new ArrayList<Flight>();
	

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(ArrayList<Flight> flightList) {
		this.flightList = flightList;
	}
	 
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Flight update(Flight flight) {
		return flightService.update(flight);
	}
	
	@Path("find")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public Flight find(Flight flight) {
		return flightService.find(flight);
	}
	
	@Path("findBynumber")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public String findByNumber() {
		
     flightList =  flightService.findByNumber(airlineQ);	
		
		return  "flightList";
	}
    
	@Path("findByAirline")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public String findByAirline() {
		
		Airline airline = airlineServic.findByName(airlineQ);
		flightList =  flightService.findByAirline(airline);	
		
		return  "flightList";
	}
    
	@Path("findByOrigin")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public String findByOrigin() {
		
		Airport airport = airportService.findByCode(origin);
		flightList = flightService.findByOrigin(airport);
		return  "flightList";
	}
	
	@Path("findByDestination")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public String findByDestination() {
		Airport airport = airportService.findByCode(destination);
		flightList = flightService.findByDestination(airport);
		return  "flightList";
	}
    
	@Path("findByArrival")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public List<Flight> findByDateArrival(Date datetime) {
		return flightService.findByArrival(datetime);
	}	
	
	public String findAll() {
	  flightList =  flightService.findAll();
	  
	  return  "flight";
	}

}
