package com.example.demo



import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.kotlin.springboot.Employee
import com.kotlin.springboot.EmployeeRepository

@RestController
@RequestMapping("/employee")
class ControllerMain(val employeeRepository: EmployeeRepository) {
	
	/*@RequestMapping("/help")
	fun welcome():String{
		return "Hello Kotlin from Spring"
	}
		*/
	@PostMapping
	fun saveEmployee(@RequestBody employee: Employee): Employee
	{
		return employeeRepository.save(employee)
		
	}

	@GetMapping("/{id}")
	fun getEmployee(@PathVariable id: Long): Employee
	{
		println("No Employee")
		return employeeRepository.findById(id).orElse(null)
	}

	@GetMapping
	fun getAllEmployees(): Iterable<Employee>
	{
		return employeeRepository.findAll()
	}

	@PutMapping
	fun updateEmployee(@RequestBody employee: Employee)
	{
		employeeRepository.save(employee)
	}

	@DeleteMapping("/{id}")
	fun deleteEmployee(@PathVariable id: Long)
	{
		employeeRepository.deleteById(id)
	}
}