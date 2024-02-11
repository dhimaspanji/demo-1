package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NasabahDto;
import com.example.demo.dto.NasabahListResponse;
import com.example.demo.dto.Response;
import com.example.demo.service.NasabahService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/nasabah")
@RequiredArgsConstructor
@Slf4j
public class NasabahController {

	private final NasabahService nasabahService;
	
	@GetMapping
	public Object getAll() {
		try {
			NasabahListResponse resp = nasabahService.getAll();
			
			if (resp != null) {
				return resp;
			} else {
				Response res = new Response();
				res.setCode(HttpStatus.BAD_REQUEST.value());
				res.setMessage("Error client");
				
				return res;
			}
		} catch (Exception e) {
			log.error("error. ", e);
			
			Response res = new Response();
			res.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMessage("Error server");
			
			return res;
		}
	}
	
	@PostMapping
	public Response create(@RequestBody NasabahDto nasabahreq) {
		Response res = new Response();

		try {
			int resp = nasabahService.create(nasabahreq);
			
			if (resp > 0) {				
				res.setCode(HttpStatus.OK.value());
				res.setMessage("Success");
			} else {
				res.setCode(HttpStatus.BAD_REQUEST.value());
				res.setMessage("Error client");
			}
		} catch (Exception e) {
			log.error("error. ", e);
			
			res.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			res.setMessage("Error server");
		}
		
		return res;
	}
	
}
