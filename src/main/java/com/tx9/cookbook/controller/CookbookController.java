package com.tx9.cookbook.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tx9.cookbook.model.Cookbook;
import com.tx9.cookbook.repository.CookbookRepository;



@RestController // contains @Controller and @ResponseBody
@RequestMapping({ "/cookbooks" })
public class CookbookController {
	private CookbookRepository repository;

	CookbookController(CookbookRepository cookbookRepository) {
		this.repository = cookbookRepository;
	}

	@GetMapping // equal to @RequestMapping(value="/contacts",
				// method=RequestMethod.GET)
	public List findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Cookbook> findById(@PathVariable long id) {
		return this.repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Cookbook create(@RequestBody Cookbook contact) {
		return repository.save(contact);
	}

//	@PutMapping(value = "/{id}")
//	public ResponseEntity<Cookbook> update(@PathVariable("id") long id, @RequestBody Cookbook cookbook) {
//		return repository.findById(id).map(record -> {
//			record.setName(cookbook.getName());
//			Cookbook updated = repository.save(record);
//			return ResponseEntity.ok().body(updated);
//		}).orElse(ResponseEntity.notFound().build());
//	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
