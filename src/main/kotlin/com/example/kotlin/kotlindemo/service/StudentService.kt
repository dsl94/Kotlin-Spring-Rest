package com.example.kotlin.kotlindemo.service

import com.example.kotlin.kotlindemo.error.ErrorCode
import com.example.kotlin.kotlindemo.error.StudentException
import com.example.kotlin.kotlindemo.model.Student
import com.example.kotlin.kotlindemo.repository.StudentRepository
import com.example.kotlin.kotlindemo.rest.dto.StudentRequestDTO
import com.example.kotlin.kotlindemo.rest.dto.StudentResponseDTO
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
    fun save(student: StudentRequestDTO): StudentResponseDTO {
        val forSave: Student = Student()
        forSave.firstName = student.firstName
        forSave.lastName = student.lastName
        val result: Student = repository.save(forSave)
        val response: StudentResponseDTO = StudentResponseDTO(result.id!!, result.firstName, result.lastName)
        return response
    }

    @Throws(StudentException::class)
    fun findById(id: Long): StudentResponseDTO {
        val result = repository.findById(id)
        if (!result.isPresent) {
            throw StudentException("Student with that ID is not found", ErrorCode.STUDENT_NOT_FOUND)
        }
        val response: StudentResponseDTO = StudentResponseDTO(result.get().id!!, result.get().firstName, result.get().lastName)
        return response
    }

    /**
     * Method that returns all students
     */
    fun findAll(): List<StudentResponseDTO> {
        val result: List<Student> = repository.findAll()
        val response = mutableListOf<StudentResponseDTO>()
        for (student in result) {
            val std: StudentResponseDTO = StudentResponseDTO(student.id!!, student.firstName, student.lastName)
            response.add(std)
        }
        return response
    }

    /**
     * Method that returns students by first name
     */
    fun findByFirstName(firstName: String): List<StudentResponseDTO> {
        val result: List<Student> = repository.findByFirstName(firstName)
        val response = mutableListOf<StudentResponseDTO>()
        for (student in result) {
            val std: StudentResponseDTO = StudentResponseDTO(student.id!!, student.firstName, student.lastName)
            response.add(std)
        }
        return response
    }

    /**
     * Method that returns students by last name
     */
    fun findByLastName(lastName: String): List<StudentResponseDTO> {
        val result: List<Student> = repository.findByLastName(lastName)
        val response = mutableListOf<StudentResponseDTO>()
        for (student in result) {
            val std: StudentResponseDTO = StudentResponseDTO(student.id!!, student.firstName, student.lastName)
            response.add(std)
        }
        return response
    }

    /**
     * Method that deletes student by id
     */
    fun delete(id: Long): Unit{
        return repository.deleteById(id)
    }
}