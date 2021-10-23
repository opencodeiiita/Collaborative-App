package com.example.opencodecollaborative21app.classes;

import java.util.ArrayList;

public class Project {
	private String name;
	private String githubLink;
	private String description;
	private String liveLink;
	private int numberOfIssuesOpened;
	private int numberOfPROpened;
	private int numberOfPRMerged;
	private int numberOfPRClosed;
	private ArrayList<Mentor> mentors;
	private ArrayList<Participant> contributors;

	public Project(String name, String githubLink, String description) {
		this.name = name;
		this.githubLink = githubLink;
		this.description=description;
		contributors = new ArrayList<>();
		mentors = new ArrayList<>();
	}

	public String getName() { return name; }

	public void setName(String name) {
		this.name = name;
	}

	public String getGithubLink() {
		return githubLink;
	}

	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description= description;
	}

	public String getLiveLink() {
		return liveLink;
	}

	public void setLiveLink(String liveLink) {
		this.liveLink = liveLink;
	}

	public int getNumberOfIssuesOpened() {
		return numberOfIssuesOpened;
	}

	public void setNumberOfIssuesOpened(int numberOfIssuesOpened) {
		this.numberOfIssuesOpened = numberOfIssuesOpened;
	}

	public int getNumberOfPROpened() {
		return numberOfPROpened;
	}

	public void setNumberOfPROpened(int numberOfPROpened) {
		this.numberOfPROpened = numberOfPROpened;
	}

	public int getNumberOfPRMerged() {
		return numberOfPRMerged;
	}

	public void setNumberOfPRMerged(int numberOfPRMerged) {
		this.numberOfPRMerged = numberOfPRMerged;
	}

	public int getNumberOfPRClosed() {
		return numberOfPRClosed;
	}

	public void setNumberOfPRClosed(int numberOfPRClosed) {
		this.numberOfPRClosed = numberOfPRClosed;
	}

	public ArrayList<Mentor> getMentors() {
		return mentors;
	}

	public void setMentors(ArrayList<Mentor> mentors) {
		this.mentors = mentors;
	}

	public ArrayList<Participant> getContributors() {
		return contributors;
	}

	public void setContributors(ArrayList<Participant> contributors) {
		this.contributors = contributors;
	}

	public void addNewMentor(Mentor mentor) {
		this.mentors.add(mentor);
	}

	public void addNewContributor(Participant participant) {
		this.contributors.add(participant);
	}

}
