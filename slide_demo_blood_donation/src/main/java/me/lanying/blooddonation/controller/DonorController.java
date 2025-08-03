package me.lanying.blooddonation.controller;

import me.lanying.blooddonation.dto.DonorRequest;
import me.lanying.blooddonation.entity.Donor;
import me.lanying.blooddonation.service.DonorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/donors")
@RequiredArgsConstructor

public class DonorController {
    private final DonorService donorService;

    // Lấy toàn bộ danh sách
    @GetMapping
    public List<Donor> getAll() {
        return donorService.getAllDonors();
    }

    // Tạo mới donor
    @PostMapping
    public ResponseEntity<Donor> create(@Valid @RequestBody DonorRequest request) {
        Donor donor = donorService.createDonor(request);
        return new ResponseEntity<>(donor, HttpStatus.CREATED);
    }

    // Xoá donor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return ResponseEntity.noContent().build();
    }
}
