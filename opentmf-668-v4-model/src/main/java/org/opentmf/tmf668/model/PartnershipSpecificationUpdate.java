package org.opentmf.tmf668.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A partnership specification contains all the information for the setup of a
 * partnership of a given kind. This includes the list of identified role types
 * for the partnership with the corresponding agreement specifications.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
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
    defaultImpl = PartnershipSpecificationUpdate.class
)
@Required(fields = {"name"})
public class PartnershipSpecificationUpdate extends Extensible implements IPartnershipSpecificationUpdate {

  /**
   * An explanatory text regarding this partnership specification.
   */
  private @SafeText String description;

  /**
   * An identifying name for the partnership specification.
   */
  private @SafeText String name;

  /**
   * The list of roles specifications a engaged party will be able to play for
   * this kind of partnership.
   */
  @JsonProperty("roleSpecification")
  private List<@Valid PartnershipRoleSpecification> roleSpecifications;
}