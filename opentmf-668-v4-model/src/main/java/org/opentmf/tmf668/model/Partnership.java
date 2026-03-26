package org.opentmf.tmf668.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Partner;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.partner.model.RoleSpecification;

/**
 * A partnership represents a formalized collaboration between various parties,
 * each party playing a role in the partnership. The parties playing a role in
 * the partnership represented by the Partner entity. The structure of a
 * partnership is specified by a PartnershipSpecification which contain all the
 * information for the setup of the partnership, including the list of
 * identified roles and the agreement that should apply.
 *
 * <p><br/>
 * <strong>Required:</strong> name, specification<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-668: Partnership Type</li>
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
    defaultImpl = Partnership.class
)
@Required(fields = {"name", "specification"})
public class Partnership extends RoleSpecification implements IPartnership {

  /**
   * The list of partners of the partnership, where a partner represents a party
   * playing a given role. Hence a partner structure includes primarily a
   * reference to the engaged party and a role name matching necessarily the name
   * of one of the role specifications defined in the specification of the
   * partnership.
   */
  @JsonProperty("partner")
  private List<@Valid Partner> partners;

  /**
   * PartnershipSpecification reference. A partnership specification contains all
   * the information for the setup of a partnership of a given kind. This includes
   * the list of identified role types for the partnership with the corresponding
   * agreement specifications.
   */
  private @Valid PartnershipSpecificationRef specification;
}