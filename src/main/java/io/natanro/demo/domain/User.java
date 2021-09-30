package io.natanro.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
//@Document(collection = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

//    @Id
    @EqualsAndHashCode.Include
    private String login;
    private String name;
    private String password;
}
