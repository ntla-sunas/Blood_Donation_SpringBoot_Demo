package me.lanying.blooddonation.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "campaign")

public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    @OneToMany( mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<DonationHistory> donationHistories;
}
