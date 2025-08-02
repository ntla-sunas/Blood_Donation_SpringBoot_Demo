package me.lanying.blooddonation.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder

public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String bloodType;
    private int age;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
    private List<DonationHistory> donationHistories;
}
