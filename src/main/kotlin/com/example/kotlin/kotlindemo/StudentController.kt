package com.example.kotlin.kotlindemo

import org.springframework.beans.factory.annotation.Autowired
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
    fun all() : List<Student> {
        return service.findAll()
    }

    @PostMapping("/add")
    fun add(@RequestBody student: Student) : Student {
        return service.save(student)
    }

    @GetMapping("/firstName")
    fun getByFirstName(@RequestParam firstName: String): List<Student> {
        return service.findByFirstName(firstName)
    }

    @GetMapping("/lastName")
    fun getByLastName(@RequestParam lastName: String): List<Student> {
        return service.findByLastName(lastName)
    }

    @DeleteMapping("/deleteStudent")
    fun delete(@RequestParam id: Long): Unit {
        return service.delete(id)
    }
}
