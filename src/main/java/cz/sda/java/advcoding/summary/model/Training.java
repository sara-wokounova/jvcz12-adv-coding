package cz.sda.java.advcoding.summary.model;

import lombok.Builder;

import java.util.Date;
import java.util.List;


@Builder
public record Training(String location, Date date, List<Attendee> attendees, TrainingType type) {
}
