package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@Getter @Setter
public class Product {
    private Long id;
    private String description;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
