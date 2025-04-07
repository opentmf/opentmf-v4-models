package org.opentmf.v4.tmf681.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.RelatedParty;

/**
 * Sender of the communication message.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-681: Communication Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = Sender.class
)
public class Sender extends Extensible {

  /**
   * ID of the sender.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Sender address of email, if the communication type is email.
   */
  private @SafeText String email;

  /**
   * Name of the sender.
   */
  private @SafeText String name;

  /**
   * Phone number of the sender, if the communication type is SMS.
   */
  private @SafeText String phoneNumber;

  private @Valid RelatedParty party;
}