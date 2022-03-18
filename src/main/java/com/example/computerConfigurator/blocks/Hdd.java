package com.example.computerConfigurator.blocks;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Hdd {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Manufacturer manufacturer;
    private HddType hddType;
    private int size;

}
