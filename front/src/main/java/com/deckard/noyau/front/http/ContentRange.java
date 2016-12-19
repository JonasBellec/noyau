package com.deckard.noyau.front.http;

public class ContentRange {
	private int acceptedRange;
	private int borneInferieure;
	private int borneSuperieure;
	private long total;

	private ContentRange(ContentRange.Builder builder) {
		this.acceptedRange = builder.acceptedRange;
		this.borneInferieure = builder.borneInferieure;
		this.borneSuperieure = builder.borneSuperieure;
	}

	public boolean isPartialContent() {
		return borneSuperieure - borneInferieure + 1 < total;
	}

	public boolean isOk() {
		return borneSuperieure - borneInferieure + 1 == total;
	}

	/**
	 * Construit le header Content-range à partir des valeurs borneInferieure,
	 * borneSuperieure et total
	 * 
	 * @return
	 */
	public String buildContentRange() {
		return borneInferieure + "-" + borneSuperieure + "/" + total;
	}

	/**
	 * Construit le header Accepted-Range à partir de la valeur acceptedRange
	 * 
	 * @return
	 */
	public String buildAcceptedRange() {
		return String.valueOf(acceptedRange);
	}

	/**
	 * @return the acceptedRange
	 */
	public int getAcceptedRange() {
		return acceptedRange;
	}

	/**
	 * @return the borneInferieure
	 */
	public int getBorneInferieure() {
		return borneInferieure;
	}

	/**
	 * @return the borneSuperieure
	 */
	public int getBorneSuperieure() {
		return borneSuperieure;
	}

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * 
	 * @param total
	 */
	public void valoriserTotalAvecImpactSurBornes(long total) {

		// Attention cette méthode a été écrite en partant du principe que
		// les deux bornes ont déjà modifié (ou pas) en
		// fonction de l'acceptedRange (voir constructeur)
		// Si on déplace cette méthode dans le builder, il faut réfléchir
		// aux impacts
		this.total = total;

		if (total > 0) {
			if (borneInferieure >= total) {
				borneInferieure = 0;
				borneSuperieure = 0;
			} else if (borneSuperieure >= total) {
				borneSuperieure = (int) total - 1;
			}
		} else {
			borneInferieure = 0;
			borneSuperieure = 0;
		}
	}

	public static class Builder {
		// required

		// optional
		private int acceptedRange;
		private int borneInferieure;
		private int borneSuperieure;

		public Builder() {
		}

		public Builder acceptedRange(Integer acceptedRange) {
			this.acceptedRange = acceptedRange;
			return this;
		}

		public Builder borneInferieure(Integer borneInferieure) {
			this.borneInferieure = borneInferieure;
			return this;
		}

		public Builder borneSuperieure(Integer borneSuperieure) {
			this.borneSuperieure = borneSuperieure;
			return this;
		}

		public ContentRange build() {
			if (acceptedRange < 1) {
				throw new RuntimeException(String.format("L'Accepted-Range %d est incorrect", acceptedRange));
			}

			if (borneInferieure > borneSuperieure) {
				borneInferieure = borneSuperieure;
			}

			if (borneSuperieure - borneInferieure >= acceptedRange) {
				borneSuperieure = borneInferieure + acceptedRange - 1;
			}

			return new ContentRange(this);
		}
	}
}