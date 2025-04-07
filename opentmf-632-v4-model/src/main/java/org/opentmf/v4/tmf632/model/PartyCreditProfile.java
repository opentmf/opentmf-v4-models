package org.opentmf.v4.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * An individual might be evaluated for its worthiness and this evaluation might
 * be based on a credit rating given by a credit agency.
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
    defaultImpl = PartyCreditProfile.class
)
public class PartyCreditProfile extends Extensible {

  /**
   * Name of the credit agency giving the score.
   */
  private @SafeText String creditAgencyName;

  /**
   * Type of the credit agency giving the score.
   */
  private @SafeText String creditAgencyType;

  /**
   * Reference corresponding to the credit rating.
   */
  private @SafeText String ratingReference;

  /**
   * A measure of a party’s creditworthiness calculated on the basis of a
   * combination of factors such as their income and credit history.
   */
  private Integer ratingScore;

  private @Valid TimePeriod validFor;
}