package org.opentmf.v4.tmf632.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;

/**
 * Reference of a tax definition. A tax is levied by an authorized tax
 * jurisdiction. There are many different types of tax (Federal Tax levied by
 * the US Government, State Tax levied by the State of California,…).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
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
    defaultImpl = TaxDefinition.class
)
public class TaxDefinition extends Extensible {

  /**
   * Unique identifier of the tax.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Tax name.
   */
  private @SafeText String name;

  /**
   * Type of the tax.
   */
  private @SafeText String taxType;

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;
}