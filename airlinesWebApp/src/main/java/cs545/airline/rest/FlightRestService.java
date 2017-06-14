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
	private static final long serialVersionUID = 1L;
	private String airlineQ;
	private String origin;
	private String destination;
	@Inject
	private FlightService flightService;
	@Inject
	private AirlineService airlineServic;	
	@Inject
	private AirportService airportService;
	
	private List<Flight> flightList = new ArrayList<Flight>();
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


	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(ArrayList<Flight> flightList) {
		this.flightList = flightList;
	}
	 
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Flight update(Flight flight) {
		return flightService.update(flight);
	}
	
	@GET
	@Path("find")
	@Consumes(MediaType.APPLICATION_JSON)
	public Flight find(Flight flight) {
		return flightService.find(flight);
	}
	
	@GET
	@Path("findBynumber")
	@Consumes(MediaType.APPLICATION_JSON)
	public String findByNumber() {
     flightList =  flightService.findByNumber(airlineQ);	
		return  "flightList";
	}
    
	@GET
	@Path("findByAirline")
	@Consumes(MediaType.APPLICATION_JSON)
	public String findByAirline() {
		
		Airline airline = airlineServic.findByName(airlineQ);
		flightList =  flightService.findByAirline(airline);	
		return  "flightList";
	}
    
	@GET
	@Path("findByOrigin")
	@Consumes(MediaType.APPLICATION_JSON)
	public String findByOrigin() {
		Airport airport = airportService.findByCode(origin);
		flightList = flightService.findByOrigin(airport);
		return  "flightList";
	}
	
	@GET
	@Path("findByDestination")
	@Consumes(MediaType.APPLICATION_JSON)
	public String findByDestination() {
		Airport airport = airportService.findByCode(destination);
		flightList = flightService.findByDestination(airport);
		return  "flightList";
	}
    
	@GET
	@Path("findByArrival")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Flight> findByDateArrival(Date datetime) {
		return flightService.findByArrival(datetime);
	}	
	
	@GET
	public String findAll() {
	  flightList =  flightService.findAll();
	  return  "flight";
	}

}
