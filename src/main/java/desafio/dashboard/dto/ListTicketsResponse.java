package desafio.dashboard.dto;

import java.time.LocalDate;

public record ListTicketsResponse(
        Long id,
        String title,
        Long moduleId,
        Long clientId,
        LocalDate openingDate,
        LocalDate closingDate
) {
}
