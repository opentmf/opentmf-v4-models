package org.opentmf.v4.customer.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * Credit profile for the party (containing credit scoring, ...). By default,
 * only the current credit profile is retrieved. It can be used as a list to
 * give the party credit profiles history, the first one in the list will be the
 * current one.
 *
 * <p><br/>
 * <strong>Required:</strong> creditProfileDate, validFor<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-629: Customer Management API</li>
 *   <li>TMF-669: Party Role Management API</li>
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
    defaultImpl = CreditProfile.class
)
@Required(fields = {"creditProfileDate", "validFor"})
public class CreditProfile extends Extensible {

  /**
   * The date the profile was established.
   */
  private OffsetDateTime creditProfileDate;

  /**
   * This is an integer whose value is used to rate the risk.
   */
  private Integer creditRiskRating;

  /**
   * A measure of a person or organizations creditworthiness calculated on the
   * basis of a combination of factors such as their income and credit history.
   */
  private Integer creditScore;

  /**
   * The period for which the profile is valid.
   */
  private @Valid TimePeriod validFor;
}