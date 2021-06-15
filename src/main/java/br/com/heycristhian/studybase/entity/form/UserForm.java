package br.com.heycristhian.studybase.entity.form;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Getter
public class UserForm {

    @Pattern(regexp = "[A-z\\s]+")
    @Size(min = 3, max = 15, message = "${UserForm.Size.name}")
    @NotBlank
    private final String name;

    @Email(message = "${UserForm.Email.email}")
    private final String email;
}
