package com.map.labdois.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.map.labdois.enums.CourseEnum;
import com.map.labdois.enums.ScheduleEnum;
import com.map.labdois.enums.SubjectEnum;
import com.map.labdois.exceptions.SchedulesDoesntMatchException;
import com.map.labdois.exceptions.SubjectNotOfferedException;

public class AcademicControlTest {

	private Subject subject;
	private Teacher teacher;
	private Student student;
	private Course course;
	private University university;
	private AcademicControl CA;

	@BeforeEach
	void setUp() throws Exception {
		university = new University();
		CA = new AcademicControl();

		teacher = new Teacher("Sabrina", 25, "sabrina@uepb.com", "83987654321", ScheduleEnum.INTEGRAL);
		subject = new Subject(SubjectEnum.Calculo,  ScheduleEnum.INTEGRAL, true, teacher);
//		student = new Student("Daniel", 21, "daniel@uepb.com", "83912341234", ScheduleEnum.INTEGRAL);
		course = new Course(CourseEnum.Computacao);
	}

	@Test
	public void getSubjectStudentQuantity() {
		
		university.addNewStudent("Daniel", 21, "daniel@uepb.com", "83912341234", 10.0, ScheduleEnum.DIURNO);
		university.addNewStudent("Lucas", 21, "daniel@uepb.com", "83912341234", 10.0, ScheduleEnum.DIURNO);
		
//		CA.getSubjectStudentQuantity(null, university)
		teacher.addSubject(subject);
		Assertions.assertEquals(subject, teacher.getSubjects().get(0));
	}
//
//	@Test
//	public void addSubjectIntoCourse() {
//		course.addSubject(subject);
//		Assertions.assertEquals(subject, course.getSubjects().get(0));
//	}
//
//	@Test
//	public void addSubjectIntoStudent() {
//		student.addSubject(subject);
//		Assertions.assertEquals(subject, student.getSubjects().get(0));
//	}
//
//	@Test
//	public void shouldAddStudentIntoSubject() {
//
//		coordination.addStudentIntoSubject(student, subject);
//		Assertions.assertEquals(student, subject.getStudents().get(0));
//		Assertions.assertEquals(student, coordination.getSubjectStudents(subject).get(0));
//	}
//
//	@Test
//    public void shouldThrowSubjectNotOfferedExceptionWhenSubjectIsntOffered() {
//        subject.setIsOffered(false);
//        Assertions.assertThrows(SubjectNotOfferedException.class, () -> {
//        	coordination.addStudentIntoSubject(student, subject);
//        });
//    }
//
//	@Test
//    public void shouldThrowSchedulesDoesntMatchExceptionWhenSchedulesDoesntMatches() {
//        student.setSchedule(ScheduleEnum.DIURNO);
//        subject.setSchedule(ScheduleEnum.NOTURNO);
//        Assertions.assertThrows(SchedulesDoesntMatchException.class, () -> {
//        	coordination.addStudentIntoSubject(student, subject);
//        });
//    }
//
//	@Test
//	public void shouldaddTeacherIntoSubject() {
//
//		coordination.addTeacherIntoSubject(teacher, subject);
//		Assertions.assertEquals(teacher, subject.getTeacher());
//	}
//
//	@Test
//    public void shouldThrowSubjectNotOfferedExceptionWhenSubjectIsntOffered2() {
//        subject.setIsOffered(false);
//        Assertions.assertThrows(SubjectNotOfferedException.class, () -> {
//        	coordination.addTeacherIntoSubject(teacher, subject);
//        });
//    }
//
//	@Test
//    public void shouldThrowSchedulesDoesntMatchExceptionWhenSchedulesDoesntMatches2() {
//        teacher.setSchedule(ScheduleEnum.DIURNO);
//        subject.setSchedule(ScheduleEnum.NOTURNO);
//        Assertions.assertThrows(SchedulesDoesntMatchException.class, () -> {
//        	coordination.addTeacherIntoSubject(teacher, subject);
//        });
//    }
//
//	@Test
//	public void shouldReturnQuantityOfTheStudents() {
//
//		Student student2 = new Student("Lucas", 20, "lucas@uepb.com", "83943214321", ScheduleEnum.INTEGRAL);
//
//		coordination.addStudentIntoSubject(student, subject);
//		coordination.addStudentIntoSubject(student2, subject);
//
//		Assertions.assertEquals(2, coordination.getAlumnsQtt(subject));
//	}
//
//
}
