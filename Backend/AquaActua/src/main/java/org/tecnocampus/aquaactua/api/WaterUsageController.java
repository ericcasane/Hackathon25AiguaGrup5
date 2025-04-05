package org.tecnocampus.aquaactua.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tecnocampus.aquaactua.application.WaterUsageService;
import org.tecnocampus.aquaactua.domain.WaterUsageDTO;

import java.util.List;

@RestController
@RequestMapping("/api/water-usage")
public class WaterUsageController {

    private final WaterUsageService waterUsageService;

    public WaterUsageController(WaterUsageService waterUsageService) {
        this.waterUsageService = waterUsageService;
    }

    @PostMapping
    public ResponseEntity<WaterUsageDTO> addUsage(@RequestBody WaterUsageDTO usageDTO) {
        return ResponseEntity.ok(waterUsageService.save(usageDTO));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WaterUsageDTO>> getUserUsage(@PathVariable String userId) {
        return ResponseEntity.ok(waterUsageService.getByUser(userId));
    }
}