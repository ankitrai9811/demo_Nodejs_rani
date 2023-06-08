package com.mastercard.dxp.service;

import java.time.LocalDateTime;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.dxp.dto.StatusDto;
import com.mastercard.dxp.entity.ServiceRequest;
import com.mastercard.dxp.repository.ServiceRequestRepository;

@Service	
public class StatusService {
	@Autowired
	ServiceRequestRepository repo;
	
	
	

	public void createStatus(StatusDto stDto) {
		ServiceRequest sr=repo.findById(stDto.getSrId()).orElseThrow(() -> new RuntimeException("sr not found"));
		 
		sr.setStatus(stDto.getStatus());
		 
		 LocalDateTime current=LocalDateTime.now();
		sr.setClosedAt(current);
		System.out.println(current);
		
		repo.save(sr);

		
	}

}
