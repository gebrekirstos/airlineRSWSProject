package cs545.airline.rest;

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
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;

@Named
@ApplicationScoped
@Path("airline")
public class AirlineRestService {
	@Inject
	private AirlineService airlineService;
	private List<Airline> airlines;
	private boolean editable;
	
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}

	@GET
	public String helloAirline(@DefaultValue("Denver") @QueryParam("name") String name){
		return "Welcome to " + name + " Airline!";
	}
	
	@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Airline airport) {
		airlineService.create(airport);
	}
	
	@Path("delete")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(Airline airport) {
		airlineService.delete(airport);
	}
	
	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Airline update(Airline airport) {
		return airlineService.update(airport);
	}
	
	//   airline/find?find="value"
	@Path("find")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Airline find(@QueryParam("find") Airline find) {
		return airlineService.find(find);
	}
	
	@Path("name")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Airline findByName(@QueryParam("name") String name) {
		return airlineService.findByName(name);
	}
	
	/*@Path("flight")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airline> findByFlight(@QueryParam("flight") Flight flight) {
		return airlineService.findByFlight(flight);
	}*/
	
	@Path("listall")
	@GET
	public String findAll() {
		airlines =  airlineService.findAll();
		return "airline";
	}
	
}
