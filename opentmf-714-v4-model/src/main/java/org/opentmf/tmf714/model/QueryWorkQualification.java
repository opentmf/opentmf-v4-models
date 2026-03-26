package org.opentmf.tmf714.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * QueryWorkQualification is used to retrieve a list of units of work that are
 * valid in the context of the interaction.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-714: Work Qualification Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = QueryWorkQualification.class
)
public class QueryWorkQualification extends WorkQualification implements IQueryWorkQualification {

  /**
   * Date when the workQualification was submitted.
   */
  private OffsetDateTime queryWorkQualificationDate;

  /**
   * A WorkQualificationItem relates to a specific unit of work being checked in a
   * qualification operation.
   */
  private @Valid WorkQualificationItem searchCriteria;

  /**
   * List of: A WorkQualificationItem relates to a specific unit of work being
   * checked in a qualification operation.
   */
  @JsonProperty("workQualificationItem")
  private List<@Valid WorkQualificationItem> workQualificationItems;
}