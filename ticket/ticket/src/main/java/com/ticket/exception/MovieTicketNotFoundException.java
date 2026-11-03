package com.ticket.exception;

public class MovieTicketNotFoundException extends RuntimeException {
    public MovieTicketNotFoundException(String msg){
        super(msg);
    }
}
