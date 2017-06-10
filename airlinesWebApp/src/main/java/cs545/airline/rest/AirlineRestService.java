package cs545.airline.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;

@Named
@Path("airline")
public class AirlineRestService {
	@Inject
	private AirlineService airlineService;
	
	@GET
	public String helloAirline(@DefaultValue("Denver") @QueryParam("name") String name){
		return "Welcome to " + name + " Airline!";
	}
	
	@Path("name")
	@GET
	public String getAirlineByName(){
		String tempAirline="Den";
		Airline airline = airlineService.findByName("oneworld");
		if(airline !=null){
			tempAirline = "This Airline name ie: " + airline.getName();
		}
		return tempAirline;
	}
	
	@Path("findairline")
	@GET
	public Airline getAirline(Airline airline){
		return airlineService.find(airline);
	}
	
	@Path("findairlinebyflight")
	@GET
	public List<Airline> getAllAirlineByFlight(Flight flight){
		return airlineService.findByFlight(flight);
	}
	
	@Path("listofairlines")
	@GET
	public List<Airline> getAllAirlines(){
		return airlineService.findAll();
	}
	
	@Path("createairline")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createAirline(Airline airline){
		airlineService.create(airline);
	}
	
	@Path("updateairline")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Airline updateAirline(Airline airline){
		return airlineService.update(airline);
	}
	
	@Path("deleteairline")
	@DELETE
	public void deleteAirline(Airline airline){
		airlineService.delete(airline);
	}
	
	
}
