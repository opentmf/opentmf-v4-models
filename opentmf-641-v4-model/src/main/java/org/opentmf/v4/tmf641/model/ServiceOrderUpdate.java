package org.opentmf.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Skipped properties:
 * id,href,orderDate,jeopardyAlert,errorMessage,milestone,{@literal @}baseType,{@literal @}schemaLocation,{@literal @}type,cancellationDate,cancellationReason,category,completionDate,startDate.
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ServiceOrderUpdate.class
)
public class ServiceOrderUpdate extends ServiceOrderBase {

  /**
   * Expected delivery date amended by the provider.
   */
  private OffsetDateTime expectedCompletionDate;

  /**
   * State of the order: described in the state-machine diagram.
   *
   * @see org.opentmf.v4.tmf641.model.ServiceOrderStateType
   */
  private @SafeText String state;
}