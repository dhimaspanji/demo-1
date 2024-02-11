package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_nasabah")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Nasabah {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNasabah;
	
	private String nama;
	private String nik;
	private String noHp;
	private String email;
	private String dob;
}
