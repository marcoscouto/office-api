package com.marcoscouto.office.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private Integer age;
    private String office;

}
