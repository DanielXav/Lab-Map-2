package com.map.labdois.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;
import com.map.labdois.exceptions.SchedulesDoesntMatchException;
import com.map.labdois.exceptions.SubjectNotOfferedException;

public class UniversityTest {

	private Subject subject;
	private Teacher teacher;
	private Student student;
	private University university;
	private Course course;

	@BeforeEach
	void setUp() throws Exception {
		university = new University();

		teacher = new Teacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.DIURNO);
//		subject = new Subject(SubjectEnum.Calculo, teacher, ScheduleEnum.INTEGRAL, true);
//		student = new Student("Daniel", 21, "daniel@uepb.com", "83912341234", ScheduleEnum.INTEGRAL);
//		course = new Course(CourseEnum.Computacao);

	}

	@Test
	public void shouldAddTeacher() {
		university.addNewTeacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.DIURNO);

		Assertions.assertEquals("Sabrina", university.getTeachers().get(0).getName());
		Assertions.assertEquals(25, university.getTeachers().get(0).getAge());

	}

	@Test
	public void shouldAddStudent() {
		university.addNewStudent("Daniel", 21, "daniel@uepb.com", "83912341234", 10.0, ScheduleEnum.DIURNO);
		
		Assertions.assertEquals("Daniel", university.getStudents().get(0).getName());
		Assertions.assertEquals(21, university.getStudents().get(0).getAge());

	}

	@Test
	public void shouldAddSubject() {
		university.addNewSubject(SubjectEnum.Calculo, ScheduleEnum.DIURNO, true, teacher);

		Assertions.assertEquals(SubjectEnum.Calculo, university.getSubjects().get(0).getName());
	}
	
	@Test
	public void shouldThrowSubjectNotOfferedExceptionWhenSubjectIsntOffered() {
		
		Assertions.assertThrows(SubjectNotOfferedException.class, () -> {
			university.addNewSubject(SubjectEnum.Calculo, ScheduleEnum.DIURNO, false, teacher);
        });
		
	}
	
	@Test
	public void shouldThrowSchedulesDoesntMatchExceptionWhenSchedulesDoesntMatches() {
		Assertions.assertThrows(SchedulesDoesntMatchException.class, () -> {
			university.addNewSubject(SubjectEnum.Calculo, ScheduleEnum.NOTURNO, true, teacher);
		});
	}
}
