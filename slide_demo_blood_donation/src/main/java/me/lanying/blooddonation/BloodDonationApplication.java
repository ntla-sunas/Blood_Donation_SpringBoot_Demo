package me.lanying.blooddonation;

import me.lanying.blooddonation.entity.Donor;
import me.lanying.blooddonation.entity.Campaign;
import me.lanying.blooddonation.entity.DonationHistory;
import me.lanying.blooddonation.repository.DonorRepository;
import me.lanying.blooddonation.repository.CampaignRepository;
import me.lanying.blooddonation.repository.DonationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


@SpringBootApplication
public class BloodDonationApplication implements CommandLineRunner {
    @Autowired
    private DonorRepository donorRepository;
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private DonationHistoryRepository donationHistoryRepository;
    private Campaign Campaign;

    public static void main(String[] args) {
        SpringApplication.run(BloodDonationApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // === 1. TẠO CHIẾN DỊCH VÀ LƯU VÀO DATABASE ===
        Campaign campaign = Campaign.builder()
                        .name("Ngày hội hiến máu cứu người 2025")
                                .location("Nhà văn hoá Thanh niên")
                                        .startDate(LocalDate.now())
                                                .endDate(LocalDate.now().plusDays(5))
                                                        .build();
        campaignRepository.save(campaign);
        System.out.println(">>> Đã tạo chiến dịch: " + campaign.getName());

        // === 2. LẤY THÔNG TIN NGƯỜI HIẾN MÁU ===
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== THÊM NGƯỜI HIẾN MÁU MỚI ===");
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        System.out.print("Nhóm máu (A/B/AB/O): ");
        String bloodType = scanner.nextLine();

        System.out.print("Tuổi: ");
        int age = scanner.nextInt();

        Donor donor = Donor.builder()
                .name(name)
                .email(email)
                .bloodType(bloodType)
                .age(age)
                .build();

        donorRepository.save(donor);
        System.out.println("Đã lưu thông tin người hiến máu vào database!");

        // === 3. TẠO LỊCH SỬ HIẾN MÁU ĐỂ LIÊN KẾT 2 BẢNG ===
        DonationHistory history = DonationHistory.builder()
                .donor(donor)
                .campaign(Campaign)
                .donationDate(LocalDate.now())
                .status("Thành công")
                .build();
        donationHistoryRepository.save(history);
    }
}