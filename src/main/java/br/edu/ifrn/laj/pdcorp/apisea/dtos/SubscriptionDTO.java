package br.edu.ifrn.laj.pdcorp.apisea.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.laj.pdcorp.apisea.models.Activity;
import br.edu.ifrn.laj.pdcorp.apisea.models.Subscription;

public class SubscriptionDTO {

	private Long id;
	private LocalDateTime lastChangeDate;

	private UserDTO user;

	private EventDTO event;
	
	private List<Activity> activities;
	
	public SubscriptionDTO() {
		super();
	}

	public SubscriptionDTO(Long id, LocalDateTime lastChangeDate, UserDTO user, EventDTO event, List<Activity> activities) {
		this();
		this.id = id;
		this.lastChangeDate = lastChangeDate;
		this.user = user;
		this.event = event;
		this.activities = activities;
	}
	
	public SubscriptionDTO(Subscription subscription) {
		this(subscription.getId(),
				subscription.getLastChangeDate(),
				UserDTO.convertFromModel(subscription.getUser()),
				EventDTO.convertFromModel(subscription.getEvent()),
				subscription.getActivities());
	}
	
	public static SubscriptionDTO convertFromModel(Subscription subscription) {
		return new SubscriptionDTO(subscription);
	}
	
	public static List<SubscriptionDTO> convertFromModel(List<Subscription> subscriptions){
		List<SubscriptionDTO> result = new ArrayList<SubscriptionDTO>();
		
		for(Subscription s : subscriptions)
			result.add(SubscriptionDTO.convertFromModel(s));
		
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getLastChangeDate() {
		return lastChangeDate;
	}

	public void setLastChangeDate(LocalDateTime lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public EventDTO getEvent() {
		return event;
	}

	public void setEvent(EventDTO event) {
		this.event = event;
	}

	public List<Activity> getActivities() {
		return activities;
	}
	
	

}
