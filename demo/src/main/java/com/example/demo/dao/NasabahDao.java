package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Nasabah;

public interface NasabahDao extends JpaRepository<Nasabah, Integer> {

}
