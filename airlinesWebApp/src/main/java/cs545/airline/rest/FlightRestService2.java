package cs545.airline.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@Named
@ApplicationScoped
@Path("flight")
public class FlightRestService2 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private FlightService flightService;
	
	private List<Flight> flights;
	
	private String airlineQ;
	private String origin;
	private String destination;
	
	
	/*@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Flight flight) {
		flightService.create(flight);
	}

	@Path("delete")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(Flight flight) {
		flightService.delete(flight);
	}*/
	
	public String getAirlineQ() {
		return airlineQ;
	}

	public void setAirlineQ(String airlineQ) {
		this.airlineQ = airlineQ;
	}

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

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Flight update(Flight flight) {
		return flightService.update(flight);
	}
	
	@Path("listall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String findAll() {		
		flights = flightService.findAll();
		return "flight";
	}

}
