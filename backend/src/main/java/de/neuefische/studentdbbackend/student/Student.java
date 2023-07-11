package de.neuefische.studentdbbackend.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "students")
public class Student {

    @MongoId
    private String mongoId;
    private String matriculationNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String courseOfStudies;

}
