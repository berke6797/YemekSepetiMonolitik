package com.bilgeadam.yemeksepetimonolotik.repository.entity;

import com.bilgeadam.yemeksepetimonolotik.utility.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long customerId;

    @NotBlank(message = "Müşteri adı boş geçilemez")
    @Size(min = 3,max = 20,message = "Kullanıcı adı en az 3 en fazla 25 karekter olabilir")
    String customerName;

    @Column(length = 2)
    @NotBlank(message = "Müşteri soyadı boş geçilemez")
    @Size(min = 3,max = 20,message = "Kullanıcı soyadı en az 3 en fazla 25 karekter olabilir")
    String customerSurname;

    @Email(message = "Lütfen geçerli bir email adresi giriniz!")
    String email;
    @Column(length = 150)
    @NotBlank(message = "Müşteri adresi boş geçilemez")
    @Size(min = 3,max = 100,message = "Kullanıcı adı en az 3 en fazla 20 karekter olabilir")
    String customerAddress;
    @NotBlank(message = "Telefon numarası doldurulmak zorundadır!")
    String phoneNumber;
    @Column(length = 32)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$",
            message = "Şifre en az bir büyük, bir küçük harf , en az bir rakam ve özel karekterden oluşmalıdır.")
    @Size(min = 3,max = 32,message = "Kullanıcı şifresi en az 3 en fazla 32 karekter olabilir")
    String password;
    @NotBlank(message = "Kart bilgileri boş geçilemez")
    String cardDetails;
    double balance;
    String activationCode;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus userStatus=EStatus.PENDING;

}
