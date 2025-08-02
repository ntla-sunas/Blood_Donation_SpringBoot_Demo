package me.lanying.blooddonation.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder

public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String location;
    private LocalDate date;
    private String description;

    @OneToMany( mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<DonationHistory> donationHistories;
}
