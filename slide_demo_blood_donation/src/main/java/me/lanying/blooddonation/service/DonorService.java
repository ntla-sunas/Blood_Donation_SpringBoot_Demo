package me.lanying.blooddonation.service;

import me.lanying.blooddonation.dto.DonorRequest;
import me.lanying.blooddonation.entity.Donor;
import me.lanying.blooddonation.exception.ResourceNotFoundException;
import me.lanying.blooddonation.repository.DonorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class DonorService {
    private final DonorRepository donorRepository;

    // Lấy danh sách tất cả người hiến máu
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    // Tạo người hiến máu mới từ DonorRequest
    @Transactional
    public Donor createDonor(DonorRequest request) {
        Donor donor = Donor.builder()
                .name(request.getName())
                .email(request.getEmail())
                .bloodType(request.getBloodType())
                .age(request.getAge())
                .build();
        return donorRepository.save(donor);
    }
    
    // Lấy donor theo ID (nếu không có sẽ ném exception)
    public Donor getDonorById(Long id) {
        return donorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy donor có ID = " + id));
    }

    // Xoá donor
    public void deleteDonor(Long id) {
        if (!donorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Không tìm thấy donor để xóa, ID = " + id);
        }
        donorRepository.deleteById(id);
    }
}
