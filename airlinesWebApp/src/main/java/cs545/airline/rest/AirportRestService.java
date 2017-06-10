package cs545.airline.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;

@Named
@Path("airport")
public class AirportRestService {
	@Inject
	private AirportService airportService;
	
	@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Airport airport) {
		airportService.create(airport);
	}
	@Path("delete")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(Airport airport) {
		airportService.delete(airport);
	}
	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Airport update(Airport airport) {
		return airportService.update(airport);
	}
	
	/*@Path("find")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Airport find(@QueryParam("find") Airport find) {
		return airportService.find(find);
	}*/
	
	@Path("code")
	@GET
	public Airport findByCode(@QueryParam("code") String airportcode) {
		return airportService.findByCode(airportcode);
	}
	
	/*@Path("arrival")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airport> findByArrival(@QueryParam("arrival") Flight flight) {
		return airportService.findByArrival(flight);
	}*/
	/*@Path("departure")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airport> findByDeparture(@QueryParam("departure") Flight flight) {
		return airportService.findByDeparture(flight);
	}*/
	
	@Path("city")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airport> findByCity(@QueryParam("city") String city) {
		return airportService.findByCity(city);
	}
	@Path("country")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airport> findByCountry(@QueryParam("country") String country) {
		return airportService.findByCountry(country);
	}
	
	@Path("name")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airport> findByName(@QueryParam("name") String name) {
		return airportService.findByName(name);
	}
	@Path("listall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airport> findAll() {
		return airportService.findAll();
	}
}
