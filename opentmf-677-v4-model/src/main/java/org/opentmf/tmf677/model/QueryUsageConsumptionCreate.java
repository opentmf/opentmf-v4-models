package org.opentmf.tmf677.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.PartyAccountRef;
import org.opentmf.common.model.RelatedParty;

/**
 * An QueryUsageConsumption allows to manage the calculation request of an usage
 * consumption
 * <br/>Skipped properties: id,href,usageConsumption.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-677: Usage Consumption Management API</li>
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
    defaultImpl = QueryUsageConsumptionCreate.class
)
public class QueryUsageConsumptionCreate extends Extensible implements IQueryUsageConsumptionCreate {

  /**
   * A reference to the account that owns the bucket.
   */
  @JsonProperty("partyAccount")
  private List<@Valid PartyAccountRef> partyAccounts;

  /**
   * Date when the query was submitted.
   */
  private OffsetDateTime queryUsageConsumptionDate;

  /**
   * Reference and role of the related parties for which the usage consumption is
   * requested.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * An usage consumption enables to know at a given point the balances and the
   * consumption counters related to various buckets (SMS, Voice, Data for
   * example). It could be calculated for a device identified by a public key
   * (msisdn number for a mobile device for example or PSTN or VOIP number for a
   * fix device), for a subscribed offer or option or for an user.
   */
  private @Valid UsageConsumption searchCriteria;
}