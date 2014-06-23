package sis.report;

import java.io.*;

import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

class RosterReport {
	static final String ROSTER_REPORT_HEADER =
			"Student" + NEWLINE +
			"-------" + NEWLINE;
	static final String ROSTER_REPORT_FOOTER =
			NEWLINE + "# students = ";

	private Session session;
	private Writer writer;

	RosterReport(Session session) {
		this.session = session;
	}

	void writeReport(Writer writer) throws IOException  {
		this.writer = writer;
		writeHeader();
		writeBody();
		writeFooter();
	}

	void writeHeader() throws IOException {
		writer.write(ROSTER_REPORT_HEADER);
	}

	void writeBody() throws IOException {
		for (Student student: session.getAllStudents()) {
			writer.write(student.getName());
			writer.write(NEWLINE);
		}
	}

	void writeFooter() throws IOException {
		writer.write(
				ROSTER_REPORT_FOOTER + session.getAllStudents().size() + NEWLINE);
	}

	public void writeReport(String fileName) throws IOException {
		Writer bufferedWriter = new BufferedWriter(new FileWriter(fileName));
		try{
			writeReport(bufferedWriter);
		}
		finally{
			bufferedWriter.close();
		}
	}
}