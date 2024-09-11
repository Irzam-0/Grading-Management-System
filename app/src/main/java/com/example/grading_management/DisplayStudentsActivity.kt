package com.example.grading_management

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.app.GradeManagementSystem

class DisplayStudentsActivity : AppCompatActivity() {

    private val bst = GradeManagementSystem.bst

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_students)

        val listView = findViewById<ListView>(R.id.listViewStudents)

        val students = bst.getAllStudents()


        val studentStrings = students.map { student ->
            "ID: ${student.studentId}, Name: ${student.name}, Grade: ${student.grade}"
        }

        // Set up the ListView with an ArrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentStrings)
        listView.adapter = adapter
    }
}
