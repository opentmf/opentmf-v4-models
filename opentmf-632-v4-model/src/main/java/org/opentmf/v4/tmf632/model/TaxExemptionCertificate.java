package org.opentmf.v4.tmf632.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * A tax exemption certificate represents a tax exemption granted to a party
 * (individual or organization) by a tax jurisdiction which may be a city,
 * state, country,... An exemption has a certificate identifier (received from
 * the jurisdiction that levied the tax) and a validity period. An exemption is
 * per tax types and determines for each type of tax what portion of the tax is
 * exempted (partial by percentage or complete) via the tax definition.
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
    defaultImpl = TaxExemptionCertificate.class
)
public class TaxExemptionCertificate extends Extensible {

  /**
   * Unique identifier of the certificate of the tax exemption.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  private @Valid AttachmentRefOrValue attachment;

  /**
   * List of: Reference of a tax definition. A tax is levied by an authorized tax
   * jurisdiction. There are many different types of tax (Federal Tax levied by
   * the US Government, State Tax levied by the State of California,…).
   */
  @JsonProperty("taxDefinition")
  private List<@Valid TaxDefinition> taxDefinitions;

  private @Valid TimePeriod validFor;
}