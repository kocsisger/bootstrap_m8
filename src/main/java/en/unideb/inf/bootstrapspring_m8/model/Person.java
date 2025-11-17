package en.unideb.inf.bootstrapspring_m8.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persons")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    Long id;
    String email;
    String firstName;
    String lastName;
    String password;
    boolean enabled;
}
