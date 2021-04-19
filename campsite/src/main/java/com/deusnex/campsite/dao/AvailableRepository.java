package com.deusnex.campsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deusnex.campsite.entity.Available;

public interface AvailableRepository extends JpaRepository<Available, String> {

}
