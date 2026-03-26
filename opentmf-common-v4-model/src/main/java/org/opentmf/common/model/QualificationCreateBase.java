package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-645: Service Qualification Management API</li>
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
    defaultImpl = QualificationCreateBase.class
)
public abstract class QualificationCreateBase extends Extensible implements IQualificationCreateBase {

  /**
   * Description of the serviceQualification.
   */
  private @SafeText String description;

  /**
   * A date (DateTime). Deadline date when the requester expected a qualification
   * answer.
   */
  private OffsetDateTime expectedQualificationDate;

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
}