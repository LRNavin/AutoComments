public static Map<String,Object> generateReqsFromCancelledPOItems(DispatchContext VAR0,Map<String,? extends Object> VAR1){
  Delegator delegator=VAR0.getDelegator();
  LocalDispatcher dispatcher=VAR0.getDispatcher();
  GenericValue userLogin=(GenericValue)VAR1.get("userLogin");
  Locale locale=(Locale)VAR1.get("locale");
  String orderId=(String)VAR1.get("orderId");
  String facilityId=(String)VAR1.get("facilityId");
  try {
    GenericValue orderHeader=EntityQuery.use(delegator).from("OrderHeader").where("orderId",orderId).queryOne();
    if (UtilValidate.isEmpty(orderHeader)) {
      String errorMessage=UtilProperties.getMessage(resource_error,"OrderErrorOrderIdNotFound",UtilMisc.toMap("orderId",orderId),locale);
      Debug.logError(errorMessage,module);
      return ServiceUtil.returnError(errorMessage);
    }
    if (!"PURCHASE_ORDER".equals(orderHeader.getString("orderTypeId"))) {
      String errorMessage=UtilProperties.getMessage(resource_error,"ProductErrorOrderNotPurchaseOrder",UtilMisc.toMap("orderId",orderId),locale);
      Debug.logError(errorMessage,module);
      return ServiceUtil.returnError(errorMessage);
    }
    Map<String,Object> productRequirementQuantities=new HashMap<String,Object>();
    List<GenericValue> orderItems=orderHeader.getRelated("OrderItem",null,null,false);
    for (    GenericValue orderItem : orderItems) {
      if (!"PRODUCT_ORDER_ITEM".equals(orderItem.getString("orderItemTypeId")))       continue;
      BigDecimal orderItemCancelQuantity=BigDecimal.ZERO;
      if (!UtilValidate.isEmpty(orderItem.get("cancelQuantity"))) {
        orderItemCancelQuantity=orderItem.getBigDecimal("cancelQuantity");
      }
      if (orderItemCancelQuantity.compareTo(BigDecimal.ZERO) <= 0)       continue;
      String productId=orderItem.getString("productId");
      if (productRequirementQuantities.containsKey(productId)) {
        orderItemCancelQuantity=orderItemCancelQuantity.add((BigDecimal)productRequirementQuantities.get(productId));
      }
      productRequirementQuantities.put(productId,orderItemCancelQuantity);
    }
    for (    String productId : productRequirementQuantities.keySet()) {
      BigDecimal requiredQuantity=(BigDecimal)productRequirementQuantities.get(productId);
      Map<String,Object> createRequirementResult=dispatcher.runSync("createRequirement",UtilMisc.<String,Object>toMap("requirementTypeId","PRODUCT_REQUIREMENT","facilityId",facilityId,"productId",productId,"quantity",requiredQuantity,"userLogin",userLogin));
      if (ServiceUtil.isError(createRequirementResult))       return createRequirementResult;
    }
  }
 catch (  GenericEntityException e) {
    Debug.logError(e,module);
    return ServiceUtil.returnError(e.getMessage());
  }
catch (  GenericServiceException se) {
    Debug.logError(se,module);
    return ServiceUtil.returnError(se.getMessage());
  }
  return ServiceUtil.returnSuccess();
}
