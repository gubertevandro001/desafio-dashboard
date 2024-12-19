package desafio.dashboard.dto;

public record ListTotalTicketsPerClientResponse(
        Long clientId,
        String name,
        Integer totalTickets
) {
}
