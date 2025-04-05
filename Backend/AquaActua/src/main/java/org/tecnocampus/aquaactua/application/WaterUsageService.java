package org.tecnocampus.aquaactua.application;

import org.springframework.stereotype.Service;
import org.tecnocampus.aquaactua.domain.WaterUsage;
import org.tecnocampus.aquaactua.domain.WaterUsageDTO;
import org.tecnocampus.aquaactua.persistence.WaterUsageRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WaterUsageService {

    private final WaterUsageRepository waterUsageRepository;

    public WaterUsageService(WaterUsageRepository waterUsageRepository) {
        this.waterUsageRepository = waterUsageRepository;
    }

    public WaterUsageDTO save(WaterUsageDTO dto) {
        WaterUsage usage = new WaterUsage(
                UUID.randomUUID().toString(),
                dto.getUserId(),
                dto.getAmountLiters(),
                dto.getTimestamp()
        );
        waterUsageRepository.save(usage);
        return dto;
    }

    public List<WaterUsageDTO> getByUser(String userId) {
        return waterUsageRepository.findByUserId(userId)
                .stream()
                .map(usage -> new WaterUsageDTO(
                        usage.getId(),
                        usage.getUserId(),
                        usage.getAmountLiters(),
                        usage.getTimestamp()
                ))
                .collect(Collectors.toList());
    }
}
