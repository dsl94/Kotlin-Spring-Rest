package com.example.kotlin.kotlindemo.repository

import com.example.kotlin.kotlindemo.model.Student
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by Nemanja on 6/9/17.
 *
 * Repository that extends Jpa repository with all CRUD methods
 */
interface StudentRepository: JpaRepository<Student, Long> {

    /**
     * Method which finds all students by first name
     */
    fun findByFirstName(firstName: String): List<Student>

    /**
     * Method that finds all students by last name
     */
    fun findByLastName(lastName: String): List<Student>
}