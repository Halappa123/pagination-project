package com.zkteco.paginationexample.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

import static java.time.LocalTime.now;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(hidden = true)
    private Long id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email")
    private String email;


    @Column(name = "Local_Date_Time")
    @Generated
    private String LocalDateTime= String.valueOf(now());


}
