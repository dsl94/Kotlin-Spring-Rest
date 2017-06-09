package com.example.kotlin.kotlindemo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by Nemanja on 6/9/17.
 *
 * Data class that represents entity in database
 */
@Entity
data class Student (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,
        var firstName: String = "",
        var lastName: String = ""
)