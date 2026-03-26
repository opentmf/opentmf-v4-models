package org.opentmf.tmf645.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * QueryServiceQualification is used to retrieve a list of services that are
 * technically available in the context of the interaction (place, party,
 * service characteristics, ...).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-645: Service Qualification Management API</li>
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
    defaultImpl = QueryServiceQualification.class
)
public class QueryServiceQualification extends ServiceQualification implements IQueryServiceQualification {

  /**
   * Date when the serviceQualification was submitted.
   */
  private OffsetDateTime queryServiceQualificationDate;

  /**
   * A ServiceQualificationItem relates to a specific service being checked in a
   * qualification operation.
   */
  private @Valid ServiceQualificationItem searchCriteria;

  /**
   * A list of service qualification items.
   */
  @JsonProperty("serviceQualificationItem")
  private List<@Valid ServiceQualificationItem> serviceQualificationItems;
}