package com.example.kotlin.kotlindemo.rest

import com.example.kotlin.kotlindemo.error.ErrorMessage
import com.example.kotlin.kotlindemo.error.StudentException
import com.example.kotlin.kotlindemo.model.Student
import com.example.kotlin.kotlindemo.rest.dto.StudentRequestDTO
import com.example.kotlin.kotlindemo.rest.dto.StudentResponseDTO
import com.example.kotlin.kotlindemo.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created by Nemanja on 6/9/17.
 *
 * REST Controller with methods for creating, reading and deleting
 * Updating is done with add method
 */
@RestController
class StudentController(val service: StudentService) {

    @GetMapping("/all")
    fun all() : ResponseEntity<*>{
        return ResponseEntity.ok(service.findAll())
    }

    @PostMapping("/add")
    fun add(@RequestBody student: StudentRequestDTO) : ResponseEntity<*> {
        return ResponseEntity.ok(service.save(student))
    }

    @GetMapping("/get")
    fun getOne(@RequestParam id: Long): ResponseEntity<*> {
        try {
            return ResponseEntity.ok(service.findById(id))
        } catch (ex: StudentException) {
            return ResponseEntity.badRequest().body(ErrorMessage(ex.message!!, ex.errorCode))
        }
    }

    @GetMapping("/firstName")
    fun getByFirstName(@RequestParam firstName: String): ResponseEntity<*> {
        return ResponseEntity.ok(service.findByFirstName(firstName))
    }

    @GetMapping("/lastName")
    fun getByLastName(@RequestParam lastName: String): ResponseEntity<*> {
        return ResponseEntity.ok(service.findByLastName(lastName))
    }

    @DeleteMapping("/deleteStudent")
    fun delete(@RequestParam id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.ok().body(null)
    }
}
