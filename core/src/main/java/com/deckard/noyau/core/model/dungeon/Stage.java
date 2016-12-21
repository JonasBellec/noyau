package com.deckard.noyau.core.model.dungeon;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.ogm.datastore.document.options.AssociationStorage;
import org.hibernate.ogm.datastore.document.options.AssociationStorageType;
import org.hibernate.ogm.datastore.document.options.MapStorage;
import org.hibernate.ogm.datastore.document.options.MapStorageType;
import org.hibernate.ogm.datastore.mongodb.options.AssociationDocumentStorage;
import org.hibernate.ogm.datastore.mongodb.options.AssociationDocumentStorageType;
import org.hibernate.ogm.datastore.mongodb.options.ReadPreference;
import org.hibernate.ogm.datastore.mongodb.options.ReadPreferenceType;
import org.hibernate.ogm.datastore.mongodb.options.WriteConcern;
import org.hibernate.ogm.datastore.mongodb.options.WriteConcernType;

@Entity
@WriteConcern(WriteConcernType.JOURNALED)
@ReadPreference(ReadPreferenceType.PRIMARY_PREFERRED)
@AssociationStorage(AssociationStorageType.ASSOCIATION_DOCUMENT)
@AssociationDocumentStorage(AssociationDocumentStorageType.COLLECTION_PER_ASSOCIATION)
@MapStorage(MapStorageType.AS_LIST)
public class Stage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Type(type = "objectid")
	private String id;
	private String title;

	@ElementCollection
	private List<Square> listSquare;

	public Stage() {
		listSquare = new ArrayList<>();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the listSquare
	 */
	public List<Square> getListSquare() {
		return listSquare;
	}

	/**
	 * @param listSquare
	 *            the listSquare to set
	 */
	public void setListSquare(List<Square> listSquare) {
		this.listSquare = listSquare;
	}
}
