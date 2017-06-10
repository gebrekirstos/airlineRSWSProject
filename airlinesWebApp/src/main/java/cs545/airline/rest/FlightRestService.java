package cs545.airline.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
@Path("flight")
public class FlightRestService {
	@Inject
	private FlightService flightService;
	
	
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
	
	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Flight update(Flight flight) {
		return flightService.update(flight);
	}

}
