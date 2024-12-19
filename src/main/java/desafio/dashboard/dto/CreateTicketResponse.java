package desafio.dashboard.dto;

public record CreateTicketResponse(
        Long id
) {

    public static CreateTicketResponse output(Long id) {
        return new CreateTicketResponse(id);
    }
}
