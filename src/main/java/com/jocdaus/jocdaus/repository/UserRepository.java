/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocdaus.jocdaus.repository;

import com.jocdaus.jocdaus.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Joan
 */
public interface UserRepository extends MongoRepository<User, Integer>{
    
}
