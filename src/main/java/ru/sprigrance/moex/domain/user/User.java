package ru.sprigrance.moex.domain.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.sprigrance.moex.domain.securities.SecuritiesTable;
import ru.sprigrance.moex.domain.securities.Stock;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable { // Serializable - для Redis

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String username;
    private String password;

    @Transient
    private String passwordConfirmation;

    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_id")
    private List<Stock> stocks;

    @Column(name = "securities_table")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_securities_table")
    private List<String> securitiesTables;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
