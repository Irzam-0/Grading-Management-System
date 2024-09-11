package com.example.grading_management
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.app.GradeManagementSystem

class SearchStudentActivity : AppCompatActivity() {

    private val bst = GradeManagementSystem.bst

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_student)

        // Get references to the UI elements
        val etStudentId = findViewById<EditText>(R.id.etStudentId)
        val btnSearchStudent = findViewById<Button>(R.id.btnSearchStudent)
        val tvSearchResult = findViewById<TextView>(R.id.tvSearchResult)


        btnSearchStudent.setOnClickListener {
            val studentIdText = etStudentId.text.toString()


            if (studentIdText.isNotEmpty()) {
                val studentId = studentIdText.toInt()


                val student = bst.search(studentId)

                if (student != null) {
                    tvSearchResult.text = "ID: ${student.studentId}, Name: ${student.name}, Grade: ${student.grade}"
                } else {
                    tvSearchResult.text = "Student not found"
                }
            } else {
                tvSearchResult.text = "Please enter a valid student ID"
            }
        }
    }
}
