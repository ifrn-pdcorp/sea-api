package br.edu.ifrn.laj.pdcorp.apisea.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import br.edu.ifrn.laj.pdcorp.apisea.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrn.laj.pdcorp.apisea.dtos.EventDTO;
import br.edu.ifrn.laj.pdcorp.apisea.exceptions.ApiEventException;
import br.edu.ifrn.laj.pdcorp.apisea.models.Activity;
import br.edu.ifrn.laj.pdcorp.apisea.services.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Event Endpoint", description = "Control of events", tags="Event Endpoint")
@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;

	@ApiOperation(value = "Listar todos os eventos")
	@GetMapping
	public List<EventDTO> findAll() {
		return eventService.findAllIsActive();
	}

	@ApiOperation(value = "Listar evento por id")
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(eventService.findById(id));
		} catch (ApiEventException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@ApiOperation(value = "Adicionar evento")
	@PostMapping
	public ResponseEntity<?> save(Principal principal, @RequestBody EventDTO event) {

		try {
			return ResponseEntity.ok(eventService.save(principal, event.convertToModel()));
		} catch (ApiEventException | ApiException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@ApiOperation(value = "Atualizar evento por id")
	@PutMapping("/{id}")
	public ResponseEntity<?> update(Principal principal, @PathVariable Long id, @RequestBody EventDTO event) {
		try {
			return ResponseEntity.ok(eventService.update(principal, id, event.convertToModel()));
		} catch (ApiEventException | ApiException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@ApiOperation(value = "Ativar atividade por id do evento")
	@PutMapping("/{idEvent}/activities")
	public ResponseEntity<?> addActivity(@PathVariable Long idEvent, @RequestBody Activity activity){
		try {
			return ResponseEntity.ok(eventService.addActivity(activity, idEvent));
		} catch (ApiEventException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@ApiOperation(value = "Desativar evento por id")
	@PutMapping("/{id}/deactivate")
	public ResponseEntity<?> deactivate(Principal principal, @PathVariable Long id) {
		try {
			return ResponseEntity.ok(eventService.deactivate(principal, id));
		} catch (ApiEventException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
