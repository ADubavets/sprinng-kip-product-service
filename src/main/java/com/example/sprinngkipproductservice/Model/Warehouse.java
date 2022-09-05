package com.example.sprinngkipproductservice.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productNumber;
    private String code;
    private int quantity;
    private String number;
    private Date onStore;
    private Date dispatch;
    private String note;
    private boolean enabled;
}
