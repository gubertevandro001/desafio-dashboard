package desafio.dashboard.service;

import desafio.dashboard.dto.*;
import desafio.dashboard.entity.Ticket;
import desafio.dashboard.repository.ClientRepository;
import desafio.dashboard.repository.ModuleRepository;
import desafio.dashboard.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final ClientRepository clientRepository;
    private final ModuleRepository moduleRepository;

    public TicketService(TicketRepository ticketRepository, ClientRepository clientRepository, ModuleRepository moduleRepository) {
        this.ticketRepository = ticketRepository;
        this.clientRepository = clientRepository;
        this.moduleRepository = moduleRepository;
    }

    public ListTicketsGroupedByModuleAndClientResponse listTicketsGroupedByModuleAndClient(Integer year, Integer month) {

        final var totalTickets = ticketRepository.findAllByMonthAndYear(month, year);
        final var totalTicketsPerClient = totalTicketsPerClient(totalTickets);
        final var totalTicketsPerModule = totalTicketsPerModule(totalTickets);

        return ListTicketsGroupedByModuleAndClientResponse.output(totalTickets, totalTicketsPerClient, totalTicketsPerModule);
    }

    private List<ListTotalTicketsPerClientResponse> totalTicketsPerClient(List<Ticket> tickets) {

        if (tickets.isEmpty()) {
            return List.of();
        }

        return tickets.stream()
                .collect(Collectors.groupingBy(ticket -> ticket.getClient().getId()))
                .entrySet()
                .stream()
                .map(entry -> new ListTotalTicketsPerClientResponse(
                        entry.getKey(),
                        entry.getValue().getFirst().getClient().getName(),
                        entry.getValue().size()
                ))
                .collect(Collectors.toList());
    }

    private List<ListTotalTicketsPerModuleResponse> totalTicketsPerModule(List<Ticket> tickets) {

        if (tickets.isEmpty()) {
            return List.of();
        }

        return tickets.stream()
                .collect(Collectors.groupingBy(ticket -> ticket.getModule().getId()))
                .entrySet()
                .stream()
                .map(entry -> new ListTotalTicketsPerModuleResponse(
                        entry.getKey(),
                        entry.getValue().getFirst().getModule().getName(),
                        entry.getValue().size()
                ))
                .collect(Collectors.toList());
    }

    public CreateTicketResponse create(CreateTicketRequest request) {

        final var client = clientRepository.findById(request.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        final var module = moduleRepository.findById(request.moduleId())
                .orElseThrow(() -> new RuntimeException("Module not found"));

        final var ticket = Ticket.newTicket(request.title(), module, client);

        final var createdTicket = ticketRepository.save(ticket);

        return CreateTicketResponse.output(createdTicket.getId());
    }
}

