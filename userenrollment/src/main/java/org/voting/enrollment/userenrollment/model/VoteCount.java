package org.voting.enrollment.userenrollment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VoteCount {
	String count;
	  String hasVotedTo;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getHasVotedTo() {
		return hasVotedTo;
	}
	public void setHasVotedTo(String hasVotedTo) {
		this.hasVotedTo = hasVotedTo;
	}

}
