package school


import grails.rest.*
import grails.converters.*

class StudentController extends RestfulController {
    static responseFormats = ['json', 'xml']
    StudentController() {
        super(Student)
    }
    // 1. Find the count of name of all student where subject is sports 
    def countStudents(){
      def subject = params.subject
    //   println(subject);
    //   respond Student.list()
    def students = Student.createCriteria()
    def results = students.list {
         createAlias 'teacherName', 'teachers'
         if(subject){
            eq('teachers.subject',subject)
             projections{
             property("name")
            } 
         }
  
    }

    def std = Student.createCriteria()
    def res = std.list{
    createAlias 'teacherName', 'teachers'
         if(subject){
            eq('teachers.subject',subject)
             projections{
            count("name");
            } 
         }
    }

    }

    //2. Display all maths student name along with section and rollNumber 

    def allMathsStd(){
        def subject = params.subject

        def creatria = Student.createCriteria()

        def result = creatria.list{
        createAlias 'teacherName', 'teachers'
           if(subject){
            eq('teachers.subject',subject)
            projections{
                property('name')
                property('section')
                property('rollNo')
            }
           }
        }
         render(view:'allMathsStd', model: [allMathsStd: result])
    }

  //  I want only student name column only
    def studentNameOnly(){

    def names=params.name;

    def results=Student.withCriteria{

        ilike('name', "%${names}%")   //case in-sensitive
       
    //  firstResult 20
     order "name", "desc"
    }
    render(view:'studentNameOnly', model:[studentNameOnly:results])
  }

   //I want student count value only 

   def studentCount(){

     def results=Student.withCriteria{

        projections{
            count("name")
        }
     }
     respond results
   }
 //I want particular teacher has count of student 

//  def teacherName(){
//     def subjects=params.subject;     

//     println(params.subject);
//     def std = Student.createCriteria()
//     def res = std.list{
//     createAlias 'teacherName', 'teachers'
//          if(subject){
//             eq('teachers.subject',subjects)
//              projections{
//              property("name");
//             } 
//          }
//           println(res)
//          respond res
//     }

//  }


// 1. Name of students which is starting form A 
def aStudent(){
  def name = params.name;
  println name;
  def criteria = Student.createCriteria();

  def res = creatria.list{
    like("name", "${names}%")
  }

  respond res;
}

}
