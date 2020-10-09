package del.ac.id.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import del.ac.id.demo.jpa.Flight;
import del.ac.id.demo.jpa.FlightRepository;

@Service
@Transactional
public class FlightImpl{

	@Autowired
	private FlightRepository repo;
	
	   public List<Flight> getAllFlight() {
	        return repo.findAll();
	    }
	     
	    public void saveFlight(Flight flight) {
	        repo.save(flight);
	    }
	     
	    public Flight get(long flightid) {
	        return repo.findById(flightid).get();
	    }
	     
	    public void deleteFlightById(long flightid) {
	        repo.deleteById(flightid);
	    }
	    
	    public Flight getFlightById(long flightid) {
		Optional<Flight> optional = repo.findById(flightid);
		Flight flight = null;
		if(optional.isPresent()) {
			flight = optional.get();
		}else {
			throw new RuntimeException("Flight not found");
		}
		
		return flight;
	}

}
