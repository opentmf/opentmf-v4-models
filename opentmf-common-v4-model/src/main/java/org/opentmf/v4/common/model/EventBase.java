package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The base event that has addressable fields.
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class EventBase {

  /**
   * The identifier of the notification.
   */
  @SafeId
  @Size(max = 100)
  private String eventId;

  /**
   * Time of the event occurrence.
   */
  private OffsetDateTime eventTime;

  /**
   * The type of the notification.
   */
  private @SafeText String eventType;

  /**
   * The correlation id for this event.
   */
  @SafeId
  @Size(max = 100)
  private String correlationId;

  /**
   * The domain of the event.
   */
  private @SafeText String domain;

  /**
   * The title of the event.
   */
  private @SafeText String title;

  /**
   * An explanatory description of the event.
   */
  private @SafeText String description;

  /**
   * A priority.
   */
  private @SafeText String priority;

  /**
   * The time the event occurred.
   */
  @JsonProperty("timeOcurred")
  private OffsetDateTime timeOccurred;
}