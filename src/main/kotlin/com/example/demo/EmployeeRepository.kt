package com.kotlin.springboot

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository	
interface EmployeeRepository : CrudRepository<Employee, Long>
{
	
}