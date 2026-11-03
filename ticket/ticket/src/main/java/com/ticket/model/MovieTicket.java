package com.ticket.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieTicket {

    private Long ticketId;

    @NotBlank(message = "Movie name is required")
    private String movieName;

    @NotBlank(message = "Customer name cannot be empty")
    private String customerName;

    @NotEmpty(message = "Seat number cannot be empty")
    private int seatNumber;

    @Positive(message = "Ticket price must be positive")
    private double ticketPrice;
}
