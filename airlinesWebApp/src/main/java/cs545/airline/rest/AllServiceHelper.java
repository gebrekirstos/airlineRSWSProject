package cs545.airline.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.model.SearchFlight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

@Named
@ApplicationScoped
/*@ViewScoped*/
public class AllServiceHelper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	AirlineRestService airlineRestService;

	@Inject
	private FlightService flightService;
	@Inject
	private AirlineService airlineService;
	@Inject
	private AirportService airportService;

	private SearchFlight flightQuery;

	// date-time, airline, departure, and destination

	public SearchFlight getFlightQuery() {
		return flightQuery;
	}

	public void setFlightQuery(SearchFlight flightQuery) {
		this.flightQuery = flightQuery;
	}

	private List<Flight> listFlight = new ArrayList<Flight>();

	public List<Flight> getListFlight() {
		return listFlight;
	}

	public void setListFlight(List<Flight> listFlight) {
		this.listFlight = listFlight;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String findAllFlight() {
		flightQuery = new SearchFlight();
		listFlight = flightService.findAll();
		return "flight";
	}

	public void changeEditStatus(Airline airline) {
		if (airline.isEditable())
			airlineRestService.update(airline);
		airline.setEditable(!airline.isEditable());
	}

	public void deleteAirline(String name) {
		airlineRestService.delete(name);
	}
	
	
	public void SearchFlight() {
		if (flightQuery == null
				|| ("".equals(flightQuery.getAirlineName()) && "".equals(flightQuery.getOriginAirportCode())
						&& "".equals(flightQuery.getDestinationAirportCode()))) {
			listFlight = flightService.findAll();
		} else {

			if (flightQuery.getAirlineName() != null && !"".equals(flightQuery.getAirlineName())) {
				Airline airlineNew = airlineService.findByName(flightQuery.getAirlineName());
				if (airlineNew != null) {
					listFlight = flightService.findByAirline(airlineNew);
				}
			}

			if (flightQuery.getOriginAirportCode() != null && !"".equals(flightQuery.getOriginAirportCode())) {
				Airport airportNew = airportService.findByCode(flightQuery.getOriginAirportCode());
				if (airportNew != null) {
					if (listFlight != null) {
						List<Flight> listFlight1 = flightService.findByOrigin(airportNew);
						List<Flight> listFlight2 = new ArrayList<Flight>();
						for (Flight flight : listFlight1) {
							if (listFlight.contains(flight)) {
								listFlight2.add(flight);
							}
						}
						listFlight = new ArrayList<Flight>(listFlight2);
					} else {
						listFlight = flightService.findByOrigin(airportNew);
					}
				}
			}

			if (flightQuery.getDestinationAirportCode() != null
					&& !"".equals(flightQuery.getDestinationAirportCode())) {
				Airport airportNew = airportService.findByCode(flightQuery.getDestinationAirportCode());
				if (airportNew != null) {
					if (listFlight != null) {
						List<Flight> listFlight1 = flightService.findByDestination(airportNew);
						List<Flight> listFlight2 = new ArrayList<Flight>();
						for (Flight flight : listFlight1) {
							if (listFlight.contains(flight)) {
								listFlight2.add(flight);
							}
						}
						listFlight = new ArrayList<Flight>(listFlight2);
					} else {
						listFlight = flightService.findByDestination(airportNew);
					}
				}
			}

		}
	}

}
