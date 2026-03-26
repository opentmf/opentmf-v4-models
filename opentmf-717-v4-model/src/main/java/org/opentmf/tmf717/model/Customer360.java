package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.customer.model.Customer;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> engagedParty<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-717: Customer360 Management API</li>
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
    defaultImpl = Customer360.class
)
@Required(fields = {"engagedParty"})
public class Customer360 extends Customer implements ICustomer360 {

  /**
   * List of: An Appointment is an arrangement to do something or meet someone at
   * a particular time, at a place (for face to face appointment) or in a contact
   * medium (for phone appointment).
   */
  @JsonProperty("appointment")
  private List<@Valid Customer360AppointmentVO> appointments;

  /**
   * List of: The customer bill. Can be a regular recurring bill or an extra bill
   * on demand by the customer or the csp.
   */
  @JsonProperty("customerBill")
  private List<@Valid Customer360CustomerBillVO> customerBills;

  /**
   * ID of Referred Customer.
   */
  @SafeId
  @Size(max = 100)
  private String customerId;

  /**
   * Customer Reference.
   */
  private @SafeText String customerRef;

  @JsonProperty("interactionItem")
  private List<@Valid Customer360PartyInteractionVO> interactionItems;

  /**
   * List of: A loyalty balance, containing a balance unit and value.
   */
  @JsonProperty("loyaltyBalance")
  private List<@Valid Customer360LoyaltyBalanceVO> loyaltyBalances;

  /**
   * List of: A Product Order is a type of order which can be used to place an
   * order between a customer and a service provider or between a service provider
   * and a partner and vice versa.
   */
  @JsonProperty("productOrder")
  private List<@Valid Customer360ProductOrderVO> productOrders;

  /**
   * List of: A product offering procured by a customer or other interested party
   * playing a party role. A product is realized as one or more service(s) and /
   * or resource(s).
   */
  @JsonProperty("productValue")
  private List<@Valid Customer360ProductValueVO> productValues;

  /**
   * List of: Promotion Resource is used to provide the additional discount,
   * voucher, bonus or gift to the customer who meets the pre-defined criteria.
   * Using promotion, the enterprise is able to attract the users and encourage
   * more consumption, especially continuous purchases.  Normally Promotion is not
   * regarded as one type of product or product offering. It is often applied when
   * the customer buys the product offerings with the price or amount surpassing
   * the certain limit.
   */
  @JsonProperty("promotion")
  private List<@Valid Customer360PromotionVO> promotions;

  /**
   * List of: Quote can be used to negotiate service and product acquisition or
   * modification between a customer and a service provider. Quote contain list of
   * quote items, a reference to customer (partyRole), a list of productOffering
   * and attached prices and conditions.
   */
  @JsonProperty("quote")
  private List<@Valid Customer360QuoteVO> quotes;

  /**
   * List of: Recommendation API is used to recommend offering quickly based on
   * the history and real-time context of customer. It is a real-time and
   * personalized recommendation API. It is usually provided by e-commerce or BSS,
   * CRM system in omni-channel.
   */
  @JsonProperty("recommendation")
  private List<@Valid Customer360RecommendationVO> recommendations;

  /**
   * List of: The problem information for Middle B which is abstracted in the
   * service layer from the issued event information by First B.
   */
  @JsonProperty("serviceProblem")
  private List<@Valid Customer360ServiceProblemVO> serviceProblems;

  /**
   * List of: A trouble ticket is a record of an issue that is created, tracked,
   * and managed by a trouble ticket management system.
   */
  @JsonProperty("troubleTicket")
  private List<@Valid Customer360TroubleTicketVO> troubleTickets;
}