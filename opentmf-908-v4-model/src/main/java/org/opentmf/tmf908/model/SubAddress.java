package org.opentmf.tmf908.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Representation of a SubAddress 
 * <br/>It is used for addressing within a property in an urban area (country
 * properties are often defined differently). It may refer to a building, a
 * building cluster, or a floor of a multistory building.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
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
    defaultImpl = SubAddress.class
)
public class SubAddress extends NamedEntity implements ISubAddress {

  /**
   * Allows for buildings that have well-known names.
   */
  private @SafeText String buildingName;

  /**
   * Used where a level type may be repeated e.g. BASEMENT 1, BASEMENT 2.
   */
  private @SafeText String levelNumber;

  /**
   * Describes level types within a building.
   */
  private @SafeText String levelType;

  /**
   * Private streets internal to a property (e.g. a university) may have internal
   * names that are not recorded by the land title office.
   */
  private @SafeText String privateStreetName;

  /**
   * Private streets numbers internal to a private street.
   */
  private @SafeText String privateStreetNumber;

  /**
   * The type of subaddress : it can be a subunit or a private street.
   */
  private @SafeText String subAddressType;

  /**
   * The discriminator of the subunit, often just a simple number e.g. FLAT 5, may
   * also be a range.
   */
  private @SafeText String subUnitNumber;

  /**
   * The type of subunit, such as BERTH, FLAT, PIER, SUITE, SHOP, TOWER, UNIT,
   * WHARF.
   */
  private @SafeText String subUnitType;
}