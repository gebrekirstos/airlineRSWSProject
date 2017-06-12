package cs545.airline.rest;

import java.io.Serializable;
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
public class AirlineRestService implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
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
	
	/*@POST
	public void create(Airline airport) {
		airlineService.create(airport);
	}*/
	
	@POST
	public String  createAirline() {
		Airline airline = new Airline();
		airline.setName(this.name);
		airlineService.create(airline);
		airlines = airlineService.findAll();
		return "airline";
	}
	
	@PUT
	public Airline update(Airline airline) {
		return airlineService.update(airline);
	}
	
	/*@PUT
	@Path("update")
	public void update(Airline airline) {
		airlineService.update(airline);
	}*/
	
	/*@GET
	@Path("namedel")
	public String delete(@QueryParam("name") String name, Airline airline) {
		airline = findByName(name);
		airlineService.delete(airline);
		return "succesful";
	}*/
	
	@Path("delete")	
	@DELETE
	public String  deleteAirline(String name) {
		
		try{
		Airline airline = airlineService.findByName(name);		
		airlineService.delete(airline);
		airlines = airlineService.findAll();		
	   }
		catch(Exception e){
			
				e.printStackTrace();
				}
		
		return "airline";
	}
	
	/*@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") long id, Airline airline) {
		airline.setId(id);
		airlineService.delete(airline);
	}*/
	
	//   airline/find?find="value"
	@GET
	@Path("find/{name}")
	public Airline find(@PathParam("name") String name) {
		Airline airline= airlineService.findByName(name);
		return airlineService.find(airline);
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
