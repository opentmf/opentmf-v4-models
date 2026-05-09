package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AgreementSpecificationRef;
import org.opentmf.common.model.RoleSpecification;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A PartyPrivacyRoleSpecification represents a specification of a role defined
 * in the context of a given privacy spesification, such as Customer, User.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-644: Privacy Management API</li>
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
    defaultImpl = PartyPrivacyRoleSpecification.class
)
@Required(fields = {"name"})
public class PartyPrivacyRoleSpecification extends RoleSpecification implements IPartyPrivacyRoleSpecification {

  /**
   * List of: Agreement specification reference. An AgreementSpecification
   * represents a template of an agreement that can be used when establishing
   * partnerships.
   */
  @JsonProperty("agreementSpecification")
  private List<@Valid AgreementSpecificationRef> agreementSpecifications;
}