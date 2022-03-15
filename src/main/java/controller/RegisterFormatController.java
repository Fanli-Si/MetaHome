package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csis3275.models.Registeryformat;
import com.csis3275.models.RegisteryformatRepository;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RegisterFormatController {
	@Autowired
	RegisteryformatRepository registeryRepository;

	@GetMapping("/registery/{id}")
	public ResponseEntity<Registeryformat> getCourseById(@PathVariable("id") long id) {
		Optional<Registeryformat> registerData = registeryRepository.findById(id);

		if (registerData.isPresent()) {
			return new ResponseEntity<>(registerData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}


	@GetMapping("/registery")
	public ResponseEntity<List<Registeryformat>> getAllRegistries(@RequestParam(required = false) String userName) {

		try {
			List<Registeryformat> Registeryformat = new ArrayList<Registeryformat>();
			if (userName == null) {
				registeryRepository.findAll().forEach(Registeryformat::add);


			} else {
				registeryRepository.findByUserName(userName).forEach(Registeryformat::add);
			}
			return new ResponseEntity<>(Registeryformat, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/registery")
	public ResponseEntity<Registeryformat> createRegistry(@RequestBody Registeryformat registery) {
		try {
			Registeryformat _Registery = registeryRepository.save(new Registeryformat(registery.getFirstName(), registery.getLastName(),
																				  registery.getAge(), registery.getEmail(), 
																				  registery.getUserName(),registery.getUserPassword()));
			return new ResponseEntity<>(_Registery, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/registery/{id}")
	public ResponseEntity<Registeryformat> updateRegistery(@PathVariable("id") long id, @RequestBody Registeryformat registery) {
		Optional<Registeryformat> registerData = registeryRepository.findById(id);

		if (registerData.isPresent()) {
			Registeryformat _Registery = registerData.get();
			_Registery.setFirstName(registery.getFirstName());
			_Registery.setLastName(registery.getLastName());
			_Registery.setAge(registery.getAge());
			_Registery.setEmail(registery.getEmail());
			_Registery.setUserName(registery.getUserName());
			_Registery.setUserPassword(registery.getUserPassword());
			return new ResponseEntity<>(registeryRepository.save(_Registery), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/registery/{id}")
	public ResponseEntity<HttpStatus> deleteRegistry(@PathVariable("id") long id) {
		try {
			registeryRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/registery")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			registeryRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}