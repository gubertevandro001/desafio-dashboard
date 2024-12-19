package desafio.dashboard.controller;

import desafio.dashboard.dto.CreateTicketRequest;
import desafio.dashboard.dto.CreateTicketResponse;
import desafio.dashboard.dto.ListTicketsGroupedByModuleAndClientResponse;
import desafio.dashboard.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    private TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/list/{month}/{year}")
    public ResponseEntity<ListTicketsGroupedByModuleAndClientResponse> listTicketsGroupedByModuleAndClient(@PathVariable("month") Integer month, @PathVariable("year") Integer year) {
        return ResponseEntity.ok(ticketService.listTicketsGroupedByModuleAndClient(year, month));
    }

    @PostMapping
    public ResponseEntity<CreateTicketResponse> createTicket(@RequestBody CreateTicketRequest request) {
        return ResponseEntity.created(URI.create("/create")).body(ticketService.create(request));
    }
}
