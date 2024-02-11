package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.NasabahDao;
import com.example.demo.dto.NasabahDto;
import com.example.demo.dto.NasabahListResponse;
import com.example.demo.entity.Nasabah;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NasabahService {

	private final NasabahDao nasabahDao;
	
	public NasabahListResponse getAll() {
		NasabahListResponse resp = new NasabahListResponse();
		
		List<Nasabah> nasabah = nasabahDao.findAll();
		
		if (nasabah.size() > 0) {
			List<NasabahDto> listDto = new ArrayList<NasabahDto>();
			
			for (Nasabah data : nasabah) {
				NasabahDto dto = new NasabahDto();
				dto.setNama(data.getNama());
				dto.setNik(data.getNik());
				dto.setNoHp(data.getNoHp());
				dto.setEmail(data.getEmail());
				dto.setDob(data.getDob());
				
				listDto.add(dto);
			}

			resp.setNasabahList(listDto);
		} else {
			log.info("Data not found");
			
			return null;
		}
		
		return resp;
	}
	
	public int create(NasabahDto nasabahReq) {
		if (nasabahReq.getNama() == null || nasabahReq.getNik() == null || nasabahReq.getNoHp() == null ||
				nasabahReq.getEmail() == null || nasabahReq.getDob() == null) {
			return 0;
		} else {
			Nasabah nasabah = new Nasabah();
			nasabah.setNama(nasabahReq.getNama());
			nasabah.setNik(nasabahReq.getNik());
			nasabah.setNoHp(nasabahReq.getNoHp());
			nasabah.setEmail(nasabahReq.getEmail());
			nasabah.setDob(nasabahReq.getDob());
			
			nasabahDao.save(nasabah);
			log.info("Nasabah {} create successfully.", nasabah.getIdNasabah());
			
			return 1;
		}
	}
}
