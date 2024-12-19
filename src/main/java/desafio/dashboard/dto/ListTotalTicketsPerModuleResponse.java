package desafio.dashboard.dto;

public record ListTotalTicketsPerModuleResponse(
        Long moduleId,
        String name,
        Integer totalTickets
) {
}
