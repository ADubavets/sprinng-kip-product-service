package com.example.sprinngkipproductservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contracts")
public class Contract {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cipher;
    private String number;
    private Date contract_date;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer firm;

    private int term;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    private Date startdate;
    private Date finishdate;
    private String note;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "calendar_id", referencedColumnName = "id")
    private CalendarWork calendar;


}
