package me.lanying.blooddonation.repository;

import me.lanying.blooddonation.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}