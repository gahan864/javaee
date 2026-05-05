package com.ewallet.ewallet.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Wallet {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private double balance;
}