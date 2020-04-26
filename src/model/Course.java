package model;

public class Course {

	private String name;
	private int credits;
	private String curriculum;
	private String[] evaluation;
	private String startDate;

	public Course(String name, int credits, String curriculum, String[] evaluation, String startDate) {
		super();
		this.name = name;
		this.credits = credits;
		this.curriculum = curriculum;
		this.evaluation = evaluation;
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public String getEvaluation() {
		String result = "";
		for (String s : evaluation) {
			result += " | " + s + " | ";
		}
		return result;
	}

	public void setEvaluation(String[] evaluation) {
		this.evaluation = evaluation;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartSate(String startDate) {
		this.startDate = startDate;
	}

}
