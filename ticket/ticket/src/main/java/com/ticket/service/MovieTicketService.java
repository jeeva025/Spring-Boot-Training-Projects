package com.ticket.service;

import com.ticket.exception.MovieTicketNotFoundException;
import com.ticket.model.MovieTicket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieTicketService {
    private long id = 1L;
    List<MovieTicket> movieTickets = new ArrayList<>();

    public List<MovieTicket> getAllTickets() {
        return movieTickets;
    }

    public MovieTicket getTicketById(int requestId) {
        for (MovieTicket movieTicket : movieTickets){
            if (movieTicket.getTicketId() == requestId){
                return movieTicket;
            }
        }
        throw new MovieTicketNotFoundException("Ticket Not found with ID: "+id);
    }

    public MovieTicket addTicket(MovieTicket request) {
        MovieTicket ticket = new MovieTicket(
                id++,
                request.getMovieName(),
                request.getCustomerName(),
                request.getSeatNumber(),
                request.getTicketPrice()
                );
        movieTickets.add(ticket);
        return ticket;
    }

    public MovieTicket updateTicket(int id, MovieTicket request) {
        MovieTicket existingTicket = getTicketById(id);

        existingTicket.setMovieName(request.getMovieName());
        existingTicket.setCustomerName(request.getCustomerName());
        existingTicket.setSeatNumber(request.getSeatNumber());
        existingTicket.setTicketPrice(request.getTicketPrice());

        return existingTicket;
    }

    public String deleteTicket(int id) {
        MovieTicket movieTicket = getTicketById(id);
        movieTickets.remove(movieTicket);
        return "Ticket Booking Cancelled";
    }
}
