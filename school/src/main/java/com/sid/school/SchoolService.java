package com.sid.school;

import com.sid.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

            private final SchoolRepository schoolRepository;
            private StudentClient studentClient;

            public void saveSchool(School school) {
                schoolRepository.save(school);
            }
            public List<School> findAllSchools(){
                return schoolRepository.findAll();
            }

    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
               var school = schoolRepository.findById(schoolId)
                       .orElse(
                               School.builder()
                                       .name("NOT FOUND")
                                       .email("NOT FOUND")
                                       .build()
                       );
            //we will find all students from thestudent microservice

               var students = studentClient.findAllStudentsBySchool(schoolId);

               return FullSchoolResponse
                       .builder()
                       .name(school.getName())
                       .email(school.getEmail())
                       .students(students)
                       .build();
    }
}
