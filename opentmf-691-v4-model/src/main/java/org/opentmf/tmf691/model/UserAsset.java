package org.opentmf.tmf691.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entitlement;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> entityType, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-691: Federated ID Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"entityType", "id"})
public class UserAsset implements IUserAsset {

  /**
   * Second level to define the type of managed element for
   * product/service/resource managed entities (e.g.: mobile line subscription,
   * video platform license, mobile equipment, etc). Allows identifying the
   * specific asset within the server referenced. Supported values are
   * implementation and application specific. Other values can be added if those
   * listed are not enough.
   */
  private @SafeText String assetType;

  /**
   * information about individual entitlements to define access levels to operate
   * over different functions that can be defined in an asset.
   */
  @JsonProperty("entitlement")
  private List<@Valid Entitlement> entitlements;

  /**
   * Type of managed entity (e.g.: product, resource, service, customer, account).
   */
  private @SafeText String entityType;

  /**
   * Unique identifier of referenced entity within the entity/asset pair
   * (customerId, accountId, mobile line number, ...).
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Represents the part played by an individual in relation to being granted a
   * set of entitlements for manageable assets (e.g.: owner, user, viewer, ...).
   */
  private @SafeText String role;
}