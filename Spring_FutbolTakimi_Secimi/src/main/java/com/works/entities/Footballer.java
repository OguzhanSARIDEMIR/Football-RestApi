package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer fid;

    @NotBlank(message = "Lütfen Adınızı Giriniz.")
    private String name;

    @NotBlank(message = "Lütfen Soyadınızı Giriniz.")
    private String surname;

    @Column(unique = true)
    @Email(message = "Email Formatı Hatalı")
    private String email;

    @Min(value = 0)
    private String password;

    @Min(message = "Futbolcu 18 yaşında olmalıdır.",value = 18)
    private Integer age;


}
