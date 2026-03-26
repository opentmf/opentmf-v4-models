package org.opentmf.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-641: Service Ordering Management API</li>
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
    defaultImpl = ServiceOrder.class
)
public class ServiceOrder extends ServiceOrderCreate implements IServiceOrder {

  /**
   * Effective delivery date amended by the provider.
   */
  private OffsetDateTime completionDate;

  /**
   * the error(s) cause an order status change.
   */
  @JsonProperty("errorMessage")
  private List<@Valid ServiceOrderErrorMessage> errorMessages;

  /**
   * Expected delivery date amended by the provider.
   */
  private OffsetDateTime expectedCompletionDate;

  /**
   * Hyperlink to access the order.
   */
  private URI href;

  /**
   * ID created on repository side.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A list of jeopardy alerts related to this order.
   */
  @JsonProperty("jeopardyAlert")
  private List<@Valid ServiceOrderJeopardyAlert> jeopardyAlerts;

  /**
   * A list of milestones related to this order.
   */
  @JsonProperty("milestone")
  private List<@Valid ServiceOrderMilestone> milestones;

  private OffsetDateTime orderDate;

  /**
   * Date when the order was started for processing.
   */
  private OffsetDateTime startDate;

  /**
   * Possible values for the state of the order
   * <br/><p>Recommended values: acknowledged, rejected, pending, held,
   * inProgress, cancelled, completed, failed, partial, assessingCancellation,
   * pendingCancellation.
   *
   * @see org.opentmf.tmf641.model.ServiceOrderStateType
   */
  private @SafeText String state;
}