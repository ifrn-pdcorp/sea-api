package br.edu.ifrn.laj.pdcorp.apisea.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.edu.ifrn.laj.pdcorp.apisea.models.Activity;
import br.edu.ifrn.laj.pdcorp.apisea.models.Event;

public class EventDTO {

	private Long id;

	@NotBlank
	private String name;

	@NotNull
	private String local;

	@NotNull
	private String theme;

	@NotBlank
	private String summary;

	private String thumbPath;

	@NotNull
	private LocalDateTime subscriptionStart;

	private List<Activity> activities;

	@NotNull
	private LocalDateTime subscriptionEnd;

	@NotNull
	private LocalDateTime dateEvent;

	public EventDTO() {
		super();
	}

	public EventDTO(@NotNull Long id, @NotBlank String name, @NotBlank String local, @NotBlank String theme,
			@NotBlank String summary, String thumbPath, List<Activity> activities,
			@NotNull LocalDateTime subscriptionStart, @NotNull LocalDateTime subscriptionEnd,
			@NotNull LocalDateTime dateEvent) {

		this();
		this.id = id;
		this.name = name;
		this.local = local;
		this.theme = theme;
		this.summary = summary;
		this.thumbPath = thumbPath;
		this.subscriptionStart = subscriptionStart;
		this.subscriptionEnd = subscriptionEnd;
		this.dateEvent = dateEvent;
		this.activities = activities;
	}

	public EventDTO(Event event) {
		this(event.getId(), event.getName(), event.getLocal(), event.getTheme(), event.getSummary(),
				event.getThumbPath(), event.getActivities(), event.getSubscriptionStart(), event.getSubscriptionEnd(),
				event.getDateEvent());
	}

	public static EventDTO convertFromModel(Event event) {
		return new EventDTO(event);
	}

	public static List<EventDTO> convertFromModel(List<Event> events) {
		List<EventDTO> result = new ArrayList<EventDTO>();

		for (Event e : events) {
			result.add(EventDTO.convertFromModel(e));
		}

		return result;
	}

	public Event convertToModel() {
		return new Event(this.getId(), this.getName(), this.getLocal(), this.getTheme(), this.getSummary(),
				this.getThumbPath(), this.getActivities(), this.getSubscriptionStart(), this.getSubscriptionEnd(),
				this.getDateEvent());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getThumbPath() {
		return thumbPath;
	}

	public void setThumbPath(String thumbPath) {
		this.thumbPath = thumbPath;
	}

	public LocalDateTime getSubscriptionStart() {
		return subscriptionStart;
	}

	public void setSubscriptionStart(LocalDateTime subscriptionStart) {
		this.subscriptionStart = subscriptionStart;
	}

	public LocalDateTime getSubscriptionEnd() {
		return subscriptionEnd;
	}

	public void setSubscriptionEnd(LocalDateTime subscriptionEnd) {
		this.subscriptionEnd = subscriptionEnd;
	}

	public LocalDateTime getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(LocalDateTime dateEvent) {
		this.dateEvent = dateEvent;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

}
