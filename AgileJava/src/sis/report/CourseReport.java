package sis.report;

import java.util.*;
import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

class CourseReport {
	private ArrayList<CourseSession> sessions = new ArrayList<CourseSession>();

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
			builder.append(session.getDepartment());
			builder.append(" ");
			builder.append(session.getNumber().toString() + 
					NEWLINE);
		}
	}
}