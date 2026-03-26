package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Represents our registration of information used as proof of identity by an
 * individual (passport, national identity card, drivers license, social
 * security number, birth certificate).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-691: Federated ID Management API</li>
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
    defaultImpl = IndividualIdentification.class
)
public class IndividualIdentification extends Extensible implements IIndividualIdentification {

  /**
   * An attachment by value or by reference. An attachment complements the
   * description of an element, for example through a document, a video, a
   * picture.
   */
  private @Valid AttachmentRefOrValue attachment;

  /**
   * Identifier.
   */
  @SafeId
  @Size(max = 100)
  private String identificationId;

  /**
   * Identification type (passport, national identity card, drivers license,
   * social security number, birth certificate).
   */
  private @SafeText String identificationType;

  /**
   * Authority which has issued the identifier, such as: social security, town
   * hall.
   */
  private @SafeText String issuingAuthority;

  /**
   * Date at which the identifier was issued.
   */
  private OffsetDateTime issuingDate;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}