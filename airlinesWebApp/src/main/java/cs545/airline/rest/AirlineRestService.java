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
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AirlineRestService {
	
	@Inject
	private AirlineService airlineService;
	private List<Airline> airlines;
	
	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}

	@GET
	public String findAll() {
		airlines =  airlineService.findAll();
		return "airline";
	}
	
	@POST
	public void create(Airline airport) {
		airlineService.create(airport);
	}
	
	@PUT
	@Path("/{id}")
	public Airline update(@PathParam("id") long id, Airline airline) {
		airline.setId(id);
		return airlineService.update(airline);
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") long id, Airline airline) {
		airline.setId(id);
		airlineService.delete(airline);
	}
	
	//   airline/find?find="value"
	@GET
	@Path("find")
	public Airline find(@QueryParam("find") Airline find) {
		return airlineService.find(find);
	}
	
	@GET
	@Path("/{name}")
	public Airline findByName(@PathParam("name") String name) {
		return airlineService.findByName(name);
	}
	
	/*@Path("flight")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airline> findByFlight(@QueryParam("flight") Flight flight) {
		return airlineService.findByFlight(flight);
	}*/
	
}
