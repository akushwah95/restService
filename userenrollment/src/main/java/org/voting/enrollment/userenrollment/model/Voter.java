package org.voting.enrollment.userenrollment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Voter {
	String fingerPrint;
	String hasVotedTo;
	public String getHasVotedTo() {
		return hasVotedTo;
	}
	public void setHasVotedTo(String hasVotedTo) {
		this.hasVotedTo = hasVotedTo;
	}
	public String getFingerPrint() {
		return fingerPrint;
	}
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	

}
