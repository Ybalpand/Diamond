package com.mycompany.bean;

public class Document {
	private int documentId;
	private String documentName;
	private String documentExpiryDate;
	private String documentAddress;
	
	public Document() {
		super();
	}

	public Document(int documentId, String documentName, String documentExpiryDate, String documentAddress) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
		this.documentExpiryDate = documentExpiryDate;
		this.documentAddress = documentAddress;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentExpiryDate() {
		return documentExpiryDate;
	}

	public void setDocumentExpiryDate(String documentExpiryDate) {
		this.documentExpiryDate = documentExpiryDate;
	}

	public String getDocumentAddress() {
		return documentAddress;
	}

	public void setDocumentAddress(String documentAddress) {
		this.documentAddress = documentAddress;
	}

	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", documentName=" + documentName + ", documentExpiryDate="
				+ documentExpiryDate + ", documentAddress=" + documentAddress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + documentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (documentId != other.documentId)
			return false;
		return true;
	}

	
}
