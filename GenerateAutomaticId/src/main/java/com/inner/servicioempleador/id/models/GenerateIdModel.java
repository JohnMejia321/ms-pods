package com.inner.servicioempleador.id.models;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

/*
 * Model file to create the table in DB cassandra..
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "id_generate")
public class GenerateIdModel implements Serializable {

    @PrimaryKey
    private String id;

    @Column("created_date")
    private Date createdDate;

}
