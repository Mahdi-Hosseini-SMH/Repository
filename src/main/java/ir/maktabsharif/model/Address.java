package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Address {
    private String country;
    private String city;
    private String address;
    private String zipCode;

}
