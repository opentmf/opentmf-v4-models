package org.opentmf.tmf649.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-649: Performance Thresholding Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ThresholdJobUpdate implements IThresholdJobUpdate {

  private @SafeText String adminState;

  private OffsetDateTime creationTime;

  private @SafeText String executionState;

  private @SafeText String granularity;

  private Integer jobPriority;

  private OffsetDateTime lastModifiedTime;

  /**
   * List of: Monitored objects are specified by the MonitoredObjectsCriteria.
   */
  @JsonProperty("monitoredObjectsCriteria")
  private List<@Valid MonitoredObjectsCriteria> monitoredObjectsCriterias;

  /**
   * A threshold base entity containing threshold rules.
   */
  private @Valid Threshold performanceThreshold;

  /**
   * The schedule definition for running jobs.
   */
  private @Valid ScheduleDefinition scheduleDefinition;

  private @SafeText String trackingRecord;
}