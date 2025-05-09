package com.pranay.StudentSelfReflection.controller;

import com.pranay.StudentSelfReflection.model.StudentUser;
import com.pranay.StudentSelfReflection.model.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * File Name: UserController.java
 * Entity: UserController
 * Package: com.pranay.StudentSelfReflection.controller
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */

@RestController
@RequestMapping("/api/v1/user/")
public class UserController
{
	
	// ==================== STUDENT APIs ====================
	
	/**
	 * [POST] http://localhost:8080/api/v1/user/student
	 * Instruction: Create a new student user. Validate uniqueness of email and roll number.
	 * Request Body: JSON payload containing all required student details.
	 */
	@PostMapping("student")
	public ResponseEntity<?> createStudentUser(@RequestBody StudentUser studentUser) {
		// Implementation here
		return null;
	}
	
	/**
	 * [GET] http://localhost:8080/api/v1/user/student/{email}
	 * Instruction: Fetch student details using email from path variable.
	 * Response: Return full student user details or 404 if not found.
	 */
	@GetMapping("student/{email}")
	public ResponseEntity<?> getStudentByEmail(@PathVariable String email) {
		// Implementation here
		return null;
	}
	
	/**
	 * [PUT] http://localhost:8080/api/v1/user/student/{email}
	 * Instruction: Update full student record using email as identifier.
	 * Request Body: Complete updated student user data.
	 */
	@PutMapping("student/{email}")
	public ResponseEntity<?> updateStudentUser(@PathVariable String email, @RequestBody StudentUser studentUser) {
		// Implementation here
		return null;
	}
	
	/**
	 * [PATCH] http://localhost:8080/api/v1/user/student/{email}
	 * Instruction: Update partial data of student (e.g., address or phone).
	 * Request Body: JSON with fields to be modified.
	 */
	@PatchMapping("student/{email}")
	public ResponseEntity<?> partiallyUpdateStudentUser(@PathVariable String email, @RequestBody StudentUser studentUser) {
		// Implementation here
		return null;
	}
	
	/**
	 * [DELETE] http://localhost:8080/api/v1/user/student/{email}
	 * Instruction: Delete student user using email as identifier.
	 * Response: Return success message or 404 if not found.
	 */
	@DeleteMapping("student/{email}")
	public ResponseEntity<?> deleteStudentUser(@PathVariable String email) {
		// Implementation here
		return null;
	}
	
	// ==================== TEACHER APIs ====================
	
	/**
	 * [POST] http://localhost:8080/api/v1/user/teacher
	 * Instruction: Create a new teacher user. Validate uniqueness of email.
	 * Request Body: JSON payload with all teacher details.
	 */
	@PostMapping("teacher")
	public ResponseEntity<?> createTeacherUser(@RequestBody Teacher teacher) {
		// Implementation here
		return null;
	}
	
	/**
	 * [GET] http://localhost:8080/api/v1/user/teacher/{email}
	 * Instruction: Fetch teacher details using email from path variable.
	 * Response: Return full teacher data or 404 if not found.
	 */
	@GetMapping("teacher/{email}")
	public ResponseEntity<?> getTeacherByEmail(@PathVariable String email) {
		// Implementation here
		return null;
	}
	
	/**
	 * [PUT] http://localhost:8080/api/v1/user/teacher/{email}
	 * Instruction: Replace full teacher details using email as key.
	 * Request Body: Complete teacher object with updated fields.
	 */
	@PutMapping("teacher/{email}")
	public ResponseEntity<?> updateTeacherUser(@PathVariable String email, @RequestBody Teacher teacher) {
		// Implementation here
		return null;
	}
	
	/**
	 * [PATCH] http://localhost:8080/api/v1/user/teacher/{email}
	 * Instruction: Update only selected fields (e.g., mobile, address).
	 * Request Body: JSON with specific fields to be modified.
	 */
	@PatchMapping("teacher/{email}")
	public ResponseEntity<?> partiallyUpdateTeacherUser(@PathVariable String email, @RequestBody Teacher teacher) {
		// Implementation here
		return null;
	}
	
	/**
	 * [DELETE] http://localhost:8080/api/v1/user/teacher/{email}
	 * Instruction: Delete a teacher user using email as identifier.
	 * Response: Return confirmation message or error if not found.
	 */
	@DeleteMapping("teacher/{email}")
	public ResponseEntity<?> deleteTeacherUser(@PathVariable String email) {
		// Implementation here
		return null;
	}
}
