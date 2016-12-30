package com.deckard.noyau.core.model.request;

import org.mongodb.morphia.annotations.Entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "typeRequestAction")
@Entity("RequestAction")
public abstract class AbstractRequestAction extends AbstractRequest {

}
