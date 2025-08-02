package me.lanying.blooddonation.repository;

import me.lanying.blooddonation.entity.DonationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationHistoryRepository extends JpaRepository<DonationHistory, Long> {
}

