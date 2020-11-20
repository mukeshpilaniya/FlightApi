package com.udaan.flight.controller;

import com.udaan.flight.model.Ticket;
import com.udaan.flight.model.User;
import com.udaan.flight.repository.TicketRepository;
import com.udaan.flight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping(value = "/user/add")
    public ResponseEntity<?> addUser(@RequestBody User user){
        if(userRepository.findByUserName(user.getUserName())!=null){
            return new ResponseEntity<>("user name already exits", HttpStatus.CONFLICT);
        }else{
            return  new ResponseEntity<>(userRepository.save(user),HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/user/viewReservation/{userId}")
    public ResponseEntity<?> viewReservation(@PathVariable long userId){
        if(userRepository.findById(userId)==null){
            return  new ResponseEntity<>("userId not found",HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(ticketRepository.getByUserId(userId),HttpStatus.OK);
        }
    }
}
