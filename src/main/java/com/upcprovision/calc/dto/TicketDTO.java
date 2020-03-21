package com.upcprovision.calc.dto;

import com.upcprovision.calc.model.tickets.TicketStatus;
import com.upcprovision.calc.security.user.CustomUserDetails;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;
import java.util.ArrayList;

public class TicketDTO implements Serializable {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private ArrayList<TicketStatus> ticketStatuses;
    @Getter
    @Setter
    private int clientId;
    @Getter
    @Setter
    private boolean closed = false;
    @Getter
    @Setter
    private String currentGroup;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String statusUpdate;
    @Getter
    @Setter
    private String ticketCreator;
    @Getter
    @Setter
    private String closedString;

    public String getAuthorityUsername() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }


    public TicketDTO() {
    }

    public TicketDTO(boolean closed, String currentGroup, String statusUpdate) {
        this.username = getAuthorityUsername();
        this.closed = closed;
        this.currentGroup = currentGroup;
        this.statusUpdate = statusUpdate;
    }
}
