package sis.report;

import java.util.*;
import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

public class CourseReport {
	private List<CourseSession> sessions = new ArrayList<CourseSession>();

	 void add(CourseSession session) {
		sessions.add(session); 
	}

	String getReport() {
		Collections.sort(sessions);
		StringBuilder builder = new StringBuilder();
		writeBody(builder);
		return builder.toString();
	}
	void writeBody(StringBuilder builder){
		for (CourseSession session: sessions){
			builder.append(session.getCourse().getDepartment());
			builder.append(" ");
			builder.append(session.getCourse().getNumber().toString() + 
					NEWLINE);
		}
	}
}