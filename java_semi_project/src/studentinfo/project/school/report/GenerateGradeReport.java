package studentinfo.project.school.report;

import studentinfo.project.grade.*;
import studentinfo.project.school.*;
import studentinfo.project.utils.Define;

import java.util.*;

//학점에 대한 결과를 생성해주는 클래스
public class GenerateGradeReport {
    School school = School.getInstance();

    public static final String TITLE = "수강생 학점 \t\t\n";
    public static final String HEADER = "이름 | 학번 | 필수과목 | 점수 \n";
    public static final String LINE = "----------------------------\n";

    //문자열 연산을 빈번하게 하는 경우에는 메모리 효율을 위해 StringBuffer를 사용한다.
    private StringBuffer buffer = new StringBuffer();

    //성적 산출 결과의 헤더, 몸통, 푸터를 합쳐준다.
    public String getReport(){
        ArrayList<Subject> subjectList = school.getSubjectList();

        for (Subject subject : subjectList) {
            makeHeader(subject);
            makeBody(subject);
            makeFooter();
        }
        return buffer.toString(); //StringBuffer 타입의 데이터를 String 타입으로 바꿔준다.
    }

    public void makeHeader(Subject subject){
        buffer.append(GenerateGradeReport.LINE);
        buffer.append("\t" + subject.getSubjectName());
        buffer.append(GenerateGradeReport.TITLE);
    }
    public void makeBody(Subject subject){
        ArrayList<Student> studentList = subject.getStudentList();

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            buffer.append(student.getStudentName());
            buffer.append(" | ");
            buffer.append(student.getStudentId());
            buffer.append(" | ");
            buffer.append(student.getMajorSubject());
            buffer.append(" | ");

            //학생별 수강과목의 점수, 학점 출력
            getScoreGrader(student, subject.getSubjectId());
        }
    }
    public void makeFooter(){buffer.append("\n");}
    public void getScoreGrader(Student student, int subjectId){
        //해당 학생이 수강한 과목의 점수리스트(국어, 수학)
        ArrayList<Score> scoreList = student.getScoreList();

        //해당 학생의 필수과목 코드
        int majorId = student.getMajorSubject().getSubjectId();

        GradeEvalution[] gradeEvaluations = {new BasicEvaluation(), new MajorEvaluation()};

        for (int i = 0; i < scoreList.size(); i++) {
            Score score = scoreList.get(i);

            //과목코드가 같은지 확인
            if (score.getSubject().getSubjectId() == subjectId){
                String grade; //학점

                //필수과목일떄 학점 산출
                if (score.getSubject().getSubjectId() == majorId){
                    grade = gradeEvaluations[Define.SAB_TYPE].getGrade(score.getPoint());
                }else {
                    //일반과목
                    grade = gradeEvaluations[Define.AB_TYPE].getGrade(score.getPoint());
                }

                buffer.append(score.getPoint());
                buffer.append(":");
                buffer.append(grade);
                buffer.append(" | ");
            }
        }
    }
}
