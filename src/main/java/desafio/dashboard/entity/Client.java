package desafio.dashboard.entity;

import jakarta.persistence.*;

@Entity(name = "Client")
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Client() {}

    private Client(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static Client newClient(final String name) {
        return new Client(null, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
