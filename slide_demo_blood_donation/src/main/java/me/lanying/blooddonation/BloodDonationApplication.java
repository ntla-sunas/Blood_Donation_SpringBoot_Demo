package me.lanying.blooddonation;

import me.lanying.blooddonation.entity.Donor;
import me.lanying.blooddonation.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class BloodDonationApplication implements CommandLineRunner {
    @Autowired
    private DonorRepository donorRepository;

    public static void main(String[] args) {
        SpringApplication.run(BloodDonationApplication.class, args);
    }

    @Override
    public void run(String... args) {
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
    }


}