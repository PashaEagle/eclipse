package com.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapi.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
