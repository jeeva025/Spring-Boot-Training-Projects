package com.ticket.controller;

import com.ticket.model.MovieTicket;
import com.ticket.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tickets")
public class MovieTicketController {

    @Autowired
    private MovieTicketService movieTicketService;

    @GetMapping
    public List<MovieTicket> getAllTickets(){
        return movieTicketService.getAllTickets();
    }

    @GetMapping("{id}")
    public MovieTicket getTicketById(@PathVariable int id){
        return movieTicketService.getTicketById(id);
    }

    @PostMapping
    public MovieTicket addTicket(@RequestBody MovieTicket movieTicket ){
        return movieTicketService.addTicket(movieTicket);
    }

    @PutMapping("{id}")
    public MovieTicket updateTicket(@PathVariable int id, @RequestBody MovieTicket movieTicket){
        return movieTicketService.updateTicket(id,movieTicket);
    }

    @DeleteMapping("{id}")
    public String deleteTicket(@PathVariable int id){
        return movieTicketService.deleteTicket(id);
    }

}
