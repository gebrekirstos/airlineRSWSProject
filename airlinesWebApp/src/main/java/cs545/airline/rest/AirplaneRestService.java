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

import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;
import cs545.airline.service.AirplaneService;

@Named
@ApplicationScoped
@Path("airplane")
public class AirplaneRestService {
	@Inject
	private AirplaneService airplaneService;
	
	private List<Airplane> airplanes;
	
	
	
	public List<Airplane> getAirplanes() {
		return airplanes;
	}

	public void setAirplanes(List<Airplane> airplanes) {
		this.airplanes = airplanes;
	}

	@GET
	public String helloAirplane(@DefaultValue("Airplane") @QueryParam("name") String name){
		return "Welcome to " + name+ " Airplane";
	}

	@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Airplane airplane) {
		airplaneService.create(airplane);
	}
	
	@Path("delete")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(Airplane airplane) {
		airplaneService.delete(airplane);
	}
	
	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Airplane update(Airplane airplane) {
		return airplaneService.update(airplane);
	}

	/*@Path("find")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Airplane find(@QueryParam("find") Airplane find) {
		return airplaneService.find(find);
	}*/
	
	@Path("serial")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Airplane findBySrlnr(@QueryParam("serial") String serialno) {
		return airplaneService.findBySrlnr(serialno);
	}
	
	/*@Path("flight")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airplane> findByFlight(@QueryParam("flight") Flight flight) {
		return airplaneService.findByFlight(flight);
	}*/
	
	@Path("model")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airplane> findByModel(@QueryParam("model") String model) {
		return airplaneService.findByModel(model);
	}
	
	@Path("listall")
	@GET
	public String findAll() {
		airplanes = airplaneService.findAll();
		return "airplane";
	}


}
