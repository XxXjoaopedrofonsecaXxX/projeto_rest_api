package com.projet.projetojava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.projetojava.Repository.TicketRepository;
import com.projet.projetojava.entity.Ticket;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket ticket = getTicket(id);
        if(ticket != null) {
            ticket.setName(ticketDetails.getName());
            ticket.setPassportNumber(ticketDetails.getPassportNumber());
            ticket.setCpf(ticketDetails.getCpf());
            ticket.setRg(ticketDetails.getRg());
            return ticketRepository.save(ticket);
        }
        return null;
    }

    public void deleteTicket(Long id) {
        Ticket ticket = getTicket(id);
        if(ticket != null) {
            ticketRepository.delete(ticket);
        }
    }
}


