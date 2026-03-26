package org.opentmf.tmf728.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AccountBalance;
import org.opentmf.common.model.BillingAccountRef;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The DunningCase represents a type of cases open for a customer. Whenever a
 * customer enters the dunning process, a dunning case is linked to his customer
 * account debt and it contains all details pertaining to the debt, such as
 * dunning case rules, interactions… The status of a dunning case evolves
 * according to internal or external events (payments made by the customer,
 * payment schedule granted…)
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-728: Dunning Case Management</li>
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
    defaultImpl = DunningCaseUpdate.class
)
public class DunningCaseUpdate extends Extensible implements IDunningCaseUpdate {

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * A categorization of a Dunning Case. It could be either "HardDunning" or
   * "SoftDunning".
   */
  private @SafeText String category;

  /**
   * The date on which the dunning case was created.
   */
  private OffsetDateTime creationDate;

  /**
   * A detailed description of the dunning case.
   */
  private @SafeText String description;

  /**
   * List of: The Dunning Case Rule represents an action performed by the company
   * (or on its behalf) to recover a debt.
   */
  @JsonProperty("dunningCaseRule")
  private List<@Valid DunningCaseRule> dunningCaseRules;

  /**
   * A dunning scenario reference.
   */
  private @Valid DunningScenarioRef dunningScenario;

  /**
   * Balances linked to the account.
   */
  private @Valid AccountBalance finalBalance;

  /**
   * Balances linked to the account.
   */
  private @Valid AccountBalance initialBalance;

  /**
   * The date and time that the dunning case had its latest activity.
   */
  private OffsetDateTime lastActivityDate;

  /**
   * The date and time that the dunning case was last updated.
   */
  private OffsetDateTime lastUpdateDate;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("note")
  private List<@Valid Characteristic> notes;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * The current status of the dunning case.
   */
  private @SafeText String status;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}