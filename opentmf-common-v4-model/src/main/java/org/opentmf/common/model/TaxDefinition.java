package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Reference of a tax definition. A tax is levied by an authorized tax
 * jurisdiction. There are many different types of tax (Federal Tax levied by
 * the US Government, State Tax levied by the State of California,…).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-713: Work Management</li>
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
    defaultImpl = TaxDefinition.class
)
public class TaxDefinition extends Extensible implements ITaxDefinition {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  /**
   * Unique identifier of the tax.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Level of the jurisdiction that levies the tax.
   */
  private @SafeText String jurisdictionLevel;

  /**
   * Name of the jurisdiction that levies the tax.
   */
  private @SafeText String jurisdictionName;

  /**
   * Tax name.
   */
  private @SafeText String name;

  /**
   * Type of the tax.
   */
  private @SafeText String taxType;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}