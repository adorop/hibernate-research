package adorop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@DynamicUpdate
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @Column(name = "times_viewed")
    private Long timesViewed;
}
