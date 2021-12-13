package org.chaoppo.rest.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Rider {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name= "name")
    private String name;

    public Rider(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
