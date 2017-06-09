package com.example.kotlin.kotlindemo

import org.springframework.stereotype.Service

/**
 * Created by Nemanja on 6/9/17.
 *
 * Spring service
 */
@Service
class StudentService(val repository: StudentRepository) {

    /**
     * Method for saving student
     */
    fun save(student: Student): Student = repository.save(student)

    /**
     * Method that returns all students
     */
    fun findAll(): List<Student> = repository.findAll()

    /**
     * Method that returns students by first name
     */
    fun findByFirstName(firstName: String): List<Student> = repository.findByFirstName(firstName)

    /**
     * Method that returns students by last name
     */
    fun findByLastName(lastName: String): List<Student> = repository.findByLastName(lastName)

    /**
     * Method that deletes student by id
     */
    fun delete(id: Long): Unit{
        return repository.deleteById(id)
    }
}