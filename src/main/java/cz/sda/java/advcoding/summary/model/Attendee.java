package cz.sda.java.advcoding.summary.model;

import lombok.Builder;

@Builder
public record Attendee(Boolean attended, boolean succeeded, Person person, Training training) {
}
