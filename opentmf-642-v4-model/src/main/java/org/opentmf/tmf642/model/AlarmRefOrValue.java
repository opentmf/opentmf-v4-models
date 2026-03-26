package org.opentmf.tmf642.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Alarm;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An alarm defined by reference or value. The polymorphic attributes {@literal @}type,
 * {@literal @}schemaLocation & {@literal @}referredType are related to the alarm entity and not the
 * RelatedAlarmRefOrValue class itself.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-642: Alarm Management API</li>
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
    defaultImpl = AlarmRefOrValue.class
)
public class AlarmRefOrValue extends Alarm implements IAlarmRefOrValue {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  /**
   * Name of the related entity.
   */
  private @SafeText String name;
}