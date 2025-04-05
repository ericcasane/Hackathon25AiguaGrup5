package org.tecnocampus.aquaactua.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tecnocampus.aquaactua.domain.WaterUsage;

import java.util.List;

public interface WaterUsageRepository extends JpaRepository<WaterUsage, String> {
    List<WaterUsage> findByUserId(String userId);
}
