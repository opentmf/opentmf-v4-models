package org.opentmf.tmf681.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Attachment;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Communication message means a notification approach in the format of a
 * message which can be dispatched (sent) to the certain user by the system with
 * the content which can be felt and understood by the recipient. The user can
 * be either a final customer or a customer service agent. The message can reach
 * the customer in different interaction channels, including: email, short
 * message, mobile app notification (push).
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> content, messageType, receiver, sender<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-681: Communication Management API</li>
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
    defaultImpl = CommunicationMessageCreate.class
)
@Required(fields = {"messageType", "receiver", "sender", "content"})
public class CommunicationMessageCreate extends Extensible implements ICommunicationMessageCreate {

  /**
   * Any attachment associated with this message.
   */
  @JsonProperty("attachment")
  private List<@Valid Attachment> attachments;

  /**
   * Any additional characteristic(s) of this message.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * The content of the communication message.
   */
  private @SafeText String content;

  /**
   * Description for the whole object.
   */
  private @SafeText String description;

  private Boolean logFlag;

  /**
   * The type of message, such as: SMS, Email, Mobile app push notification.
   */
  private @SafeText String messageType;

  /**
   * The priority of the communication message.
   * <br/>Small number means higher priority.
   */
  private @SafeText String priority;

  /**
   * The receiver(s) of this message.
   */
  @JsonProperty("receiver")
  private @Size(min = 1) List<@Valid Receiver> receivers;

  /**
   * The scheduled time for sending the communication message.
   */
  private OffsetDateTime scheduledSendTime;

  /**
   * The time of sending communication message.
   */
  private OffsetDateTime sendTime;

  /**
   * The time of completion of sending communication message.
   */
  private OffsetDateTime sendTimeComplete;

  /**
   * Sender of the communication message.
   */
  private @Valid Sender sender;

  /**
   * Communication message state type
   * <br/><p>Recommended values: initial, inProgress, completed, cancelled,
   * failed.
   *
   * @see org.opentmf.tmf681.model.CommunicationMessageStateType
   */
  private @SafeText String state;

  /**
   * The title of the message, necessary for the email and mobile app push.
   */
  private @SafeText String subject;

  /**
   * How many times do you want to retry the delivery of this message?.
   */
  private Integer tryTimes;
}