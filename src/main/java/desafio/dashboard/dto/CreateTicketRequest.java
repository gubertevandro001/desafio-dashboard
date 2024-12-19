package desafio.dashboard.dto;

public record CreateTicketRequest(
        String title,
        Long moduleId,
        Long clientId
) {
}
