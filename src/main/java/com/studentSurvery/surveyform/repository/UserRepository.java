package com.studentSurvery.surveyform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentSurvery.surveyform.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails,  Integer >{ 
 
}
