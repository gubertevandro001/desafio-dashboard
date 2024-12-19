package desafio.dashboard.dto;

import desafio.dashboard.entity.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public record ListTicketsGroupedByModuleAndClientResponse(
        List<ListTicketsResponse> tickets,
        List<ListTotalTicketsPerClientResponse> totalTicketsPerClient,
        List<ListTotalTicketsPerModuleResponse> totalTicketsPerModule


) {

    private static List<ListTicketsResponse> toDto(List<Ticket> tickets) {
        return tickets.stream()
                .map(ticket -> new ListTicketsResponse(
                        ticket.getId(),
                        ticket.getTitle(),
                        ticket.getModule().getId(),
                        ticket.getClient().getId(),
                        ticket.getOpeningDate(),
                        ticket.getClosingDate()
                ))
                .collect(Collectors.toList());
    }

    public static ListTicketsGroupedByModuleAndClientResponse output(List<Ticket> tickets, List<ListTotalTicketsPerClientResponse> totalTicketsPerClient, List<ListTotalTicketsPerModuleResponse> totalTicketsPerModule) {
        return new ListTicketsGroupedByModuleAndClientResponse(toDto(tickets), totalTicketsPerClient, totalTicketsPerModule);
    }

}
