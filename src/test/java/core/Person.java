package core;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Person {

    @Id
    private Integer id;

    private String name;
}
