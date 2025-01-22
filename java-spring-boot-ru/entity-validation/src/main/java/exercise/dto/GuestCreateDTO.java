package exercise.dto;

// BEGIN

import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GuestCreateDTO {
    @Column
    @NotBlank
    private String name;

    @Email
    private String email;

    @Size(min = 11)
    @Size(max = 13)
    @Pattern(regexp = "[+]\\d{12,14}")
    private String phoneNumber;

    @Digits(integer = 4, fraction = 0)
    @Size(min = 4)
    @Size(max = 4)
    private String clubCard;

    @FutureOrPresent
    private LocalDate cardValidUntil;
}
// END
