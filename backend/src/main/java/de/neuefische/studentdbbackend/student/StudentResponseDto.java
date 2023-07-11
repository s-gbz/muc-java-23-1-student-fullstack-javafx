package de.neuefische.studentdbbackend.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponseDto {

    private String matriculationNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String courseOfStudies;

}
