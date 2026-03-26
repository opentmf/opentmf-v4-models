package org.opentmf.tmf645.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * ServiceQualification is used to perform a technical eligibility. It allows to
 * retrieve a list of services that are technically available in the context of
 * the interaction (place, party, service characteristics, ...).
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
    defaultImpl = ServiceQualification.class
)
public class ServiceQualification extends Entity implements IServiceQualification {

  /**
   * Description of the serviceQualification.
   */
  private @SafeText String description;

  /**
   * Effective date to serviceQualification completion.
   */
  private OffsetDateTime effectiveQualificationDate;

  /**
   * Date when the requester expect to provide an answer for the qualification
   * request.
   */
  private OffsetDateTime estimatedResponseDate;

  /**
   * A date (DateTime). Deadline date when the requester expected a qualification
   * answer.
   */
  private OffsetDateTime expectedQualificationDate;

  /**
   * Date when the qualification response expires.
   */
  private OffsetDateTime expirationDate;

  /**
   * Identifier provided by the requester.
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

  /**
   * An indicator which when the value is "true" means that requester expects to
   * get qualifcation result immediately in the response. If the indicator is true
   * then the response code of 200 indicates the operation is successful otherwise
   * a task is created with a response 201.
   */
  private Boolean instantSyncQualification;

  /**
   * A list of related party references, defines party or party role linked to
   * this request.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}