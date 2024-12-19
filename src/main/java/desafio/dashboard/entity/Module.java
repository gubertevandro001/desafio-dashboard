package desafio.dashboard.entity;

import jakarta.persistence.*;

@Entity(name = "Module")
@Table(name = "MODULE")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Module() {
    }

    private Module(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static Module newModule(final String name) {
        return new Module(null, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
