package com.app.QR_Code_Generator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.QR_Code_Generator.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
