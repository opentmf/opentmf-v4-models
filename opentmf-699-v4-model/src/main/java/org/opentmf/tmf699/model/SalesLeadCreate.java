package org.opentmf.tmf699.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CategoryRef;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.ContactMedium;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.MarketSegmentRef;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.Note;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.common.model.ProductRef;
import org.opentmf.common.model.ProductSpecificationRef;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A Sales Lead is the identification of a person or organization that has an
 * interest in the goods and/or services provided in the prospect of them
 * becoming Customers with one or more Subscriptions.
 * <br/>Skipped properties: id,href,status,creationDate,statusChangeDate.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-699: Sales Management API</li>
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
    defaultImpl = SalesLeadCreate.class
)
@Required(fields = {"name"})
public class SalesLeadCreate extends Extensible implements ISalesLeadCreate {

  /**
   * The category for grouping recommendations.
   */
  private @Valid CategoryRef category;

  /**
   * The channel to which the resource reference to. e.g. channel for selling
   * product offerings, channel for opening a trouble ticket etc..
   */
  private @Valid ChannelRef channel;

  /**
   * Unique description of the salesLead.
   */
  private @SafeText String description;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money estimatedRevenue;

  /**
   * provides references to the corresponding market segment as target of product
   * offerings. A market segment is grouping of Parties, GeographicAreas,
   * SalesChannels, and so forth.
   */
  private @Valid MarketSegmentRef marketSegment;

  /**
   * MarketingCampaign reference. Marketing campaign represents the
   * carrier-initiated marketing activity which aims at the better recognition
   * about its brand and offerings by the market.
   */
  private @Valid MarketingCampaignRef marketingCampaign;

  /**
   * Name of the salesLead.
   */
  private @SafeText String name;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Urgency of working this salesLead
   * <br/><p>Recommended values: low, medium, high.
   *
   * @see org.opentmf.tmf699.model.SalesLeadPriorityType
   */
  private @SafeText String priority;

  private @Valid ProductRef product;

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef productOffering;

  /**
   * Product specification reference: A ProductSpecification is a detailed
   * description of a tangible or intangible object made available externally in
   * the form of a ProductOffering to customers or other parties playing a party
   * role.
   */
  private @Valid ProductSpecificationRef productSpecification;

  /**
   * List of: Indicates the contact medium that could be used to contact the
   * party.
   */
  @JsonProperty("prospectContact")
  private List<@Valid ContactMedium> prospectContacts;

  /**
   * Identifies the potential of a salesLead for becoming a sale. Usual ratings
   * for qualified leads are: hot, warm, cold.
   */
  private @SafeText String rating;

  /**
   * Date when the prospect information was received (for example, from a trade
   * show).
   */
  private OffsetDateTime referredDate;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Sales Opportunity is an 'opportunity' to generate revenue from a Sales
   * Account or Sales Lead. Opportunities are the pending deals that need to be
   * tracked and on which Sales Team plans and executes Sales Activities (Events
   * and Tasks).
   */
  private @Valid SalesOpportunityRef salesOpportunity;

  /**
   * Reason why the status has changed.
   */
  private @SafeText String statusChangeReason;

  /**
   * Indicates the nature of the salesLead.
   */
  private @SafeText String type;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}