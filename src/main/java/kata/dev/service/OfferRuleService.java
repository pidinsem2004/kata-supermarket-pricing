package kata.dev.service;

import kata.dev.dao.DataAccess;
import kata.dev.entities.OfferRule;

import java.util.List;

public class OfferRuleService {

    private List<OfferRule>  offerRules = new DataAccess().getOfferRules();


    public List<OfferRule> getOfferRules() {
        return offerRules;
    }

    public void setOfferRules(List<OfferRule> offerRules) {
        this.offerRules = offerRules;
    }

    public void addOfferRule(OfferRule offerRule){
        if(offerRule==null || offerRule.getProductName()==null || offerRule.getProductName()=="" || offerRule.getOfferPrice()==0)
            throw  new RuntimeException("invalid Offer rule");
        else
             offerRules.add(offerRule);
    }





}
