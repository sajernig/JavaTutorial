/*-------------------------------------------------------------------------------------------------
| *** UNCLASSIFIED ***
|--------------------------------------------------------------------------------------------------
| U.S. Army Research, Development, and Engineering Command
| Aviation and Missile Research, Development, and Engineering Center
| Software Engineering Directorate, Redstone Arsenal, AL
|--------------------------------------------------------------------------------------------------
| Export-Control Act Warning: Warning - This Document contains technical data whose export is
| restricted by the Arms Export Control Act (Title 22, U.S.C., Sec 2751, et seq) or the Export
| Administration Act of 1979, as amended, Title 50, U.S.C., App. 2401 et seq. Violations of these
| export laws are subject to severe criminal penalties. Disseminate in accordance with provisions
| of DoD Directive 5230.25.
|--------------------------------------------------------------------------------------------------
| Distribution Statement C:  Distribution authorized to U.S. Government Agencies and their
| contractors, Export Controlled, Critical Technology, 13 Feb 2017. Other request for this document
| shall be referred to U.S. Army Aviation and Missile Research Development and Engineering Center
| Software Engineering Directorate, Attn: RDMR-BAW, Redstone Arsenal, AL 35898.
--------------------------------------------------------------------------------------------------*/

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

  //list is working as a database
  List<Student> students;

  public StudentDaoImpl(){
    students = new ArrayList<Student>();
    Student student1 = new Student("Robert",0);
    Student student2 = new Student("John",1);
    students.add(student1);
    students.add(student2);
  }
  @Override
  public void deleteStudent(Student student) {
    students.remove(student.getRollNo());
    System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
  }

  //retrive list of students from the database
  @Override
  public List<Student> getAllStudents() {
    return students;
  }

  @Override
  public Student getStudent(int rollNo) {
    return students.get(rollNo);
  }

  @Override
  public void updateStudent(Student student) {
    students.get(student.getRollNo()).setName(student.getName());
    System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
  }
}
