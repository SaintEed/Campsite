package com.deusnex.campsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deusnex.campsite.entity.Available;

@Repository
public interface AvailableRepository extends JpaRepository<Available, String> {

}
