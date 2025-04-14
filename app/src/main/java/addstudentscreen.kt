package com.example.arsenal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddStudent(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add Student",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        var fullName by remember { mutableStateOf("") }
        var age by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var course by remember { mutableStateOf("") }
        var gender by remember { mutableStateOf("") }
        var errorMessage by remember { mutableStateOf("") }

        val courseOptions = listOf("Fullstack", "Datascience", "Cybersecurity")
        val genderOptions = listOf("Male", "Female")

        // Full Name Field
        OutlinedTextField(
            value = fullName,
            onValueChange = {
                fullName = it
                errorMessage = if (fullName.isBlank()) "Full Name cannot be empty" else ""
            },
            label = { Text("Full Name", color = Color.Black) },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Full Name Icon",
                    tint = Color.Black
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
        )

        // Age Field
        OutlinedTextField(
            value = age,
            onValueChange = {
                age = it
                errorMessage = if (age.isBlank() || age.toIntOrNull() == null || age.toInt() <= 0) "Invalid age" else ""
            },
            label = { Text("Age", color = Color.Black) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Age Icon",
                    tint = Color.Black
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
        )

        // Phone Number Field
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
                errorMessage = if (!phoneNumber.matches("^\\d+\$".toRegex())) "Invalid phone number" else ""
            },
            label = { Text("Phone Number", color = Color.Black) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Phone Number Icon",
                    tint = Color.Black
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
        )

        // Course Dropdown
        DropdownMenuField(
            label = "Course",
            options = courseOptions,
            selectedOption = course,
            onOptionSelected = { course = it }
        )

        // Gender Dropdown
        DropdownMenuField(
            label = "Gender",
            options = genderOptions,
            selectedOption = gender,
            onOptionSelected = { gender = it }
        )

        // Error Message
        if (errorMessage.isNotBlank()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        // Upload Student Button
        Button(
            onClick = {
                if (fullName.isNotBlank() && age.isNotBlank() && phoneNumber.isNotBlank() &&
                    course.isNotBlank() && gender.isNotBlank() && errorMessage.isBlank()
                ) {
                    println("Uploading student: $fullName, $age, $phoneNumber, $course, $gender")
                } else {
                    errorMessage = "Please fill all fields correctly."
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Upload Student")
        }
    }
}

@Composable
fun DropdownMenuField(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = selectedOption,
        onValueChange = {},
        readOnly = true,
        label = { Text(label, color = Color.Black) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier.clickable { expanded = !expanded },
                tint = Color.Black
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp))
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier.background(Color.White)
    ) {
        options.forEach { option ->
            DropdownMenuItem(
                text = { Text(option, color = Color.Black) },
                onClick = {
                    onOptionSelected(option)
                    expanded = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddStudentPreview() {
    MaterialTheme {
        val mocknavController = rememberNavController()
       AddStudent(navController = mocknavController)
    }
}
